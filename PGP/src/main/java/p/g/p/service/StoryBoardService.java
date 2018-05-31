package p.g.p.service;

import java.io.File;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.Sb_dao;
import p.g.p.dao.StoryBoardDao;
import p.g.p.model.Join_MemberInfo_StoryBoard;
import p.g.p.model.Join_MemberInfo_StoryBoardComment;
import p.g.p.model.Like;
import p.g.p.model.StoryBoard;
import p.g.p.model.StoryBoard_Comment;
import p.g.p.model.report;

public class StoryBoardService {

	StoryBoardDao dao;

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	// 글 입력
	public int insertStroyboard(StoryBoard storyboard) {
		dao = sqlSessionTemplate.getMapper(StoryBoardDao.class);
		int resultStoryCnt = dao.insertStroyboard(storyboard);
		return resultStoryCnt;
	}

	public int updateStroyboard(StoryBoard storyboard) {
		dao = sqlSessionTemplate.getMapper(StoryBoardDao.class);
		int resultStoryCnt = dao.updateStroyboard(storyboard);
		return resultStoryCnt;
	}
	
	
	// 글 리스트 출력
		public List<Join_MemberInfo_StoryBoard> select_join_MemberInfo_StoryBoard(Like like) {
			dao = sqlSessionTemplate.getMapper(StoryBoardDao.class);
			System.out.println(like);
			System.out.println(like);
			System.out.println(like);
			List<Like> likelist = selecting(like);
			System.out.println(likelist);
			System.out.println(likelist);
			System.out.println(likelist);
			
		
			List<Join_MemberInfo_StoryBoard> listStory = dao.select_join_MemberInfo_StoryBoard();
			
			
			System.out.println("story"+listStory);
			System.out.println("story"+listStory);
			System.out.println("story"+listStory);
			System.out.println("story"+listStory);
			System.out.println("story"+listStory);	
			System.out.println("크기"+likelist.size());
			System.out.println("크기"+likelist.size());
			System.out.println("크기"+likelist.size());
			System.out.println("크기"+likelist.size());
			
			if(likelist.size()>0) {
				
			for (int i = 0; i < listStory.size(); i++) {
				System.out.println("asdasdasd"+listStory);
				System.out.println("asdasdasd"+listStory);
				int photoidx = listStory.get(i).getStoryboard_idx();
				System.out.println("2번쨰 ㅇㄴㅁㅇㅁㅇㄴㅁㄴ");
				for (int x = 0; x < likelist.size(); x++) {
					System.out.println("3번째ㅁㄴㅇㄴㅇㅁㅁㄴ");
					int listidx = likelist.get(x).getStoryboard_idx();
					System.out.println("4번째 ");
					if (photoidx == listidx) {
						System.out.println("5번째");
						listStory.get(i).setLikeck("ss");
					}
				}
			}
			}else {
				  
				System.out.println(likelist);
				System.out.println(likelist);
				System.out.println(likelist);
				System.out.println(likelist);
				System.out.println(likelist);
				System.out.println(likelist);
				System.out.println(likelist);
				likelist = null;
			}
			
			return listStory;
		}
	// 댓글 입력
	public int insertStoryComment(StoryBoard_Comment storyboardComment) {
		dao = sqlSessionTemplate.getMapper(StoryBoardDao.class);
		int resultCommentCnt = dao.insertStoryComment(storyboardComment);
		return resultCommentCnt;
	}

	// 포토번호 넣기
	public int selectPhotoMaxIDX() {
		dao = sqlSessionTemplate.getMapper(StoryBoardDao.class);
		int photoMaxIDX = dao.selectPhotoMaxIDX();
		
		return photoMaxIDX;
	}

	// 댓글 리스트 출력
	public List<Join_MemberInfo_StoryBoardComment> storyCommentList() {
		dao = sqlSessionTemplate.getMapper(StoryBoardDao.class);
		List<Join_MemberInfo_StoryBoardComment> listStoryComment = dao.storyCommentList();
		return listStoryComment;
	}

	// 스토리보드 삭제
	public int deleteStoryboard(int storyboard_idx) {
		dao = sqlSessionTemplate.getMapper(StoryBoardDao.class);
		int delStory = dao.deleteStoryboard(storyboard_idx);
		return delStory;
	}

