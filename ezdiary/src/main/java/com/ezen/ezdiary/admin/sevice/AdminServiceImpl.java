package com.ezen.ezdiary.admin.sevice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.ezdiary.admin.dao.AdminDAO;
import com.ezen.ezdiary.admin.dto.AdminAnswerDTO;
import com.ezen.ezdiary.admin.dto.AdminAskDTO;
import com.ezen.ezdiary.admin.dto.AdminMemberDTO;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDAO adminDAO;

	@Override
	public AdminMemberDTO login(AdminMemberDTO adminMemberDTO) throws Exception {
		
		return adminDAO.login(adminMemberDTO);
	}

	@Override
	public List<AdminAskDTO> quseList() throws Exception {
		
		return adminDAO.quseList();
	}

	@Override
	public void quesEnroll(AdminAskDTO askDTO) throws Exception {
		
		adminDAO.quesEnroll(askDTO);
	}
	
	@Override
	public int lastAskNO(AdminAskDTO askDTO) throws Exception {
		
		return adminDAO.lastAskNO(askDTO);
	}

	@Override
	public void answerEnroll(AdminAnswerDTO answerDTO) throws Exception {
		
		adminDAO.answerEnroll(answerDTO);
		
	}

	@Override
	public Map<String, Object> getAskNO(int ask_idx) throws Exception {
		
		Map<String, Object> articleMap = new HashMap<>();
		AdminAskDTO getAskInfo = adminDAO.getAskNO(ask_idx);
		List<AdminAnswerDTO> answerInfoList = adminDAO.selectAnswerList(ask_idx); 
		
		articleMap.put("getAskInfo", getAskInfo);
		articleMap.put("answerInfoList", answerInfoList);
		
		return articleMap;
	}

	@Override
	public int modifyQues(AdminAskDTO askDTO) throws Exception {
		
		return adminDAO.modifyQues(askDTO);
	}

	@Override
	public void modifyQues(Map<String, Object> articleMap) throws Exception {
		
		adminDAO.modifyQues(articleMap);
		
	}

	/*
	 * @Override public AdminAnswerDTO getAnswerInfo(int answer_idx) throws
	 * Exception {
	 * 
	 * return adminDAO.getAnswerInfo(answer_idx); }//
	 * 
	 * @Override public List<AdminAnswerDTO> anwerInfoList() throws Exception {
	 * 
	 * return adminDAO.anwerInfoList(); }
	 */
	

}
