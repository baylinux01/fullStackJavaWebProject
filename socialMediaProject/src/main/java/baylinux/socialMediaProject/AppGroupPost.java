package baylinux.socialMediaProject;

import java.time.LocalDateTime;
import java.time.ZoneId;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;

//@Entity
public class AppGroupPost {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
//	@ManyToOne
	private long ownerId;
//	@ManyToOne
	private long appGroupId;
//	@ManyToOne
	private String appGroupPostContent;
//	@ManyToOne
	private long appMediaId;
	
	private long quotedAppGroupPostId;
	
	private long readByQuotedAppCommentOwner=0;
	
	private long readByQuotedAppMediaOwner=0;
	
	private String date=LocalDateTime.now(ZoneId.of("Turkey")).toString();
	
	private String editDate=LocalDateTime.now(ZoneId.of("Turkey")).toString();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

	public long getAppGroupId() {
		return appGroupId;
	}

	public void setAppGroupId(long appGroupId) {
		this.appGroupId = appGroupId;
	}

	public String getAppGroupPostContent() {
		return appGroupPostContent;
	}

	public void setAppGroupPostContent(String appGroupPostContent) {
		this.appGroupPostContent = appGroupPostContent;
	}

	public long getAppMediaId() {
		return appMediaId;
	}

	public void setAppMediaId(long appMediaId) {
		this.appMediaId = appMediaId;
	}

	public long getQuotedAppGroupPostId() {
		return quotedAppGroupPostId;
	}

	public void setQuotedAppGroupPostId(long quotedAppGroupPostId) {
		this.quotedAppGroupPostId = quotedAppGroupPostId;
	}

	public long getReadByQuotedAppCommentOwner() {
		return readByQuotedAppCommentOwner;
	}

	public void setReadByQuotedAppCommentOwner(long readByQuotedAppCommentOwner) {
		this.readByQuotedAppCommentOwner = readByQuotedAppCommentOwner;
	}

	public long getReadByQuotedAppMediaOwner() {
		return readByQuotedAppMediaOwner;
	}

	public void setReadByQuotedAppMediaOwner(long readByQuotedAppMediaOwner) {
		this.readByQuotedAppMediaOwner = readByQuotedAppMediaOwner;
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
