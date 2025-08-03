package baylinux.socialMediaProject;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;

//@Entity
public class AppUserAppGroupPermission {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
//	@ManyToOne
	private long appUserId;
//	@ManyToOne
	private long appGroupId;
	private String appUserPermissions="SENDMESSAGE-SENDMEDIA";
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getAppUserId() {
		return appUserId;
	}
	public void setAppUserId(long appUserId) {
		this.appUserId = appUserId;
	}
	public long getAppGroupId() {
		return appGroupId;
	}
	public void setAppGroupId(long appGroupId) {
		this.appGroupId = appGroupId;
	}
	public String getAppUserPermissions() {
		return appUserPermissions;
	}
	public void setAppUserPermissions(String appUserPermissions) {
		this.appUserPermissions = appUserPermissions;
	}
	
	
	
}
