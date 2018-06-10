package p.g.p.dao;

import java.util.List;

import p.g.p.model.Join_MemberInfo_StoryBoard;
import p.g.p.model.Join_MemberInfo_StoryBoardComment;
import p.g.p.model.Like;
import p.g.p.model.Member_info;
import p.g.p.model.StoryBoard;
import p.g.p.model.StoryBoard_Comment;
import p.g.p.model.report;

public interface StoryBoardDao {

	public int insertStroyboard(StoryBoard storyboard); // 글쓰기
	public int updateStroyboard(StoryBoard storyboard);
	public List<Join_MemberInfo_StoryBoard> select_join_MemberInfo_StoryBoard();// 스토리보드 & 멤버정보 리스트

	public int insertStoryComment(StoryBoard_Comment storyboardComment); // 댓글 쓰기
	public List<Join_MemberInfo_StoryBoardComment> storyCommentList(); // 스토리댓글 & 멤버정보 리스트

	public int deleteStoryboard(int storyboard_idx); // 스토리보드 삭제
	public int deleteAllStoryComment(int storyboard_idx);; // 스토리보드 댓글 전체 삭제
	public int deleteAllLike(int storyboard_idx); //스토리 좋아요 전체 삭제 
	
	public int deleteStoryComment(int storyboard_comment_idx); // 스토리 댓글 삭제

	public String selectStoryPhotoName(int storyboard_idx); // 물리적 삭제하기위한 이름찾ㅈ기

	public Like selectLikeCk(Like like); // 스토리 좋아요 체크
	public int insertStoryLike(Like like); // 좋아요 회원번호 및 글번호 삽입
	public int updateLikeUp(int storyboard_idx); // 스토리 좋아요 증가
	public int updateLikeDown(int storyboard_idx); // 스토리 좋아요 감소
	public int selectPhotoMaxIDX(); // <!-- 포토번호 넣기 -->
	public int deletelike(Like like); // 좋아요 삭제
	public List<Like> selecting(Like like);

	public int reportboard(report report); // 스토리 신고
	
	//마이페이지 스토리 
	public List<Join_MemberInfo_StoryBoard> selectMpStory(Member_info member);
}
