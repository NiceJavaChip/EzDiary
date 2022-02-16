package com.ezen.ezdiary.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.ezdiary.admin.dto.AdminAnswerDTO;
import com.ezen.ezdiary.admin.dto.AdminAskDTO;
import com.ezen.ezdiary.user.dto.MyAnswerDTO;
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
//	==/regist, method post 함수 역할==
//			1. userNick에서 닉네임 입력 후 엔터를 누르면 
//				1-1. 닉네임이 등록된다. 
//					1-2. 첫 질문지 인덱스값을 조회한다.
//						1-3. 그 값을(첫 질문지 인덱스값)을 /survey 주소로를 포함시켜서 이동한다.
	@Override
	@RequestMapping(value = "/regist" , method = RequestMethod.POST)
	public String registNick(UserDTO userDTO, HttpServletRequest request) throws Exception {
		
		session = request.getSession();
		List<AdminAskDTO> askDTO = userService.selectAsk();
		System.out.println("askDTO : " + askDTO.get(0).getAsk_idx());
		
		List<AdminAnswerDTO> answerDTO = userService.selectAnswer();
		System.out.println("answerDTO : " + answerDTO.get(0).getAsk_idx());
		
		userService.registNick(userDTO);
		
		log.info("UserDTO : " + userDTO);
		log.info("닉네임 등록 성공");
		
		session.setAttribute("nick", userDTO);
		log.info("session : " + userDTO);
		return "redirect:/survey?ask_idx="+askDTO.get(0).getAsk_idx();
	}

	
	/* 설문조사 질문리스트 가져오기 */
//	==/survey, method get 함수 역할==	
//			1. /regist, method post 함수에서 받아온 파라미터를 확인한다.
//			2. 받아온 파라미터로 질문지를 조회한다.
//			3. 받아온 파라미터로 선택지를 조회한다.(1,2번과 동일한 파라미터)
//			4. jsp 페이지에서 확인한다.
	@Override
	@RequestMapping(value = "/survey" , method = RequestMethod.GET)
	public String surveyAskList(AdminAskDTO askDTO, AdminAnswerDTO answerDTO, Model model) throws Exception {
		
		log.info("survey페이지 진입");
		List<AdminAskDTO> askListDTO = userService.askList(askDTO);
		model.addAttribute("ask", askListDTO);	// 모델에 저장해준 "ask"는 jsp에서만 쓰인다.
		
		System.out.println("ask_idx : " + askListDTO);
		
		List<AdminAnswerDTO> answerListDTO = userService.answerList(answerDTO);
		model.addAttribute("answer", answerListDTO);
		
		System.out.println("answer_idx : " + answerListDTO);
		
		return "/ezdiary/user/userSurvey";
	}

	
	  @Override
	  @ResponseBody
	  @RequestMapping(value = "/survey2" , method = RequestMethod.POST) 
	  public Map<String, Object> testAjax(@RequestParam("ask_idx") int ask_idx, AdminAnswerDTO answerDTO, AdminAskDTO askDTO)
	  throws Exception {
		  
		System.out.println("ask_idx : "+ ask_idx);  
	  
	  System.out.println("ajax 컨트롤러 접근");
	  
	  Map<String, Object> result = new HashMap<String,Object>();
	  
	  System.out.println(userService.ajaxAsk(askDTO));
	  System.out.println(userService.ajaxAnswer(answerDTO));
	  
	  result.put("ajaxAsk",userService.ajaxAsk(askDTO));
	  result.put("ajaxAnswer",userService.ajaxAnswer(answerDTO));
	  
	  return result; 
	  
	  }
	  @ResponseBody
	  @RequestMapping(value = "/survey3" , method = RequestMethod.POST) 
	  public Map<String, Object> testAjax7(@RequestParam("ask_idx") int ask_idx, AdminAnswerDTO answerDTO, AdminAskDTO askDTO)
			  throws Exception {
		  
		  System.out.println("ask_idx : "+ ask_idx);  
		  
		  System.out.println("ajax 컨트롤러 접근");
		  
		  Map<String, Object> result = new HashMap<String,Object>();
		  
		  System.out.println(userService.ajaxAsk(askDTO));
		  System.out.println(userService.ajaxAnswer(answerDTO));
		  
		  result.put("ajaxAsk",userService.ajaxAsk(askDTO));
		  result.put("ajaxAnswer",userService.ajaxAnswer(answerDTO));
		  
		  return result; 
		  
	  }
	 
	
	@Override
	@ResponseBody
	@RequestMapping(value = "/survey5" , method = RequestMethod.POST)
	public void testAjax4(@RequestParam("answer_idx") int answer_idx) throws Exception {
		
		System.out.println("survey2");
		

	}
	
	@ResponseBody
	@RequestMapping(value = "/survey6" , method = RequestMethod.POST)
	public void testAjax1(@RequestParam("answer_idx") int answer_idx) throws Exception {
		
		System.out.println("survey3");
		
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/survey7" , method = RequestMethod.POST)
	public void testAjax2(@RequestParam("answer_idx") int answer_idx) throws Exception {
		
		System.out.println("survey4");
		
		
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
	public String resultPage(Model model) throws Exception {
		
		
  		List<MyAnswerDTO> answerDTO =  userService.getUserAnswer();	
  		
  		System.out.println("answerDTO.size : " + answerDTO.size());
  		System.out.println("answerDTO : " + answerDTO);
  		answerDTO.get(0).getAsk_idx();
  		
  		int lastAskNO = userService.lastAskNO();
  		
  		List<Integer> getAnswerCnt = new ArrayList<>();
  		
  		Map answerInfo = new HashMap<>();
  		
  		for(int i = 0; i<lastAskNO; i++) {
  			
  			int ask_idx = answerDTO.get(i).getAnswer_idx();
  			
  			System.out.println(1);
  			System.out.println(ask_idx);
  			
  			for(int j = 0; j<3; j++) {

  			  int answer_idx = answerDTO.get(j).getAnswer_idx();
  			  
  			  System.out.println(2);
  			  System.out.println("answer_idx : " + answer_idx);
  			  
  			  answerInfo.put("ask_idx", ask_idx);
  			  answerInfo.put("answer_idx", answer_idx);
  			  
  			  System.out.println(3);
  			  System.out.println("answerInfo : "+answerInfo);
  			  
  			  int answerCount = userService.getAnswerCount(answerInfo);
  			  
  			  System.out.println(4);
  			  System.out.println("answerCount" + answerCount);
  			  
  			  getAnswerCnt.add(answerCount);
  			  System.out.println(5);
  			  System.out.println("answerCnt : "+getAnswerCnt);
  			}
			 
  		}

		System.out.println(getAnswerCnt);
  		
		model.addAttribute("answerInfo", answerDTO); 
		model.addAttribute("answerCnt", getAnswerCnt); 
		
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