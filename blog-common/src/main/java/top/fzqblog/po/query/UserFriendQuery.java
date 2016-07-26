package top.fzqblog.po.query;

import top.fzqblog.utils.Page;

public class UserFriendQuery extends BaseQuery{
	private Integer userId;
	private Integer friendUserId;
	private Page page;
	private int pageNum = 1;
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
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
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	
}
