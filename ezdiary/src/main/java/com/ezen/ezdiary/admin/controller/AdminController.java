package com.ezen.ezdiary.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.ezdiary.admin.dto.AdminAnswerDTO;
import com.ezen.ezdiary.admin.dto.AdminAskDTO;
import com.ezen.ezdiary.admin.dto.AdminBoardDTO;
import com.ezen.ezdiary.admin.dto.AdminMemberDTO;
import com.ezen.ezdiary.admin.dto.UserJoinDTO;
import com.ezen.ezdiary.user.dto.UserDTO;
import com.ezen.ezdiary.user.dto.UserMsgDTO;

public interface AdminController {
	
	//member
	public String login(AdminMemberDTO adminMemberDTO, RedirectAttributes rttr,
									HttpServletRequest request) throws Exception;
	public String adminlogout() throws Exception;
	
	//board
	//admin
	public String adminselect() throws Exception;
	public ModelAndView quesListArticles(AdminBoardDTO boardDTO, HttpServletRequest request) throws Exception;
	public ModelAndView quesWrite() throws Exception;
	public ModelAndView quesWriteInsert(AdminAskDTO askDTO, AdminAnswerDTO answerDTO, HttpServletRequest request) throws Exception;
	public ModelAndView quesView(@RequestParam("ask_idx") int ask_idx) throws Exception;
	public ModelAndView quesWriteUpdatePage(@RequestParam("ask_idx") int ask_idx) throws Exception;
	public ModelAndView quesWriteUpdate(AdminAskDTO askDTO, AdminAnswerDTO answerDTO, HttpServletRequest request, RedirectAttributes rttr) throws Exception;
	public ModelAndView quesWriteRemove(AdminAskDTO askDTO, AdminAnswerDTO answerDTO, HttpServletRequest request) throws Exception;

	//user
	public ModelAndView userMsgListArticles(AdminBoardDTO boardDTO, HttpServletRequest request) throws Exception;
	public ModelAndView userMsgView(@RequestParam("user_idx") int user_idx) throws Exception;
	public ModelAndView userMsgRemove(UserDTO userDTO, UserMsgDTO msgDTO, HttpServletRequest request) throws Exception;
	public ModelAndView userTotalCount() throws Exception;
	
}

