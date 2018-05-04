package p.g.p.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import p.g.p.model.Board_Photo;
import p.g.p.service.BoardService;

@Controller

public class BoardPhotoTagController {
	@Autowired
	BoardService service;
	@RequestMapping("/board/boardPhtoTagForm")
	public String BoardphotoTagForm(Model model,@RequestParam("board_idx")String board_idx) {

		
		String view = "home";
		String page ="";
		Board_Photo photo = service.phototagselect(board_idx);		
		if(photo !=null) {
			page = "board/boardPhotoTagForm.jsp";
			model.addAttribute("page",page);
			model.addAttribute("photo",photo);
		}else {
			model.addAttribute("page",page);
			model.addAttribute("photo",photo);
		}
		
		return view;
	}
	

	
}
