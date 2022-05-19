package com.dancestudioSpring.DTO.User;

public class UserSearchDTO {

    private int page;
    private String queryString;
    
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getQueryString() {
		return queryString;
	}
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
    
    
}
