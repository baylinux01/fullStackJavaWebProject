package baylinux.socialMediaProject;

public class AppGroupAppGroupMemberRelation 
{
	private long id;
	private long appGroupId;
	private long appGroupMemberId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getAppGroupId() {
		return appGroupId;
	}
	public void setAppGroupId(long appGroupId) {
		this.appGroupId = appGroupId;
	}
	public long getAppGroupMemberId() {
		return appGroupMemberId;
	}
	public void setAppGroupMemberId(long appGroupMemberId) {
		this.appGroupMemberId = appGroupMemberId;
	}
	
	
}
