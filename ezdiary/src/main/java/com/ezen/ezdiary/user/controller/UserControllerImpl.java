package com.ezen.ezdiary.user.controller;

import java.util.Enumeration;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	private MyAnswerDTO myAnswerDTO;
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
	public String registNick(UserDTO userDTO, MyAnswerDTO myAnswerDTO ,HttpServletRequest request,  RedirectAttributes rAttr) throws Exception {
		
		session = request.getSession(); 
		List<AdminAskDTO> askDTO = userService.selectAsk(); 
		System.out.println("askDTO : " + askDTO.get(0).getAsk_idx());
		  
		  List<AdminAnswerDTO> answerDTO = userService.selectAnswer();
		  System.out.println("answerDTO : " + answerDTO.get(0).getAsk_idx());
		  
		  userService.registNick(userDTO);
		  
		  userDTO.setUser_idx(userService.selectUser(userDTO));
		  
//		  userService.selectUser(userDTO);
//		  System.out.println("userDTO : " + userDTO);
		  
		  
		  log.info("UserDTO : " + userDTO); log.info("닉네임 등록 성공");
		  
		  session.setAttribute("nick", userDTO);
		  
		  
		
		return "redirect:/survey?ask_idx="+askDTO.get(0).getAsk_idx()+"&user_idx="+userDTO.getUser_idx();
		
	}

	
	/* 설문조사 질문리스트 가져오기 */
//	==/survey, method get 함수 역할==	
//			1. /regist, method post 함수에서 받아온 파라미터를 확인한다.
//			2. 받아온 파라미터로 질문지를 조회한다.
//			3. 받아온 파라미터로 선택지를 조회한다.(1,2번과 동일한 파라미터)
//			4. jsp 페이지에서 확인한다.
	@Override
	@RequestMapping(value = "/survey" , method = RequestMethod.GET)
	public String surveyAskList(MyAnswerDTO myAnswerDTO, UserDTO userDTO, AdminAskDTO askDTO, AdminAnswerDTO answerDTO, Model model, HttpServletRequest request) throws Exception {
		
		log.info("survey페이지 진입");
		
		session = request.getSession();
		userDTO = (UserDTO) session.getAttribute("nick");
		
		int nickIdx = userDTO.getUser_idx();
		String userInfo = userDTO.getUser_nick();
		int answerIdx = answerDTO.getAnswer_idx();
		
		myAnswerDTO.setUser_nick(userInfo);
		myAnswerDTO.setUser_idx(nickIdx);
		myAnswerDTO.setAnswer_idx(answerIdx);
		
		System.out.println("user session확인 : " + nickIdx);
		System.out.println("myAnswerDTO : " + myAnswerDTO);
		
		List<AdminAskDTO> askListDTO = userService.askList(askDTO);
		model.addAttribute("ask", askListDTO);	// 모델에 저장해준 "ask"는 jsp에서만 쓰인다.
		System.out.println("ask_idx : " + askListDTO);
		
		List<AdminAnswerDTO> answerListDTO = userService.answerList(answerDTO);
		model.addAttribute("answer", answerListDTO);
		System.out.println("answer_idx : " + answerListDTO);
		
		
//		userService.registMyAnswer(myAnswerDTO);
		System.out.println("myAnswerDTO 정보 : " + myAnswerDTO);
		
		return "/ezdiary/user/userSurvey";
	}
	
	/*ajax 통신*/
	@Override
	@ResponseBody
	@RequestMapping(value = "/survey2" , method = RequestMethod.POST)
	public Map<String, Object> testAjax(AdminAnswerDTO answerDTO, AdminAskDTO askDTO, MyAnswerDTO myAnswerDTO, UserDTO userDTO) throws Exception {
		
		System.out.println("ajax 컨트롤러 접근");
		
		Map<String, Object> result = new HashMap<String,Object>();
		
		System.out.println(userService.ajaxAsk(askDTO));
		System.out.println(userService.ajaxAnswer(answerDTO));
		
		System.out.println("myAnswerDTO 정보 : " + myAnswerDTO);
		
		result.put("ajaxAsk",userService.ajaxAsk(askDTO));
		result.put("ajaxAnswer",userService.ajaxAnswer(answerDTO));
		
		return result;
	}
	
	/* 내가 선택한 선택지 */
