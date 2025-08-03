package baylinux.socialMediaProject;

import java.time.LocalDateTime;
import java.time.ZoneId;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;

//@Entity
public class AppMessagePost {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
//	@ManyToOne
	private long appMessagePostSenderId;
//	@ManyToOne
	private long appMessagePostReceiverId;
//	@ManyToOne
	private String appMessagePostContent;
	
	
//	@ManyToOne
	private long appMediaId;
	
	private long quotedAppMessagePostId;
	
	private long deletedForSender=0;
	
	private long deletedForReceiver=0;
	
	private long readByReceiver=0;
	
	private String date=LocalDateTime.now(ZoneId.of("Turkey")).toString();
	
	private String editDate=LocalDateTime.now(ZoneId.of("Turkey")).toString();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAppMessagePostSenderId() {
		return appMessagePostSenderId;
	}

	public void setAppMessagePostSenderId(long appMessagePostSenderId) {
		this.appMessagePostSenderId = appMessagePostSenderId;
	}

	public long getAppMessagePostReceiverId() {
		return appMessagePostReceiverId;
	}

	public void setAppMessagePostReceiverId(long appMessagePostReceiverId) {
		this.appMessagePostReceiverId = appMessagePostReceiverId;
	}

	public String getAppMessagePostContent() {
		return appMessagePostContent;
	}

	public void setAppMessagePostContent(String appMessagePostContent) {
		this.appMessagePostContent = appMessagePostContent;
	}

	public long getAppMediaId() {
		return appMediaId;
	}

	public void setAppMediaId(long appMediaId) {
		this.appMediaId = appMediaId;
	}

	public long getQuotedAppMessagePostId() {
		return quotedAppMessagePostId;
	}

	public void setQuotedAppMessagePostId(long quotedAppMessagePostId) {
		this.quotedAppMessagePostId = quotedAppMessagePostId;
	}

	public long getDeletedForSender() {
		return deletedForSender;
	}

	public void setDeletedForSender(long deletedForSender) {
		this.deletedForSender = deletedForSender;
	}

	public long getDeletedForReceiver() {
		return deletedForReceiver;
	}

	public void setDeletedForReceiver(long deletedForReceiver) {
		this.deletedForReceiver = deletedForReceiver;
	}

	public long getReadByReceiver() {
		return readByReceiver;
	}

	public void setReadByReceiver(long readByReceiver) {
		this.readByReceiver = readByReceiver;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEditDate() {
		return editDate;
	}

	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}

	
	
	
}
