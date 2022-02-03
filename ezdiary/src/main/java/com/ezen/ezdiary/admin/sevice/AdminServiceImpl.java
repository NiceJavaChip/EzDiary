package com.ezen.ezdiary.admin.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.ezdiary.admin.dao.AdminDAO;
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

}
