package com.ezen.ezdiary.admin.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.ezdiary.admin.dto.AdminAnswerDTO;
import com.ezen.ezdiary.admin.dto.AdminAskDTO;
import com.ezen.ezdiary.admin.dto.AdminBoardDTO;
import com.ezen.ezdiary.admin.dto.AdminMemberDTO;
import com.ezen.ezdiary.admin.dto.BoardPageDTO;
import com.ezen.ezdiary.admin.sevice.AdminService;

@Controller("adminController")
public class AdminControllerImpl implements AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private AdminMemberDTO memberDTO;
	@Autowired
	private AdminAnswerDTO answerDTO;
	@Autowired
	private AdminAskDTO askDTO;
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value = "loginView", method = RequestMethod.GET)
	public String adminlogin() {
		
		return "ezdiary/admin/adminLogin";	//여기서 setViewName을 어떻게 쓰지
	}

	@Override
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(AdminMemberDTO adminMemberDTO, RedirectAttributes rttr,
			HttpServletRequest request) throws Exception {
		
		System.out.println("login 메서드 진입");
		
		session = request.getSession();
		memberDTO = adminService.login(adminMemberDTO);
		
		if(memberDTO == null) {
			int result = 0;
			rttr.addFlashAttribute("result", result);
			return "redirect:loginView";
		}
		
		session.setAttribute("member", memberDTO);
		session.setAttribute("isLogOn", true);
		
		return "redirect:adminselect";	
	}

	@Override		//추후 처리할 예정
	public String adminlogout() throws Exception{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@RequestMapping(value = "adminselect", method = {RequestMethod.GET,RequestMethod.POST})
	public String adminselect() throws Exception{
		// TODO Auto-generated method stub
		return "ezdiary/admin/adminSelect";
	}
	
	//jsp 페이지에서 .do를 붙였는데도 adminselect 페이지가 나왔다... 왜?

	/*
	 * @Override
	 * 
	 * @RequestMapping(value = "adminQuesList", method = RequestMethod.GET) public
	 * ModelAndView quesListArticles() throws Exception{ ModelAndView mav = new
	 * ModelAndView("ezdiary/admin/adminQuesList");
	 * 
	 * List<AdminAskDTO> askDTO = adminService.quseList();
	 * System.out.println("전달된 데이터 " + askDTO); mav.addObject("quesList", askDTO);
	 * 
	 * return mav; }
	 */
	
	@Override
	@RequestMapping(value = "adminQuesList", method = RequestMethod.GET)
	public ModelAndView quesListArticles(AdminBoardDTO boardDTO, HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView();

		  String search = request.getParameter("search");
		  
		  System.out.println("search = "+ search);
		  
		  boardDTO.setSearch(search);
		  
		  System.out.println("뭘까요? = "+boardDTO.getSearch());
		
		  mav.addObject("quesList", adminService.getQuesListPaging(boardDTO));
		  System.out.println("전달된 데이터 " + boardDTO);
		  
		  int amount = adminService.getAmount(boardDTO);
		  
		  System.out.println(amount);
		  
		  BoardPageDTO pageDTO = new BoardPageDTO(boardDTO, amount);
		  
		  System.out.println(pageDTO);
		  
		  mav.addObject("boardPage", pageDTO);
		  
		  mav.setViewName("ezdiary/admin/adminQuesList");
		
		return mav;
	}

	//질문지 추가 페이지
	@Override
	@RequestMapping(value = "quesWrite", method = RequestMethod.GET)
	public ModelAndView quesWrite() throws Exception{
		ModelAndView mav = new ModelAndView("ezdiary/admin/quesWrite");
		
		return mav;
	}

	//질문지 추가 기능
	@Override
	@RequestMapping(value = "quesWriteInsert",method = RequestMethod.POST)
	public ModelAndView quesWriteInsert(AdminAskDTO askDTO, AdminAnswerDTO answerDTO, HttpServletRequest request) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		session = request.getSession();
		memberDTO = (AdminMemberDTO) session.getAttribute("member");
		String writer = memberDTO.getWriter();
		
		if(writer != null) {
			askDTO.setWriter(writer);
			adminService.quesEnroll(askDTO);
			System.out.println("quesINFO Insert" + askDTO);
			int parentNO = adminService.lastAskNO(askDTO);
			System.out.println("parentNO : "+ parentNO);
			
			if(parentNO != 0) {
				
				answerDTO.setAsk_idx(parentNO);
				for(int i= 1; i<=3; i++) {
					askDTO.getAsk_idx();
					answerDTO.setAnswer_idx(i);
					
					String anwerWriter = memberDTO.getWriter();
					
					answerDTO.setWriter(anwerWriter);
					adminService.answerEnroll(answerDTO);
				}
			}
		}
		
		
		mav.setViewName("redirect:/adminQuesList");
		
		return mav;
	}

	//질문지 상세페이지
	@Override
	@RequestMapping(value = "adminQuesView", method = {RequestMethod.GET,RequestMethod.POST}) 
	public ModelAndView quesView(@RequestParam("ask_idx") int ask_idx) throws Exception{
		
		
		Map<String, Object> articleMap = adminService.getAskNO(ask_idx);
		
		ModelAndView mav = new ModelAndView();
		
		/* mav.addObject("askInfo", adminService.getAskNO(ask_idx)); */
		System.out.println("ask_idx : " + ask_idx);

		mav.setViewName("ezdiary/admin/adminQuesView");
		mav.addObject("articleMap", articleMap);
		return mav;
	}
	
	//추가한 질문지 상세페이지의 수정 페이지
	@Override
	@RequestMapping(value = "adminQuesModPage", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView quesWriteUpdatePage(@RequestParam("ask_idx") int ask_idx) throws Exception {
		
		Map<String, Object> articleMap = adminService.getAskNO(ask_idx);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ezdiary/admin/adminquesMod");
		mav.addObject("articleMap", articleMap);
		
		return mav;
	}

	//추가한 질문지 수정페이지의 수정하기
	@Override
	@RequestMapping(value = "adminQuesMod", method = RequestMethod.POST)
	public ModelAndView quesWriteUpdate(AdminAskDTO askDTO, AdminAnswerDTO answerDTO, HttpServletRequest request, RedirectAttributes rttr) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		session = request.getSession();
		memberDTO = (AdminMemberDTO) session.getAttribute("member");
		String writer = memberDTO.getWriter();
		

		if(writer != null) {
			
			Map<String, Object> articleMap = new HashMap<>();
			
			askDTO.setEditor(writer);
			
			articleMap.put("editor", askDTO.getEditor());
			
			Enumeration enu = request.getParameterNames();
			while(enu.hasMoreElements()) {
				String name = (String) enu.nextElement();
				
				String value = request.getParameter(name);
				
				articleMap.put(name, value);
			}

			String ask_idx = (String) articleMap.get("ask_idx");

			adminService.modifyQues(articleMap); 
			
			
			for(int i= 1; i<=3; i++) {
				askDTO.getAsk_idx();
				answerDTO.setAnswer_idx(i);
				
				articleMap.put("answer_idx", answerDTO.getAnswer_idx());
				
				String anwerWriter = memberDTO.getWriter();
				answerDTO.setWriter(anwerWriter);
				
				articleMap.put("editor", answerDTO.getWriter());
				
				articleMap.put("answer_cntnt", answerDTO.getAnswer_cntnt());
				adminService.modifyAnswer(articleMap);

				System.out.println("answer_idx"  + articleMap.get("answer_idx"));
				System.out.println("answer_cntnt"  + articleMap.get("answer_cntnt"));
			}
			
			mav.setViewName("redirect:/adminQuesView?ask_idx="+ask_idx);
		}
		
		return mav;
	}

	
	//추가한 질문지 상세페이지 삭제 기능
	@Override
	@RequestMapping(value = "removeQues", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView quesWriteRemove(AdminAskDTO askDTO, AdminAnswerDTO answerDTO, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		session = request.getSession();
		memberDTO = (AdminMemberDTO) session.getAttribute("member");
		String writer = memberDTO.getWriter();
		

		if(writer != null) {
			
			Map<String, Object> articleMap = new HashMap<>();
			
			askDTO.setEditor(writer);
			
			articleMap.put("editor", askDTO.getEditor());
			
			Enumeration enu = request.getParameterNames();
			
			while(enu.hasMoreElements()) {
				String name = (String) enu.nextElement();
				String value = request.getParameter(name);
				articleMap.put(name, value);
			}
			
			int askNOresult = askDTO.getAsk_idx();
			
			System.out.println(askNOresult);
			
			articleMap.put("ask_idx", askDTO.getAsk_idx());

			adminService.removeQues(articleMap); 


			askDTO.getAsk_idx();
			  
			String anwerWriter = memberDTO.getWriter();
			answerDTO.setWriter(anwerWriter); 
		    articleMap.put("editor",answerDTO.getWriter());  
				  
			adminService.removeAnswer(articleMap);

			mav.setViewName("redirect:/adminQuesList");
		}
		
		return mav;
	}

	
	//유저 Msg의 게시판 페이지
	@Override
	@RequestMapping(value = "userMsgList")
	public ModelAndView userMsgListArticles() throws Exception{
		ModelAndView mav = new ModelAndView("ezdiary/admin/userMsgList");
		return mav;
	}

	//유저 Msg 게시판의 상세 페이지(게시물)
	@Override
	@RequestMapping(value = "userMsgView")
	public ModelAndView userMsgView() throws Exception{
		ModelAndView mav = new ModelAndView("ezdiary/admin/userMsgView");
		return mav;
	}

	//유저 Msg 게시판의 상세 게시물의 삭제 기능
	@Override
	public ModelAndView userMsgRemove() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
	

}
