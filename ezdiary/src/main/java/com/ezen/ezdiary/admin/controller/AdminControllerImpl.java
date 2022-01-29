package com.ezen.ezdiary.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	

	@Override
	@RequestMapping(value = "login.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String adminlogin() {
		
		return "ezdiary/admin/adminLogin";	//여기서 setViewName을 어떻게 쓰지
	}

	@Override		//추후 처리할 예정
	public String adminlogout() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@RequestMapping(value = "adminselect.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String adminselect() {
		// TODO Auto-generated method stub
		return "ezdiary/admin/adminSelect";
	}

	@Override
	@RequestMapping(value = "adminQuesList.do", method = RequestMethod.GET)
	public ModelAndView quesListArticles() {
		ModelAndView mav = new ModelAndView("ezdiary/admin/adminQuesList");
		
		return mav;
	}

	@Override
	@RequestMapping(value = "adminWrite.do", method = RequestMethod.GET)
	public ModelAndView quesWrite() {
		ModelAndView mav = new ModelAndView("ezdiary/admin/quesWrite");
		
		return mav;
	}

	@Override
	/* @RequestMapping(value = "quesWrite.do",method = RequestMethod.GET) */
	public ModelAndView quesWriteInsert() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("ezdiary/admin/quesWrite");
		
		return mav;
	}

	@Override
	/* @RequestMapping(value = "adminWrite.do", method = RequestMethod.GET) */
	public ModelAndView quesView() {
		ModelAndView mav = new ModelAndView("ezdiary/admin/adminQuesView");
		return null;
	}

	@Override
	public ModelAndView quesWriteUpdate() {
		ModelAndView mav = new ModelAndView("ezdiary/admin/adminQuesMod");
		return mav;
	}

	@Override
	public ModelAndView quesWriteRemove() {
		ModelAndView mav = new ModelAndView("ezdiary/admin/adminQuesView");
		return null;
	}

	@Override
	public ModelAndView userMsgListArticles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView userMsgView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView userMsgRemove() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
