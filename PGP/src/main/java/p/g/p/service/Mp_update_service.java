package p.g.p.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.Mp_dao;
import p.g.p.model.Member_info;

public class Mp_update_service {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private Mp_dao dao;
	
	@Autowired
	private Mp_file_service service;
	
	public Member_info Mp_update_select(String member_id) {
		
		Member_info member;
		dao = sqlSessionTemplate.getMapper(Mp_dao.class);
		member = dao.selectById(member_id);
		return member;
	}
	
	public int Mp_update(Member_info member,HttpServletRequest request) throws IllegalStateException, IOException {
		
				
		
		service.memberPhotoUpload(member, request);
		
        dao = sqlSessionTemplate.getMapper(Mp_dao.class);
		int resultCnt = dao.updateById(member);
		System.out.println("===========================================================");
		System.out.println(resultCnt);
		
		return resultCnt;
	}
	

}
