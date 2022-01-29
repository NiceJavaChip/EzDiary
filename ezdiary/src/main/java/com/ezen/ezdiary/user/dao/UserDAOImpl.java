package com.ezen.ezdiary.user.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.ezdiary.user.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertNick(UserDTO userDTO) throws Exception {
		
		int result = sqlSession.insert("", userDTO);
		
		return result;
	}

	@Override
	public int insertMsg(Map msgMap) throws Exception {
		
		int msgNo = selectMsgNo();
		msgMap.put("msgNo", msgNo);
		
		sqlSession.insert("", msgMap);
		
		return msgNo;
	}
	
	private int selectMsgNo() throws Exception {
	
		return sqlSession.selectOne("");
	}
	
}
