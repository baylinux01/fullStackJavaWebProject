package baylinux.socialMediaProject;



import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;


//@Entity
public class AppConnectionRequest {
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
//	@ManyToOne
	private long appConnectionRequestSenderId;
//	@ManyToOne
	private long appConnectionRequestReceiverId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getAppConnectionRequestSenderId() {
		return appConnectionRequestSenderId;
	}
	public void setAppConnectionRequestSenderId(long connectionRequestSenderId) {
		this.appConnectionRequestSenderId = connectionRequestSenderId;
	}
	public long getAppConnectionRequestReceiverId() {
		return appConnectionRequestReceiverId;
	}
	public void setAppConnectionRequestReceiverId(long connectionRequestReceiverId) {
		this.appConnectionRequestReceiverId = connectionRequestReceiverId;
	}
	
	
	
}
