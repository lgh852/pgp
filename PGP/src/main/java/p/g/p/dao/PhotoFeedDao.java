package p.g.p.dao;

import java.util.List;

import p.g.p.model.Board_Photo;

public interface PhotoFeedDao {

	
	public List<Board_Photo> selectPhotoFeed();
	public int boardCommentDelete(int board_idx);   // 댓글 다   삭제 
	public int boardPhotoDelete(int board_idx); 	//사진 다 삭제	
	public int boardDelete(int board_idx); //글쓰기 다 삭제 

	
}