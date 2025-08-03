package baylinux.socialMediaProject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;


//@Entity
public class AppComment {
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
//	@ManyToOne(fetch=FetchType.EAGER)
	private long appCommentOwnerId;
	private String appCommentContent;


//	@ManyToOne
	private long appGroupId;
	//@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
	private String appCommentDate=LocalDateTime.now(ZoneId.of("Turkey")).toString();
	//@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
	private String appCommentEditDate=LocalDateTime.now(ZoneId.of("Turkey")).toString();
	
	
	
	public AppComment() {
		super();
		// TODO Auto-generated constructor stub
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public long getAppCommentOwnerId() {
		return appCommentOwnerId;
	}



	public void setAppCommentOwnerId(long appCommentOwnerId) {
		this.appCommentOwnerId = appCommentOwnerId;
	}



	public String getAppCommentContent() {
		return appCommentContent;
	}



	public void setAppCommentContent(String appCommentContent) {
		this.appCommentContent = appCommentContent;
	}



	public long getAppGroupId() {
		return appGroupId;
	}



	public void setAppGroupId(long appGroupId) {
		this.appGroupId = appGroupId;
	}



	public String getAppCommentDate() {
		return appCommentDate;
	}



	public void setAppCommentDate(String appCommentDate) {
		this.appCommentDate = appCommentDate;
	}



	public String getAppCommentEditDate() {
		return appCommentEditDate;
	}



	public void setAppCommentEditDate(String appCommentEditDate) {
		this.appCommentEditDate = appCommentEditDate;
	}
	

	
}
