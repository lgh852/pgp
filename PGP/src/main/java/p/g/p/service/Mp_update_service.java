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
	
	public Member_info Mp_update_select(String member_idx) {
		
		Member_info member;
		dao = sqlSessionTemplate.getMapper(Mp_dao.class);
		member = dao.selectByIdx(member_idx);
		return member;
		
		
	}
	
	public int Mp_update(Member_info member,HttpServletRequest request) throws IllegalStateException, IOException {
		
		if(member.getPhotofile()!=null) {
			//새로운 사진값이 있을 경우에만w
			service.memberPhotoUpload(member, request);
		}
		System.out.println("membsadasd"+member.getMember_photo());

        int resultCnt = dao.updatemember(member);
	
        if(resultCnt>0) {
			//성공
		}else {
			//실패 
			resultCnt=-1;
		}

		System.out.println("===========================================================");
		System.out.println(resultCnt);
		
		return resultCnt;
	}
	

}
