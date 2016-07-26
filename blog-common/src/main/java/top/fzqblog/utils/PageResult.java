package top.fzqblog.utils;

import java.util.List;

public class PageResult <T>{
	private Page page;
	
	private List<T> list;
	
	public PageResult() {
	
	}
	
	public PageResult(Page page, List<T> list) {
		this.page = page;
		this.list = list;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "PageResult [page=" + page + ", list=" + list + "]";
	}
	
	
	
}
