package com.ezen.ezdiary.admin.sevice;

import java.util.List;
import java.util.Map;

import com.ezen.ezdiary.admin.dto.AdminAnswerDTO;
import com.ezen.ezdiary.admin.dto.AdminAskDTO;
import com.ezen.ezdiary.admin.dto.AdminMemberDTO;

public interface AdminService {
	
	public AdminMemberDTO login(AdminMemberDTO adminMemberDTO) throws Exception;
	
	public List<AdminAskDTO> quseList() throws Exception;
	
	public void quesEnroll(AdminAskDTO askDTO) throws Exception;

	public void answerEnroll(AdminAnswerDTO answerDTO) throws Exception;

	public int lastAskNO(AdminAskDTO askDTO) throws Exception;

	public Map<String, Object> getAskNO(int ask_idx) throws Exception;

	/*
	 * public AdminAnswerDTO getAnswerInfo(int answer_idx) throws Exception;
	 * 
	 * public List<AdminAnswerDTO> anwerInfoList() throws Exception;
	 */
	
	public int modifyQues(AdminAskDTO askDTO) throws Exception;

	public void modifyQues(Map<String, Object> articleMap) throws Exception;
}
