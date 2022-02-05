package com.ezen.ezdiary.admin.sevice;

import java.util.List;

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
	public AdminAskDTO getAskNO(int ask_idx) throws Exception {
		
		return adminDAO.getAskNO(ask_idx);
	}

	

}
