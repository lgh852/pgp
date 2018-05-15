package p.g.p.dao;

import p.g.p.model.Like;
import p.g.p.model.PhotoListmodel;
import p.g.p.model.report;

public interface Sb_dao {

    //신고
	public int reportboard(report report);

	//좋아요들!!! 좋아요 체크 되어있나 확인해보쟈 
	public Like selectlikeck(Like like);

    //게시물에 라이크 해준당
	public int likeup(Like like);

	//게시물 라이크 수 업!
	public int likeUpdateUP(Like like);

	//게시물 라이크 없어져랏 야아아ㅏㅏㅂ
	public int deletelike(Like likeck);
	
	//게ㅣ물 라이크 수 다운!
	public int likeupdateDown(Like like);
	
	public PhotoListmodel mypagelikeck(String board_idx);
	
	
	
	
	
	
	
	
	
}
