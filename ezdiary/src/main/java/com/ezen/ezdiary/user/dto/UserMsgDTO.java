package com.ezen.ezdiary.user.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

/*	msg_idx		int							 
,	user_idx	int							  
,	msg_cntnt	varchar2(1000)				  
,	status		char(1)		  				 
,   writer		varchar2(100) 				 
,   write_date  DATE 	DEFAULT sysdate 	 
,	editor		varchar2(100)				 
,	edit_date	DATE 	DEFAULT sysdate*/
@Component
public class UserMsgDTO {
	
	private int msg_idx;
	private int user_idx;
	private String msg_cntnt;
	private String status;
	private String writer;
	private Date write_date;
	private String editor;
	private Date edit_date;
	public int getMsg_idx() {
		return msg_idx;
	}
	public void setMsg_idx(int msg_idx) {
		this.msg_idx = msg_idx;
	}
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public String getMsg_cntnt() {
		return msg_cntnt;
	}
	public void setMsg_cntnt(String msg_cntnt) {
		this.msg_cntnt = msg_cntnt;
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
		return "UserMsgDTO [msg_idx=" + msg_idx + ", user_idx=" + user_idx + ", msg_cntnt=" + msg_cntnt + ", status="
				+ status + ", writer=" + writer + ", write_date=" + write_date + ", editor=" + editor + ", edit_date="
				+ edit_date + "]";
	}
	
}
