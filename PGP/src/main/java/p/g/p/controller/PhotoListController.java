package p.g.p.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import p.g.p.model.Board;
import p.g.p.model.Board_Comment;
import p.g.p.model.Board_Photo;
import p.g.p.model.Join_BoardComment_MemberInfo;
import p.g.p.model.Join_Board_Category_RoomNSpace;
import p.g.p.model.Join_Board_MemberInfo;
import p.g.p.model.Join_board_boardphoto;
import p.g.p.model.Like;
import p.g.p.model.Member_info;
import p.g.p.model.PhotoListmodel;
import p.g.p.model.Scrap;
import p.g.p.model.scrapFN;
import p.g.p.service.BoardPhotoUpLoad;
import p.g.p.service.PhotoDetailUpdateService;
import p.g.p.service.PhotoListLeeService;
import p.g.p.service.PhotoService;
import p.g.p.service.PhotodetailService;
import p.g.p.service.PhotofeedService;
import p.g.p.service.Sb_like_service;
import p.g.p.service.Sb_scrap_service;
@Controller
public class PhotoListController {
	@Autowired
	private PhotoService photoervice;

	@Autowired
	private PhotoListLeeService listservice;
	
	@Autowired
	private PhotofeedService photofeedservice;
	
	@Autowired
	private Sb_scrap_service scrap_service;
	
	@Autowired
	private PhotodetailService photodetailservice;

	@Autowired
	private Sb_like_service sblikeservice;
	
	@Autowired
	private PhotoDetailUpdateService photodetailupdateservice;

	@Autowired
	private BoardPhotoUpLoad photoup;
	
	@RequestMapping("/photo/photoList")
	public String photoList(Model model,HttpSession session,Like like,PhotoListmodel photolist,Scrap scrap) {
		
		String view = "";
		String page = "";

		
		Member_info member = (Member_info)session.getAttribute("user");
			List<PhotoListmodel> list = photoervice.photolistview(like,photolist,member);
			if(list!=null) {
				view = "home";
				page = "photo/photolist.jsp";
			
			if(member!=null) {
				
				 scrap.setMember_idx(member.getMember_idx());
			
				List<scrapFN> scrapNameList = scrap_service.folder(member.getMember_idx());
			       model.addAttribute("scrapNameList", scrapNameList);
			     
			     //스크랩 체크
			     
			     list= scrap_service.Listscrapck(list,scrap);

			}
			model.addAttribute("page",page);
			model.addAttribute("list",list);
			model.addAttribute("Alignment",photolist.getAlignment());	//1.최신순 2.인기순 ,3 좋아요순 1 ==default 값 
			model.addAttribute("room",photolist.getRoom()); //romm 0==default 값 모든 공간 
			model.addAttribute("space",photolist.getSpace());//space =="";
			model.addAttribute("member",member);
			
			}else {
				
				//에러페이지 내나 
			}

	
		return view;
	
	}
	
	
	
	@RequestMapping("/board/photolistlike")
	@ResponseBody
	public String listlikeajax(Like like, HttpSession session) {
		Member_info member = (Member_info) session.getAttribute("user");
		String ck = "n";

		like.setMember_idx(like.getMember_idx());
		if (member != null) {
			int member_idx = member.getMember_idx();

			like.setMember_idx(member_idx);

			/* board 와 member_idx 기준으로 조회하는 select 문 */
			Like likeck = listservice.likeck(like);

			if (likeck == null) {
				// 실행

				int result = listservice.listLikeup(like);

				if (result > 0) {
					// 성공
					int resultCnt = listservice.updateLikecntUP(like);

					if (resultCnt > 0) {

						ck = "y";

					} else {

						ck = "s";
					}

				} else {
					ck = "s";
				}
			} else {
				// 값이 있으면 삭제후 -1 감소 실행
				int resultcnt = listservice.deltelike(likeck);
				if (resultcnt > 0) {
					int result = listservice.udateLikecntDown(like);
					// 실패
					ck = "n";
					// 감소문 실행
					if (result > 0) {
						// 성공
					} else {
						// 실패
						ck = "s";
					}
				} else {
					ck = "s";
				}
				// 조회해서 값이 있으면 -1 감수 실행 없으면

			}

		} else {
			ck = "s";
		}

		return ck;
	}
	
	@RequestMapping(value = "photo/photofeed",method=RequestMethod.GET)
	public String feed(Model model) {
		String view ="";
		String page="";
		
		
		
		List<Board_Photo> photoList=photofeedservice.BoardPhotoList();
		if(photoList!=null) {
			view ="home";
			page="photo/photofeed.jsp";
			model.addAttribute("photoList",photoList);		
		}else {
			
			//에러 페이지 주세요 ! 
		}
		
		
		/*//글 그림 데이터 다 삭제 
		int allDeleteCnt=photodetailservice.AllDelete(board_idx);
		if(allDeleteCnt<0) {
			page = "photo/photoCommentFail.jsp";
			model.addAttribute("page", page);
		}
		*/
		model.addAttribute("page",page);
		
		return view;
	}



