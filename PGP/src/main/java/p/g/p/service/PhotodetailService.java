package p.g.p.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.PhotoDao;
import p.g.p.dao.PhotoDetailUpdateDao;
import p.g.p.dao.PhotoFeedDao;
import p.g.p.model.Board;
import p.g.p.model.Board_Comment;
import p.g.p.model.Board_Photo;
import p.g.p.model.Join_BoardComment_MemberInfo;
import p.g.p.model.Join_Board_Category_RoomNSpace;
import p.g.p.model.Join_Board_MemberInfo;
import p.g.p.model.Join_board_boardphoto;
import p.g.p.model.PageMaker;
import p.g.p.model.Url_Tag;

public class PhotodetailService {

	PhotoDao dao;

	PhotoDetailUpdateDao dao2;
	
    PhotoFeedDao dao3;
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public Join_Board_MemberInfo selectJoin_Board_Member(int board_idx) {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		Join_Board_MemberInfo boardMemberinfo=dao.selectJoin_Board_Member(board_idx);
		return boardMemberinfo;
	}
	
	public int ListInsertComment(Board_Comment board_comment) {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		
			int group = maxRegroup();
	
		
		board_comment.setRegroup(group);
	    
		int resultCnt = dao.insertComment(board_comment);
		
		if (resultCnt > 0) {
			
		} else {
			resultCnt = -1;
		}
		return resultCnt;
	}
	
	//댓글 초기값 
	public int maxRegroup() {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		int max = dao.maxSelect();

		return max;
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
		
		return resultCnt;
	}

	public int boardCntUpdateView(int board_idx) {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);

		int resultCnt = dao.boardCntUpdate(board_idx);
		
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
	
	public int commentUpdate(Board_Comment comment) {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		int result = dao.repleUpdate(comment);

		return result;
	}
	

	public int boardDelete(int board_idx) {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		int resultCnt = dao.boardDelete(board_idx);
		return resultCnt;
	}

	public int urlDelete(int board_idx) {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		int resultCnt = dao.urlDelete(board_idx);
		return resultCnt;
	}
	public int AllDelete(int board_idx) {
		int resultCnt = boardPhotoDelete(board_idx); //꼭ㅈ삭제 
		int resultCnt2=urlDelete(board_idx);
		int resultCnt3 = boardCommentDelete(board_idx);
		int resultCnt4 = boardDelete(board_idx);//꼭 삭제 
		
		
		if (resultCnt > 0 && resultCnt4 > 0) {

			return resultCnt;
		}
		return -1;

	}


	public String tagcks(Board boardboard) {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		String tagcks= dao.tagcksmember(boardboard);
			if(tagcks!=null) {
			
			}else {
				tagcks = null;
			}
		return tagcks;
	}

	public List<Url_Tag> selectUrl(int board_idx) {
	      dao = sqlSessionTemplate.getMapper(PhotoDao.class);
	      List<Url_Tag> list = dao.selectUrl(board_idx);
	      return list;
	   }

	public int  re_repleInsert(Board_Comment board_comment) {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		
		int result = dao.re_repleInsert(board_comment);
		
		if (result > 0) {
			
			int idx = dao.maxIdx();
			board_comment = dao.selectByIdx(idx);
			
		    dao.reorderPlus(board_comment);
			
		}
		return result;
		
	}

	public List<Board_Comment> childReple(Board_Comment comment) {
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		
		List<Board_Comment> list = dao.childReple(comment);
			if(list.size()<0) {
							
			}
		return list;
	}
	
   //photodeatail에서 댓글 가져오는데 페이징 처리하느라 
	public List<Join_BoardComment_MemberInfo> selectCommentList(PageMaker pagemaker) {
		
		dao = sqlSessionTemplate.getMapper(PhotoDao.class);
		List<Join_BoardComment_MemberInfo> list = dao.selectCommentList(pagemaker);

		return list;

	}

	/////////////////////////////////////////////photodetail update 서비스
	public int  UpdateBoard(Board board) {
		dao2 = sqlSessionTemplate.getMapper(PhotoDetailUpdateDao.class);
		int resultCnt=dao2.UpdateBoard(board);
		return resultCnt;
	}
	
	public int  UpdateBoardPhoto(Board_Photo board_photo) {
		dao2 = sqlSessionTemplate.getMapper(PhotoDetailUpdateDao.class);
		int resultCnt=dao2.UpdateBoardPhoto(board_photo); 
		return resultCnt;
	}
	
	public int  UpdateCategoryRoom(Join_Board_Category_RoomNSpace joinBoardRoom) {
		dao2 = sqlSessionTemplate.getMapper(PhotoDetailUpdateDao.class);
		int resultCnt=dao2.UpdateCategoryRoom(joinBoardRoom);
		return resultCnt;
	}
	
	public int  UpdateCategorySpace(Join_Board_Category_RoomNSpace joinBoardSpace) {
		dao2 = sqlSessionTemplate.getMapper(PhotoDetailUpdateDao.class);
		int resultCnt=dao2.UpdateCategorySpace(joinBoardSpace);
		return resultCnt;
	}
	
	public int AllPhotoDetailUpdate(Board board,Board_Photo board_photo,Join_Board_Category_RoomNSpace joinBoardRoomNSpace) {
	
		
		
		int result1=UpdateBoard(board);
		int result2=UpdateBoardPhoto(board_photo);
		int result3=UpdateCategoryRoom(joinBoardRoomNSpace);
		int result4=UpdateCategorySpace(joinBoardRoomNSpace);
		
	    return result1;
	}
	
  ////////////////////////////////////////////////////////photofeed
	public  List<Board_Photo> BoardPhotoList(){
		dao3 = sqlSessionTemplate.getMapper(PhotoFeedDao.class);
		List<Board_Photo> list = dao3.selectPhotoFeed();
		return list;
	}

}
