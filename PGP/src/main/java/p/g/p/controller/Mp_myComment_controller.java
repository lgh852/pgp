package p.g.p.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import p.g.p.model.Board_Comment;
import p.g.p.service.Mp_myComment_service;

@Controller
public class Mp_myComment_controller {
	
	@Autowired
	Mp_myComment_service service;
	
	@RequestMapping(value="/mypage/mp_myComment",method=RequestMethod.GET)
		public String myComment(@RequestParam("member_id")String member_id,Model model) {
			
		List<Board_Comment> myComment = service.Mp_myCommentList(member_id);
		
		model.addAttribute("myComment", myComment);
		
		String page= "mypage/mp_myComment.jsp";
		
		String view = "home";
		
		model.addAttribute("page",page);
		
		
		
		return view;
		
		
			
		
	}
		
	

}
