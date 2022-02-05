package com.ezen.ezdiary.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.ezdiary.admin.dto.AdminAnswerDTO;
import com.ezen.ezdiary.admin.dto.AdminAskDTO;
import com.ezen.ezdiary.user.dto.UserDTO;
import com.ezen.ezdiary.user.dto.UserMsgDTO;

public interface UserController {
	
	/* 유저 메인페이지 */
	public String mainPage() throws Exception;
	
	/* 닉네임 등록 페이지 */
	public String registNickPage() throws Exception;
	
	/* 닉네임 등록 */			    /* @ModelAttribute("nick") jsp에서 값을 불러올때 "nick"로 불러올 수 있음 */
//	public ModelAndView registNick(@ModelAttribute("nick") UserDTO userDTO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	/* 닉네임 등록 */
	public String registNick(UserDTO userDTO) throws Exception;
	
	/* 설문조사 페이지 */
//	public String surveyPage() throws Exception;
	
	/* 설문조사 질문리스트 가져오기 */
	public String surveyAskList(Model model) throws Exception;
	
	/* 설문조사 답변리스트 가져오기 */
	public ModelAndView surveyAnswerList(@RequestParam(value = "ask_idx") int ask_idx, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	/* 설문조사 결과 로딩페이지 */
	public String loadingPage() throws Exception;
	
	/* 설문조사 결과페이지 */
	public String resultPage() throws Exception;
	
	/* 하고싶은말 등록 */ 			
	public String sendMsg(UserMsgDTO userMsgDTO) throws Exception; 
}
