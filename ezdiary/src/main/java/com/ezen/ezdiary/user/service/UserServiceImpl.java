package com.ezen.ezdiary.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.ezdiary.admin.dto.AdminAnswerDTO;
import com.ezen.ezdiary.admin.dto.AdminAskDTO;
import com.ezen.ezdiary.user.dao.UserDAO;
import com.ezen.ezdiary.user.dto.MyAnswerDTO;
import com.ezen.ezdiary.user.dto.UserDTO;
import com.ezen.ezdiary.user.dto.UserMsgDTO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public void registNick(UserDTO userDTO) throws Exception {

		userDAO.insertNick(userDTO);
	}
	
	@Override
	public int selectUser(UserDTO userDTO) throws Exception {
		return userDAO.selectUser(userDTO);
	}
	
	@Override
	public List<AdminAskDTO> selectAsk() throws Exception {
		return userDAO.selectAsk();
	}
	
	@Override
	public List<AdminAnswerDTO> selectAnswer() throws Exception {
		return userDAO.selectAnswer();
	}
	
	@Override
	public List<AdminAskDTO> askList(AdminAskDTO askDTO) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.askList(askDTO);
	}
	
	@Override
	public List<AdminAnswerDTO> answerList(AdminAnswerDTO answerDTO) throws Exception {
		return userDAO.answerList(answerDTO);
	}
	
	@Override
	public List<AdminAskDTO> ajaxAsk(AdminAskDTO askDTO) throws Exception {
		return userDAO.ajaxAsk(askDTO);
	}
	
	@Override
	public List<AdminAnswerDTO> myAnswer(AdminAnswerDTO answerDTO) throws Exception {
		return userDAO.myAnswer(answerDTO);
	}
	
	@Override
	public List<AdminAnswerDTO> ajaxAnswer(AdminAnswerDTO answerDTO) throws Exception {
		return userDAO.ajaxAnswer(answerDTO);
	}
	
	@Override
	public List<MyAnswerDTO> mySurveyList(MyAnswerDTO myAsnwerDTO) throws Exception {
		return userDAO.mySurveyList(myAsnwerDTO);
	}
	
	@Override
	public int registMyAnswer(MyAnswerDTO myAnswerDTO) throws Exception {
		 return userDAO.insertMyAnswer(myAnswerDTO);
	}
	
	@Override
	public void sendMsg(UserMsgDTO msgDTO) throws Exception {
		userDAO.insertMsg(msgDTO);
	}

	@Override
	public List<MyAnswerDTO> getUserAnswer() throws Exception {
	
		return userDAO.getUserAnswer();
	}

	@Override
	public int getAnswerCount(int ask_idx,int answer_idx) throws Exception {
		
		return userDAO.getAnswerCount(ask_idx,answer_idx);
	}

	@Override
	public int getAnswerCount(Map answerInfo) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.getAnswerCount(answerInfo);
	}

	@Override
	public int lastAskNO() throws Exception {
		
		return userDAO.lastAskNO();
	}












	

	
}