package p.g.p.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.PhotoDao;
import p.g.p.model.Board;
import p.g.p.model.Board_Comment;
import p.g.p.model.Join_BoardComment_MemberInfo;
import p.g.p.model.Join_board_boardphoto;

public class PhotodetailService {

	PhotoDao dao;

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public int ListInsertComment(Board_Comment board_comment) {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		System.out.println("댓글 성공" + board_comment);
		int resultCnt = dao.insertComment(board_comment);
		if (resultCnt > 0) {
			System.out.println("댓글성공");
		} else {
			resultCnt = -1;
		}
		return resultCnt;
	}

	public List<Join_BoardComment_MemberInfo> ListselectCommentAll(int board_idx) {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		List<Join_BoardComment_MemberInfo> list = dao.selectCommentAll(board_idx);

		return list;

	}

	public int ListdeleteComment(int board_comment_idx) {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		int resultCnt = dao.deleteComment(board_comment_idx);
		if (resultCnt < 0) {
			resultCnt = -1;
		}
		return 1;
	}

	public int commentTotalCntView(int board_idx) {

		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		int resultCnt = 0;
		resultCnt = dao.commentTotalCnt(board_idx);
		System.out.println(resultCnt + "dsdsdsdjajdjasjkdjajksdjsadjk이거야야야야ㅑ야야야야ㅑ ");
		return resultCnt;
	}

	public int boardCntUpdateView(int board_idx) {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);

		int resultCnt = dao.boardCntUpdate(board_idx);
		System.out.println("조회수ㅜ우우우ㅜ우우우ㅜ우우우우ㅜ우웅");
		return resultCnt;
	}

	public int boardCntView(int board_idx) {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		int resultboardCnt = dao.boardCntSelect(board_idx);
		return resultboardCnt;

	}

	public String photodetailView(int board_idx) {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		String photoName = dao.selectPhotoFeed(board_idx);
		return photoName;

	}

	public Board boardSelectView(int board_idx) {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		Board boardselect = dao.boardSelect(board_idx);
		return boardselect;
	}

	public int commentTotalUpdate(int board_idx) {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		int commentUpate = dao.commentTotalUpdate(board_idx);
		return commentUpate;
	}

	public List<Join_board_boardphoto> popluarphotoSelect() {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		List<Join_board_boardphoto> list = dao.popluarphotoSelect();
		return list;
	}


	public int boardPhotoDelete(int board_idx) {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		int resultCnt = dao.boardPhotoDelete(board_idx);
		return resultCnt;
	}
	public int boardCommentDelete(int board_idx) {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		int resultCnt = dao.boardCommentDelete(board_idx);
		return resultCnt;
	}

	public int boardDelete(int board_idx) {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		int resultCnt = dao.boardDelete(board_idx);
		return resultCnt;
	}

	public int AllDelete(int board_idx) {
		int resultCnt = boardPhotoDelete(board_idx);
		int resultCnt2 = boardCommentDelete(board_idx);
		int resultCnt3 = boardDelete(board_idx);
		if (resultCnt > 0 && resultCnt2 > 0 && resultCnt3 > 0) {
			System.out.println("야야야야얍!!!!!!!==>"+resultCnt);
			return resultCnt;
		}
		return -1;

	}
	// public String listPage(HttpServletRequest request)
	/*
	 * public String listPage(HttpServletRequest request) { dao2 =
	 * sqlSessionTemplate.getMapper(PhotoDetailPageDao.class); PhotoDetailPageMaker
	 * pageMaker= new PhotoDetailPageMaker(); String pagenum =
	 * request.getParameter("pagenum"); String contetnum =
	 * request.getParameter("contentnum"); int cpagenum= Integer.parseInt(pagenum);
	 * int ccontentnum=Integer.parseInt(contetnum);
	 * 
	 * pageMaker.setTotalcount(dao2.testcount()); //전체 게시글 개수를 지정한다
	 * pageMaker.setPagenum(cpagenum-1); // 현재 페이지를 페이지 객체에 지정한다 -1을 해야 쿼리에서 사용할 수
	 * 있다 pageMaker.setContentnum(ccontentnum);//한 페이지에 몇개씩 게시슬을 보여줄지 지정한다
	 * pageMaker.setCurrentblock(cpagenum);//현재 페이지 블록이 몇번인지 현재 페이지 ㅂ번호를 통해서 지정
	 * pageMaker.setLastblock(pageMaker.getTotalcount());// 마지막 블록 번호를 전체 게시글 수를 통해
	 * 정함
	 * 
	 * pageMaker.prevnext(cpagenum);//현재 페이지 번호로 화살표를 나타낼지 정함
	 * pageMaker.setStartPage(pageMaker.getCurrentblock());// 시작 페이지를 페이지 블ㄹ록 번호로 정함
	 * pageMaker.setEndPage(pageMaker.getLastblock(),pageMaker.getCurrentblock());
	 * //마지막 페이지를 마지막 페이지 블록과 현재 페이지 블록 번호로 정함
	 * 
	 * List<PhotoDetailPageMaker> testlist= new ArrayList<>(); testlist=
	 * dao2.testlist(pageMaker.getPagenum()*10,pageMaker.getContentnum());
	 * request.setAttribute("list",testlist);
	 * request.setAttribute("page",pageMaker); return "list"; }
	 */

}
