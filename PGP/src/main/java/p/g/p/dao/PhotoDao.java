package p.g.p.dao;

import java.util.List;

import p.g.p.model.Board_Comment;
import p.g.p.model.Join_BoardComment_MemberInfo;
import p.g.p.model.Member_info;

public interface PhotoDao {

	public int insertComment(Board_Comment board_comment);
	public List<Join_BoardComment_MemberInfo> selectCommentAll();
	public Board_Comment deleteComment();
}
