package p.g.p.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import p.g.p.model.Board;
import p.g.p.model.Board_Comment;
import p.g.p.model.Board_Photo;
import p.g.p.model.Join_BoardComment_MemberInfo;
import p.g.p.model.Join_board_boardphoto;
import p.g.p.model.Like;
import p.g.p.model.Member_info;
import p.g.p.model.Scrap;
import p.g.p.model.scrapFN;
import p.g.p.service.PhotodetailService;
import p.g.p.service.Sb_like_service;
import p.g.p.service.Sb_scrap_service;

@Controller
@RequestMapping(value = "photo/photodetail")
public class PhotodetailController {
	@Autowired
	PhotodetailService photodetailservice;

	 @Autowired
	   Sb_scrap_service service2;
	   
	   @Autowired
	   Sb_like_service service;

	
	@RequestMapping(method = RequestMethod.GET)
	public String detail(@RequestParam(value = "del", defaultValue = "default") String del, Model model,
	         HttpSession session, @RequestParam(value = "board_idx", defaultValue = "0") int board_idx,Board boardboard,Scrap scrap,Like like,	Board_Photo photo){

		
		System.out.println("뭐야!!!!!!!!!!!!!!!!!!!!"+board_idx);

		String view = "home";
		String page = "photo/photodetail.jsp";
		Member_info member = (Member_info)session.getAttribute("user");
	     model.addAttribute("member", member);
	     scrap.setMember_idx(member.getMember_idx());
	     like.setMember_idx(member.getMember_idx());
		
		model.addAttribute("page", page);
		int board_cnt_view = 0;
		 
		if (del.equals("default")) {
			photodetailservice.boardCntUpdateView(board_idx);
		}
		//조회수 출력
		board_cnt_view = photodetailservice.boardCntView(board_idx);
		model.addAttribute("board_cnt_view", board_cnt_view);

		//댓글수
		int commentCnt = photodetailservice.commentTotalCntView(board_idx);
		model.addAttribute("commentCnt", commentCnt);
		//댓글 디비에 저장
		int commentUpdate=photodetailservice.commentTotalUpdate(board_idx);
		model.addAttribute("commentUpdate",commentUpdate);

		List<Join_BoardComment_MemberInfo> Commentlist = photodetailservice.ListselectCommentAll(board_idx);
		model.addAttribute("Commentlist", Commentlist);

		//사진
		String photoName=photodetailservice.photodetailView(board_idx);
		model.addAttribute("photoName",photoName);
		
		//글제목내용
		Board board=photodetailservice.boardSelectView(board_idx);
		model.addAttribute("boardContents",board.getBoard_contents());
		model.addAttribute("boardTitle",board.getBoard_title());
		model.addAttribute("memberIdx",board.getMember_idx());
		model.addAttribute("boardIdx",board.getBoard_idx());
		
		//조회수 기준 인기사진 출력 
		List<Join_board_boardphoto> popularPhotoList=photodetailservice.popluarphotoSelect();
		model.addAttribute("popularPhotoList",popularPhotoList);
		

	      Board boardInfo = service.selectBoardInfo(board_idx);
	      model.addAttribute("boardInfo", boardInfo);
	      
	      
	      //스크랩 목록
	      List<scrapFN> scrapNameList = service2.folder(member.getMember_idx());
	     model.addAttribute("scrapNameList", scrapNameList);
	     //스크랩 체크
	      Scrap scrapck = service2.scrapck(scrap);
	     model.addAttribute("scrapck", scrapck);
	     //좋아요 체크
	     Like likecheck = service.likeck(like);
	     model.addAttribute("likecheck", likecheck);
	    
		
		photo.setBoard_idx(board_idx);
		photo.setPhoto_name(photoName);
		
		int sessionck=0;
		List<Board_Photo> latelylist = (List<Board_Photo>) session.getAttribute("latelylist");
		if (latelylist != null) {
			System.out.println(latelylist.size());
			System.out.println(latelylist.size());
			System.out.println(latelylist.size());
			System.out.println(latelylist.size());
			System.out.println(latelylist.size());
			
			for(int i=0;i<latelylist.size();i++) {
				String listck = latelylist.get(i).getPhoto_name();
					System.out.println("현재 비교할 값이지롱"+listck);
					if(listck!=null&&photoName.equals(listck)) {
							//값이 있고 기존리스트에 동일한 값이 있으면 생성안함 
						sessionck =+1;
						}else{
							
						
						}
					
				}
			if(sessionck==0) {
				
				latelylist.add(latelylist.size(),photo);
			
			}
				session.setAttribute("latelylist", latelylist);
				
		}

		else {
			latelylist = new ArrayList<Board_Photo>();
			latelylist.add(0,photo);
			session.setAttribute("latelylist", latelylist);
		}
		

		return view;
	
	}

	// 댓글 쓰기 (insert)
	@RequestMapping(method = RequestMethod.POST)
	public String detailComment(Model model, Board_Comment bc,
			@RequestParam("board_comment_contents") String board_comment_contents,
			HttpSession session,@RequestParam(value="board_idx",defaultValue="0")int board_idx) {
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

		//댓글수 
		int commentCnt = photodetailservice.commentTotalCntView(board_idx);
		model.addAttribute("commentCnt", commentCnt);
		//댓글 디비에 저장
		int commentUpdate=photodetailservice.commentTotalUpdate(board_idx);
		model.addAttribute("commentUpdate",commentUpdate);

		//조회수 출력
		int board_cnt_view = photodetailservice.boardCntView(board_idx);
		model.addAttribute("board_cnt_view", board_cnt_view);

		//사진 출력
		String photoName=photodetailservice.photodetailView(board_idx);
		model.addAttribute("photoName",photoName);
		
		
		//글 제목 내용 
		Board board=photodetailservice.boardSelectView(board_idx);
		model.addAttribute("boardContents",board.getBoard_contents());
		model.addAttribute("boardTitle",board.getBoard_title());
		model.addAttribute("memberIdx",board.getMember_idx());
		model.addAttribute("boardIdx",board.getBoard_idx());
		//조회수 기준 인기사진 출력 
		List<Join_board_boardphoto> popularPhotoList=photodetailservice.popluarphotoSelect();
		model.addAttribute("popularPhotoList",popularPhotoList);
		
		return view;

	}
}
