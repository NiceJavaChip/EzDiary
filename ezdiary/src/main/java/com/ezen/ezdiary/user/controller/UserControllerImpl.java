package com.ezen.ezdiary.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.ezdiary.admin.dto.AdminAnswerDTO;
import com.ezen.ezdiary.admin.dto.AdminAskDTO;
import com.ezen.ezdiary.user.dto.UserDTO;
import com.ezen.ezdiary.user.dto.UserMsgDTO;
import com.ezen.ezdiary.user.service.UserService;

@Controller
public class UserControllerImpl implements UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserControllerImpl.class);
	
	@Autowired
	private UserDTO userDTO;
	
	@Autowired
	private UserMsgDTO userMsgDTO;
	
	@Autowired
	private UserService userService;
	
	/* 유저 메인페이지 */
	@Override
	@RequestMapping(value = "/main" , method = RequestMethod.GET)
	public String mainPage() throws Exception {
		
		log.info("메인페이지 진입!");
		return "/ezdiary/user/userMain";
		
	}
	
	/* 닉네임 등록페이지 */
	@Override
	@RequestMapping(value = "/regist" , method = RequestMethod.GET)
	public String registNickPage() throws Exception {
		
		log.info("닉네임 등록페이지 진입!");
		return "/ezdiary/user/userNick";
	}
	
	/* 닉네임 등록 */
//	@Override
//	@RequestMapping(value = "/regist" , method = RequestMethod.POST)
//	public ModelAndView registNick(UserDTO userDTO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		/* UserDTO클래스에 데이터가 의도대로 저장되었는지 확인 */
//		log.info("UserDTO : " + userDTO);
		
//		ModelAndView mav = new ModelAndView("redirect:/survey");
//		userService.registNick(userDTO);
		
		
//		return mav;
//	}
	
	/* 닉네임 등록 */
	@Override
	@RequestMapping(value = "/regist" , method = RequestMethod.POST)
	public String registNick(UserDTO userDTO) throws Exception {
		log.info("UserDTO : " + userDTO);
		userService.registNick(userDTO);
		
		return "redirect:/survey";
	}
	
	/* 설문조사 페이지 */
	@Override
	@RequestMapping(value = "/survey" , method = {RequestMethod.GET , RequestMethod.POST})
	public String surveyPage() throws Exception {
		
		log.info("설문조사 페이지 진입!");
		return "/ezdiary/user/userSurvey";
	}
	
	/* 설문조사 질문리스트 가져오기 */
	@Override
	@RequestMapping(value = "/ask" , method = RequestMethod.GET)
	public String surveyAskList(Model model) throws Exception {
		
		return "/ezdiary/user/userSurvey";
	}
	
	/* 설문조사 답변리스트 가져오기 */
	@Override
	@RequestMapping(value = "/answer" , method =  RequestMethod.GET)
	public String surveyAnswerList(Model model) throws Exception {
		
		return "/ezdiary/user/userSurvey";
	}
	
	/* 결과 로딩페이지 */
	@Override
	@RequestMapping(value = "/loading" , method = RequestMethod.GET)
	public String loadingPage() throws Exception {

		log.info("결과 로딩페이지 진입!");
		return "/ezdiary/user/userResultloading";
	}
	
	/* 결과페이지 */
	@Override
	@RequestMapping(value = "/result" , method = RequestMethod.GET)
	public String resultPage() throws Exception {
		
		log.info("결과페이지 진입!");
		return "/ezdiary/user/userResult";
	}
	
	/* 하고싶은말 작성 */
	@Override
	@RequestMapping(value = "/msg" , method = RequestMethod.POST)
	public String sendMsg(UserMsgDTO userMsgDTO) throws Exception {
		
		return "redirect:/result";
	}



}
