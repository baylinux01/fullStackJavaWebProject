package baylinux.socialMediaProject;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class InitializerForTables{
	
	DaoForCreation daoForCreation;
	
	@Autowired
	public InitializerForTables(DaoForCreation daoForCreation) {
		super();
		this.daoForCreation = daoForCreation;
	}
	
	@PostConstruct
	public void initializeTables()
	{
		try 
		{
			daoForCreation.createAppUserTable();
		} 
		catch (SQLException e) 
		{
			
		}
		try 
		{
			daoForCreation.createEMailAndCodeTable();
		} 
		catch (SQLException e) 
		{
			
		}
		try 
		{
			daoForCreation.createAppGroupTable();
		} 
		catch (SQLException e) 
		{
			
		}
		try 
		{
			daoForCreation.createAppMediaTable();
		} 
		catch (SQLException e) 
		{
			
		}
		try 
		{
			daoForCreation.createAppGroupPostTable();
		} 
		catch (SQLException e) 
		{
			
		}
		
		try 
		{
			daoForCreation.createAppMessagePostTable();
		} 
		catch (SQLException e) 
		{
			
		}
		
		try 
		{
			daoForCreation.createAppGroupAppGroupMemberRelationTable();
		} 
		catch (SQLException e) 
		{
			
		}
		
		try 
		{
			daoForCreation.createAppConnectionRequestTable();
		} 
		catch (SQLException e) 
		{
			
		}
		
		try 
		{
			daoForCreation.createAppGroupAppGroupPostRelationTable();
		} 
		catch (SQLException e) 
		{
			
		}
		
		try 
		{
			daoForCreation.createAppUserAppGroupPermissionTable();
		} 
		catch (SQLException e) 
		{
			
		}
		
	}
	

}
