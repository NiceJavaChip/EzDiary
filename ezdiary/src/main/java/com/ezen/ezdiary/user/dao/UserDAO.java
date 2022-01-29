package com.ezen.ezdiary.user.dao;

import java.util.Map;

import com.ezen.ezdiary.user.dto.UserDTO;

public interface UserDAO {
	
	public int insertNick(UserDTO userDTO) throws Exception;
	
	public int insertMsg(Map msgMap) throws Exception;
}
