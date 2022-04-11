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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.ezdiary.admin.dto.AdminAnswerDTO;
import com.ezen.ezdiary.admin.dto.AdminAskDTO;
import com.ezen.ezdiary.admin.sevice.AdminService;
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
	@Autowired
	private AdminService adminService;
	
	/* 유저 메인페이지 */
	@Override
	@RequestMapping(value = "/main" , method = RequestMethod.GET)
	public String mainPage() throws Exception {
		
		log.info("메인페이지 진입!");
		return "ezdiary/user/userMain";
		
	}
	
	/* 닉네임 등록페이지 */
	@Override
	@RequestMapping(value = "/regist" , method = RequestMethod.GET)
	public String registNickPage() throws Exception {
		
		log.info("닉네임 등록페이지 진입!");
		return "ezdiary/user/userNick";
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
		  
		  List<AdminAnswerDTO> answerDTO = userService.selectAnswer();
		  
		  userService.registNick(userDTO);
		  
		  userDTO.setUser_idx(userService.selectUser(userDTO));
		  
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

		System.out.println("myAnswerDTO : " + myAnswerDTO);
		
		List<AdminAskDTO> askListDTO = userService.askList(askDTO);
		model.addAttribute("ask", askListDTO);	// 모델에 저장해준 "ask"는 jsp에서만 쓰인다.
		System.out.println("ask_idx : " + askListDTO);
		
		List<AdminAnswerDTO> answerListDTO = userService.answerList(answerDTO);
		model.addAttribute("answer", answerListDTO);
		System.out.println("answer_idx : " + answerListDTO);
		
		return "ezdiary/user/userSurvey";
	}

	@Override
	@ResponseBody
	@RequestMapping(value = "/bar" , method = RequestMethod.POST)
	public Map<String, Object> prograssBar(AdminAskDTO askDTO) throws Exception {
		
		System.out.println("Bar ajax 접근");
		
		Map<String, Object> result = new HashMap<String,Object>();
		
		result.put("ajaxAsk",userService.ajaxAsk(askDTO));
		
		System.out.println("===============ajaxAsk=============" + userService.ajaxAsk(askDTO));
		
		return result;
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

	/* 결과 로딩페이지 */
	@Override
	@RequestMapping(value = "/loading" , method = RequestMethod.GET)
	public String loadingPage() throws Exception {

		log.info("결과 로딩페이지 진입!");
		return "ezdiary/user/userResultloading";
	}
	
	/* 결과페이지 */
	@Override
	@RequestMapping(value = "/result" , method = RequestMethod.GET)
	public String resultPage(Model model) throws Exception {
		
		
  		List<MyAnswerDTO> answerDTO =  userService.getUserAnswer();
  		
  		System.out.println("answerDTO.size : " + answerDTO.size());
  		System.out.println("answerDTO : " + answerDTO);
  		
  		int lastAskNO = userService.lastAskNO();
  		
  		List<Integer> getAnswerCnt = new ArrayList<>();
  		
  		Map answerInfo = new HashMap<>();
  		
  		for(int i = 0; i<lastAskNO; i++) {
  			
  			int ask_idx = answerDTO.get(i).getAnswer_idx();
  			
  			for(int j = 0; j<3; j++) {

  			  int answer_idx = answerDTO.get(j).getAnswer_idx();
  			  
  			  answerInfo.put("ask_idx", ask_idx);
  			  answerInfo.put("answer_idx", answer_idx);
  			  
  			  int answerCount = userService.getAnswerCount(answerInfo);
	  
  			  getAnswerCnt.add(answerCount);
  		
  			}
			 
  		}

		System.out.println(getAnswerCnt);
		int userCount = adminService.userTotalCount();
		 model.addAttribute("userCount", userCount);
		 System.out.println("userCount : "+userCount);
  		
		model.addAttribute("answerInfo", answerDTO); 
		model.addAttribute("answerCnt", getAnswerCnt); 
		
		log.info("결과페이지 진입!");
		return "ezdiary/user/userResult";
	}
	
	/* 하고싶은말 등록 페이지 */
	@Override
	@RequestMapping(value = "/msgPage" , method = RequestMethod.GET)
	public String msgPage(MyAnswerDTO myAnswerDTO, Model model, HttpServletRequest request) throws Exception {
		
		log.info("하고싶은말 등록 페이지 진입");
		
		session = request.getSession();
		userDTO = (UserDTO)session.getAttribute("nick");
		
		int userIdx = userDTO.getUser_idx();
		
		myAnswerDTO.setUser_idx(userIdx);
		
		List<MyAnswerDTO> mySurveyList = userService.mySurveyList(myAnswerDTO);
		model.addAttribute("mySurveyList", mySurveyList);
		
		int userCount = adminService.userTotalCount();
		 model.addAttribute("userCount", userCount);
		 System.out.println("userCount : "+userCount);
		
		
		return "ezdiary/user/userMsg";
	}
	
	/* 하고싶은말 작성 */
	@Override
	@RequestMapping(value = "/msg" , method = RequestMethod.POST)
	public String sendMsg(UserMsgDTO userMsgDTO , HttpServletRequest request) throws Exception {
		
		log.info("userMsgDTO : " + userMsgDTO );
		session = request.getSession();
		userDTO = (UserDTO)session.getAttribute("nick");
		
		int userIdx = userDTO.getUser_idx();
		String userNick = userDTO.getUser_nick();
		
//		System.out.println("메세지 작성 useridx : " + userIdx);
		userMsgDTO.setUser_idx(userIdx);
		userMsgDTO.setUser_nick(userNick);
		
		userService.sendMsg(userMsgDTO);
		
//		System.out.println(userMsgDTO);
		
		return "redirect:/result";
	}

	/* ajax 답변 1 */
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
//		List<AdminAskDTO> askCntnt = userService.askList(askDTO);
		List<AdminAnswerDTO> answerCntnt = userService.myAnswer(answerDTO);
		
		int userIdx = userDTO.getUser_idx();
		answerIdx.get(0).getAnswer_idx();
//		askCntnt.get(0).getAsk_cntnt();
		System.out.println("============================");
		System.out.println("answerCntnt값 : " + answerCntnt.get(0).getAnswer_cntnt());		//3

		
		answerCntnt.get(0).getAnswer_cntnt();
		
		
		myAnswerDTO.setUser_idx(userIdx);
		myAnswerDTO.setAnswer_idx(answerIdx.get(0).getAnswer_idx());
		myAnswerDTO.setAsk_idx(ask_idx);
//		myAnswerDTO.setAsk_cntnt(askCntnt.get(0).getAsk_cntnt());
		myAnswerDTO.setAnswer_cntnt(answerCntnt.get(0).getAnswer_cntnt());
		
		
		
		int result = userService.registMyAnswer(myAnswerDTO);
		
		System.out.println("351252151521myAnswerDTO : " + myAnswerDTO);
		
		return result;
		
	}
	
	/* ajax 답변 2 */
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
//		List<AdminAskDTO> askCntnt = userService.askList(askDTO);
		List<AdminAnswerDTO> answerCntnt = userService.myAnswer(answerDTO);
		
		int userIdx = userDTO.getUser_idx();
		answerIdx.get(1).getAnswer_idx();
