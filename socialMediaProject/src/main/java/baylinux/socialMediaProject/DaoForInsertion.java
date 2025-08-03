package baylinux.socialMediaProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;


@Repository
public class DaoForInsertion 
{
	private static String PrefSchema="sosyalMedya";
	private static String MySqlClassName="com.mysql.cj.jdbc.Driver";
	private static String MySqlEmptyUrl="jdbc:mysql://localhost:3306/";
	private static String MySqlUrl="jdbc:mysql://localhost:3306/"+PrefSchema;
	private static String MySqlUname=System.getenv("MYSQL_USERNAME");
	private static String MySqlPass=System.getenv("MYSQL_PASSWORD");
	
	private static String className=MySqlClassName;
	private static String emptyUrl=MySqlEmptyUrl;
	private static String url=MySqlUrl;
	private static String uname=MySqlUname;
	private static String pass=MySqlPass;
	
	

	PasswordEncoder encoder;
	
	@Autowired
	public DaoForInsertion(PasswordEncoder encoder) {
		super();
		this.encoder = encoder;
	}
	
	private static Connection con=null;
	private static Connection conEmpty=null;
	
	static Connection getEmptyCon() throws ClassNotFoundException, SQLException 
	{
		Class.forName(className);
		conEmpty=DriverManager.getConnection(emptyUrl,uname,pass);
//		Connection con = DriverManager.getConnection(url,uname,pass);
		return conEmpty;
	}
	
	static Connection getCon() throws ClassNotFoundException, SQLException 
	{
		Class.forName(className);
		con=DriverManager.getConnection(url,uname,pass);
//		Connection con = DriverManager.getConnection(url,uname,pass);
		return con;
	}
	
	
	
	int insertIntoAppUserTable(AppUser appUser) throws SQLException
	{
		
		
		String query1="Insert into AppUserTable (name, surname, "
				+ "username, eMail,password, "
				+"userImageAsByteArray, birthDate, roles,verified)"
				+ "values (?,?,?,?,?,?,?,?,?)";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.setString(1, appUser.getName());
			st1.setString(2, appUser.getSurname());
			st1.setString(3, appUser.getUsername());
			st1.setString(4, appUser.getEMail());
			st1.setString(5, appUser.getPassword());
			st1.setBytes(6, appUser.getUserImageAsByteArray());
			st1.setString(7, appUser.getBirthDate());
			st1.setString(8, appUser.getRoles());
			st1.setLong(9, appUser.getVerified());
			result=st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
		}
		
