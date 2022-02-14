package com.ezen.ezdiary.admin.dto;

import org.springframework.stereotype.Component;

import com.ezen.ezdiary.user.dto.UserDTO;
import com.ezen.ezdiary.user.dto.UserMsgDTO;

@Component
public class UserJoinDTO {
	
	private UserDTO userDTO;
	private UserMsgDTO msgDTO;
	
	public UserJoinDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public UserMsgDTO getMsgDTO() {
		return msgDTO;
	}

	public void setMsgDTO(UserMsgDTO msgDTO) {
		this.msgDTO = msgDTO;
	}

	@Override
	public String toString() {
		return "UserJoinDTO [userDTO=" + userDTO + ", msgDTO=" + msgDTO + "]";
	}
	
}