//		askCntnt.get(0).getAsk_cntnt();
		answerCntnt.get(1).getAnswer_cntnt();
		
		myAnswerDTO.setUser_idx(userIdx);
		myAnswerDTO.setAnswer_idx(answerIdx.get(1).getAnswer_idx());
		myAnswerDTO.setAsk_idx(ask_idx);
//		myAnswerDTO.setAsk_cntnt(askCntnt.get(0).getAsk_cntnt());
		myAnswerDTO.setAnswer_cntnt(answerCntnt.get(1).getAnswer_cntnt());
		
		int result = userService.registMyAnswer(myAnswerDTO);
		System.out.println("351252151521myAnswerDTO : " + myAnswerDTO);
		
		return result;
	}
	
	/* ajax 답변 3 */
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
//		List<AdminAskDTO> askCntnt = userService.askList(askDTO);
		List<AdminAnswerDTO> answerCntnt = userService.myAnswer(answerDTO);
		
		int userIdx = userDTO.getUser_idx();
		answerIdx.get(2).getAnswer_idx();
//		askCntnt.get(0).getAsk_cntnt();
		answerCntnt.get(2).getAnswer_cntnt();
		
		myAnswerDTO.setUser_idx(userIdx);
		myAnswerDTO.setAnswer_idx(answerIdx.get(2).getAnswer_idx());
		myAnswerDTO.setAsk_idx(ask_idx);
//		myAnswerDTO.setAsk_cntnt(askCntnt.get(0).getAsk_cntnt());
		myAnswerDTO.setAnswer_cntnt(answerCntnt.get(2).getAnswer_cntnt());
		
		int result = userService.registMyAnswer(myAnswerDTO);
		System.out.println("351252151521myAnswerDTO : " + myAnswerDTO);
		
		return result;
	}


	
}