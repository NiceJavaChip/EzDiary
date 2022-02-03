package com.ezen.ezdiary.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.ezdiary.admin.dto.AdminAnswerDTO;
import com.ezen.ezdiary.admin.dto.AdminAskDTO;
import com.ezen.ezdiary.admin.dto.AdminMemberDTO;
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
	
	@RequestMapping(value = "loginView", method = RequestMethod.GET)
	public String adminlogin() {
		
		return "ezdiary/admin/adminLogin";	//여기서 setViewName을 어떻게 쓰지
	}

	@Override
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(AdminMemberDTO adminMemberDTO, RedirectAttributes rttr,
			HttpServletRequest request) throws Exception {
		
		System.out.println("login 메서드 진입");
		
		HttpSession session = request.getSession();
		memberDTO = adminService.login(adminMemberDTO);
		
		if(memberDTO == null) {
			int result = 0;
			rttr.addFlashAttribute("result", result);
			return "redirect:loginView";
		}
		
		session.setAttribute("member", memberDTO);
		
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

	@Override
	@RequestMapping(value = "adminQuesList", method = RequestMethod.GET)
	public ModelAndView quesListArticles() throws Exception{
		ModelAndView mav = new ModelAndView("ezdiary/admin/adminQuesList");
		
		List<AdminAskDTO> askDTO = adminService.quseList();
		System.out.println("전달된 데이터 " + askDTO);
		mav.addObject("quesList", askDTO);
		
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
	public ModelAndView quesWriteInsert(AdminAskDTO askDTO, HttpServletRequest request) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		memberDTO = (AdminMemberDTO) session.getAttribute("member");
		String writer = memberDTO.getAdmin_name();
		System.out.println("전달된 writer " + writer);
		askDTO.setWriter(writer);
		
		System.out.println("이름 설정 전 데이터 " + askDTO);
		adminService.quesEnroll(askDTO);
		mav.setViewName("redirect:/adminQuesList");
		
		return mav;
	}

	//추가한 질문지 상세페이지
	@Override
	@RequestMapping(value = "adminQuesView", method = RequestMethod.GET) 
	public ModelAndView quesView() throws Exception{
		ModelAndView mav = new ModelAndView("ezdiary/admin/adminQuesView");
		return mav;
	}

	//추가한 질문지 상세페이지의 수정 페이지
	@Override
	@RequestMapping(value = "adminQuesMod")
	public ModelAndView quesWriteUpdate() throws Exception{
		ModelAndView mav = new ModelAndView("ezdiary/admin/adminquesMod");
		return mav;
	}

	
	//추가한 질문지 상세페이지 삭제 기능
	@Override
	public ModelAndView quesWriteRemove() throws Exception{
		ModelAndView mav = new ModelAndView("ezdiary/admin/adminQuesView");
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
