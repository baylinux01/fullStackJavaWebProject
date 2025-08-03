package baylinux.socialMediaProject;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;

//@Entity
public class AppMedia {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
//	@ManyToOne
	private long appMediaGroupId;
//	@ManyToOne
	private long appMediaOwnerId;
	private String appMediaAddress;
	private String appMediaContentType;
	private String appMediaName;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getAppMediaGroupId() {
		return appMediaGroupId;
	}
	public void setAppMediaGroupId(long appMediaGroupId) {
		this.appMediaGroupId = appMediaGroupId;
	}
	public long getAppMediaOwnerId() {
		return appMediaOwnerId;
	}
	public void setAppMediaOwnerId(long appMediaOwnerId) {
		this.appMediaOwnerId = appMediaOwnerId;
	}
	public String getAppMediaAddress() {
		return appMediaAddress;
	}
	public void setAppMediaAddress(String appMediaAddress) {
		this.appMediaAddress = appMediaAddress;
	}
	public String getAppMediaContentType() {
		return appMediaContentType;
	}
	public void setAppMediaContentType(String appMediaContentType) {
		this.appMediaContentType = appMediaContentType;
	}
	public String getAppMediaName() {
		return appMediaName;
	}
	public void setAppMediaName(String appMediaName) {
		this.appMediaName = appMediaName;
	}
	
	
	
}
