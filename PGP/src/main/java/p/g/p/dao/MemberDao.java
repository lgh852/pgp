package p.g.p.dao;

import java.util.List;

import p.g.p.model.Board;
import p.g.p.model.Board_Photo;
import p.g.p.model.Join_board_boardphoto;
import p.g.p.model.Member_info;

public interface MemberDao {

	public int insertMember(Member_info member);

	public Member_info loginSelect(String id);
    
    //사진 몇개 올렸나 세보쟈
	public int countPhoto(int member_idx);
    
	//마이 메인 페이지 최근 3개만 가져오기 
	public List<Join_board_boardphoto> LatestPhoto(int member_idx);

	//좋아요 누른 사진 가져오기
	public List<Join_board_boardphoto> selectLikePhoto(int member_idx);

	public int kakaoinsert(Member_info member);
    
	//스크랩 최근 사진 가져오기 
	public String LatestScrapPhoto(int member_idx);

	//좋아요 최근 사진 가져오기 
	public String LatestLikePhoto(int member_idx);
	

	//////////////////////////////////////////
	public String selectChkId(Member_info member);

	public Member_info selectChkPw(Member_info member);


	public int updateChkPw(Member_info member);


	public int updateChgPw(Member_info member);

	public String selectPw(Member_info member);

	
	
}
