package baylinux.socialMediaProject;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SocialMediaProjectApplication {
 

	public static void main(String[] args) {
		
		try 
		{
			
			DaoForCreation.createDatabase();
		} 
		catch (Exception e) 
		{
			System.out.println("Database oluşturulamadı. Muhtemelen zaten var");
		}
		SpringApplication.run(SocialMediaProjectApplication.class, args);
	}

}
