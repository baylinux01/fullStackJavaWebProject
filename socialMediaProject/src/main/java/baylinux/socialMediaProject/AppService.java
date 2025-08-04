package baylinux.socialMediaProject;

import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
	
	
	@Autowired
	public AppService(DaoForCreation daoForCreation, DaoForDeletion daoForDeletion, DaoForGet daoForGet,
			DaoForInsertion daoForInsertion, DaoForUpdate daoForUpdate, FileTransferService fileTransferService,
			PasswordEncoder encoder, AuthenticationManager authenticationManager, JavaMailSender mailSender) {
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
	}


	boolean loggedIn()
	{
		return false;
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
	
	
	
	
	
	
	
	
	
	
	
	
}
