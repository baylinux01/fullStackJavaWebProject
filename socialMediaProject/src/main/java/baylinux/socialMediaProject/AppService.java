package baylinux.socialMediaProject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;

import com.vaadin.flow.server.VaadinServletRequest;
import com.vaadin.flow.spring.security.AuthenticationContext;

import jakarta.servlet.http.HttpSession;

@Service
public class AppService 
{
	DaoForCreation daoForCreation;
	DaoForDeletion daoForDeletion;
	DaoForGet daoForGet;
	DaoForInsertion daoForInsertion;
	DaoForUpdate daoForUpdate;
	FileTransferService fileTransferService;
	PasswordEncoder encoder;
	AuthenticationManager authenticationManager;
	JavaMailSender mailSender;
	UserDetailsService userDetailsService;
	
	AuthenticationContext authCtx = new AuthenticationContext();
	
	@Autowired
	public AppService(DaoForCreation daoForCreation, DaoForDeletion daoForDeletion, DaoForGet daoForGet,
			DaoForInsertion daoForInsertion, DaoForUpdate daoForUpdate, FileTransferService fileTransferService,
			PasswordEncoder encoder, AuthenticationManager authenticationManager, JavaMailSender mailSender
			,UserDetailsService userDetailsService) 
	{
		super();
		this.daoForCreation = daoForCreation;
		this.daoForDeletion = daoForDeletion;
		this.daoForGet = daoForGet;
		this.daoForInsertion = daoForInsertion;
		this.daoForUpdate = daoForUpdate;
		this.fileTransferService = fileTransferService;
		this.encoder = encoder;
		this.authenticationManager = authenticationManager;
		this.mailSender = mailSender;
		this.userDetailsService=userDetailsService;
	}


	
	void sendEMail(String eMail)
	{
		String code = String.format("%04d", ThreadLocalRandom.current().nextInt(10000));
		try 
		{
			daoForInsertion.insertIntoEMailAndCodeTable(eMail, code);
			//tabloda eMail alanı unique olduğu için kayıt varsa hata verip catch bloğuna geçecek
		} 
		catch (SQLException e) 
		{
			try 
			{
				System.out.println("email code eşleşmesi zaten var");
				daoForUpdate.updateEMailAndCode(eMail,code);
			} 
			catch (SQLException e1) 
			{
				System.out.println("email kod eşleşmesi güncellemesi sırasında hata oluştu");
			}
		}
		try 
		{
			
			SimpleMailMessage message=new SimpleMailMessage();
			message.setFrom("baylinux01@gmail.com");
			message.setTo(eMail);
			message.setSubject("Kayıt olmak için kodunuz");
			message.setText("Kodunuz: "+code);
			mailSender.send(message);
		} 
		catch (MailException e) 
		{
			System.out.println("Mail Gönderimi sırasında hata MailException oluştu");
		}
		catch (Exception e) 
		{
			System.out.println("Mail Gönderimi sırasında hata Exception oluştu");
		}
	}
	int signUp(String name, String surname,String username, String password,
			String imagePath,String birthDate,String eMail, String code)
	{
		if(name==null||name.equalsIgnoreCase("")) return -2;
		if(surname==null||surname.equalsIgnoreCase("")) return -3;
		if(username==null||username.equalsIgnoreCase("")) return -4;
		if(password==null||password.equalsIgnoreCase("")) return -5;
		if(eMail==null||eMail.equalsIgnoreCase("")) return -6;
		if(code==null||code.equalsIgnoreCase("")) return -7;
		int result=-1;
		EMailAndCode emc=null;
		try 
		{
			emc=daoForGet.getEMailAndCodeObjectByEMail(eMail);
		} 
		catch (SQLException e) 
		{
			System.out.println("EMailAndCode objesi veritabanından çekilirken sql exception oluştu");
		}
		if(emc!=null&&encoder.matches(code, emc.getCode()))
		{
			AppUser appUser=new AppUser();
			appUser.setName(name);
			appUser.setSurname(surname);
			appUser.setUsername(username);
			appUser.setPassword(encoder.encode(password));
			appUser.setEMail(eMail);
			appUser.setBirthDate(birthDate);
			appUser.setRoles("USER-");
			byte[] imageBytes=null;
			if(imagePath!=null)
			{
				Path path=Path.of(imagePath);
				boolean exists=Files.exists(path);
				if(exists==true)
				{
					try 
					{
						imageBytes=Files.readAllBytes(path);
					} 
					catch (IOException e) 
					{
						System.out.println("image byte array alırken io hatası oluştu");
					}
					
				}
			}
			appUser.setUserImageAsByteArray(imageBytes);
			try 
			{
				result=daoForInsertion.insertIntoAppUserTable(appUser);
			} 
			catch (SQLException e) 
			{
				System.out.println("kullanıcıyı veritabanına kaydederken sql hatası oluştu hata unique key ile ilgili olabilir");
				return -9;
			}
			
		}
		else
		{
			return -8;
		}
		return result;
		
	}
	int login(String usernameOrEMail,String password)
	{
		
		
		AppUser appUser=null;
		try 
		{
			appUser = daoForGet.getAppUserByEMail(usernameOrEMail);
		} 
		catch (Exception e) 
		{
			System.out.println("user email ile bulunamadı");
		}
		if(appUser==null)
		{
			try 
			{
				appUser=daoForGet.getAppUserByUsername(usernameOrEMail);
			} 
			catch (Exception e) 
			{
				System.out.println("user username ile bulunamadı");
			}
		}
		if(appUser==null) return -1;
		Authentication authentication =authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken
						(appUser.getUsername(),password));
		if(authentication.isAuthenticated()) 
		{
			SecurityContext context = SecurityContextHolder.createEmptyContext();
			context.setAuthentication(authentication);
			SecurityContextHolder.setContext(context);
			VaadinServletRequest vaadinReq = VaadinServletRequest.getCurrent();
		    if (vaadinReq != null) 
		    {
		        HttpSession session = vaadinReq.getSession(true);
		        session.setAttribute(
		            HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
		            context);
		    }
			return 1;
		}
		else
		{
			System.out.println("isauthenticated değil");
			return -1;
		}
		
	}
	boolean isLoggedIn()
	{
//		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
//		
//		if(auth!=null && auth.isAuthenticated()==true && !(auth instanceof AnonymousAuthenticationToken))
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
		if(authCtx==null) return false;
		if(authCtx.getPrincipalName().toString().startsWith("Optional[")
				&&authCtx.getPrincipalName().toString().endsWith("]"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	AppUser getCurrentAppUser()
	{
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		String username = auth.getName();
		String u=null;
		String username=null;
		if(authCtx!=null&&authCtx.getPrincipalName()!=null)
		{
			u=authCtx.getPrincipalName().toString();
			if(u.contains("Optional[")&&u.contains("]"))
			{
				username=u.substring(u.indexOf("[")+1,u.lastIndexOf("]"));
			}
			else
			{
				return null;
			}
			
		}
		else
		{
			return null;
		}
		
		
		 
		AppUser appUser=null;
		try 
		{ 
			appUser = daoForGet.getAppUserByUsername(username);
		} 
		catch (Exception e) 
		{
			
			System.out.println(username+" kullanıcı adı ile userı veritabanından çekerken hata oluştu");
		}
		
		return appUser;
	}
	
	
	
	
	
	
	
	
	
	
	
}
