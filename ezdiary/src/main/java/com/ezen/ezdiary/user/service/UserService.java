package com.ezen.ezdiary.user.service;

import java.util.List;

import com.ezen.ezdiary.admin.dto.AdminAnswerDTO;
import com.ezen.ezdiary.admin.dto.AdminAskDTO;
import com.ezen.ezdiary.user.dto.MyAnswerDTO;
import com.ezen.ezdiary.user.dto.UserDTO;
import com.ezen.ezdiary.user.dto.UserMsgDTO;

public interface UserService {
	
	public void registNick(UserDTO userDTO) throws Exception;
	public int selectUser(UserDTO userDTO) throws Exception;
	
	public List<AdminAskDTO> selectAsk() throws Exception;
	public List<AdminAnswerDTO> selectAnswer() throws Exception;
	
	public List<AdminAskDTO> askList(AdminAskDTO askDTO) throws Exception;
	public List<AdminAnswerDTO> answerList(AdminAnswerDTO answerDTO) throws Exception;
	
	public List<AdminAskDTO> ajaxAsk(AdminAskDTO askDTO) throws Exception;
	public List<AdminAnswerDTO> ajaxAnswer(AdminAnswerDTO answerDTO) throws Exception;
	
	public List<AdminAnswerDTO> myAnswer(AdminAnswerDTO answerDTO) throws Exception;
	public List<MyAnswerDTO> mySurveyList(MyAnswerDTO myAsnwerDTO) throws Exception;
	
	public int registMyAnswer(MyAnswerDTO myAnswerDTO) throws Exception;
	
	public void sendMsg(UserMsgDTO msgDTO) throws Exception;
	
//	public UserDTO loginNick(UserDTO userDTO)throws Exception;
}
