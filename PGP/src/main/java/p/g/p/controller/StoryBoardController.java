package p.g.p.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import p.g.p.model.Join_MemberInfo_StoryBoard;
import p.g.p.model.Join_MemberInfo_StoryBoardComment;
import p.g.p.model.Like;
import p.g.p.model.Member_info;
import p.g.p.model.StoryBoard;
import p.g.p.model.StoryBoard_Comment;
import p.g.p.model.report;
import p.g.p.service.BoardPhotoUpLoad;
import p.g.p.service.StoryBoardService;

@Controller

public class StoryBoardController {

	@Autowired
	StoryBoardService storyboardservice;
	@Autowired
	BoardPhotoUpLoad photoup;

	@RequestMapping(value = "story/storyboardForm", method = RequestMethod.GET)
	public String story(Model model, Like like, HttpSession session) {
		
		String view = "home";
		String page = "story/storyboardForm.jsp";
		model.addAttribute("page", page);
		
		System.out.println("1"+like);
		
		
		Member_info member = (Member_info) session.getAttribute("user");
		
		if(member==null) {
			model.addAttribute("seck",null);
		}else {
			like.setMember_idx(member.getMember_idx());
			model.addAttribute("seck",member);
			System.out.println("2 member가 있다면 나와라"+member);
          
					
		}
		System.out.println("3");
		List<Join_MemberInfo_StoryBoard> listStory = storyboardservice.select_join_MemberInfo_StoryBoard(like,member); // 스토리보드
		System.out.println("4 룰루"+like);
		// 리스트
		if(listStory==null) {
			System.out.println("안다");
		}
		


		model.addAttribute("listStory", listStory);
		
		List<Join_MemberInfo_StoryBoardComment> listStroyComment = storyboardservice.storyCommentList(); // 스토리 댓글 리스트
		
		System.out.println("5");
		model.addAttribute("listStroyComment", listStroyComment);

		return view;
	}

	@RequestMapping(value = "story/storyboardForm", method = RequestMethod.POST)
	public String storyboard(HttpServletRequest request, HttpSession session, Model model, StoryBoard storyboard,
			Like like) throws IllegalStateException, IOException {
		String view = "home";
		String page = "story/storyboardForm.jsp";
		System.out.println(storyboard);
		System.out.println(storyboard);
		System.out.println(storyboard);
		
		model.addAttribute("page", page);
		Member_info member = (Member_info) session.getAttribute("user");
	System.out.println(member);
	
		if(member != null) {
			int member_idx = member.getMember_idx();
			storyboard.setMember_idx(member_idx); // 세션값통해 memberidx값 받아서 저장
			System.out.println(storyboard);
		}else {
			int member_idx = 0;
			storyboard.setMember_idx(member_idx); // 세션값통해 memberidx값 받아서 저장
			System.out.println(storyboard);
		}
			
		int resultStoryCnt = storyboardservice.insertStroyboard(storyboard); // 스토리보드값, 멤버idx저장
		int photoMaxIDX = storyboardservice.selectPhotoMaxIDX();
		photoup.storyfileupload(request, session, storyboard, photoMaxIDX); // 사진등록
		storyboard.setStoryboard_idx(photoMaxIDX);
		int resultStoryCnt2 = storyboardservice.updateStroyboard(storyboard); // update로 사진 등록

		
		List<Join_MemberInfo_StoryBoard> listStory = storyboardservice.select_join_MemberInfo_StoryBoard(like, member); // 스토리보드
		// 리스트로 출력
		model.addAttribute("listStory", listStory);
		List<Join_MemberInfo_StoryBoardComment> listStroyComment = storyboardservice.storyCommentList(); // 스토리 댓글 리스트
		model.addAttribute("listStroyComment", listStroyComment);
		System.out.println("이것봐!!1=>>"+resultStoryCnt+":"+resultStoryCnt2);
		if (resultStoryCnt > 0 && resultStoryCnt2 > 0) {
			page = "redirect:storyboardForm";
		}
		return view;
	}

