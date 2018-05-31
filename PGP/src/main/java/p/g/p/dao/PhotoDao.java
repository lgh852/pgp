package p.g.p.dao;

import java.util.List;

import p.g.p.model.Board;
import p.g.p.model.Board_Comment;
import p.g.p.model.Join_BoardComment_MemberInfo;
import p.g.p.model.Join_board_boardphoto;
import p.g.p.model.Url_Tag;

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
   
   public int boardCommentDelete(int board_idx);   // 댓글 테이블  삭제 
   public int boardPhotoDelete(int board_idx);    //사진 테이블  삭제   
   public int boardDelete(int board_idx); //글쓰기 테이블 삭제 
   public int urlDelete(int board_idx);//url 테이블  삭제 
   public int scrapDelete (int board_idx);//스크랩 테이블 삭제
   public int likeDelete (int board_idx); //좋아요 테이블 삭제
   public int categoryRoomDelete (int board_idx); //카테고리 룸 테이블 삭제 
   public int categorySpaceDelete (int board_idx); //카테고리 공간 테이블 삭제 
   
   public List<Url_Tag> selectUrl(int board_idx); //url 리스트 출력 
   public int updateUrlCnt(int tag_idx); // url 태그 클릭시 조회수 증가  
   
   //보드 정보 뽑아올 리스트 
   public List<Board> selectByBoardIdx(int board_idx);
  
   
}