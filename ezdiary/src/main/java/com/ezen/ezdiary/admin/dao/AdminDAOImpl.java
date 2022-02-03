package com.ezen.ezdiary.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.ezdiary.admin.dto.AdminAnswerDTO;
import com.ezen.ezdiary.admin.dto.AdminAskDTO;
import com.ezen.ezdiary.admin.dto.AdminMemberDTO;

@Repository("adminDAO")
public class AdminDAOImpl implements AdminDAO {
	
	private String NAMESPACE ="mapper.admin.";
	
	@Autowired
	private SqlSession sqlSession;	

	@Override
	public AdminMemberDTO login(AdminMemberDTO adminMemberDTO) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"adminLogin", adminMemberDTO);
	}

	@Override
	public List<AdminAskDTO> quseList() throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"quesList");
	}

	@Override
	public void quesEnroll(AdminAskDTO askDTO) throws Exception {
		
		sqlSession.insert(NAMESPACE+"quesAdd",askDTO);
	}

	@Override
	public void quesAnswerEnroll(AdminAnswerDTO answerDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
