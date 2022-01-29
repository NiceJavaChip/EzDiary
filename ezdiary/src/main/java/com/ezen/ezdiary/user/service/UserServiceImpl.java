package com.ezen.ezdiary.user.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.ezdiary.user.dao.UserDAO;
import com.ezen.ezdiary.user.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public int registNick(UserDTO userDTO) throws Exception {
		
		return userDAO.insertNick(userDTO);
	}

	@Override
	public int sendMsg(Map msgMap) throws Exception {
		
		int msgNo = userDAO.insertMsg(msgMap);
		msgMap.put("msgNo", msgNo);
		
		return msgNo;
	}
	
}
