package com.ezen.ezdiary.user.service;

import java.util.Map;

import com.ezen.ezdiary.user.dto.UserDTO;

public interface UserService {
	
	public int registNick(UserDTO userDTO) throws Exception;
	
	public int sendMsg(Map msgMap) throws Exception;
}
