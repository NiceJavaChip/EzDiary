package com.ezen.ezdiary.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.ezdiary.admin.dto.AdminAnswerDTO;
import com.ezen.ezdiary.admin.dto.AdminAskDTO;
import com.ezen.ezdiary.user.dao.UserDAO;
import com.ezen.ezdiary.user.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public void registNick(UserDTO userDTO) throws Exception {
		
		userDAO.insertNick(userDTO);
	}

//	@Override
//	public int registNick(UserDTO userDTO) throws Exception {
//		
//		return userDAO.insertNick(userDTO);
//	}
	
	@Override
	public List<AdminAskDTO> askList() throws Exception {
		// TODO Auto-generated method stub
		return userDAO.askList();
	}
	
	@Override
	public List<AdminAnswerDTO> answerList() throws Exception {
		// TODO Auto-generated method stub
		return userDAO.answerList();
	}

	@Override
	public int sendMsg(Map msgMap) throws Exception {
		
		int msgNo = userDAO.insertMsg(msgMap);
		msgMap.put("msgNo", msgNo);
		
		return msgNo;
	}

	

	
}
