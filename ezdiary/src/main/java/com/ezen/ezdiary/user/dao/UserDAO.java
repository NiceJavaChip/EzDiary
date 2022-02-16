package com.ezen.ezdiary.user.dao;

import java.util.List;
import java.util.Map;

import com.ezen.ezdiary.admin.dto.AdminAnswerDTO;
import com.ezen.ezdiary.admin.dto.AdminAskDTO;
import com.ezen.ezdiary.user.dto.MyAnswerDTO;
import com.ezen.ezdiary.user.dto.UserDTO;
import com.ezen.ezdiary.user.dto.UserMsgDTO;

public interface UserDAO {
	
	public int insertNick(UserDTO userDTO) throws Exception;
	
	public List<AdminAskDTO> selectAsk() throws Exception;
	public List<AdminAnswerDTO> selectAnswer() throws Exception
	;
	public List<AdminAskDTO> askList(AdminAskDTO askDTO) throws Exception;
	public List<AdminAnswerDTO> answerList(AdminAnswerDTO answerDTO) throws Exception;
	
	public List<AdminAskDTO> ajaxAsk(AdminAskDTO askDTO) throws Exception;
	public List<AdminAnswerDTO> ajaxAnswer(AdminAnswerDTO answerDTO) throws Exception;
	
	public int insertMsg(UserMsgDTO msgDTO) throws Exception;

	public List<MyAnswerDTO> getUserAnswer() throws Exception;

	public int getAnswerCount(int ask_idx,int answer_idx) throws Exception;

	public int getAnswerCount(Map answerInfo) throws Exception;

	public int lastAskNO() throws Exception;
}