//	@Override
//	@RequestMapping(value = "/myAsk" , method = RequestMethod.POST)
//	public String myAnswer(AdminAskDTO askDTO, AdminAnswerDTO answerDTO , MyAnswerDTO myAnswerDTO, HttpServletRequest request, Model model) throws Exception {
//		
//		session = request.getSession();
//		userDTO = (UserDTO) session.getAttribute("nick");
//		
//		int userIdx = userDTO.getUser_idx();
//		myAnswerDTO.setUser_idx(userIdx);
//		userService.registMyAnswer(myAnswerDTO);
//		
//		
//		return "redirect:/survey";
//	}
	
	/*ajax 통신2*/
//	@Override
//	@ResponseBody
//	@RequestMapping(value = "/myAsk2" , method = RequestMethod.POST)
//	public int myAnswerRegist(AdminAnswerDTO answerDTO, AdminAskDTO askDTO, MyAnswerDTO myAnswerDTO,HttpServletRequest request) throws Exception {
//		
//		System.out.println("myAsk2 ajax 컨트롤러 접근");
//		
//		session = request.getSession();
//		userDTO = (UserDTO)session.getAttribute("nick");
//		
//		int userIdx = userDTO.getUser_idx();
//		
//		List<AdminAnswerDTO> answerIdx = userService.selectAnswer();
//		
//		System.out.println(userIdx);
//		System.out.println(answerIdx.get(0).getAnswer_idx());
//		System.out.println(answerIdx.get(1).getAnswer_idx());
//		System.out.println(answerIdx.get(2).getAnswer_idx());
//		
//		myAnswerDTO.setUser_idx(userIdx);
//		myAnswerDTO.setAnswer_idx(answerIdx.get(0).getAnswer_idx());
//		
//		if(answerIdx.get(0).getAnswer_idx() == 1 ) {
//			
//			myAnswerDTO.setAnswer_idx(answerIdx.get(0).getAnswer_idx());
//			
//		} else if(answerIdx.get(1).getAnswer_idx() == 2) {
//			
//			myAnswerDTO.setAnswer_idx(answerIdx.get(1).getAnswer_idx());
//			
//		} else if(answerIdx.get(2).getAnswer_idx() == 3) {
//			
//			myAnswerDTO.setAnswer_idx(answerIdx.get(2).getAnswer_idx());
//			
//		}
//		
//		int result = userService.registMyAnswer(myAnswerDTO);
//		
//		System.out.println(myAnswerDTO);
//		return result;
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

	@Override
	@ResponseBody
	@RequestMapping(value = "/answer1" , method = RequestMethod.POST)
	public int myAnswerRegist1(@RequestParam("ask_idx")int ask_idx, AdminAnswerDTO answerDTO, AdminAskDTO askDTO, MyAnswerDTO myAnswerDTO,
			HttpServletRequest request) throws Exception {
		
		System.out.println("ajax answer1");
		System.out.println("===========ask_idx========= : "+ask_idx);
		
		
		session = request.getSession();
		userDTO = (UserDTO)session.getAttribute("nick");
		
		List<AdminAnswerDTO> answerIdx = userService.myAnswer(answerDTO);
		List<AdminAskDTO> askIdx = userService.selectAsk();
		List<AdminAnswerDTO> answerCntnt = userService.myAnswer(answerDTO);
		
		int userIdx = userDTO.getUser_idx();
		answerIdx.get(0).getAnswer_idx();
//		askIdx.get(0).getAsk_idx();
		System.out.println("============================");
		System.out.println("answerCntnt값 : " + answerCntnt.get(0).getAnswer_cntnt());
		answerCntnt.get(0).getAnswer_cntnt();
		
		
		myAnswerDTO.setUser_idx(userIdx);
		myAnswerDTO.setAnswer_idx(answerIdx.get(0).getAnswer_idx());
//		myAnswerDTO.setAsk_idx(askIdx.get(0).getAsk_idx());
		myAnswerDTO.setAsk_idx(ask_idx);
		myAnswerDTO.setAnswer_cntnt(answerCntnt.get(0).getAnswer_cntnt());
		
		
		
		int result = userService.registMyAnswer(myAnswerDTO);
		
		System.out.println("351252151521myAnswerDTO : " + myAnswerDTO);
		
		return result;
		
	}

	@Override
	@ResponseBody
	@RequestMapping(value = "/answer2" , method = RequestMethod.POST)
	public int myAnswerRegist2(@RequestParam("ask_idx")int ask_idx, AdminAnswerDTO answerDTO, AdminAskDTO askDTO, MyAnswerDTO myAnswerDTO,
			HttpServletRequest request) throws Exception {
		
		System.out.println("ajax answer2");
		System.out.println("===========ask_idx========= : "+ask_idx);
		session = request.getSession();
		userDTO = (UserDTO)session.getAttribute("nick");
		
		List<AdminAnswerDTO> answerIdx = userService.myAnswer(answerDTO);
		List<AdminAskDTO> askIdx = userService.selectAsk();
		List<AdminAnswerDTO> answerCntnt = userService.myAnswer(answerDTO);
		
		int userIdx = userDTO.getUser_idx();
		answerIdx.get(1).getAnswer_idx();
//		askIdx.get(0).getAsk_idx();
		answerCntnt.get(1).getAnswer_cntnt();
		
		myAnswerDTO.setUser_idx(userIdx);
		myAnswerDTO.setAnswer_idx(answerIdx.get(1).getAnswer_idx());
//		myAnswerDTO.setAsk_idx(askIdx.get(0).getAsk_idx());
		myAnswerDTO.setAsk_idx(ask_idx);
		myAnswerDTO.setAnswer_cntnt(answerCntnt.get(1).getAnswer_cntnt());
		
		int result = userService.registMyAnswer(myAnswerDTO);
		System.out.println("351252151521myAnswerDTO : " + myAnswerDTO);
		
		return result;
	}

	@Override
	@ResponseBody
	@RequestMapping(value = "/answer3" , method = RequestMethod.POST)
	public int myAnswerRegist3(@RequestParam("ask_idx")int ask_idx, AdminAnswerDTO answerDTO, AdminAskDTO askDTO, MyAnswerDTO myAnswerDTO,
			HttpServletRequest request) throws Exception {
		
		System.out.println("ajax answer3");
		System.out.println("===========ask_idx========= : "+ask_idx);
		session = request.getSession();
		userDTO = (UserDTO)session.getAttribute("nick");
		
		List<AdminAnswerDTO> answerIdx = userService.myAnswer(answerDTO);
//		List<AdminAskDTO> askIdx = userService.selectAsk();
		List<AdminAnswerDTO> answerCntnt = userService.myAnswer(answerDTO);
		
		int userIdx = userDTO.getUser_idx();
		answerIdx.get(2).getAnswer_idx();
//		askIdx.get(0).getAsk_idx();
		answerCntnt.get(2).getAnswer_cntnt();
		
		myAnswerDTO.setUser_idx(userIdx);
		myAnswerDTO.setAnswer_idx(answerIdx.get(2).getAnswer_idx());
//		myAnswerDTO.setAsk_idx(askIdx.get(0).getAsk_idx());
		myAnswerDTO.setAsk_idx(ask_idx);
		myAnswerDTO.setAnswer_cntnt(answerCntnt.get(2).getAnswer_cntnt());
		
		int result = userService.registMyAnswer(myAnswerDTO);
		System.out.println("351252151521myAnswerDTO : " + myAnswerDTO);
		
		return result;
	}



}