	@RequestMapping(value = "photo/photodetail",method = RequestMethod.GET)
	public String detail(@RequestParam(value = "del", defaultValue = "default") String del, Model model,
			HttpSession session, @RequestParam(value = "board_idx", defaultValue = "0") int board_idx, Board boardboard,
			Scrap scrap, Like like, Board_Photo photo) {

		System.out.println("뭐야!!!!!!!!!!!!!!!!!!!!" + board_idx);

		String view = "home";
		String page = "photo/photodetail.jsp";

		Member_info member = (Member_info) session.getAttribute("user");
		
		int board_cnt_view = 0;

		if (del.equals("default")) {
			photodetailservice.boardCntUpdateView(board_idx);
		}
		// 조회수 출력
		board_cnt_view = photodetailservice.boardCntView(board_idx);
		model.addAttribute("board_cnt_view", board_cnt_view);

		// 댓글수
		int commentCnt = photodetailservice.commentTotalCntView(board_idx);
		model.addAttribute("commentCnt", commentCnt);
		// 댓글 디비에 저장
		int commentUpdate = photodetailservice.commentTotalUpdate(board_idx);
		model.addAttribute("commentUpdate", commentUpdate);

		List<Join_BoardComment_MemberInfo> Commentlist = photodetailservice.ListselectCommentAll(board_idx);
		model.addAttribute("Commentlist", Commentlist);
		//String 형 변수에 담은거 다 고쳐라 
		
		//String 형 변수에 담은거 다 고쳐라 
		//String 형 변수에 담은거 다 고쳐라 
		//String 형 변수에 담은거 다 고쳐라 
		//String 형 변수에 담은거 다 고쳐라 
		//String 형 변수에 담은거 다 고쳐라 
		//String 형 변수에 담은거 다 고쳐라 
		//String 형 변수에 담은거 다 고쳐라 
		//String 형 변수에 담은거 다 고쳐라 
		//String 형 변수에 담은거 다 고쳐라 
		//String 형 변수에 담은거 다 고쳐라 
		//String 형 변수에 담은거 다 고쳐라 
		//String 형 변수에 담은거 다 고쳐라 
		//String 형 변수에 담은거 다 고쳐라 
		//String 형 변수에 담은거 다 고쳐라 
		
		// 사진
		String photoName = photodetailservice.photodetailView(board_idx);
		model.addAttribute("photoName", photoName);
		
		// 글제목내용
		Board board = photodetailservice.boardSelectView(board_idx);
		model.addAttribute("board", board);

		// board, memberinfo 조인
		Join_Board_MemberInfo boardMemberinfo = photodetailservice.selectJoin_Board_Member(board_idx);
		model.addAttribute("boardMemberinfo", boardMemberinfo);

		// 조회수 기준 인기사진 출력
		List<Join_board_boardphoto> popularPhotoList = photodetailservice.popluarphotoSelect();
		model.addAttribute("popularPhotoList", popularPhotoList);

		Board boardInfo = sblikeservice.selectBoardInfo(board_idx);
		model.addAttribute("boardInfo", boardInfo);

	
		
		if (member != null) {
			boardboard.setMember_idx(member.getMember_idx());
			// 스크랩 체크
			Scrap scrapck = scrap_service.scrapck(scrap);
			model.addAttribute("scrapck", scrapck);
			// 좋아요 체크
			Like likecheck = sblikeservice.likeck(like);
			model.addAttribute("likecheck", likecheck);
			// 스크랩 목록
			List<scrapFN> scrapNameList = scrap_service.folder(member.getMember_idx());
			model.addAttribute("scrapNameList", scrapNameList);
		}else {
			Scrap scrapck = null;
			model.addAttribute("scrapck", scrapck);
			// 좋아요 체크
			Like likecheck = null;
			model.addAttribute("likecheck", likecheck);
			// 스크랩 목록
			List<scrapFN> scrapNameList =null;
			model.addAttribute("scrapNameList", scrapNameList);
		}
		
		
		
		String tagckss = photodetailservice.tagcks(boardboard);
		if (tagckss != null) {
			// 태그 정보 저장
			// 수정가능
			model.addAttribute("tagckss", tagckss);

		} else {

			//태그정보 에러남 에러페이지 내나 
			
			
		}
		
		photo.setBoard_idx(board_idx);
		photo.setPhoto_name(photoName);

		List<Board_Photo> latelylist = (List<Board_Photo>) session.getAttribute("latelylist");
		//최근 사진 들어올시 session 추가 
		listservice.latestlist(session,latelylist,photoName,photo);
		
		
		model.addAttribute("page", page);
		model.addAttribute("member", member);
		return view;

	}

