package top.fzqblog.po.query;

import top.fzqblog.utils.Page;

public class ShuoShuoQuery extends BaseQuery{
	private Integer id;
	private Integer userId;
	private Integer shuoShuoId;
	private Page page;
	private int pageNum = 1;
	

	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
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
	public Integer getShuoShuoId() {
		return shuoShuoId;
	}
	public void setShuoShuoId(Integer shuoShuoId) {
		this.shuoShuoId = shuoShuoId;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	
	
}
