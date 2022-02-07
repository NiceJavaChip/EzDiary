package com.ezen.ezdiary.admin.dao;

import java.util.List;
import java.util.Map;

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
		/* int quesNO = selectNewQuesNO(); */
		sqlSession.insert(NAMESPACE+"quesAdd",askDTO);//
	}
	
	/*
	 * private int selectNewQuesNO() throws Exception{ return
	 * sqlSession.selectOne(NAMESPACE+"quesAddNO"); }
	 */

	@Override
	public void quesAnswerEnroll(AdminAnswerDTO answerDTO) throws Exception {
		
	}
	
	@Override
	public int lastAskNO(AdminAskDTO askDTO) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"quesAddNO");
	}

	@Override
	public void answerEnroll(AdminAnswerDTO answerDTO) throws Exception {
		
		sqlSession.insert(NAMESPACE+"answerAdd",answerDTO);
	}

	@Override
	public AdminAskDTO getAskNO(int ask_idx) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"getAskNO", ask_idx);
	}

	@Override
	public AdminAnswerDTO getAnswerInfo(int answer_idx) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"getAnswerInfo", answer_idx);
	}

	/*
	 * @Override public List<AdminAnswerDTO> anwerInfoList() throws Exception { //
	 * TODO Auto-generated method stub return
	 * sqlSession.selectList(NAMESPACE+"anwerInfoList"); }
	 */

	@Override
	public List<AdminAnswerDTO> selectAnswerList(int ask_idx) throws Exception {
		
		List<AdminAnswerDTO> selectAnswerList = sqlSession.selectList(NAMESPACE+"selectAnswerList", ask_idx);
		
		return selectAnswerList;
	}

	@Override
	public int modifyQues(AdminAskDTO askDTO) throws Exception {
		
		return sqlSession.update(NAMESPACE+"modifyQues", askDTO);
	}

	@Override
	public void modifyQues(Map<String, Object> articleMap) throws Exception {
		
		sqlSession.update(NAMESPACE+"modifyQues", articleMap); 
	}

	

}
