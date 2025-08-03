package baylinux.socialMediaProject;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;


//@Entity
public class AppGroup {
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String appGroupName;
//	@ManyToOne(fetch=FetchType.EAGER)
	private long appGroupOwnerId;
//	@ManyToMany(fetch=FetchType.EAGER)
	private List<AppUser> appGroupMembers;
//	@OneToMany(fetch=FetchType.EAGER)
	private List<AppGroupPost> appGroupPosts;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAppGroupName() {
		return appGroupName;
	}
	public void setAppGroupName(String appGroupName) {
		this.appGroupName = appGroupName;
	}
	public long getAppGroupOwnerId() {
		return appGroupOwnerId;
	}
	public void setAppGroupOwnerId(long appGroupOwnerId) {
		this.appGroupOwnerId = appGroupOwnerId;
	}
	public List<AppUser> getAppGroupMembers() {
		return appGroupMembers;
	}
	public void setAppGroupMembers(List<AppUser> appGroupMembers) {
		this.appGroupMembers = appGroupMembers;
	}
	public List<AppGroupPost> getAppGroupPosts() {
		return appGroupPosts;
	}
	public void setAppGroupPosts(List<AppGroupPost> appGroupPosts) {
		this.appGroupPosts = appGroupPosts;
	}
	
	
	
	
}