	// 댓글 리스트
	/*@RequestMapping(value = "story/storyboardComment", method = RequestMethod.POST)
	public String storyComment(HttpSession session, Model model, StoryBoard_Comment storyboardComment) {
		Member_info member = (Member_info) session.getAttribute("user");
	
		int member_idx = member.getMember_idx();
		
		storyboardComment.setMember_idx(member_idx);	// 댓글쓸때 사용하기위해 세션값통해 아이디번호 저장
		storyboardservice.insertStoryComment(storyboardComment); // 댓글쓰기
		String page = "redirect:storyboardForm";
		return page;
	}*/
	@RequestMapping(value="story/storyboardComment")
	@ResponseBody
	public String storyComment(StoryBoard_Comment storyboardComment,HttpSession session) {
		String getStoryboard_comment_idx = "";
		System.out.println(storyboardComment);
		int result  = storyboardservice.insertStoryComment(storyboardComment);		
			if(result>0) {
				System.out.println("성곤");
				getStoryboard_comment_idx = String.valueOf(storyboardComment.getStoryboard_comment_idx());
			}else {
				
			}

		return getStoryboard_comment_idx;
		
	}
	
	
	// 댓글만 삭제
/*	@RequestMapping(value = "story/storyboardCommentDelete", method = RequestMethod.GET)
	public String storyCommentDelete(StoryBoard_Comment storyboardComment) {
		int storyboard_comment_idx = storyboardComment.getStoryboard_comment_idx();
		storyboardservice.deleteStoryComment(storyboard_comment_idx); // 댓글 삭제
		String page = "redirect:storyboardForm";
		return page;
	}
*/	@RequestMapping(value = "story/storyboardCommentDelete")
	@ResponseBody
	public String storyCommentDelete(StoryBoard_Comment storyboardComment) {
		
	int result = storyboardservice.deleteStoryComment(storyboardComment.getStoryboard_comment_idx()); // 댓글 삭제
		String idx ="";
	if(result>0) {
		idx = String.valueOf(storyboardComment.getStoryboard_comment_idx());
		}else {
			idx = "";
		}
	return idx;
}
	// 스토리 보드 삭제
	@RequestMapping(value = "story/storyboardDelete", method = RequestMethod.GET)
	public String storyDelete(StoryBoard_Comment storyboardComment) {
		int storyboard_idx = storyboardComment.getStoryboard_idx();
		storyboardservice.AllDeleteStory(storyboard_idx); // 스토리보드 & 댓글 전체 삭제
		System.out.println(">>S>D>S>D>S>D>S>D>D>>S>D::" + storyboard_idx);
		String page = "redirect:storyboardForm";
		return page;
	}

	// 스토리 좋아용!
	@RequestMapping(value = "story/storyboardLike", method = RequestMethod.GET)
	@ResponseBody
	public String storyLike(Like like, HttpSession session, Model model,Join_MemberInfo_StoryBoard story) {
		Member_info member = (Member_info) session.getAttribute("user");
		int member_idx = member.getMember_idx();
		System.out.println(story);

		like.setMember_idx(member_idx);

		String ck = "y";
		
		Like likeck = storyboardservice.selectLikeCk(like); //스토리 좋아요 눌럿는가
		
		if (likeck == null) { //스토리 좋아요안눌려잇음

			int result = storyboardservice.insertStoryLike(like);
			if (result > 0) {
				ck = "y";
				int resultCnt = storyboardservice.updateLikeUp(like.getStoryboard_idx());
				if (resultCnt > 0) {
					ck = "y";
				} else {
					ck = "s";
				}
			} else {
				ck = "s";
			}
			story.setLikeck(ck);
			return ck;

		} else { //스토리 좋아요 이미 눌려잇음 
			int resultCnt = storyboardservice.deletelike(like);
			if (resultCnt > 0) {
				int result = storyboardservice.updateLikeDown(like.getStoryboard_idx());
				ck = "n";
				if (result <= 0) {
					ck = "s";
				}
			} else {
				ck = "s";
			}
			story.setLikeck(ck);
			return ck;
		}

	}

	// 스토리 신고
	@RequestMapping(value = "story/storyboardReport", method = RequestMethod.GET)
	@ResponseBody
	public String storyReport(report report) {
	       	System.out.println(report);
	      String ck ="";
	      System.out.println("sdsds!!>>!!"+report);
	      int resultCnt = storyboardservice.reportSubmit(report);
	      System.out.println("sdsds!!!!"+report);
	       if(resultCnt>0) {
	         //성공
	      ck = "y";
	      //ss
	      }else {
	         
	         ck = "n";   
	      }
	      
	      return ck;
	   
	   }

}
