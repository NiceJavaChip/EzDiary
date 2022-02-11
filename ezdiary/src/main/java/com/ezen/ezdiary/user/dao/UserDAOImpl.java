package com.ezen.ezdiary.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.ezdiary.admin.dto.AdminAnswerDTO;
import com.ezen.ezdiary.admin.dto.AdminAskDTO;
import com.ezen.ezdiary.user.dto.UserDTO;
import com.ezen.ezdiary.user.dto.UserMsgDTO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	private String NAMESPACE ="mapper.user.";
	
    @Autowired 
    private SqlSession sqlSession;

    @Override
    public int insertNick(UserDTO userDTO) throws Exception {
    	
    	return sqlSession.insert(NAMESPACE+"insertNick", userDTO);
    	
    }
    
	@Override
	public List<AdminAskDTO> selectAsk() throws Exception {
		return sqlSession.selectList(NAMESPACE+"selectAsk");
	}
	
	@Override
	public List<AdminAnswerDTO> selectAnswer() throws Exception {
		return sqlSession.selectList(NAMESPACE+"selectAnswer");
	}
    
    @Override
    public List<AdminAskDTO> askList(AdminAskDTO askDTO) throws Exception {
    	return sqlSession.selectList(NAMESPACE+"surveyAskList", askDTO);
    }   
  
    @Override
    public List<AdminAnswerDTO> answerList(AdminAnswerDTO answerDTO) throws Exception {
    	
    	return sqlSession.selectList(NAMESPACE+"surveyAnswerList", answerDTO);
    }
    
	@Override
	public List<AdminAskDTO> ajaxAsk(AdminAskDTO askDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE+"ajaxAskList", askDTO);
	}
   
	@Override
	public List<AdminAnswerDTO> ajaxAnswer(AdminAnswerDTO answerDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE+"ajaxAnswerList", answerDTO);
	}
	
	private int selectMsgNo() throws Exception {
	
		return sqlSession.selectOne("");
		

	}

	@Override
	public int insertMsg(UserMsgDTO msgDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"insertMsg", msgDTO);
	}









}
