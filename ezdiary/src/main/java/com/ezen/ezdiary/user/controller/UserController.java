package com.ezen.ezdiary.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.ezdiary.user.dto.UserDTO;

public interface UserController {
	
	/* 유저 메인페이지 */
	public String mainPage() throws Exception;
	
	/* 닉네임 등록 페이지 */
	public String registNickPage() throws Exception;
	
	/* 닉네임 등록 */			    /* @ModelAttribute("nick") jsp에서 값을 불러올때 "nick"로 불러올 수 있음 */
	public ModelAndView registNick(@ModelAttribute("nick") UserDTO userDTO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	/* 하고싶은말 등록 */ 			
	public String sendMsg(HttpServletResponse response, UserDTO userDTO) throws Exception; 
}
