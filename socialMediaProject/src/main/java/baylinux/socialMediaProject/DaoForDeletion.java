package baylinux.socialMediaProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;





@Repository
public class DaoForDeletion
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
	
	int deleteAppComment(AppComment comment) throws SQLException
	{
		
		String query="Delete From AppCommentTable where id=?";
		
		int result=0;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setLong(1, comment.getId());
			result=st.executeUpdate();
			
		
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
	int deleteAppUser(AppUser user) throws SQLException
	{
		
		String query="Delete From AppUserTable where id=?";
		
		int result=0;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setLong(1, user.getId());
			result=st.executeUpdate();
			
		
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
	int deleteAppConnectionRequest(AppConnectionRequest conreq) throws SQLException
	{
		
		String query="Delete From AppConnectionRequestTable where id=?";
		
		int result=0;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setLong(1, conreq.getId());
			result=st.executeUpdate();
			
		
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
	int deleteAppGroup(AppGroup group) throws SQLException
	{
		
		String query="Delete From AppGroupTable where id=?";
		
		int result=0;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setLong(1, group.getId());
			result=st.executeUpdate();
			
		
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
	int deleteAppGroupAppGroupMemberRelation(AppGroup group, AppUser member) throws SQLException
	{
		
		String query="Delete From AppGroupAppGroupMemberRelationTable where appGroupId=? and appGroupMemberId=?";
		
		int result=0;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setLong(1, group.getId());
			st.setLong(2, member.getId());
			result=st.executeUpdate();
			
		
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
	
	int deleteAppGroupAppGroupPostRelation(AppGroup group, AppGroupPost post) throws SQLException
	{
		
		String query="Delete From AppGroupAppGroupPostRelationTable where appGroupId=? and appGroupPostId=?";
		
		int result=0;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setLong(1, group.getId());
			st.setLong(2, post.getId());
			result=st.executeUpdate();
			
		
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
	
	int deleteAppMedia(AppMedia media) throws SQLException
	{
		
		String query="Delete From AppMediaTable where id=?";
		
		int result=0;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setLong(1, media.getId());
			
			result=st.executeUpdate();
			
		
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
	
	int deleteAppMessage(AppMedia message) throws SQLException
	{
		
		String query="Delete From AppMessageTable where id=?";
		
		int result=0;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setLong(1, message.getId());
			
			result=st.executeUpdate();
			
		
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
	
	int deleteAppMessagePost(AppMessagePost post) throws SQLException
	{
		
		String query="Delete From AppMessagePostTable where id=?";
		
		int result=0;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setLong(1, post.getId());
			
			result=st.executeUpdate();
			
		
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
	int deleteAppGroupPost(AppGroupPost post) throws SQLException
	{
		
		String query="Delete From AppGroupPostTable where id=?";
		
		int result=0;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setLong(1, post.getId());
			
			result=st.executeUpdate();
			
		
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
	
	int deleteAppUserAppGroupPermission(AppUser user, AppGroup group) throws SQLException
	{
		
		String query="Delete From AppUserAppGroupPermissionTable where appUserId=? and appGroupId=?";
		
		int result=0;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setLong(1, user.getId());
			st.setLong(2, group.getId());
			
			result=st.executeUpdate();
			
		
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
	
	int deleteFromEMailAndCodeTableByEmail(EMailAndCode eMailAndCode) throws SQLException
	{
		
		String query="Delete From EMailAndCodeTable where eMail=?";
		
		int result=0;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setString(1, eMailAndCode.getEMail());
			
			result=st.executeUpdate();
			
		
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