	// 댓글 쓰기 (insert)
	@RequestMapping(value = "photo/photodetail",method = RequestMethod.POST)
	public String detailComment(Model model, Board_Comment bc,
			@RequestParam("board_comment_contents") String board_comment_contents, HttpSession session,
			@RequestParam(value = "board_idx", defaultValue = "0") int board_idx) {
		String view = "home";
		Member_info member = (Member_info) session.getAttribute("user");
		int member_idx = member.getMember_idx();

		bc.setMember_idx(member_idx);
		bc.setBoard_idx(board_idx);
		bc.setBoard_comment_contents(board_comment_contents);

		int comment = photodetailservice.ListInsertComment(bc);
		String page = "photo/photodetail.jsp";
		model.addAttribute("page", page);
		// 실패하면
		if (comment < 0) {
			page = "photo/photoCommentFail.jsp";
			model.addAttribute("page", page);
		}
		List<Join_BoardComment_MemberInfo> Commentlist = photodetailservice.ListselectCommentAll(board_idx);
		model.addAttribute("Commentlist", Commentlist);

		// 댓글수
		int commentCnt = photodetailservice.commentTotalCntView(board_idx);
		model.addAttribute("commentCnt", commentCnt);
		// 댓글 디비에 저장
		int commentUpdate = photodetailservice.commentTotalUpdate(board_idx);
		model.addAttribute("commentUpdate", commentUpdate);

		// 조회수 출력
		int board_cnt_view = photodetailservice.boardCntView(board_idx);
		model.addAttribute("board_cnt_view", board_cnt_view);

		// 사진 출력
		String photoName = photodetailservice.photodetailView(board_idx);
		model.addAttribute("photoName", photoName);

		// 글 제목 내용
		Board board = photodetailservice.boardSelectView(board_idx);
		model.addAttribute("board", board);

		// board, memberinfo 조인
		Join_Board_MemberInfo boardMemberinfo = photodetailservice.selectJoin_Board_Member(board_idx);
		model.addAttribute("boardMemberinfo", boardMemberinfo);

		// 조회수 기준 인기사진 출력
		List<Join_board_boardphoto> popularPhotoList = photodetailservice.popluarphotoSelect();
		model.addAttribute("popularPhotoList", popularPhotoList);

		return view;

	}
	
	@RequestMapping("photo/photofeedAllDelete")
	public String feedAllDelete(@RequestParam(value = "board_idx") int board_idx) {
		int resultCnt = photodetailservice.AllDelete(board_idx);
		System.out.println("욕데게ㅔ게게리절트 !===>"+resultCnt);
		String page = "../";
		if (resultCnt > 0) {
			page="redirect:photoList?Alignment=board_idx&room=&space=";
		}else {
			
			//에러페이지 내나 
		}
		
		
		return page;
		
		
		
	}
	@RequestMapping(value = "photo/updatePhotodetail",method = RequestMethod.GET)
	public String UpdateDetail(Model model, @RequestParam(value = "board_idx", defaultValue = "0") int board_idx) {
		String view = "home";
		String page = "photo/updatePhotodetail.jsp";
		model.addAttribute("page", page);

		// 글 제목
		Board board = photodetailservice.boardSelectView(board_idx);
		model.addAttribute("board", board);

		// 사진
		String photoName = photodetailservice.photodetailView(board_idx);
		model.addAttribute("photoName", photoName);
		
	

		return view;

	}

	@RequestMapping(value = "photo/updatePhotodetail",method = RequestMethod.POST)
	public String UpdateDetailSend(HttpServletRequest request, HttpSession session, Model model,
			Board board,
			Board_Photo board_photo, Join_Board_Category_RoomNSpace joinBoardRoomNSpace)
			throws IllegalStateException, IOException {
		
		String page = "../";
		
		photoup.fileupload(request, session, board_photo);

		int result = photodetailupdateservice.AllPhotoDetailUpdate(board, board_photo, joinBoardRoomNSpace);
		System.out.println("RESULT값===>"+result);
		if (result > 0) {
			System.out.println("이것보세요~!!!!!!!!!!!!!!!=>"+board.getBoard_idx());
			page = "redirect:photodetail?board_idx="+board.getBoard_idx();
	
		}else {
			
			//에러페이지 주세요
		}

	

		return page;

	}
	@RequestMapping("photo/photoCommentDelete")
	public String CommentDelete(@RequestParam(value = "board_idx") int board_idx,
			@RequestParam(value = "board_comment_idx") int board_comment_idx) {

		int resultCnt = photodetailservice.ListdeleteComment(board_comment_idx);
		String del = "del_success";
		String page = "";
		if (resultCnt > 0) {
			page = "../";
			page = "redirect:photodetail?board_idx=" + board_idx + "&del=" + del;
		}else {
			//에러 페이지 내나 
		}
		return page;
	}
}
