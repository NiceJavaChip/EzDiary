package com.ezen.ezdiary.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.ezdiary.user.dto.UserDTO;

@Controller
@RequestMapping("/user")
public class UserControllerImpl implements UserController {
	
	@Autowired
	private UserDTO userDTO;
	
	/* 유저 메인페이지 */
	@Override
	@RequestMapping(value = "/main" , method = RequestMethod.GET)
	public String mainPage() throws Exception {
		
		return "/user/userMain";
	}
	
	/* 닉네임 등록페이지 */
	@Override
	@RequestMapping(value = "/regist")
	public String registNickPage() throws Exception {
		
		return "/user/userNick";
	}
	
	/* 닉네임 등록 */
	@Override
	@RequestMapping(value = "/regist" , method = RequestMethod.POST)
	public ModelAndView registNick(UserDTO userDTO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView("redirect:/user/userSurvey");
		
		return mav;
	}
	
	/* 하고싶은말 작성 */
	@Override
	@RequestMapping(value = "/msg" , method = RequestMethod.POST)
	public String sendMsg(HttpServletResponse response, UserDTO userDTO) throws Exception {
		
		return "redirect:/user/userResult";
	}

}
