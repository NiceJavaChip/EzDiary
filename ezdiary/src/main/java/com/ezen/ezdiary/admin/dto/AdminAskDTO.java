package com.ezen.ezdiary.admin.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

/*
 *  ask_idx        int                      
,   ask_cntnt   varchar2(1000)               
,   status      char(1)                    
,   writer      varchar2(100)             
,   write_date  DATE    DEFAULT sysdate    
,   editor      varchar2(100)            
,   edit_date   DATE    DEFAULT sysdate  
 */

@Component
public class AdminAskDTO {

	private int ask_idx;
	private String ask_cntnt;
	private char status;
	private String writer;
	private Date write_date;
	private String editor;
	private Date edit_date;
	
	public AdminAskDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getAsk_idx() {
		return ask_idx;
	}

	public void setAsk_idx(int ask_idx) {
		this.ask_idx = ask_idx;
	}

	public String getAsk_cntnt() {
		return ask_cntnt;
	}

	public void setAsk_cntnt(String ask_cntnt) {
		this.ask_cntnt = ask_cntnt;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
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
	
	
	
}
