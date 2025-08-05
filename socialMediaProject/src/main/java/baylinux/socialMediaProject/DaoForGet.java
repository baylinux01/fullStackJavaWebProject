package baylinux.socialMediaProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public class DaoForGet
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
	
	
	List<AppUser> getAllAppUsers() throws SQLException
	{
		String query="Select "
				+ "*"
				+ " From AppUserTable";
		List<AppUser> appUsersInDb=new ArrayList<AppUser>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				AppUser p=new AppUser();
				p.setId(rs.getLong("id"));
				p.setName(rs.getString("name"));
				p.setSurname(rs.getString("surname"));
				p.setUsername(rs.getString("username"));
				p.setEMail(rs.getString("eMail"));
				p.setPassword(rs.getString("password"));
				p.setUserImageAsByteArray(rs.getBytes("userImageAsByteArray"));
				p.setBirthDate(rs.getString("birthData"));
				p.setRoles(rs.getString("roles"));
				appUsersInDb.add(p);
				
				
			
			}
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
		return appUsersInDb;
	}
	
	List<AppUser> getAppUsersByGroup(AppGroup group) throws SQLException
	{
		String query="Select"
				+ "*"
				+ "From AppUserTable where id in "
				+ "(select appGroupMemberId from AppGroupAppGroupMemberRelationTable"
				+ "where appGroupId id=?)";
		List<AppUser> appUsersInDb=new ArrayList<AppUser>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setLong(1, group.getId());
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				AppUser p=new AppUser();
				p.setId(rs.getLong("id"));
				p.setName(rs.getString("name"));
				p.setSurname(rs.getString("surname"));
				p.setUsername(rs.getString("username"));
				p.setEMail(rs.getString("eMail"));
				p.setPassword(rs.getString("password"));
				p.setUserImageAsByteArray(rs.getBytes("userImageAsByteArray"));
				p.setBirthDate(rs.getString("birthDate"));
				p.setRoles(rs.getString("roles"));
				appUsersInDb.add(p);
				
				
			
			}
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
		return appUsersInDb;
	}
	
	AppUser getAppUserById(long id) throws SQLException
	{
		String query="Select "
				+ "*"
				+ "From AppUserTable where id=?";
		List<AppUser> appUsersInDb=new ArrayList<AppUser>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setLong(1, id);
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				AppUser p=new AppUser();
				p.setId(rs.getLong("id"));
				p.setName(rs.getString("name"));
				p.setSurname(rs.getString("surname"));
				p.setUsername(rs.getString("username"));
				p.setEMail(rs.getString("eMail"));
				p.setPassword(rs.getString("password"));
				p.setUserImageAsByteArray(rs.getBytes("userImageAsByteArray"));
				p.setBirthDate(rs.getString("birthDate"));
				p.setRoles(rs.getString("roles"));
				appUsersInDb.add(p);
				
				
			
			}
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
		return appUsersInDb.get(0);
	}
	
	AppUser getAppUserByUsername(String username) throws SQLException
	{
		String query="Select "
				+ "*"
				+ "From AppUserTable where username=?";
		List<AppUser> appUsersInDb=new ArrayList<AppUser>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setString(1, username);
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				AppUser p=new AppUser();
				p.setId(rs.getLong("id"));
				p.setName(rs.getString("name"));
				p.setSurname(rs.getString("surname"));
				p.setUsername(rs.getString("username"));
				p.setEMail(rs.getString("eMail"));
				p.setPassword(rs.getString("password"));
				p.setUserImageAsByteArray(rs.getBytes("userImageAsByteArray"));
				p.setBirthDate(rs.getString("birthDate"));
				p.setRoles(rs.getString("roles"));
				appUsersInDb.add(p);
				
				
			
			}
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
		return appUsersInDb.get(0);
	}
	AppUser getAppUserByEMail(String eMail) throws SQLException
	{
		String query="Select "
				+ "*"
				+ "From AppUserTable where eMail=?";
		List<AppUser> appUsersInDb=new ArrayList<AppUser>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setString(1, eMail);
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				AppUser p=new AppUser();
				p.setId(rs.getLong("id"));
				p.setName(rs.getString("name"));
				p.setSurname(rs.getString("surname"));
				p.setUsername(rs.getString("username"));
				p.setEMail(rs.getString("eMail"));
				p.setPassword(rs.getString("password"));
				p.setUserImageAsByteArray(rs.getBytes("userImageAsByteArray"));
				p.setBirthDate(rs.getString("birthDate"));
				p.setRoles(rs.getString("roles"));
				appUsersInDb.add(p);
				
				
			
			}
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
		return appUsersInDb.get(0);
	}
	
	List<AppConnectionRequest> getAllConnectionRequests() throws SQLException
	{
		String query="Select "
				+ "*"
				+ " From AppConnectionRequestTable";
		List<AppConnectionRequest> appConnectionRequestsInDb=new ArrayList<AppConnectionRequest>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				AppConnectionRequest p=new AppConnectionRequest();
				p.setId(rs.getLong("id"));
				p.setAppConnectionRequestSenderId(rs.getLong("appConnectionRequestSenderId"));
				p.setAppConnectionRequestSenderId(rs.getLong("appConnectionRequestReceiverId"));
				
				appConnectionRequestsInDb.add(p);
				
				
			
			}
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
		return appConnectionRequestsInDb;
	}
	
	List<AppConnectionRequest> getConnectionRequestsBySender(AppUser sender) throws SQLException
	{
		String query="Select "
				+ "*"
				+ " From AppConnectionRequestTable where appConnectionRequestSenderId=?";
		List<AppConnectionRequest> appConnectionRequestsInDb=new ArrayList<AppConnectionRequest>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setLong(1, sender.getId());
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				AppConnectionRequest p=new AppConnectionRequest();
				p.setId(rs.getLong("id"));
				p.setAppConnectionRequestSenderId(rs.getLong("appConnectionRequestSenderId"));
				p.setAppConnectionRequestSenderId(rs.getLong("appConnectionRequestReceiverId"));
				
				appConnectionRequestsInDb.add(p);
				
				
			
			}
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
		return appConnectionRequestsInDb;
	}
	
	List<AppConnectionRequest> getConnectionRequestsByReceiver(AppUser receiver) throws SQLException
	{
		String query="Select "
				+ "*"
				+ " From AppConnectionRequestTable where appConnectionRequestReceiverId=?";
		List<AppConnectionRequest> appConnectionRequestsInDb=new ArrayList<AppConnectionRequest>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setLong(1, receiver.getId());
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				AppConnectionRequest p=new AppConnectionRequest();
				p.setId(rs.getLong("id"));
				p.setAppConnectionRequestSenderId(rs.getLong("appConnectionRequestSenderId"));
				p.setAppConnectionRequestSenderId(rs.getLong("appConnectionRequestReceiverId"));
				
				appConnectionRequestsInDb.add(p);
				
				
			
			}
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
		return appConnectionRequestsInDb;
	}
	
	AppConnectionRequest getConnectionRequestsBySenderAndReceiver(AppUser sender,AppUser receiver) throws SQLException
	{
		String query="Select "
				+ "*"
				+ " From AppConnectionRequestTable where appConnectionRequestSenderId=? and appConnectionRequestReceiverId=?";
		List<AppConnectionRequest> appConnectionRequestsInDb=new ArrayList<AppConnectionRequest>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setLong(1, sender.getId());
			st.setLong(2, receiver.getId());
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				AppConnectionRequest p=new AppConnectionRequest();
				p.setId(rs.getLong("id"));
				p.setAppConnectionRequestSenderId(rs.getLong("appConnectionRequestSenderId"));
				p.setAppConnectionRequestSenderId(rs.getLong("appConnectionRequestReceiverId"));
				
				appConnectionRequestsInDb.add(p);
				
				
			
			}
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
		return appConnectionRequestsInDb.get(0);
	}
	
	List<AppGroup> getAllAppGroups() throws SQLException
	{
		String query="Select "
				+ "*"
				+ " From AppGroupTable";
		List<AppGroup> appGroupsInDb=new ArrayList<AppGroup>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				AppGroup p=new AppGroup();
				p.setId(rs.getLong("id"));
				p.setAppGroupName(rs.getString("appGroupName"));
				p.setAppGroupOwnerId(rs.getLong("appGroupOwnerId"));
				appGroupsInDb.add(p);
				
				
			
			}
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
		return appGroupsInDb;
	}
	
	List<AppGroup> getAppGroupsByOwner(AppUser owner) throws SQLException
	{
		String query="Select "
				+ "*"
				+ " From AppGroupTable where appGroupOwnerId=?;";
		List<AppGroup> appGroupsInDb=new ArrayList<AppGroup>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setLong(1, owner.getId());
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				AppGroup p=new AppGroup();
				p.setId(rs.getLong("id"));
				p.setAppGroupName(rs.getString("appGroupName"));
				p.setAppGroupOwnerId(rs.getLong("appGroupOwnerId"));
				appGroupsInDb.add(p);
				
				
			
			}
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
		return appGroupsInDb;
	}
	
	List<AppGroup> getAppGroupsByMember(AppUser member) throws SQLException
	{
		String query="Select "
				+ "*"
				+ " From AppGroupTable where appGroupOwnerId in "
				+ "(select appGroupId from AppGroupAppGroupMemberRelationTable"
				+ "where appGroupMemberId=?);";
		List<AppGroup> appGroupsInDb=new ArrayList<AppGroup>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setLong(1, member.getId());
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				AppGroup p=new AppGroup();
				p.setId(rs.getLong("id"));
				p.setAppGroupName(rs.getString("appGroupName"));
				p.setAppGroupOwnerId(rs.getLong("appGroupOwnerId"));
				appGroupsInDb.add(p);
				
				
			
			}
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
		return appGroupsInDb;
	}
	
	List<AppMessagePost> getAllAppMessagePosts() throws SQLException
	{
		String query="Select "
				+ "*"
				+ " From AppMessagePostTable";
		List<AppMessagePost> appMessagePostsInDb=new ArrayList<AppMessagePost>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				AppMessagePost p=new AppMessagePost();
				p.setId(rs.getLong("id"));
				p.setAppMessagePostSenderId(rs.getLong("appMessagePostSenderId"));
				p.setAppMessagePostReceiverId(rs.getLong("appMessagePostReceiverId"));
				p.setAppMessagePostContent(rs.getString("appMessagePostContent"));
				p.setAppMediaId(rs.getLong("appMediaId"));
				p.setQuotedAppMessagePostId(rs.getLong("quotedAppMessagePostId"));
				p.setDeletedForSender(rs.getLong("deletedForSender"));
				p.setDeletedForReceiver(rs.getLong("deletedForReceiver"));
				p.setDate(rs.getString("date"));
				p.setEditDate(rs.getString("editDate"));
				appMessagePostsInDb.add(p);
				
				
			
			}
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
		return appMessagePostsInDb;
	}
	
	List<AppMessagePost> getAllAppMessagePostsBySender(AppUser sender) throws SQLException
	{
		String query="Select "
				+ "*"
				+ " From AppMessagePostTable where appMessagePostSenderId=?";
		List<AppMessagePost> appMessagePostsInDb=new ArrayList<AppMessagePost>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setLong(1, sender.getId());
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				AppMessagePost p=new AppMessagePost();
				p.setId(rs.getLong("id"));
				p.setAppMessagePostSenderId(rs.getLong("appMessagePostSenderId"));
				p.setAppMessagePostReceiverId(rs.getLong("appMessagePostReceiverId"));
				p.setAppMessagePostContent(rs.getString("appMessagePostContent"));
				p.setAppMediaId(rs.getLong("appMediaId"));
				p.setQuotedAppMessagePostId(rs.getLong("quotedAppMessagePostId"));
				p.setDeletedForSender(rs.getLong("deletedForSender"));
				p.setDeletedForReceiver(rs.getLong("deletedForReceiver"));
				p.setDate(rs.getString("date"));
				p.setEditDate(rs.getString("editDate"));
				appMessagePostsInDb.add(p);
				
				
			
			}
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
		return appMessagePostsInDb;
	}
	
	List<AppMessagePost> getAllAppMessagePostsByReceiver(AppUser receiver) throws SQLException
	{
		String query="Select "
				+ "*"
				+ " From AppMessagePostTable where appMessagePostReceiverId=?";
		List<AppMessagePost> appMessagePostsInDb=new ArrayList<AppMessagePost>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setLong(1, receiver.getId());
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				AppMessagePost p=new AppMessagePost();
				p.setId(rs.getLong("id"));
				p.setAppMessagePostSenderId(rs.getLong("appMessagePostSenderId"));
				p.setAppMessagePostReceiverId(rs.getLong("appMessagePostReceiverId"));
				p.setAppMessagePostContent(rs.getString("appMessagePostContent"));
				p.setAppMediaId(rs.getLong("appMediaId"));
				p.setQuotedAppMessagePostId(rs.getLong("quotedAppMessagePostId"));
				p.setDeletedForSender(rs.getLong("deletedForSender"));
				p.setDeletedForReceiver(rs.getLong("deletedForReceiver"));
				p.setDate(rs.getString("date"));
				p.setEditDate(rs.getString("editDate"));
				appMessagePostsInDb.add(p);
				
				
			
			}
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
		return appMessagePostsInDb;
	}
	
	List<AppMessagePost> getAllAppMessagePostsBySenderAndReceiver(AppUser sender,AppUser receiver) throws SQLException
	{
		String query="Select "
				+ "*"
				+ " From AppMessagePostTable where appMessagePostSenderId=? and appMessagePostReceiverId=?";
		List<AppMessagePost> appMessagePostsInDb=new ArrayList<AppMessagePost>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setLong(1, sender.getId());
			st.setLong(2, receiver.getId());
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				AppMessagePost p=new AppMessagePost();
				p.setId(rs.getLong("id"));
				p.setAppMessagePostSenderId(rs.getLong("appMessagePostSenderId"));
				p.setAppMessagePostReceiverId(rs.getLong("appMessagePostReceiverId"));
				p.setAppMessagePostContent(rs.getString("appMessagePostContent"));
				p.setAppMediaId(rs.getLong("appMediaId"));
				p.setQuotedAppMessagePostId(rs.getLong("quotedAppMessagePostId"));
				p.setDeletedForSender(rs.getLong("deletedForSender"));
				p.setDeletedForReceiver(rs.getLong("deletedForReceiver"));
				p.setDate(rs.getString("date"));
				p.setEditDate(rs.getString("editDate"));
				appMessagePostsInDb.add(p);
				
				
			
			}
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
		return appMessagePostsInDb;
	}
	
	List<AppGroupPost> getAllAppGroupPosts() throws SQLException
	{
		String query="Select "
				+ "*"
				+ " From AppGroupPostTable";
		List<AppGroupPost> appGroupPostsInDb=new ArrayList<AppGroupPost>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				AppGroupPost p=new AppGroupPost();
				p.setId(rs.getLong("id"));
				p.setOwnerId(rs.getLong("ownerId"));
				p.setAppGroupId(rs.getLong("appGroupId"));
				p.setAppGroupPostContent(rs.getString("appGroupPostContent"));
				p.setAppMediaId(rs.getLong("appMediaId"));
				p.setQuotedAppGroupPostId(rs.getLong("quotedAppGroupPostId"));
				p.setReadByQuotedAppCommentOwner(rs.getLong("readByQuotedAppCommentOwner"));
				p.setReadByQuotedAppMediaOwner(rs.getLong("readByQuotedAppMediaOwner"));
				p.setDate(rs.getString("date"));
				p.setEditDate(rs.getString("editDate"));
				appGroupPostsInDb.add(p);
				
				
			
			}
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
		return appGroupPostsInDb;
	}
	
	List<AppGroupPost> getAppGroupPostsByGroup(AppGroup group) throws SQLException
	{
		String query="Select "
				+ "*"
				+ " From AppGroupPostTable where appGroupId=?;";
		List<AppGroupPost> appGroupPostsInDb=new ArrayList<AppGroupPost>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setLong(1, group.getId());
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				AppGroupPost p=new AppGroupPost();
				p.setId(rs.getLong("id"));
				p.setOwnerId(rs.getLong("ownerId"));
				p.setAppGroupId(rs.getLong("appGroupId"));
				p.setAppGroupPostContent(rs.getString("appGroupPostContent"));
				p.setAppMediaId(rs.getLong("appMediaId"));
				p.setQuotedAppGroupPostId(rs.getLong("quotedAppGroupPostId"));
				p.setReadByQuotedAppCommentOwner(rs.getLong("readByQuotedAppCommentOwner"));
				p.setReadByQuotedAppMediaOwner(rs.getLong("readByQuotedAppMediaOwner"));
				p.setDate(rs.getString("date"));
				p.setEditDate(rs.getString("editDate"));
				appGroupPostsInDb.add(p);
				
				
			
			}
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
		return appGroupPostsInDb;
	}
	
	List<AppGroupPost> getAppGroupPostsByOwner(AppUser owner) throws SQLException
	{
		String query="Select "
				+ "*"
				+ " From AppGroupPostTable where ownerId=?;";
		List<AppGroupPost> appGroupPostsInDb=new ArrayList<AppGroupPost>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setLong(1, owner.getId());
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				AppGroupPost p=new AppGroupPost();
				p.setId(rs.getLong("id"));
				p.setOwnerId(rs.getLong("ownerId"));
				p.setAppGroupId(rs.getLong("appGroupId"));
				p.setAppGroupPostContent(rs.getString("appGroupPostContent"));
				p.setAppMediaId(rs.getLong("appMediaId"));
				p.setQuotedAppGroupPostId(rs.getLong("quotedAppGroupPostId"));
				p.setReadByQuotedAppCommentOwner(rs.getLong("readByQuotedAppCommentOwner"));
				p.setReadByQuotedAppMediaOwner(rs.getLong("readByQuotedAppMediaOwner"));
				p.setDate(rs.getString("date"));
				p.setEditDate(rs.getString("editDate"));
				appGroupPostsInDb.add(p);
				
				
			
			}
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
		return appGroupPostsInDb;
	}
	
	List<AppUserAppGroupPermission> getAllAppUserAppGroupPermissionObjects() throws SQLException
	{
		String query="Select "
				+ "*"
				+ " From AppUserAppGroupPermissionTable";
		List<AppUserAppGroupPermission> appUserAppGroupPermissionObjectsInDb=new ArrayList<AppUserAppGroupPermission>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				AppUserAppGroupPermission p=new AppUserAppGroupPermission();
				p.setId(rs.getLong("id"));
				p.setAppUserId(rs.getLong("appUserId"));
				p.setAppGroupId(rs.getLong("appGroupId"));
				p.setAppUserPermissions(rs.getString("appUserPermissions"));
				appUserAppGroupPermissionObjectsInDb.add(p);
				
				
			
			}
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
		return appUserAppGroupPermissionObjectsInDb;
	}
	
	List<AppUserAppGroupPermission> getAppUserAppGroupPermissionObjectsByAppGroup(AppGroup group) throws SQLException
	{
		String query="Select "
				+ "*"
				+ " From AppUserAppGroupPermissionTable where appGroupId=?";
		List<AppUserAppGroupPermission> appUserAppGroupPermissionObjectsInDb=new ArrayList<AppUserAppGroupPermission>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setLong(1, group.getId());
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				AppUserAppGroupPermission p=new AppUserAppGroupPermission();
				p.setId(rs.getLong("id"));
				p.setAppUserId(rs.getLong("appUserId"));
				p.setAppGroupId(rs.getLong("appGroupId"));
				p.setAppUserPermissions(rs.getString("appUserPermissions"));
				appUserAppGroupPermissionObjectsInDb.add(p);
				
				
			
			}
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
		return appUserAppGroupPermissionObjectsInDb;
	}
	
	List<AppUserAppGroupPermission> getAppUserAppGroupPermissionObjectsByAppUser(AppUser user) throws SQLException
	{
		String query="Select "
				+ "*"
				+ " From AppUserAppGroupPermissionTable where appUserId=?";
		List<AppUserAppGroupPermission> appUserAppGroupPermissionObjectsInDb=new ArrayList<AppUserAppGroupPermission>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setLong(1, user.getId());
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				AppUserAppGroupPermission p=new AppUserAppGroupPermission();
				p.setId(rs.getLong("id"));
				p.setAppUserId(rs.getLong("appUserId"));
				p.setAppGroupId(rs.getLong("appGroupId"));
				p.setAppUserPermissions(rs.getString("appUserPermissions"));
				appUserAppGroupPermissionObjectsInDb.add(p);
				
				
			
			}
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
		return appUserAppGroupPermissionObjectsInDb;
	}
	
	AppUserAppGroupPermission getAppUserAppGroupPermissionObjectByAppUserAndAppGroup(AppUser user,AppGroup group) throws SQLException
	{
		String query="Select "
				+ "*"
				+ " From AppUserAppGroupPermissionTable where appUserId=? and appGroupId=?";
		List<AppUserAppGroupPermission> appUserAppGroupPermissionObjectsInDb=new ArrayList<AppUserAppGroupPermission>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setLong(1, user.getId());
			st.setLong(2, group.getId());
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				AppUserAppGroupPermission p=new AppUserAppGroupPermission();
				p.setId(rs.getLong("id"));
				p.setAppUserId(rs.getLong("appUserId"));
				p.setAppGroupId(rs.getLong("appGroupId"));
				p.setAppUserPermissions(rs.getString("appUserPermissions"));
				appUserAppGroupPermissionObjectsInDb.add(p);
				
				
			
			}
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
		return appUserAppGroupPermissionObjectsInDb.get(0);
	}
	
	EMailAndCode getEMailAndCodeObjectByEMail(String eMail) throws SQLException
	{
		String query="Select "
				+ "*"
				+ "From EMailAndCodeTable where eMail=?";
		List<EMailAndCode> eMailAndCodesInDb=new ArrayList<EMailAndCode>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setString(1, eMail);
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				EMailAndCode p=new EMailAndCode();
				p.setId(rs.getLong("id"));
				p.setEMail(rs.getString("eMail"));
				p.setCode(rs.getString("code"));
				
				eMailAndCodesInDb.add(p);
				
				
			
			}
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
		return eMailAndCodesInDb.get(0);
	}
}
