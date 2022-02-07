package com.ezen.ezdiary.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	private AdminAskDTO askDTO;
	@Autowired
	private AdminAnswerDTO answerDTO;
	@Autowired
	private UserService userService;
	@Autowired
	private HttpSession session;
	
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
	public String registNick(UserDTO userDTO, HttpServletRequest request) throws Exception {
		
		session = request.getSession();
		
		AdminAskDTO askDTO = userService.selectAsk();
		System.out.println("askDTO : " + askDTO.getAsk_idx());
		System.out.println("ezdiary/user/userSurvey?ask_idx=+askDTO.getAsk_idx() : "  + askDTO);
		
		AdminAnswerDTO answerDTO = userService.selectAnswer();
		System.out.println("answerDTO : " + answerDTO.getAnswer_idx());
		
		userService.registNick(userDTO);
		
		log.info("UserDTO : " + userDTO);
		log.info("닉네임 등록 성공");
		
		session.setAttribute("nick", userDTO);
		log.info("session : " + userDTO);
//		return "ezdiary/user/userSurvey?ask_idx="+askDTO.getAsk_idx();
		return "redirect:/survey?ask_idx="+askDTO.getAsk_idx()+"&answer_idx="+answerDTO.getAnswer_idx();
	}
	
//	@Override
//	@RequestMapping(value="/survey")
//	public String surveyPage() throws Exception {
//		System.out.println("설문조사 페이지");
//		return "/ezdiary/user/userSurvey";
//	}
	
	/* 설문조사 질문리스트 가져오기 */
	@Override
	@RequestMapping(value = "/survey" , method = RequestMethod.GET)
	public String surveyAskList(@RequestParam(value = "ask_idx" , required = false)int ask_idx,
								@RequestParam(value = "answer_idx" , required = false)int answer_idx, 
								Model model, AdminAskDTO askDTO, AdminAnswerDTO answerDTO) throws Exception {
		
		log.info("survey페이지 진입");
		model.addAttribute("ask", userService.askList(askDTO.getAsk_idx()));
		
		System.out.println("ask_idx : " + ask_idx);
		
		model.addAttribute("answer", userService.answerList(answerDTO.getAnswer_idx()));
		System.out.println("answer_cntnt : " + answerDTO.getAnswer_cntnt());
		System.out.println("answer_idx : " + answer_idx);
		
		log.info("model : " + model);
		
		return "/ezdiary/user/userSurvey";
	}
	
	/* 설문조사 답변리스트 가져오기 */
//	  @Override 
//	  @RequestMapping(value = "/survey" , method = RequestMethod.GET) 
//	  public String surveyAnswerList(Model model, @RequestParam(value = "answer_idx" , required = false)int answer_idx, AdminAnswerDTO answerDTO) throws Exception {
//	  model.addAttribute("answer", userService.answerList(answerDTO.getAnswer_idx()));
//	  System.out.println("answer_idx : " + answer_idx);
//	  return "/ezdiary/user/userSurvey";
//	  
//	  }
	
	/* 설문조사 질문지 인덱스 조회하기 */
//	@Override
//	@RequestMapping(value = "/survey" , method = RequestMethod.GET)
//	public String selectAsk(Model model) throws Exception {
//		
//		AdminAskDTO askDTO = userService.selectAsk();
//		System.out.println("ezdiary/user/userSurvey?ask_idx=+askDTO.getAsk_idx() : "  + askDTO);
//		System.out.println("askDTO : " + askDTO.getAsk_idx());
//		model.addAttribute("ask", userService.selectAsk());
//		
//		return "ezdiary/user/userSurvey?ask_idx="+askDTO.getAsk_idx();
//	}

	

	 
	 
	
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
	
	/* 하고싶은말 등록 페이지 */
	@Override
	@RequestMapping(value = "/msgPage" , method = RequestMethod.GET)
	public String msgPage() throws Exception {
		
		log.info("하고싶은말 등록 페이지 진입");
		return "/ezdiary/user/userMsg";
	}
	
	/* 하고싶은말 작성 */
	@Override
	@RequestMapping(value = "/msg" , method = RequestMethod.POST)
	public String sendMsg(UserMsgDTO userMsgDTO , HttpSession session) throws Exception {
		
		log.info("userMsgDTO : " + userMsgDTO );
		String writer = (String)session.getAttribute("nick");
		userMsgDTO.setWriter(writer);
		log.info("writer : " + writer );
		userService.sendMsg(userMsgDTO);
		
		return "redirect:/msgPage";
	}





}
