package com.ezen.ezdiary.user.dao;

import java.util.List;
import java.util.Map;

import com.ezen.ezdiary.admin.dto.AdminAskDTO;
import com.ezen.ezdiary.user.dto.UserDTO;

public interface UserDAO {
	
	public int insertNick(UserDTO userDTO) throws Exception;
//	public int insertNick(UserDTO userDTO) throws Exception;
	
	public List<AdminAskDTO> askList() throws Exception;
	
	public int insertMsg(Map msgMap) throws Exception;
}
