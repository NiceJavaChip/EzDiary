package com.ezen.ezdiary.admin.dto;

public class AdminBoardDTO {
	
	private int pageNum;
	private int total;
	
	private String search;
	
	public AdminBoardDTO() {
		this(1,10);
	}
	
	public AdminBoardDTO(int pageNum, int total) {
		this.pageNum = pageNum;
		this.total = total;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	@Override
	public String toString() {
		return "AdminBoardDTO [pageNum=" + pageNum + ", total=" + total + ", search=" + search + "]";
	}
	
	

}
