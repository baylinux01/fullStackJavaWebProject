package baylinux.socialMediaProject;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class AppUserDetailsService implements UserDetailsService {

DaoForGet daoForGet;



	@Autowired
	public AppUserDetailsService(DaoForGet daoForGet) 
	{
	super();
	this.daoForGet = daoForGet;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user=null;
		try 
		{
			user = daoForGet.getAppUserByUsername(username);
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		if(user==null)
		{
			System.out.println("user not found");
			throw new UsernameNotFoundException("User not found");
		}
		return new AppUserDetails(user);
	}
	
	public UserDetails loadUserById(long id)
	{
		AppUser user=null;
		try {
			user = daoForGet.getAppUserById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user==null)
		{
			System.out.println("user not found");
			throw new UsernameNotFoundException("User not found");
		}
		return new AppUserDetails(user);
	}

}
