package p.g.p.dao;

import java.util.List;

import p.g.p.model.Board_Comment;
import p.g.p.model.Board_Photo;
import p.g.p.model.Join_board_boardphoto;
import p.g.p.model.Member_info;
import p.g.p.model.PhotoListmodel;
import p.g.p.model.scrapFN;

public interface Mp_dao {
   
   public Member_info selectById(String member_id);
   
    public int updateById(Member_info member);
    
    public List<Board_Photo> selectScrapPhotoList(String member_id);
    
    public List<Join_board_boardphoto> selectMyPhotoList(int member_idx);

    public List<Board_Comment> selectMyCommentList(String member_id);

    //스크랩 디테일에서 각각 폴더에 맞는 board_idx 가져오기 
    public List<String> selectBoardIdx(scrapFN scrap);

    //나의 사진만 보여쥑 
	public List<PhotoListmodel> myphotolist(int member_idx);
}