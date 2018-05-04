package p.g.p.dao;

import java.util.List;

import p.g.p.model.Board_Comment;
import p.g.p.model.Board_Photo;
import p.g.p.model.Join_board_boardphoto;
import p.g.p.model.Member_info;

public interface Mp_dao {
	
	public Member_info selectById(String member_id);
	
    public int updateById(Member_info member);
    
    public List<Board_Photo> selectScrapPhotoList(String member_id);
    
    public List<Join_board_boardphoto> selectMyPhotoList(String member_id);

    public List<Board_Comment> selectMyCommentList(String member_id);
}
