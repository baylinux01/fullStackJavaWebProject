package baylinux.socialMediaProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;


@Repository
public class DaoForUpdate
{
	private static String PrefSchema="sosyalMedya";
	private static String MySqlClassName="com.mysql.cj.jdbc.Driver";
	private static String MySqlEmptyUrl="jdbc:mysql://localhost:3306/";
	private static String MySqlUrl="jdbc:mysql://localhost:3306/"+PrefSchema;
	private static String MySqlUname=System.getenv("mysqlUsername");
	private static String MySqlPass=System.getenv("mysqlPassword");
	
	private static String className=MySqlClassName;
	private static String emptyUrl=MySqlEmptyUrl;
	private static String url=MySqlUrl;
	private static String uname=MySqlUname;
	private static String pass=MySqlPass;
	
	PasswordEncoder encoder;
	
	@Autowired
	public DaoForUpdate(PasswordEncoder encoder) {
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
	
	int updateAppUser(AppUser user) throws SQLException
	{

		String query1="update AppUserTable "
				+ "set "
				+ "name=?, "
				+ "surname=?, "
				+ "username=?,"
				+ "eMail=?,"
				+ "password=?,"
				+ "userImageAsByteArray=?,"
				+ "birthDate=?,"
				+ "roles=?"
				+ "where id=?";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.setString(1, user.getName());
			st1.setString(2, user.getSurname());
			st1.setString(3, user.getUsername());
			st1.setString(4, user.getEMail());
			st1.setString(5, user.getPassword());
			st1.setBytes(6,  user.getUserImageAsByteArray());
			st1.setString(7, user.getBirthDate());
			st1.setString(8, user.getRoles());
			st1.setLong(9,   user.getId());
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
	
	int updateAppConectionRequest(AppConnectionRequest conreq) throws SQLException
	{

		String query1="update AppConnectionRequestTable "
				+ "set "
				+ "appConnectionRequestSenderId=?, "
				+ "appConnectionRequestReceiverId=? "
				+ "where id=?";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.setLong(1, 	 conreq.getAppConnectionRequestSenderId());
			st1.setLong(2,   conreq.getAppConnectionRequestReceiverId());
			st1.setLong(3, 	 conreq.getId());
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
	
	int updateAppGroup(AppGroup group) throws SQLException
	{

		String query1="update AppGroupTable "
				+ "set "
				+ "appGroupName=?, "
				+ "appGroupOwnerId=? "
				+ "where id=?";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.setString(1, group.getAppGroupName());
			st1.setLong(2,   group.getAppGroupOwnerId());
			st1.setLong(3,   group.getId());
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
	
	int updateAppMedia(AppMedia media) throws SQLException
	{

		String query1="update AppMediaTable "
				+ "set "
				+ "appMediaGroupId=?, "
				+ "appMediaOwnerId=?, "
				+ "appMediaAddress=?, "
				+ "appMediaContentType=?, "
				+ "appMediaName=? "
				+ "where id=?";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.setLong(1,   media.getAppMediaGroupId());
			st1.setLong(2,   media.getAppMediaOwnerId());
			st1.setString(3, media.getAppMediaAddress());
			st1.setString(4, media.getAppMediaContentType());
			st1.setString(5, media.getAppMediaName());
			st1.setLong(6,   media.getId());
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
	
	int updateAppMessagePost(AppMessagePost post) throws SQLException
	{

		String query1="update AppMessagePostTable "
				+ "set "
				+ "appMessagePostSenderId=?, "
				+ "appMessagePostReceiverId=?, "
				+ "appMessagePostContent=?, "
				+ "appMediaId=?, "
				+ "quotedAppMessagePostId=?, "
				+ "deletedForSender=?, "
				+ "deletedForReceiver=?, "
				+ "readByReceiver=?, "
				+ "date=?, "
				+ "editDate=? "
				+ "where id=?";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.setLong(1,    post.getAppMessagePostSenderId());
			st1.setLong(2,    post.getAppMessagePostReceiverId());
			st1.setString(3,  post.getAppMessagePostContent());
			st1.setLong(4,    post.getAppMediaId());
			st1.setLong(5,    post.getQuotedAppMessagePostId());
			st1.setLong(6,    post.getDeletedForSender());
			st1.setLong(7,    post.getDeletedForReceiver());
			st1.setLong(8,    post.getReadByReceiver());
			st1.setString(9, post.getDate());
			st1.setString(10, post.getEditDate());
			st1.setLong(11,   post.getId());
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
	
	int updateAppGroupPost(AppGroupPost post) throws SQLException
	{

		String query1="update AppGroupPostTable "
				+ "set "
				+ "ownerId=?, "
				+ "appGroupId=?, "
				+ "appGroupPostContent=?, "
				+ "appMediaId=?, "
				+ "quotedAppCommentId=?, "
				+ "quotedAppMediaId=?, "
				+ "readByQuotedAppCommentOwner=?, "
				+ "readByQuotedAppMediaOwner=?, "
				+ "date=?, "
				+ "editDate=? "
				+ "where id=?";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.setLong(1,    post.getOwnerId());
			st1.setLong(2,    post.getAppGroupId());
			st1.setString(3,  post.getAppGroupPostContent());
			st1.setLong(4,    post.getAppMediaId());
			st1.setLong(5,    post.getQuotedAppGroupPostId());
			st1.setLong(6,    post.getReadByQuotedAppCommentOwner());
			st1.setLong(7,    post.getReadByQuotedAppMediaOwner());
			st1.setString(8, post.getDate());
			st1.setString(9, post.getEditDate());
			st1.setLong(10,   post.getId());
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
	
	int updateAppUserAppGroupPermission(AppUserAppGroupPermission obj,String updatedPermissions) throws SQLException
	{

		String query1="update AppUserAppGroupPermissionTable "
				+ "set "
				+ "appUserId=?, "
				+ "appGroupId=?, "
				+ "appUserPermissions=? "
				+ "where id=?";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.setLong(1,    obj.getAppUserId());
			st1.setLong(2,    obj.getAppGroupId());
			st1.setString(3,  updatedPermissions);
			st1.setLong(4,     obj.getId());
			
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
	
	int updateEMailAndCode(String eMail,String code) throws SQLException
	{
		
		String query1="update EMailAndCodeTable "
				+ "set "
				+ "code=? "
				+ "where eMail=?";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.setString(1,    encoder.encode(code));
			st1.setString(2, eMail);
			
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
