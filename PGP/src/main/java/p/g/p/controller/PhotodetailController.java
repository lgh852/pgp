package p.g.p.controller;

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
import p.g.p.model.Join_Board_MemberInfo;
import p.g.p.model.Member_info;
import p.g.p.service.PhotodetailService;

@Controller
@RequestMapping(value = "photo/photodetail")
public class PhotodetailController {
	@Autowired
	PhotodetailService photodetailservice;

	@RequestMapping(method = RequestMethod.GET)
	public String detail(@RequestParam(value = "del", defaultValue = "default") String del, Model model,
			 HttpSession session,@RequestParam(value="board_idx",defaultValue="0")int board_idx) {
		String view = "home";
		String page = "photo/photodetail.jsp";
		
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
		
		//, Join_BoardComment_MemberInfo joinbc
		/*	joinbc.setMember_idx(member_idx);
		joinbc.setBoard_idx(board_idx);
		joinbc.setBoard_comment_contents(board_comment_contents);
		joinbc.setMember_id(member.getMember_id());*/

	
		int comment = photodetailservice.ListInsertComment(bc);
		String page = "photo/photodetail.jsp";
		model.addAttribute("page", page);
		// 실패하면
		if (comment < 0) {
			page = "photo/photoCommentFail.jsp";
			model.addAttribute("page", page);
		} else {

		}
		List<Join_BoardComment_MemberInfo> Commentlist = photodetailservice.ListselectCommentAll(board_idx);
		model.addAttribute("Commentlist", Commentlist);

		//댓글수 
		int commentCnt = photodetailservice.commentTotalCntView(board_idx);
		model.addAttribute("commentCnt", commentCnt);

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
		return view;

	}
}
