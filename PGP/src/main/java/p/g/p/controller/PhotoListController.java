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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import p.g.p.model.Board;
import p.g.p.model.Board_Comment;
import p.g.p.model.Board_Photo;
import p.g.p.model.Faq;
import p.g.p.model.Join_BoardComment_MemberInfo;
import p.g.p.model.Join_Board_Category_RoomNSpace;
import p.g.p.model.Join_Board_MemberInfo;
import p.g.p.model.Join_board_boardphoto;
import p.g.p.model.Like;
import p.g.p.model.Member_info;
import p.g.p.model.PageMaker;
import p.g.p.model.PhotoListmodel;
import p.g.p.model.Scrap;
import p.g.p.model.Url_Tag;
import p.g.p.model.report;
import p.g.p.model.scrapFN;
import p.g.p.service.BoardPhotoUpLoad;
import p.g.p.service.PhotoService;
import p.g.p.service.PhotodetailService;


import p.g.p.service.SidebarSerivce;
@Controller
public class PhotoListController {
	@Autowired
	private PhotoService photoervice;

	@Autowired
	private SidebarSerivce sidebarservice;
	
	@Autowired
	private PhotodetailService photodetailservice;

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
			
				List<scrapFN> scrapNameList = sidebarservice.folder(member.getMember_idx());
			       model.addAttribute("scrapNameList", scrapNameList);
			     
			     //스크랩 체크
			     
			     list= sidebarservice.Listscrapck(list,scrap);

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
			Like likeck = photoervice.likeck(like);

			if (likeck == null) {
				// 실행

				int result = photoervice.listLikeup(like);

				if (result > 0) {
					// 성공
					int resultCnt = photoervice.updateLikecntUP(like);

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
				int resultcnt = photoervice.deltelike(likeck);
				if (resultcnt > 0) {
					int result = photoervice.udateLikecntDown(like);
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
		
		
		
		List<Board_Photo> photoList=photodetailservice.BoardPhotoList();
		if(photoList!=null) {
			view ="home";
			page="photo/photofeed.jsp";
			model.addAttribute("photoList",photoList);		
		}else {
			
			//에러 페이지 주세요 ! 
		}
		
		
		model.addAttribute("page",page);
		
		return view;
	}



	@RequestMapping(value = "photo/photodetail",method = RequestMethod.GET)
	public String detail(@RequestParam(value = "del", defaultValue = "default") String del, Model model,
			HttpSession session, @RequestParam(value = "board_idx", defaultValue = "0") int board_idx, Board boardboard,
			Scrap scrap, Like like, Board_Photo photo,HttpServletRequest request) {

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
		
		/////////////////////////////////////댓글 페이징 처리 해보쟈 
		
		
        PageMaker pagemaker = new PageMaker();
		
		String pagenum = request.getParameter("pagenum");
		if(pagenum==null) {
			pagenum = "1";
			
		}
		
		String contentnum = request.getParameter("contentnum");	
		if(contentnum==null) {
			contentnum ="5";
			
		}
	    int ccpagenum =Integer.parseInt(pagenum);
		int cccontentnum=Integer.parseInt(contentnum);
		
		//전체 게시물 갯수
		pagemaker.setTotalcount(commentCnt);
		
		//쿼리에서 첫 페이지 0이라 페이지에서 -1해줘야함
		pagemaker.setPagenum(ccpagenum-1);
		
	    //한 페이지에 몇개씩 게시글을 보여줄지 지정
		pagemaker.setContentnum(cccontentnum);
		
		//현재 페이지 블록의 몇번인지 현재 페이지 번호를 통해서 
		pagemaker.setCurrentblock(ccpagenum);
		
	   
		
		
		//마지막 블록 번호를 전체 게시글 수를 통해 
		pagemaker.setLastblock(pagemaker.getTotalcount());
		
		//쿼리에 들어가는 페이지 시작 글 idx 
		pagemaker.setPageChecknum(pagemaker.getPagenum());
		
		//화살표
		pagemaker.prevnext(ccpagenum);
		
		pagemaker.setStartPage(pagemaker.getCurrentblock());
		
	    pagemaker.setEndPage(pagemaker.getLastblock(),pagemaker.getCurrentblock());
	    
	    pagemaker.setBoard_idx(board_idx);
		
		
	    List<Join_BoardComment_MemberInfo> Commentlist = photodetailservice.selectCommentList(pagemaker);
		model.addAttribute("Commentlist", Commentlist);
		model.addAttribute("pagenum", pagemaker);	
		
		
		System.out.println("왜 안나올까"+Commentlist);

		/*List<Join_BoardComment_MemberInfo> Commentlist = photodetailservice.ListselectCommentAll(board_idx);
		model.addAttribute("Commentlist", Commentlist);*/
		
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

		Board boardInfo = sidebarservice.selectBoardInfo(board_idx);
		model.addAttribute("boardInfo", boardInfo);

	
		
		if (member != null) {
			boardboard.setMember_idx(member.getMember_idx());
			// 스크랩 체크
			Scrap scrapck = sidebarservice.scrapck(scrap);
			model.addAttribute("scrapck", scrapck);
			// 좋아요 체크
			Like likecheck = sidebarservice.likeck(like);
			model.addAttribute("likecheck", likecheck);
			// 스크랩 목록
			List<scrapFN> scrapNameList = sidebarservice.folder(member.getMember_idx());
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
		// url 태그
	    List<Url_Tag> urlList = photodetailservice.selectUrl(board_idx);
	   
	    model.addAttribute("urlList",urlList);
		photo.setBoard_idx(board_idx);
		photo.setPhoto_name(photoName);

		List<Board_Photo> latelylist = (List<Board_Photo>) session.getAttribute("latelylist");
		//최근 사진 들어올시 session 추가 
		photoervice.latestlist(session,latelylist,photoName,photo);
		
		
		model.addAttribute("page", page);
		model.addAttribute("member", member);
		return view;

	}

	
	@RequestMapping("/photo/comment")
	@ResponseBody
	public String commentinset(Board_Comment board_comment) {
		System.out.println(board_comment);
		int result = photodetailservice.ListInsertComment(board_comment);

		String idx = "";
		if(result>0) {
						
			idx = String.valueOf(board_comment.getMember_idx());
			
			}else {
				idx = "";
			}
		
		
		return idx;
	}
	@RequestMapping("photo/re_commentInsert")
	@ResponseBody
	public String re_commentInsert(Board_Comment board_comment) {
	
		
		System.out.println("대댓글 : " + board_comment);
		
		photodetailservice.re_repleInsert(board_comment);

		return "cody/repleOk";
		
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

		int result = photodetailservice.AllPhotoDetailUpdate(board, board_photo, joinBoardRoomNSpace);
		
		if (result > 0) {
			
			page = "redirect:photodetail?board_idx="+board.getBoard_idx();
	
		}else {
			
			//에러페이지 주세요
		}

	

		return page;

	}
	
	
	@RequestMapping("photo/photoCommentDelete")
	@ResponseBody
	public String CommentDelete(Board_Comment comment) {
	
		
		List<Board_Comment> reple = photodetailservice.childReple(comment);
		
		String ck = "";
		if (reple.size()== 0) {
			
			photodetailservice.ListdeleteComment(comment.getBoard_comment_idx());
			
			ck = "y";
		} else {

		    comment.setBoard_comment_contents("댓글이 삭제되었습니다.");
			
			photodetailservice.commentUpdate(comment);
		
			
			ck = "n";
		}
			return ck;
	}
}
