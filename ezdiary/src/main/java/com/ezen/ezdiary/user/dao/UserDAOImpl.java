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
	public AdminAskDTO selectAsk() throws Exception {
		return sqlSession.selectOne(NAMESPACE+"selectAsk");
	}
	
	@Override
	public AdminAnswerDTO selectAnswer() throws Exception {
		return sqlSession.selectOne(NAMESPACE+"selectAnswer");
	}
    
    @Override
    public AdminAskDTO askList(int ask_idx) throws Exception {
    	return sqlSession.selectOne(NAMESPACE+"surveyAskList", ask_idx);
    }   
    
//    @Override
//    public List<AdminAskDTO> askList(int ask_idx) throws Exception {
//    	
//    	return sqlSession.selectList(NAMESPACE+"surveyAskList", ask_idx);
//    }

    
    @Override
    public AdminAnswerDTO answerList(int answer_idx) throws Exception {
    	
    	return sqlSession.selectOne(NAMESPACE+"surveyAnswerList", answer_idx);
    }
    
   
	
	private int selectMsgNo() throws Exception {
	
		return sqlSession.selectOne("");
		

	}

	@Override
	public int insertMsg(UserMsgDTO msgDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"insertMsg", msgDTO);
	}





}
