package p.g.p.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import p.g.p.model.Like;
import p.g.p.model.Member_info;
import p.g.p.model.PhotoListmodel;
import p.g.p.service.BoardService;

@Controller
public class BoardSearchController {

	@Autowired
	BoardService service;

	@RequestMapping(value = "/board/boardserach", method = RequestMethod.POST)
	public String boardserch(Model model, PhotoListmodel photoListmodel, Like like, HttpSession session) {

		String page = "board/boardserach.jsp";

		String ck = photoListmodel.getSearch();
		if (ck != null) {

			Member_info member = (Member_info) session.getAttribute("user");
			like.setMember_idx(member.getMember_idx());	
			List<PhotoListmodel> list = service.search(like, photoListmodel);
			model.addAttribute("list", list);

			model.addAttribute("page", page);
			String search = photoListmodel.getSearch();
			String choice = photoListmodel.getChoice();
			String Alignment = photoListmodel.getAlignment();
			model.addAttribute("search", search);
			model.addAttribute("choice", choice);
			model.addAttribute("Alignment", Alignment);

		} else {

		}

		return "home";
	}

	@RequestMapping(value = "/board/boardserach", method = RequestMethod.GET)
	public String boardserchAlignment(Model model, PhotoListmodel photoListmodel, Like like, HttpSession session) {
		String search = photoListmodel.getSearch();
		String choice = photoListmodel.getChoice();
		String room = photoListmodel.getRoom();
		String space = photoListmodel.getSpace();
		String Alignment = photoListmodel.getAlignment();
	
		model.addAttribute("search", search);
		model.addAttribute("choice", choice);
		model.addAttribute("Alignment", Alignment);
		model.addAttribute("room", room);
		model.addAttribute("Alignment", Alignment);
		model.addAttribute("space", space);
		String page = "board/boardserach.jsp";
		String ck = photoListmodel.getSearch();
		Member_info member = (Member_info) session.getAttribute("user");
		like.setMember_idx(member.getMember_idx());

		if (ck != null) {
			List<PhotoListmodel> list = service.search(like, photoListmodel);
			model.addAttribute("list", list);
			model.addAttribute("page", page);
		}

		return "home";

	}

}
