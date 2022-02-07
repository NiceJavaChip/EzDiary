package com.ezen.ezdiary.user.service;

import java.util.List;

import com.ezen.ezdiary.admin.dto.AdminAnswerDTO;
import com.ezen.ezdiary.admin.dto.AdminAskDTO;
import com.ezen.ezdiary.user.dto.UserDTO;
import com.ezen.ezdiary.user.dto.UserMsgDTO;

public interface UserService {
	
	public void registNick(UserDTO userDTO) throws Exception;
	
//	public int registNick(UserDTO userDTO) throws Exception;
//	public List<AdminAskDTO> askList(int ask_idx) throws Exception;
	public AdminAskDTO selectAsk() throws Exception;
	public AdminAnswerDTO selectAnswer() throws Exception;
	public AdminAskDTO askList(int ask_idx) throws Exception;
	public AdminAnswerDTO answerList(int answer_idx) throws Exception;
	
	public void sendMsg(UserMsgDTO msgDTO) throws Exception;
}
