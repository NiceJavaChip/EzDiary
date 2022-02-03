package com.ezen.ezdiary.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.ezdiary.admin.dto.AdminAnswerDTO;
import com.ezen.ezdiary.admin.dto.AdminAskDTO;
import com.ezen.ezdiary.user.dto.UserDTO;

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
    public List<AdminAskDTO> askList() throws Exception {
    	
    	return sqlSession.selectList(NAMESPACE+"surveyAskList");
    }
    
    
    @Override
    public List<AdminAnswerDTO> answerList() throws Exception {
    	
    	return sqlSession.selectList(NAMESPACE+"surveyAnswerList");
    }
    
    
	@Override
	public int insertMsg(Map msgMap) throws Exception {
		
		
		  int msgNo = selectMsgNo(); 
		  msgMap.put("msgNo", msgNo);
		  
		  sqlSession.insert("", msgMap);
		 
		
		return 0;

	}
	
	private int selectMsgNo() throws Exception {
	
		return sqlSession.selectOne("");
		

	}

}
