package p.g.p.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.MemberDao;
import p.g.p.model.Board;
import p.g.p.model.Board_Photo;
import p.g.p.model.Join_board_boardphoto;
import p.g.p.model.Member_info;

public class MemberService {

	MemberDao dao;

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public int memberInsert(Member_info member) {
		dao = sqlSessionTemplate.getMapper(MemberDao.class);
		System.out.println("service 목록" + member);
		int resultCnt = dao.insertMember(member);
		if (resultCnt > 0) {
			// insert 성공시
			System.out.println("회원가입 성공");
		} else {
			// 회원가입 실패시 -1 값 주입
			resultCnt = -1;
		}

		return resultCnt;
	}

	public Member_info loginService(String id, String pw) {

		dao = sqlSessionTemplate.getMapper(MemberDao.class);
		Member_info member = dao.loginSelect(id);
		if (member != null && member.getMember_pw().equals(pw)) {
			// 로그인성공

			// 비밀번호 있을시
			member.setMember_pw("");

		} else {
			// 로그인 실패
			member = null;
		}

		return member;
	}


	public int countPhoto(int member_idx) {
		dao = sqlSessionTemplate.getMapper(MemberDao.class);
		int c = dao.countPhoto(member_idx);
		if(c>0) {
			//등록한 사진 있음
		}else {
			c=-1;
		}
		return c;
	}

	public List<Join_board_boardphoto> selectLatestPhoto(int member_idx) {
		
		dao = sqlSessionTemplate.getMapper(MemberDao.class);
		List<Join_board_boardphoto> LatestPhoto = dao.LatestPhoto(member_idx);
		
		return LatestPhoto;
	}

	public List<Join_board_boardphoto> selectLikeList(int member_idx) {

		dao = sqlSessionTemplate.getMapper(MemberDao.class);
		List<Join_board_boardphoto> LikeList = dao.selectLikePhoto(member_idx);
		
		return LikeList;
	}
	public Member_info kakaock(Member_info member) {
		dao = sqlSessionTemplate.getMapper(MemberDao.class);
		Member_info memberck = dao.loginSelect(member.getMember_id());
		int cks =0;
		if(memberck!=null) {
			//아이디 있음
			//memberck 값이 존재
			//아이디 있으면 0;
			System.out.println("체크"+memberck);
			System.out.println("체크"+memberck);
			System.out.println("체크"+memberck);
			System.out.println("체크"+memberck);
			System.out.println("체크"+memberck);
			System.out.println("체크"+memberck);
			System.out.println("체크"+memberck);
			System.out.println("체크"+memberck);
			
		}else {
			memberck = null;
			cks = dao.kakaoinsert(member);
			//회원가입 가능 
			//insert 성공시 1 값		
	
		}
		
		return memberck;
	
	}

	public Member_info memberCk(String member_id) {
		dao = sqlSessionTemplate.getMapper(MemberDao.class);
		Member_info member = dao.loginSelect(member_id);
		if(member ==null) {
			// 없으면 
			member =null;
		}else {
		
		}
	
		return member;
	}

	public String selectScrapLatestPhoto(int member_idx) {
		
		dao = sqlSessionTemplate.getMapper(MemberDao.class);
		String LatestScrapPhoto = dao.LatestScrapPhoto(member_idx);
		
		return LatestScrapPhoto;
	}

	public String selectLikeLatestPhoto(int member_idx) {
		dao = sqlSessionTemplate.getMapper(MemberDao.class);
		String LatestLikePhoto = dao.LatestLikePhoto(member_idx);
		return LatestLikePhoto;
	}


}
