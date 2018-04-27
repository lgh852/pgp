package p.g.p.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import p.g.p.model.Board_Comment;
import p.g.p.model.Join_BoardComment_MemberInfo;
import p.g.p.model.Member_info;
import p.g.p.service.PhotodetailService;

@Controller
@RequestMapping(value = "/photo/photodetail")
public class photodetailController {
	@Autowired
	PhotodetailService photodetailservice;

	@RequestMapping(method = RequestMethod.GET)
	public String detail(Model model) {

		/*
		 * String view = "home"; String page = "photo/photodetail.jsp";
		 * model.addAttribute("page",page); return view;
		 */
		String page = "photo/photodetail";
		model.addAttribute("page", page);

		List<Join_BoardComment_MemberInfo> Commentlist = photodetailservice.ListselectCommentAll();
		model.addAttribute("Commentlist", Commentlist);
		return page;
	}

	// 댓글 쓰기 (insert)
	@RequestMapping(method = RequestMethod.POST)
	public String detailComment(Model model, Board_Comment bc,
			@RequestParam("board_comment_contents") String board_comment_contents, Join_BoardComment_MemberInfo joinbc,
			HttpSession session) {
		String view = "home";
		Member_info member = (Member_info) session.getAttribute("user");
		int member_idx = member.getMember_idx();
		bc.setMember_idx(member_idx);
		bc.setBoard_idx(1);
		bc.setBoard_comment_contents(board_comment_contents);

		joinbc.setMember_idx(member_idx);
		joinbc.setBoard_idx(1);
		joinbc.setBoard_comment_contents(board_comment_contents);
		joinbc.setMember_id(member.getMember_id());

		String page = null;
		int comment = photodetailservice.ListInsertComment(bc);
		page = "photo/photodetail.jsp";
		model.addAttribute("page",page);
		// 실패하면
		if (comment < 0) {
			page = "photo/photoCommentFail.jsp";
			model.addAttribute("page",page);
		}else {
			
		}

		List<Join_BoardComment_MemberInfo> Commentlist = photodetailservice.ListselectCommentAll();
	
		model.addAttribute("Commentlist", Commentlist);
		
		return view;

	}
}
