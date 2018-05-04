package p.g.p.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.PhotoDao;
import p.g.p.model.Board;
import p.g.p.model.Board_Comment;
import p.g.p.model.Join_BoardComment_MemberInfo;

public class PhotodetailService {

	
	PhotoDao dao;
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	public int ListInsertComment(Board_Comment  board_comment) {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		System.out.println("댓글 성공"+board_comment);
		int resultCnt = dao.insertComment(board_comment);
			if(resultCnt>0) {
				System.out.println("댓글성공");
			}else {
				resultCnt = -1;
			}
		return resultCnt;
	}
	


	public List<Join_BoardComment_MemberInfo> ListselectCommentAll(int board_idx) {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		List<Join_BoardComment_MemberInfo> list= dao.selectCommentAll(board_idx);
		
		return list;
		
	}
	
	public int ListdeleteComment(int board_comment_idx) {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		int resultCnt=dao.deleteComment(board_comment_idx);
		if(resultCnt<0) {
			resultCnt=-1;
		}
		return 1;
	}
	
	public int commentTotalCntView(int board_idx) {
	
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		int resultCnt = 0;
		resultCnt =dao.commentTotalCnt(board_idx);
		System.out.println(resultCnt+"dsdsdsdjajdjasjkdjajksdjsadjk이거야야야야ㅑ야야야야ㅑ ");
		return resultCnt;
	}
	
	public int boardCntUpdateView(int board_idx) {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);

		int resultCnt=dao.boardCntUpdate(board_idx);
		System.out.println("조회수ㅜ우우우ㅜ우우우ㅜ우우우우ㅜ우웅");
		return resultCnt;
	}
	
	public int boardCntView(int board_idx) {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		int resultboardCnt= dao.boardCntSelect(board_idx);
		return resultboardCnt;

	}
	
	public String photodetailView(int board_idx) {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		String photoName=dao.selectPhotoFeed(board_idx);
		return photoName;
		
	}
	
	public Board boardSelectView(int board_idx) {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		Board boardselect=dao.boardSelect(board_idx);
		return boardselect;
	}

	
	
	
	
}
