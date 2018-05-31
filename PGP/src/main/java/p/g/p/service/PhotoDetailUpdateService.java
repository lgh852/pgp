package p.g.p.service;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.PhotoDetailUpdateDao;
import p.g.p.model.Board;
import p.g.p.model.Board_Photo;
import p.g.p.model.Join_Board_Category_RoomNSpace;


public class PhotoDetailUpdateService {
	
	PhotoDetailUpdateDao dao;
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int  UpdateBoard(Board board) {
		dao = sqlSessionTemplate.getMapper(PhotoDetailUpdateDao.class);
		int resultCnt=dao.UpdateBoard(board);
		return resultCnt;
	}
	
	public int  UpdateBoardPhoto(Board_Photo board_photo) {
		dao = sqlSessionTemplate.getMapper(PhotoDetailUpdateDao.class);
		int resultCnt=dao.UpdateBoardPhoto(board_photo); 
		return resultCnt;
	}
	
	public int  UpdateCategoryRoom(Join_Board_Category_RoomNSpace joinBoardRoom) {
		dao = sqlSessionTemplate.getMapper(PhotoDetailUpdateDao.class);
		int resultCnt=dao.UpdateCategoryRoom(joinBoardRoom);
		return resultCnt;
	}
	
	public int  UpdateCategorySpace(Join_Board_Category_RoomNSpace joinBoardSpace) {
		dao = sqlSessionTemplate.getMapper(PhotoDetailUpdateDao.class);
		int resultCnt=dao.UpdateCategorySpace(joinBoardSpace);
		return resultCnt;
	}
	
	public int AllPhotoDetailUpdate(Board board,Board_Photo board_photo,Join_Board_Category_RoomNSpace joinBoardRoomNSpace) {
	
		
		
		int result1=UpdateBoard(board);
		int result2=UpdateBoardPhoto(board_photo);
		int result3=UpdateCategoryRoom(joinBoardRoomNSpace);
		int result4=UpdateCategorySpace(joinBoardRoomNSpace);
		
		System.out.println("야야야ㅑㅂ===>"+result1);
		System.out.println("야야야ㅑㅂ===>"+result2);
		System.out.println("야야야ㅑㅂ===>"+result3);
		System.out.println("야야야ㅑㅂ===>"+result4);
		
		return result1;
	}
	
	

}
