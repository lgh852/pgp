package p.g.p.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
		if(LatestPhoto!=null) {
			
	
		}else {
			
			LatestPhoto = null;
	
		}
		
		return LatestPhoto;
	}

	public List<Join_board_boardphoto> selectLikeList(int member_idx) {

		dao = sqlSessionTemplate.getMapper(MemberDao.class);
		List<Join_board_boardphoto> LikeList = dao.selectLikePhoto(member_idx);
		if(LikeList!=null) {
			
			
		}else {
			
			LikeList = null;
	
		}
		return LikeList;
	}
	public Member_info kakaock(Member_info member) {
		dao = sqlSessionTemplate.getMapper(MemberDao.class);
		Member_info memberck = dao.loginSelect(member.getMember_id());
		int cks =0;
		System.out.println("쳌");
		if(memberck!=null) {
			//아이디 있음
			//memberck 값이 존재
			//아이디 있으면 0;
	
			
		}else {
			member.setMember_phone("");
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
		
		if(LatestScrapPhoto!=null) {
			
			
		}else {
			
			LatestScrapPhoto = null;
	
		}
		return LatestScrapPhoto;
	}

	public String selectLikeLatestPhoto(int member_idx) {
		dao = sqlSessionTemplate.getMapper(MemberDao.class);
		String LatestLikePhoto = dao.LatestLikePhoto(member_idx);
		if(LatestLikePhoto!=null) {
			
			
		}else {
			
			LatestLikePhoto = null;
	
		}		
		return LatestLikePhoto;
	}

	
	//회원정보 수정 사진 업로드
	public void memberPhotoUpload(Member_info member, HttpServletRequest request) throws IllegalStateException, IOException {
		
		String uploadURI = "/resources/memberphoto";
		String dir = request.getSession().getServletContext().getRealPath(uploadURI);
		
		// 업로드 파일의 물리적 저장
		// 파일 저장 : 증명사진.jpg
		// 회원의 사진은 하나만 존재한다.
		// 파일 이름 생성 : 회원아이디_원본파일이름
		if (!member.getPhotofile().isEmpty() ) {
			// 새로운 파일 이름 생성 -> 파일 저장 -> DB에 저장할 파일이름 set
			String fileName = member.getMember_id()+"_"+member.getPhotofile().getOriginalFilename();
			member.getPhotofile().transferTo(new File(dir, fileName));
			member.setMember_photo(fileName);
		}
		
		
	}
	

}
