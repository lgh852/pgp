package p.g.p.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.MemberDao;
import p.g.p.model.Member_info;

public class MemberService {

	MemberDao dao;
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	public int memberInsert(Member_info member) {
		dao = sqlSessionTemplate.getMapper(MemberDao.class);
		System.out.println("service 목록"+member);
		int resultCnt = dao.insertMember(member);
			if(resultCnt>0) {
				//insert 성공시 
				System.out.println("회원가입 성공");
			}else {
				//회원가입 실패시 -1 값 주입
				resultCnt = -1;
			}
		
		
		return resultCnt;
	}
	public Member_info loginService( String id, String pw) {
		
		dao = sqlSessionTemplate.getMapper(MemberDao.class);
		Member_info member = dao.loginSelect(id);
		if(member != null) {
			//로그인성공
			if(member.getMember_pw()==pw) {
				//비밀번호 있을시 
				member.setMember_pw("");
			
			}
			
		}else {
			//로그인 실패
			
		}
		
		
		
		return member;
	}
	
	
}
