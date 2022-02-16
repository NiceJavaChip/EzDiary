package com.ezen.ezdiary.user.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String registNick(UserDTO userDTO, HttpServletRequest request) throws Exception;
	
//	public String selectAsk(Model model) throws Exception;
	
	/* 설문조사 페이지 */
//	public String surveyPage() throws Exception;
	/* 설문조사 질문리스트 가져오기 */
	public String surveyAskList(AdminAskDTO askDTO, AdminAnswerDTO answerDTO, Model model) throws Exception;
	
	/* 설문조사 답변리스트 가져오기 */
//	public String surveyAnswerList(Model model, @RequestParam(value = "answer_idx" , required = false)int answer_idx, AdminAnswerDTO answerDTO) throws Exception;
	
	/* 설문조사 결과 로딩페이지 */
	public String loadingPage() throws Exception;
	
	/* 설문조사 결과페이지 */
	public String resultPage(Model model) throws Exception;
	
	/* 하고싶은말 등록 페이지 */
	public String msgPage() throws Exception;
	
	/* 하고싶은말 등록 */ 			
	public String sendMsg(UserMsgDTO userMsgDTO, HttpSession session) throws Exception; 
	
	/* ajax 통신 */
	
	  public Map<String, Object> testAjax(@RequestParam("ask_idx") int ask_idx, AdminAnswerDTO answerDTO, AdminAskDTO
	  askDTO) throws Exception;
	 
	public void testAjax4(@RequestParam("answer_idx") int answer_idx) throws Exception;
}