	// 스토리보드 댓글 전체 삭제
	public int deleteAllStoryComment(int storyboard_idx) {
		dao = sqlSessionTemplate.getMapper(StoryBoardDao.class);
		int delAllStoryComment = dao.deleteAllStoryComment(storyboard_idx);
		return delAllStoryComment;
	}

	//좋아요 전체 삭제 
	   public int deleteAllLike(int storyboard_idx) {
	      dao = sqlSessionTemplate.getMapper(StoryBoardDao.class);
	      int delLikeResult=dao.deleteAllLike(storyboard_idx);
	      return delLikeResult;
	   }

	   // 스토리 게시물 댓글까지 다 삭제,좋아요도 다 삭제 
	   public int AllDeleteStory(int storyboard_idx) {
	      deleteAllStoryComment(storyboard_idx);
	      deleteAllStoryComment(storyboard_idx);
	      int delStory = deleteStoryboard(storyboard_idx);

	      String photoName = selectStoryPhotoName(storyboard_idx);
	      String path = "C:\\Users\\403room-07\\Documents\\workspace-sts-3.9.2.RELEASE\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\p\\resources\\StoryPhoto\\"
	            + photoName;
	      File file = new File(path);
	      if (file.exists() == true) {

	         file.delete();
	      }

	      if (delStory > 0 ) {
	         return delStory;
	      }
	      return -1;
	   }

	// 스토리 댓글삭제
	public int deleteStoryComment(int storyboard_comment_idx) {
		dao = sqlSessionTemplate.getMapper(StoryBoardDao.class);
		int delStoryComment = dao.deleteStoryComment(storyboard_comment_idx);
		return delStoryComment;
	}
	
	//물리적 삭제를 위한 이름 찾기 
	public String selectStoryPhotoName(int storyboard_idx) {
		dao = sqlSessionTemplate.getMapper(StoryBoardDao.class);
		String storyPhotoName=dao.selectStoryPhotoName(storyboard_idx);
		return storyPhotoName;
		
	}
	
	

	public Like selectLikeCk(Like like) {
		dao = sqlSessionTemplate.getMapper(StoryBoardDao.class);
		Like likeCk = dao.selectLikeCk(like); //좋아요 눌럿는지 검색해서 값 가져감
		if (likeCk != null) { //좋아요 눌ㅇ럿을때
		} else { //좋아요 안눌럿을떄 널값줌 
			likeCk = null;
		}
		return likeCk;
	}

	public int insertStoryLike(Like like) {
		dao = sqlSessionTemplate.getMapper(StoryBoardDao.class);
		int resultLike = dao.insertStoryLike(like);
		return resultLike;
	}

	public int updateLikeUp(int storyboard_idx) {
		dao = sqlSessionTemplate.getMapper(StoryBoardDao.class);
		int updateLikeup = dao.updateLikeUp(storyboard_idx);
		System.out.println("으야야야야ㅑ야" + updateLikeup);
		return updateLikeup;
	}

	public int updateLikeDown(int storyboard_idx) {
		dao = sqlSessionTemplate.getMapper(StoryBoardDao.class);
		int updateLikedown = dao.updateLikeDown(storyboard_idx);
		return updateLikedown;
	}

	public int deletelike(Like like) {
		dao = sqlSessionTemplate.getMapper(StoryBoardDao.class);
		int deletelike = dao.deletelike(like);
		return deletelike;
	}

	public List<Like> selecting(Like like) {
		dao = sqlSessionTemplate.getMapper(StoryBoardDao.class);
		List<Like> likelist = dao.selecting(like);

		
		if (likelist != null) {
		
		} else {
		
			likelist = null;
		}

		return likelist;
	}


	//스토리 신고 
	public int reportSubmit(report report) {
	      
	      dao = sqlSessionTemplate.getMapper(StoryBoardDao.class);
	      int result = dao.reportboard(report);
	      
	      if(result>0) {
	         System.out.println("성공");
	      }else {
	         result=-1;
	      }
	      
	      return result;
	   }
	


}