package top.fzqblog.utils;

public class Page {
	private int start = 0;
	private int end;
	private int pageNum=1;//当前页
	private int count;//数据总数
	private int pageSize;//一页多少条数据
	private int pageTotal;
	
	public int getPageTotal() {
		return count%pageSize==0? count/pageSize:count/pageSize+1;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	public Page() {

	}
	public Page(int pageNum, int count, int pageSize) {
		this.pageNum = pageNum;
		this.count = count;
		this.pageSize = pageSize;
	}
	public int getStart() {
		return (pageNum - 1) * pageSize;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return pageSize;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
