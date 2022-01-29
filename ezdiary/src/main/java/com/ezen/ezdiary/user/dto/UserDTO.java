package com.ezen.ezdiary.user.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

/*user_idx	int			  				 
,	user_nick	varchar2(100) 				  
,	status		char(1)		  				 
,   writer		varchar2(100) 				 
,   write_date  DATE 	DEFAULT sysdate 	 
,	editor		varchar2(100)				 
,	edit_date	DATE 	DEFAULT sysdate	*/

@Component
public class UserDTO {
	
	private int user_idx;
	private String user_nick;
	private String status;
	private String writer;
	private Date write_date;
	private String editor;
	private Date edit_date;
	
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public String getUser_nick() {
		return user_nick;
	}
	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public Date getEdit_date() {
		return edit_date;
	}
	public void setEdit_date(Date edit_date) {
		this.edit_date = edit_date;
	}
	
	@Override
	public String toString() {
		return "UserDTO [user_idx=" + user_idx + ", user_nick=" + user_nick + ", status=" + status + ", writer="
				+ writer + ", write_date=" + write_date + ", editor=" + editor + ", edit_date=" + edit_date + "]";
	}
	
	
	
}
