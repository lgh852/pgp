package p.g.p.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.Mp_dao;
import p.g.p.model.Board_Comment;
import p.g.p.model.Join_Scrap_scrapFN;
import p.g.p.model.Join_board_boardphoto;
import p.g.p.model.Member_info;
import p.g.p.model.PhotoListmodel;
import p.g.p.model.Scrap;

public class MypageService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private Mp_dao dao;

	@Autowired
	private Mp_file_service service;

	//////////////////////////////////////////////////////////////////////////// 나의
	//////////////////////////////////////////////////////////////////////////// 사진

	// 이거는 마이페이지 메인 들어가자 마자 최근 올린 사진 3개 보여주는 기능
	public List<Join_board_boardphoto> Mp_MyphotoList(int member_idx) {

		dao = sqlSessionTemplate.getMapper(Mp_dao.class);

		List<Join_board_boardphoto> list = dao.selectMyPhotoList(member_idx);

		if (list != null) {

		} else {
			list = null;
		}

		return list;

	}

	// 마이페이지 사진 카테고리에 들어가면 photolist.jsp 처럼 정렬되어 있는 기능
	public List<PhotoListmodel> myPhotolistview(Member_info member) {

		dao = sqlSessionTemplate.getMapper(Mp_dao.class);

		List<PhotoListmodel> list = dao.myphotolist(member);

		if (list != null) {

		} else {
			list = null;
		}

		return list;
	}

	///////////////////////////////////////////////////////////////////////// 나의
	///////////////////////////////////////////////////////////////////////// 회원정보
	///////////////////////////////////////////////////////////////////////// 수정
	
	public Member_info Mp_update_select(String member_idx) {

		Member_info member;
		dao = sqlSessionTemplate.getMapper(Mp_dao.class);
		member = dao.selectByIdx(member_idx);
		return member;

	}

	public int Mp_update(Member_info member, HttpServletRequest request) throws IllegalStateException, IOException {

		if (member.getPhotofile() != null) {
			// 새로운 사진값이 있을 경우에만
			service.memberPhotoUpload(member, request);
		}

		int resultCnt = dao.updatemember(member);

		if (resultCnt > 0) {
			// 성공
		} else {
			// 실패
			resultCnt = -1;
		}

		return resultCnt;
	}

	//////////////////////////////////////////////////////////////나의 스크랩 
	public List<Join_Scrap_scrapFN> selectScrapPhotoList(Scrap scrap2) {
		
		dao = sqlSessionTemplate.getMapper(Mp_dao.class);
		List<Join_Scrap_scrapFN> scrapList = dao.selectScrapPhotoList(scrap2);
		
		return scrapList;
	}


	public List<Integer> selectscrapfnidx(int member_idx) {
		
		dao = sqlSessionTemplate.getMapper(Mp_dao.class);
		List<Integer> scrapfnidx = dao.selectscrpafnidx(member_idx);
	    return scrapfnidx;
	}


	public int countFnIdx(int member_idx) {
		
		dao = sqlSessionTemplate.getMapper(Mp_dao.class);
		int c = dao.countFnIdx(member_idx);
		return c;
	}


	public int selectScrapboardidx(Join_Scrap_scrapFN scrap) {

		dao = sqlSessionTemplate.getMapper(Mp_dao.class);
        int result = dao.selectScrapBoardIdx(scrap);
		
		return result;
	}


	public String selectPhotoName(Integer integer) {
		
		dao = sqlSessionTemplate.getMapper(Mp_dao.class);
		String r = dao.selectPhotoName(integer);
		
		return r;
	}


	public int boardIdxCheck(Join_Scrap_scrapFN scrap) {
		
		dao = sqlSessionTemplate.getMapper(Mp_dao.class);
		int idxcheck = dao.boardidxCheck(scrap);
		
		if (idxcheck>0) {
			//board_idx가 있는것이지
		}else {
			idxcheck = 0;
		}
		
		return idxcheck;
	}
	
	////////////////////////////////////////////////////////댓글
	
	public List<Board_Comment> Mp_myCommentList(Member_info member){
		
		
		dao = sqlSessionTemplate.getMapper(Mp_dao.class);
		
		List<Board_Comment> list = dao.selectMyCommentList(member);
		
		return list;
		
	}

}
