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
	public String photoList(Model model,HttpSession session,Like like,PhotoListmodel photolist) {
		
		String view = "home";
		String page = "photo/photolist.jsp";
		model.addAttribute("page",page);
		Member_info member = (Member_info)session.getAttribute("user");
		//1번 
			
			//Like 체크 를 위해 
			
		
			
			System.out.println(photolist);
			
			
			
			List<PhotoListmodel> list = service.photolistview(like,photolist,member);

			
		model.addAttribute("list",list);
		model.addAttribute("Alignment",photolist.getAlignment());	//1.최신순 2.인기순 ,3 좋아요순 1 ==default 값 
		model.addAttribute("room",photolist.getRoom()); //romm 0==default 값 모든 공간 
		model.addAttribute("space",photolist.getSpace());//space =="";
		model.addAttribute("member",member);
		

		
	
		return view;
	
	}
}
