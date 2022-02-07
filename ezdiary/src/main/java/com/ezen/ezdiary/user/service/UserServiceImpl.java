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
	public AdminAskDTO selectAsk() throws Exception {
		return userDAO.selectAsk();
	}
	
	@Override
	public AdminAnswerDTO selectAnswer() throws Exception {
		return userDAO.selectAnswer();
	}
	
	@Override
	public AdminAskDTO askList(int ask_idx) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.askList(ask_idx);
	}
	
	@Override
	public AdminAnswerDTO answerList(int answer_idx) throws Exception {
		return userDAO.answerList(answer_idx);
	}

	@Override
	public void sendMsg(UserMsgDTO msgDTO) throws Exception {
		userDAO.insertMsg(msgDTO);
	}








	

	
}
