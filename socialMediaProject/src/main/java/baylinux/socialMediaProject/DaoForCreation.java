package baylinux.socialMediaProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;


@Repository
public class DaoForCreation 
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
	
	static void createDatabase() throws SQLException, ClassNotFoundException 
	{
		
		String query1="create database if not exists "+PrefSchema;
				//String query1=" CREATE DATABASE [?]";
		
		try {
			con=getEmptyCon();
//			Connection con1 = DriverManager.getConnection(emptyUrl,uname,pass);
			
			Statement st1= con.createStatement();
			//st1.setString(1, databasename);
			st1.executeUpdate(query1);
		
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
		
	}
	
	void createAppUserTable() throws SQLException
	{

		String query1="Create table AppUserTable" +
                "(" +
				"id bigint primary key auto_increment,"
                +"name text,"
                +"surname text,"
                +"username text unique,"
                +"eMail text unique,"
                +"password text,"
                +"userImageAsByteArray longblob,"
                +"birthDate text,"
                +"roles text,"
                + "verified bigint"
                + ");";

		
		
		
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.executeUpdate();
		
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
		
	}
	void createAppConnectionRequestTable() throws SQLException
	{
		String query1="Create table AppConnectionRequestTable" +
                "(" +
				"id bigint primary key auto_increment,"
                +"appConnectionRequestSenderId bigint references AppUserTable(id) on delete set null on update cascade,"
                +"appConnectionRequestReceiverId bigint references AppUserTable(id) on delete set null on update cascade"
                + ");";

		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.executeUpdate();
		
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
		
	}
	void createAppGroupTable() throws SQLException
	{

		
		
		String query1="Create table AppGroupTable" +
                "(" +
				"id bigint primary key auto_increment,"
                +"appGroupName text,"
                +"appGroupOwnerId bigint references AppUserTable(id) on delete set null on update cascade"
                + ");";

		
		
		
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.executeUpdate();
		
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
		
	}
	void createAppGroupAppGroupMemberRelationTable() throws SQLException
	{

		
		
		String query1="Create table AppGroupAppGroupMemberRelationTable" +
                "(" +
				"id bigint primary key auto_increment,"
                +"appGroupId bigint references AppGroupTable(id) on delete set null on update cascade,"
                +"appGroupMemberId bigint references AppUserTable(id) on delete set null on update cascade,"
                +"constraint ctr_group_member unique(appGroupId,appGroupMemberId)"
                + ");";

		
		
		
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.executeUpdate();
		
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
		
	}
	void createAppGroupAppGroupPostRelationTable() throws SQLException
	{

		
		
		String query1="Create table AppGroupAppGroupPostRelationTable" +
                "(" +
				"id bigint primary key auto_increment,"
                +"appGroupId bigint references AppGroupTable(id) on delete set null on update cascade,"
                +"appGroupPostId bigint references AppGroupPostTable(id) on delete set null on update cascade,"
                +"constraint ctr_group_comment unique(appGroupId,appGroupPostId)"
                + ");";

		
		
		
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.executeUpdate();
		
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
		
	}
	void createAppMediaTable() throws SQLException
	{

		
		
		String query1="Create table AppMediaTable" +
                "(" +
				"id bigint primary key auto_increment,"
                +"appMediaGroupId bigint references AppGroupTable(id) on delete set null on update cascade,"
                +"appMediaOwnerId bigint references AppUserTable(id) on delete set null on update cascade,"
                +"appMediaAddress text,"
                +"appMediaContentType text,"
                +"appMediaName text"
                + ");";

		
		
		
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.executeUpdate();
		
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
		
	}
	
	
	void createAppMessagePostTable() throws SQLException
	{

		
		
		String query1="Create table AppMessagePostTable" +
                "(" +
				"id bigint primary key auto_increment,"
                +"appMessagePostSenderId bigint references AppUserTable(id) on delete set null on update cascade,"
                +"appMessagePostReceiverId bigint references AppUserTable(id) on delete set null on update cascade,"
                +"appMessagePostContent text,"
                +"appMediaId bigint references AppMediaTable(id) on delete set null on update cascade,"
                +"quotedAppMessagePostId bigint references AppMessagePostTable(id) on delete set null on update cascade,"
                +"deletedForSender bigint,"
                +"deletedForReceiver bigint,"
                +"readByReceiver bigint,"
                +"date text,"
                +"editDate text"
                + ");";

		
		
		
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.executeUpdate();
		
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
		
	}
	
	void createAppGroupPostTable() throws SQLException
	{

		
		
		String query1="Create table AppGroupPostTable" +
                "(" +
				"id bigint primary key auto_increment,"
                +"ownerId bigint references AppUserTable(id) on delete set null on update cascade,"
                +"appGroupId bigint references AppGroupTable(id) on delete set null on update cascade,"
                +"appGroupPostContent text,"
                +"appMediaId bigint references AppMediaTable(id) on delete set null on update cascade,"
                +"quotedAppGroupPostId bigint references AppGroupPostTable(id) on delete set null on update cascade,"
                +"readByQuotedAppCommentOwner bigint,"
                +"readByQuotedAppMediaOwner bigint,"
                +"date text,"
                +"editDate text"
                + ");";

		
		
		
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.executeUpdate();
		
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
		
	}
	void createAppUserAppGroupPermissionTable() throws SQLException
	{

		
		
		String query1="Create table AppUserAppGroupPermissonTable" +
                "(" +
				"id bigint primary key auto_increment,"
                +"appUserId bigint references AppUserTable(id) on delete set null on update cascade,"
                +"appGroupId bigint references AppGroupTable(id) on delete set null on update cascade,"
                +"appUserPermissions text"
                + ");";

		
		
		
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.executeUpdate();
		
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
		
	}
	void createEMailAndCodeTable() throws SQLException
	{

		
		
		String query1="Create table EMailAndCodeTable" +
                "(" +
				"id bigint primary key auto_increment,"
                +"eMail text unique,"
                +"code text"
                + ");";

		
		
		
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.executeUpdate();
		
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
		
	}
	
}
