package com.ezen.ezdiary.admin.dao;

import java.util.List;
import java.util.Map;

import com.ezen.ezdiary.admin.dto.AdminAnswerDTO;
import com.ezen.ezdiary.admin.dto.AdminAskDTO;
import com.ezen.ezdiary.admin.dto.AdminBoardDTO;
import com.ezen.ezdiary.admin.dto.AdminMemberDTO;
import com.ezen.ezdiary.admin.dto.UserJoinDTO;
import com.ezen.ezdiary.user.dto.UserDTO;
import com.ezen.ezdiary.user.dto.UserMsgDTO;

public interface AdminDAO {
	
	public AdminMemberDTO login(AdminMemberDTO adminMemberDTO) throws Exception;
	
	public List<AdminAskDTO> quseList() throws Exception;
	
	public void quesEnroll(AdminAskDTO askDTO) throws Exception;

	public void quesAnswerEnroll(AdminAnswerDTO answerDTO) throws Exception;

	public void answerEnroll(AdminAnswerDTO answerDTO) throws Exception;

	public int lastAskNO(AdminAskDTO askDTO) throws Exception;
	
	public AdminAskDTO getAskNO(int ask_idx) throws Exception;

	public AdminAnswerDTO getAnswerInfo(int answer_idx) throws Exception;

	/* public List<AdminAnswerDTO> anwerInfoList() throws Exception; */
	  
	public List<AdminAnswerDTO> selectAnswerList(int ask_idx) throws Exception;
	
	public int modifyQues(AdminAskDTO askDTO) throws Exception;

	public void modifyQues(Map<String, Object> articleMap) throws Exception;

	public void modifyAnswer(Map<String, Object> articleMap) throws Exception;

	public void removeQues(Map<String, Object> articleMap) throws Exception;

	public void removeAnswer(Map<String, Object> articleMap) throws Exception;

	
	public List<AdminAskDTO> getQuesListPaging(AdminBoardDTO boardDTO) throws Exception;
	
	public int getAmount(AdminBoardDTO boardDTO) throws Exception;

	public List<UserJoinDTO> getUserMsgListPaging(AdminBoardDTO boardDTO) throws Exception;

	public int getMsgAmount(AdminBoardDTO boardDTO) throws Exception;

	public List<UserDTO> getUser(AdminBoardDTO boardDTO) throws Exception;

	public UserJoinDTO getMsgIdx(int user_idx) throws Exception;

	public void removeUser(Map<String, Object> articleMap)throws Exception;

	public void removeMsg(Map<String, Object> articleMap) throws Exception;

	public int userTotalCount() throws Exception;
	
	
}
