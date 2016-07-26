package top.fzqblog.po.model;

import java.util.Date;

import top.fzqblog.utils.CustomDateSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class UserFriend{
	private Integer userId;

    private Integer friendUserId;
    
    public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getFriendUserId() {
		return friendUserId;
	}

	public void setFriendUserId(Integer friendUserId) {
		this.friendUserId = friendUserId;
	}

	private String userIcon;

    private String userName;

    private String friendUserIcon;

    private String friendUserName;

    private Date createTime;

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon == null ? null : userIcon.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getFriendUserIcon() {
        return friendUserIcon;
    }

    public void setFriendUserIcon(String friendUserIcon) {
        this.friendUserIcon = friendUserIcon == null ? null : friendUserIcon.trim();
    }

    public String getFriendUserName() {
        return friendUserName;
    }

    public void setFriendUserName(String friendUserName) {
        this.friendUserName = friendUserName == null ? null : friendUserName.trim();
    }
    @JsonSerialize(using = CustomDateSerializer.class)  
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	@Override
	public String toString() {
		return "UserFriend [userId=" + userId + ", friendUserId="
				+ friendUserId + ", userIcon=" + userIcon + ", userName="
				+ userName + ", friendUserIcon=" + friendUserIcon
				+ ", friendUserName=" + friendUserName + ", createTime="
				+ createTime + "]";
	}
    
    
}