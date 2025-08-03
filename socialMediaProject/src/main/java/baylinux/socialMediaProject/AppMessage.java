package baylinux.socialMediaProject;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;


//@Entity
public class AppMessage {
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
//	@ManyToOne
	private long appMessageSenderId;
	
//	@ManyToOne
	private long appMessageReceiverId;
	
	private String appMessageContent;


	public long getId() {
		return id;
	}


	public long getAppMessageSenderId() {
		return appMessageSenderId;
	}


	public void setAppMessageSenderId(long appMessageSenderId) {
		this.appMessageSenderId = appMessageSenderId;
	}


	public long getAppMessageReceiverId() {
		return appMessageReceiverId;
	}


	public void setAppMessageReceiverId(long appMessageReceiverId) {
		this.appMessageReceiverId = appMessageReceiverId;
	}

	public String getAppMessageContent() {
		return appMessageContent;
	}


	public void setAppMessageContent(String appMessageContent) {
		this.appMessageContent = appMessageContent;
	}


	public void setId(long id) {
		this.id = id;
	}

	
}
