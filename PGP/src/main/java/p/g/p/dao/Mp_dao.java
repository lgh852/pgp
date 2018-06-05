package p.g.p.dao;

import java.util.List;

import p.g.p.model.Board_Comment;
import p.g.p.model.Board_Photo;
import p.g.p.model.Join_Scrap_scrapFN;
import p.g.p.model.Join_board_boardphoto;
import p.g.p.model.Member_info;
import p.g.p.model.PhotoListmodel;
import p.g.p.model.Scrap;
import p.g.p.model.scrapFN;

public interface Mp_dao {
   
   public Member_info selectById(String member_id);
   
    public int updateById(Member_info member);
    
   
    public List<Join_board_boardphoto> selectMyPhotoList(int member_idx);

    public List<Board_Comment> selectMyCommentList(String member_id);

    //나의 사진만 보여쥑 
	public List<PhotoListmodel> myphotolist(int member_idx);
 
	//마이페이지 스크랩 폴더에 맞는 사진 리스트 보여주기 다시
	public List<Join_Scrap_scrapFN> selectScrapPhotoList(Scrap scrap2);

	
	
	//일단 scrapfnidx가져오기
	public List<Integer> selectscrpafnidx(int member_idx);

	//갯수 가져오기 (몇 번 돌아야 하냐)
	public int countFnIdx(int member_idx);

	//board_idx 리스트 만들어오쟈
	public int selectScrapBoardIdx(Join_Scrap_scrapFN scrap);

	//photo_name 리스트 가져오기 
	public String selectPhotoName(Integer integer);
}