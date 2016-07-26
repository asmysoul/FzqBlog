package top.fzqblog.po.model;

import java.util.Date;

import top.fzqblog.utils.CustomDateSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class ShuoShuoLike {
    private Integer id;

    private Integer shuoshuoId;

	@Override
	public String toString() {
		return "ShuoShuoLike [id=" + id + ", shuoshuoId=" + shuoshuoId
				+ ", userId=" + userId + ", userIcon=" + userIcon
				+ ", userName=" + userName + ", createTime=" + createTime + "]";
	}

	public Integer getShuoshuoId() {
		return shuoshuoId;
	}

	public void setShuoshuoId(Integer shuoshuoId) {
		this.shuoshuoId = shuoshuoId;
	}

	private Integer userId;

    private String userIcon;

    private String userName;

    private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		this.userIcon = userIcon;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@JsonSerialize(using = CustomDateSerializer.class)  
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


    
 
}