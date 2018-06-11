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
import p.g.p.model.Member_info;
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
		public List<Join_MemberInfo_StoryBoard> select_join_MemberInfo_StoryBoard(Like like,Member_info member) {
			
			dao = sqlSessionTemplate.getMapper(StoryBoardDao.class);
			System.out.println("서비스 dao맵핑 되냐");
			List<Like> likelist;
			
	
			System.out.println();
			int member_idx;
			
			if(member!=null) {
				System.out.println("서비스 멤버 쪽으로 들어옴????");
				 member_idx = member.getMember_idx();
				 System.out.println("서비스 2");
				 like.setMember_idx(member_idx);
				 System.out.println("서비스 3");
				 likelist = selecting(like);
				 System.out.println("서비스 4"+likelist);
				
			}else{
				
				 member_idx = 0; 
				
				 like.setMember_idx(member_idx);
				
				 likelist = selecting(like);
				
			}
		
			System.out.println("서비스 4adfsafadfadfadff"+likelist);
		
			List<Join_MemberInfo_StoryBoard> listStory = dao.select_join_MemberInfo_StoryBoard();
			
			 System.out.println("서비스 5"+listStory);
			
			
			if(likelist.size()>0) {
				
				System.out.println("서비스6"+likelist.size());
				
			for (int i = 0; i < listStory.size(); i++) {
				
		
				int photoidx = listStory.get(i).getStoryboard_idx();
				
				
				for (int x = 0; x < likelist.size(); x++) {
					
			
					int listidx = likelist.get(x).getStoryboard_idx();
					
					System.out.println("서비스10"+listidx);
					if (photoidx == listidx) {
						
						listStory.get(i).setLikeck("ss");
						
					}
				}
			}
			
			}else {
				  
				
				likelist = null;
			}
			
			
			System.out.println("서비스13"+listStory);
			return listStory;
		}
	// 댓글 입력
	public int insertStoryComment(StoryBoard_Comment storyboardComment) {
		dao = sqlSessionTemplate.getMapper(StoryBoardDao.class);
		int resultCommentCnt = dao.insertStoryComment(storyboardComment);
		if(resultCommentCnt>0) {
			
		}else {
			resultCommentCnt = -2;
		}
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
		if(delStoryComment>0) {
			
		}else {
			
			delStoryComment = -1;
		}
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

	
	//마이페이지 스토리 가져오기 위해 
	public List<Join_MemberInfo_StoryBoard> selectMpStory(Like like, Member_info member) {
		
		dao = sqlSessionTemplate.getMapper(StoryBoardDao.class);
		System.out.println("서비스 dao맵핑 되냐");
		List<Like> likelist;
		

		System.out.println();
		int member_idx;
		
		if(member!=null) {
			System.out.println("서비스 멤버 쪽으로 들어옴????");
			 member_idx = member.getMember_idx();
			 System.out.println("서비스 2");
			 like.setMember_idx(member_idx);
			 System.out.println("서비스 3");
			 likelist = selecting(like);
			 System.out.println("서비스 4"+likelist);
			
		}else{
			
			 member_idx = 0; 
			
			 like.setMember_idx(member_idx);
			
			 likelist = selecting(like);
			
		}
	
		System.out.println("서비스 4adfsafadfadfadff"+likelist);
	
		List<Join_MemberInfo_StoryBoard> listStory = dao.selectMpStory(member);
		
		 System.out.println("서비스 5"+listStory);
		
		
		if(likelist.size()>0) {
			
			System.out.println("서비스6"+likelist.size());
			
		for (int i = 0; i < listStory.size(); i++) {
			
	
			int photoidx = listStory.get(i).getStoryboard_idx();
			
			
			for (int x = 0; x < likelist.size(); x++) {
				
		
				int listidx = likelist.get(x).getStoryboard_idx();
				
				System.out.println("서비스10"+listidx);
				if (photoidx == listidx) {
					
					listStory.get(i).setLikeck("ss");
					
				}
			}
		}
		
		}else {
			  
			
			likelist = null;
		}
		
		
		System.out.println("서비스13"+listStory);
		return listStory;
	}
	


}
