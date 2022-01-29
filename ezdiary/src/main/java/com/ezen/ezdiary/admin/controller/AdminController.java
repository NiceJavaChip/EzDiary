package com.ezen.ezdiary.admin.controller;

import org.springframework.web.servlet.ModelAndView;

public interface AdminController {
	
	//member
	public String adminlogin();
	public String adminlogout();
	
	//board
	//admin
	public String adminselect();
	public ModelAndView quesListArticles();
	public ModelAndView quesWrite();
	public ModelAndView quesWriteInsert();
	public ModelAndView quesView();
	public ModelAndView quesWriteUpdate();
	public ModelAndView quesWriteRemove();

	//user
	public ModelAndView userMsgListArticles();
	public ModelAndView userMsgView();
	public ModelAndView userMsgRemove();
}
