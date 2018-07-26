package com.neuedu.entity;

import java.io.Serializable;
import java.util.List;

public class PageModel<T> implements Serializable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 8411220394663258663L;
	//每一页的数据集合
	private List<T> data;
	//一共有多少页
	private int totalPage;
	//当前页面
	private int currentPage;
	
	
	
	@Override
	public String toString() {
		return "PageModel [data=" + data + ", totalPage=" + totalPage + ", currentPage=" + currentPage + "]";
	}
	public PageModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageModel(List<T> data, int totalPage, int currentPage) {
		super();
		this.data = data;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
	
	
	

