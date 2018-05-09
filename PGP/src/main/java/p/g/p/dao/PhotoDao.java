package p.g.p.dao;

import java.util.List;

import p.g.p.model.Board;
import p.g.p.model.Board_Comment;
import p.g.p.model.Join_BoardComment_MemberInfo;
import p.g.p.model.Join_board_boardphoto;

public interface PhotoDao {

	public int insertComment(Board_Comment board_comment);
	public List<Join_BoardComment_MemberInfo> selectCommentAll(int board_idx);
	public int deleteComment(int board_comment_idx);
	public int commentTotalCnt(int board_idx);
	public int boardCntUpdate(int board_idx);
	public int boardCntSelect(int board_idx);
	public Board boardSelect(int board_idx);
	public String selectPhotoFeed(int board_idx);
	public int commentTotalUpdate(int board_idx);
	public List<Join_board_boardphoto> popluarphotoSelect();  //조회수 기준 인기 사진 세개만 출력 
	public int boardCommentDelete(int board_idx);   // 댓글 다   삭제 
	public int boardPhotoDelete(int board_idx); 	//사진 다 삭제	
	public int boardDelete(int board_idx); //글쓰기 다 삭제 
	public int urlDelete(int board_idx);//url 태그 다 삭제 
	
	
}
