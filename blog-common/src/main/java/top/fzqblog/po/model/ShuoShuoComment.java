package top.fzqblog.po.model;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import top.fzqblog.utils.CustomDateSerializer;
import top.fzqblog.utils.Emotions;
import top.fzqblog.utils.Emotions.Dev;

public class ShuoShuoComment {
    private Integer id;

    private Integer shuoshuoId;

    private String content;

    private Date createTime;

    private Integer userId;

    private String userIcon;

    private String userName;
    
    private String showContent;
    
    
    public String getShowContent() {
    	this.showContent = Emotions.formatEmotion(this.content, Dev.WEB);
    	return showContent;
	}

	public void setShowContent(String showContent) {
		this.showContent = showContent;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShuoshuoId() {
        return shuoshuoId;
    }

    public void setShuoshuoId(Integer shuoshuoId) {
        this.shuoshuoId = shuoshuoId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
    @JsonSerialize(using = CustomDateSerializer.class)  
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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

	@Override
	public String toString() {
		return "ShuoShuoComment [id=" + id + ", shuoshuoId=" + shuoshuoId
				+ ", content=" + content + ", createTime=" + createTime
				+ ", userId=" + userId + ", userIcon=" + userIcon
				+ ", userName=" + userName + "]";
	}
    
    
}