		return result;
		
	}
	
	int insertIntoConnectionRequestTable(AppConnectionRequest conreq) throws SQLException
	{
		
		
		String query1="Insert into ConnectionRequestTable (appConnectionRequestSenderId,"
				+ "appConnectionRequestReceiverId)"
				+ "values (?,?)";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			st1.setLong(1, conreq.getAppConnectionRequestSenderId());
			st1.setLong(2, conreq.getAppConnectionRequestReceiverId());
			result=st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
		}
		
		return result;
		
	}
	
	int insertIntoAppGroupTable(AppGroup group) throws SQLException
	{
		
		
		String query1="Insert into AppGroupTable (appGroupName, appGroupOwnerId)"
				+ "values (?,?)";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			st1.setString(1, group.getAppGroupName());
			st1.setLong(2, group.getAppGroupOwnerId());
		
			result=st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
		}
		
		return result;
		
	}
	
	int insertIntoAppGroupAppGroupMemberRelationTable(AppGroup group,AppUser member) throws SQLException
	{
		
		
		String query1="Insert into AppGroupAppGroupMemberRelationTable "
				+ "(appGroupId, appGroupMemberId)"
				+ "values (?,?)";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			st1.setLong(1, group.getId());
			st1.setLong(2, group.getId());
		
			result=st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
		}
		
		return result;
		
	}
	
	int insertIntoAppGroupAppGroupPostRelationTable(AppGroup group,AppGroupPost post) throws SQLException
	{
		
		
		String query1="Insert into AppGroupAppGroupPostRelationTable "
				+ "(appGroupId, appGroupPostId)"
				+ "values (?,?)";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			st1.setLong(1, group.getId());
			st1.setLong(2, post.getId());
		
			result=st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
		}
		
		return result;
		
	}
	
	int insertIntoAppMediaTable(AppMedia media) throws SQLException
	{
		
		
		String query1="Insert into AppMediaTable "
				+ "(appGroupId, appMediaOwnerId,appMediaAddress,"
				+ "appMediaContentType,appMediaName)"
				+ "values (?,?,?,?,?)";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			st1.setLong(1, media.getAppMediaGroupId());
			st1.setLong(2, media.getAppMediaOwnerId());
			st1.setString(3, media.getAppMediaAddress());
			st1.setString(4, media.getAppMediaContentType());
			st1.setString(5, media.getAppMediaName());
			result=st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
		}
		
		return result;
		
	}
	
	int insertIntoAppMessagePostTable(AppMessagePost post) throws SQLException
	{
		
		
		String query1="Insert into AppMessagePostTable "
				+ "("
				+ "appMessagePostSenderId, "
				+ "appMessagePostReceiverId,"
				+ "appMessagePostContent,"
				+ "appMediaId,"
				+ "quotedAppMessagePostId,"
				+ "deletedForSender, "
				+ "deletedForReceiver,"
				+ "readByReceiver,"
				+ "date,"
				+ "editDate"
				+ ")"
				+ "values "
				+ "("
				+ "?,"
				+ "?,"
				+ "?,"
				+ "?,"
				+ "?,"
				+ "?,"
				+ "?,"
				+ "?,"
				+ "?,"
				+ "?)";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			st1.setLong(1, post.getAppMessagePostSenderId());
			st1.setLong(2, post.getAppMessagePostReceiverId());
			st1.setString(3, post.getAppMessagePostContent());
			st1.setLong(4, post.getAppMediaId());
			st1.setLong(5, post.getQuotedAppMessagePostId());
			st1.setLong(6, post.getDeletedForSender());
			st1.setLong(7, post.getDeletedForReceiver());
			st1.setLong(8, post.getReadByReceiver());
			st1.setString(9, post.getDate());
			st1.setString(10, post.getEditDate());
		
			
			result=st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
		}
		
		return result;
		
	}
	
	int insertIntoAppGroupPostTable(AppGroupPost post) throws SQLException
	{
		
		
		String query1="Insert into AppGroupPostTable "
				+ "("
				+"ownerId,"
				+ "appGroupId, "
				+ "appGroupPostContent,"
				+ "appMediaId,"
				+ "quotedAppGroupPostId,"
				+ "readByQuotedAppCommentOwner,"
				+ "readByQuotedAppMediaOwner,"
				+ "date,"
				+ "editDate"
				+ ")"
				+ "values "
				+ "("
				+ "?,"
				+ "?,"
				+ "?,"
				+ "?,"
				+ "?,"
				+ "?,"
				+ "?,"
				+ "?,"
				+ "?)";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			st1.setLong(1, post.getOwnerId());
			st1.setLong(2, post.getAppGroupId());
			st1.setString(3, post.getAppGroupPostContent());
			st1.setLong(4, post.getAppMediaId());
			st1.setLong(5, post.getQuotedAppGroupPostId());
			st1.setLong(6, post.getReadByQuotedAppCommentOwner());
			st1.setLong(7, post.getReadByQuotedAppMediaOwner());
			st1.setString(8, post.getDate());
			st1.setString(9, post.getEditDate());
		
			
			result=st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
		}
		
		return result;
		
	}
	
	int insertIntoAppUserAppGroupPermissionTable(AppUser user, AppGroup group,String permissions) throws SQLException
	{
		
		
		String query1="Insert into AppUserAppGroupPermissionTable "
				+ "("
				+ "appUserId, "
				+ "appGroupId,"
				+ "appUserPermissions"
				+ ")"
				+ "values "
				+ "("
				+ "?,"
				+ "?,"
				+ "?)";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			st1.setLong(1, user.getId());
			st1.setLong(2, group.getId());
			st1.setString(3, permissions);
		
			
			result=st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
		}
		
		return result;
		
	}
	
	int insertIntoEMailAndCodeTable(String eMail,String code) throws SQLException
	{
		
		
		String query1="Insert into EMailAndCodeTable "
				+ "(eMail,code)"
				+ "values (?,?)";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			st1.setString(1, eMail);
			st1.setString(2, encoder.encode(code));
			
			result=st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
		}
		
		return result;
		
	}
}
