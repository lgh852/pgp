package p.g.p.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.PhotoDao;
import p.g.p.dao.PhotoFeedDao;
import p.g.p.model.Board_Photo;

public class PhotofeedService {
	
	PhotoFeedDao dao;
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	public  List<Board_Photo> BoardPhotoList(){
		dao = sqlSessionTemplate.getMapper(PhotoFeedDao.class);
		List<Board_Photo> list = dao.selectPhotoFeed();
		return list;
	}

	
	/*public int boardCommentDelete(int board_idx) {
		dao = sqlSessionTemplate.getMapper(PhotoFeedDao.class);
		int resultCnt = dao.boardCommentDelete(board_idx);
		return resultCnt;
	}

	public int boardPhotoDelete(int board_idx) {
		dao = sqlSessionTemplate.getMapper(PhotoFeedDao.class);
		int resultCnt = dao.boardPhotoDelete(board_idx);
		return resultCnt;
	}

	public int boardDelete(int board_idx) {
		dao = sqlSessionTemplate.getMapper(PhotoFeedDao.class);
		int resultCnt = dao.boardDelete(board_idx);
		return resultCnt;
	}

	public int AllDelete(int board_idx) {

		int resultCnt = boardCommentDelete(board_idx);
		int resultCnt2 = boardPhotoDelete(board_idx);
		int resultCnt3 = boardDelete(board_idx);
		if (resultCnt > 0 && resultCnt2 > 0 && resultCnt3 > 0) {
			return resultCnt;
		}
		return -1;
}*/
}
