package com.ezen.ezdiary.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.ezdiary.admin.dto.AdminAnswerDTO;
import com.ezen.ezdiary.admin.dto.AdminAskDTO;
import com.ezen.ezdiary.admin.dto.AdminMemberDTO;

public interface AdminController {
	
	//member
	public String login(AdminMemberDTO adminMemberDTO, RedirectAttributes rttr,
									HttpServletRequest request) throws Exception;
	public String adminlogout() throws Exception;
	
	//board
	//admin
	public String adminselect() throws Exception;
	public ModelAndView quesListArticles() throws Exception;
	public ModelAndView quesWrite() throws Exception;
	public ModelAndView quesWriteInsert(AdminAskDTO askDTO, AdminAnswerDTO answerDTO, HttpServletRequest request) throws Exception;
	public ModelAndView quesView(int ask_idx) throws Exception;
	public ModelAndView quesWriteUpdate() throws Exception;
	public ModelAndView quesWriteRemove() throws Exception;

	//user
	public ModelAndView userMsgListArticles() throws Exception;
	public ModelAndView userMsgView() throws Exception;
	public ModelAndView userMsgRemove() throws Exception;
}
