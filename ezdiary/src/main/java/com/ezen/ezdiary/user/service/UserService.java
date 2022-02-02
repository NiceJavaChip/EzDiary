package com.ezen.ezdiary.user.service;

import java.util.List;
import java.util.Map;

import com.ezen.ezdiary.admin.dto.AdminAnswerDTO;
import com.ezen.ezdiary.admin.dto.AdminAskDTO;
import com.ezen.ezdiary.user.dto.UserDTO;

public interface UserService {
	
	public void registNick(UserDTO userDTO) throws Exception;
	
//	public int registNick(UserDTO userDTO) throws Exception;
	public List<AdminAskDTO> askList() throws Exception;
	
	public List<AdminAnswerDTO> answerList() throws Exception;
	
	public int sendMsg(Map msgMap) throws Exception;
}
