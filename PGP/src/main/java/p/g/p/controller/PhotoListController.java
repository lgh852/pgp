package p.g.p.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import p.g.p.model.Like;
import p.g.p.model.Member_info;
import p.g.p.model.PhotoListmodel;
import p.g.p.service.PhotoService;
@Controller
public class PhotoListController {
	@Autowired
	PhotoService service;

	@RequestMapping("/photo/photoList")
	public String photoList(Model model,HttpSession session,Like like) {
		
		String view = "home";
		String page = "photo/photolist.jsp";
		model.addAttribute("page",page);
		Member_info member = (Member_info)session.getAttribute("user");
		if(member!=null) {
			like.setMember_idx(member.getMember_idx());
			List<PhotoListmodel> list = service.photolistview(like);
		
		model.addAttribute("list",list);
		
		}
		return view;
	}
}
