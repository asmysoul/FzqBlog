package top.fzqblog.po.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import top.fzqblog.utils.CustomDateSerializer;
import top.fzqblog.utils.Emotions;
import top.fzqblog.utils.Emotions.Dev;



public class ShuoShuo {
    private Integer id;

    private Integer userId;

    private String userIcon;

    private String userName;

    private String imageUrl;

    private String imageUrlSmall;

    private String musicUrl;

    private Date createTime;

    private Integer commentCount;

    private Integer likeCount;

    private String content;
    
    private String showContent;

	private List<ShuoShuoComment> commentList = new ArrayList<ShuoShuoComment>();
	
	private List<ShuoShuoLike> shuoShuoLikeList = new ArrayList<ShuoShuoLike>();


	public List<ShuoShuoLike> getShuoShuoLikeList() {
		return shuoShuoLikeList;
	}

	public void setShuoShuoLikeList(List<ShuoShuoLike> shuoShuoLikeList) {
		this.shuoShuoLikeList = shuoShuoLikeList;
	}

	public String getShowContent() {
    	this.showContent = Emotions.formatEmotion(this.content, Dev.WEB);
    	return showContent;
	}

	public void setShowContent(String showContent) {
		this.showContent = showContent;
	}


    public List<ShuoShuoComment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<ShuoShuoComment> commentList) {
		this.commentList = commentList;
	}

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
        this.userIcon = userIcon == null ? null : userIcon.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public String getImageUrlSmall() {
        return imageUrlSmall;
    }

    public void setImageUrlSmall(String imageUrlSmall) {
        this.imageUrlSmall = imageUrlSmall == null ? null : imageUrlSmall.trim();
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl == null ? null : musicUrl.trim();
    }
    @JsonSerialize(using = CustomDateSerializer.class)  
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	@Override
	public String toString() {
		return "ShuoShuo [id=" + id + ", userId=" + userId + ", userIcon="
				+ userIcon + ", userName=" + userName + ", imageUrl="
				+ imageUrl + ", imageUrlSmall=" + imageUrlSmall + ", musicUrl="
				+ musicUrl + ", createTime=" + createTime + ", commentCount="
				+ commentCount + ", likeCount=" + likeCount + ", content="
				+ content + ", showContent=" + showContent + ", commentList="
				+ commentList + ", shuoShuoLikeList=" + shuoShuoLikeList + "]";
	}




    
    
}