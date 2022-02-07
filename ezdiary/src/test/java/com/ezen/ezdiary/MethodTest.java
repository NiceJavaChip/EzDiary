package com.ezen.ezdiary;

import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;

import com.ezen.ezdiary.admin.dao.AdminDAO;
import com.ezen.ezdiary.admin.dto.AdminAskDTO;

public class MethodTest {
	
	private AdminDAO adminDAO;
	
	@Test
	public void testMod() {
		AdminAskDTO askDTO = new AdminAskDTO();
		
		askDTO.setAsk_cntnt("제발 되어 주세요");
		askDTO.setEditor("js");
		askDTO.setAsk_idx(27);
		
		try {
			int result = adminDAO.modifyQues(askDTO);
			System.out.println("result = "+result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
