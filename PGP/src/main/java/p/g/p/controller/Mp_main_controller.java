package p.g.p.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.cj.Session;

import p.g.p.model.Board;
import p.g.p.model.Board_Comment;
import p.g.p.model.Join_MemberInfo_StoryBoard;
import p.g.p.model.Join_board_boardphoto;
import p.g.p.model.Like;
import p.g.p.model.Member_info;
import p.g.p.model.PhotoListmodel;
import p.g.p.service.MemberService;
import p.g.p.service.Mp_MyPageList;
import p.g.p.service.Mp_myComment_service;
import p.g.p.service.Mp_myphoto_service;
import p.g.p.service.Mp_update_service;
import p.g.p.service.PhotodetailService;
import p.g.p.service.StoryBoardService;

@Controller
public class Mp_main_controller {

	@Autowired
	private StoryBoardService storyboardservice;
	@Autowired
	private  MemberService service;

	@Autowired
	private Mp_MyPageList pagelistservice;

	@Autowired
	private Mp_myphoto_service myphotoservice;

	@Autowired
	private Mp_myComment_service commentservice;

	@RequestMapping("/mypage/mp_main")
	public String mypage(HttpSession session, Model model, Board board, Member_info member) {

		String view = "home";

		String page = "mypage/mp_newmain.jsp";

		String ck = "s";

		member = pagelistservice.userck(session, member);
		if (member != null) {
			// 성공
			int member_idx = member.getMember_idx();

			// 사진 갯수
			int photo_count = service.countPhoto(member_idx);
			model.addAttribute("photo_count", photo_count);

			if (photo_count > 0) {

				ck = "y";

			} else {

				ck = "n";
			}
			
			// 사진들 가져오쟈
			List<Join_board_boardphoto> boardLatestPhoto = service.selectLatestPhoto(member_idx);
			if (boardLatestPhoto != null) {
				model.addAttribute("boardLatestPhoto", boardLatestPhoto);

			} else {
				boardLatestPhoto = null;
			}
			// 스크랩한 최근 사진 가져오쟈
			String scrapLatestPhoto = service.selectScrapLatestPhoto(member_idx);
			if (scrapLatestPhoto != null) {
				model.addAttribute("scrapLatestPhoto", scrapLatestPhoto);
			} else {
				scrapLatestPhoto = null;
			}

			// 좋아요한 최근 사진 가져오쟈
			String likeLatestPhoto = service.selectLikeLatestPhoto(member_idx);
			if (likeLatestPhoto != null) {
				model.addAttribute("likeLatestPhoto", likeLatestPhoto);
			} else {
				likeLatestPhoto = null;
			}
			
			model.addAttribute("member", member);
		} else {

			// 실패 뷰값 주삼
			// 실패
		}
		
		    //

		model.addAttribute("page", page);
		model.addAttribute("ck", ck);
		model.addAttribute("member", member);

		return view;

	}

	@RequestMapping("/mypage/mp_myLike")
	public String myLikePage(HttpSession session, Model model, Member_info member) {

		String view = "";
		String page = "";

		member = pagelistservice.userck(session, member);
		if (member != null) {
			// 좋아요 가져오쟈
			view = "home";
			page = "mypage/mp_myLike.jsp";
			List<Join_board_boardphoto> likeList = service.selectLikeList(member.getMember_idx());
			if (likeList != null) {

				model.addAttribute("likeList", likeList);
			} else {
				likeList = null;
			}

			model.addAttribute("member", member);
		} else {

			// 에러페이지로 보내 이색기야

		}

		model.addAttribute("page", page);

		return view;
	}

	// mp_myStory
	@RequestMapping("/mypage/mp_myStory")
	public String myStoryPage(HttpSession session, Model model, Like like, Member_info member) {
		String view = "";
		String page = "";
		
		System.out.println("111111111"+member);

		member = pagelistservice.userck(session, member);
		
		System.out.println("222222222"+member);

		if (member != null) {
			
			List<Join_MemberInfo_StoryBoard> mpListStory = storyboardservice.selectMpStory(like,member);

			view = "home";
			page = "mypage/mp_myStory.jsp";
			
			if (mpListStory != null) {

				model.addAttribute("listStory", mpListStory);
			} else {
				mpListStory = null;
			}
			model.addAttribute("member", member);
		} else {

			// 에러페이지로 보내 이시키야
		}

		model.addAttribute("page", page);

		return view;
	}

	// commentcontroller 에 잇던것 controller 제거함
	@RequestMapping(value = "/mypage/mp_myComment", method = RequestMethod.GET)
	public String myComment(HttpSession session, Model model, Member_info member) {
		String page = "";

		String view = "";
		
		member = pagelistservice.userck(session, member);
		
		System.out.println("멤버정보 왜 이거들어오냐?"+member);
		
		if (member != null) {
			page = "mypage/mp_myComment.jsp";
			view = "home";
			
			List<Board_Comment> myComment = commentservice.Mp_myCommentList(member);
			System.out.println("아니왜죠"+myComment);
			
			if (myComment != null) {

				System.out.println("adjf"+myComment);
				model.addAttribute("myComment", myComment);
				System.out.println("adfadfadfadfadf");
			} else {
				myComment = null;
				System.out.println("여기로 들어와야 하는데?0?");
				model.addAttribute("myComment", myComment);
			}
			model.addAttribute("member",member);
		} else {

			// 에러 페이지 처리
		}

		model.addAttribute("page", page);

		return view;

	}

	@RequestMapping(value ="/mypage/mp_myphoto",method=RequestMethod.GET)
	public String mypageMyphoto(HttpSession session, Model model, Member_info member,Like like) {
	
		String page = "";
		
		String view = "";
		
		member = pagelistservice.userck(session, member);
		
		if(member!=null) {
			
			view = "home";
			
			page = "mypage/mp_myphoto.jsp";
			
			List<PhotoListmodel> list = myphotoservice.myPhotolistview(member);
			
			if(list!=null) {

				model.addAttribute("listlist",list);
				
			}else {
				
				list = null;
			}
			
			model.addAttribute("member", member);
		}else {
			
			
			//에러페이지 처리 하세요 
		}
	

		
		model.addAttribute("page", page);

		return view;
		
	
	}
}
