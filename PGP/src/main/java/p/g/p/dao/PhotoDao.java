package p.g.p.dao;

import java.util.List;

import p.g.p.model.Board;
import p.g.p.model.Board_Comment;
import p.g.p.model.Board_Photo;
import p.g.p.model.Join_BoardComment_MemberInfo;

public interface PhotoDao {

	public int insertComment(Board_Comment board_comment);
	public List<Join_BoardComment_MemberInfo> selectCommentAll(int board_idx);
	public int deleteComment(int board_comment_idx);
	public int commentTotalCnt(int board_idx);
	public int boardCntUpdate(int board_idx);
	public int boardCntSelect(int board_idx);
	public Board boardSelect(int board_idx);
	public String selectPhotoFeed(int board_idx);
}
