package com.ezen.ezdiary.user.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

/*CREATE TABLE EZ_DIARY_USER_ANSWER (
		user_idx		int
	,	user_nick		varchar2(100)
	,	ask_idx			int
	,	answer_idx		int
	,	ask_cntnt		varchar2(1000)
	,	answer_cntnt	varchar2(1000)
	,	status			char(1)		  				 
	,   writer			varchar2(100) 				 
	,   write_date  	DATE 	DEFAULT sysdate 	 
	,	editor			varchar2(100)				 
	,	edit_date		DATE 	DEFAULT sysdate	
	);*/
@Component
public class MyAnswerDTO {
	
	private int user_idx;
	private int ask_idx;
	private int answer_idx;
	private String user_nick;
	private String ask_cntnt;
	private String answer_cntnt;
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
	public int getAsk_idx() {
		return ask_idx;
	}
	public void setAsk_idx(int ask_idx) {
		this.ask_idx = ask_idx;
	}
	public int getAnswer_idx() {
		return answer_idx;
	}
	public void setAnswer_idx(int answer_idx) {
		this.answer_idx = answer_idx;
	}
	public String getAsk_cntnt() {
		return ask_cntnt;
	}
	public void setAsk_cntnt(String ask_cntnt) {
		this.ask_cntnt = ask_cntnt;
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
	
	public String getUser_nick() {
		return user_nick;
	}
	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}
	
	public String getAnswer_cntnt() {
		return answer_cntnt;
	}
	public void setAnswer_cntnt(String answer_cntnt) {
		this.answer_cntnt = answer_cntnt;
	}
	
	@Override
	public String toString() {
		return "MyAnswerDTO [user_idx=" + user_idx + ", ask_idx=" + ask_idx + ", answer_idx=" + answer_idx
				+ ", user_nick=" + user_nick + ", ask_cntnt=" + ask_cntnt + ", answer_cntnt=" + answer_cntnt
				+ ", status=" + status + ", writer=" + writer + ", write_date=" + write_date + ", editor=" + editor
				+ ", edit_date=" + edit_date + "]";
	}
	
}
