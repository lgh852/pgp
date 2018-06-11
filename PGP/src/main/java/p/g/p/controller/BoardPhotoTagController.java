package p.g.p.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import p.g.p.model.Board_Photo;
import p.g.p.model.Url_Tag;
import p.g.p.service.BoardService;
import p.g.p.service.PhotodetailService;

@Controller

public class BoardPhotoTagController {
	@Autowired
	BoardService service;
	@Autowired
	private PhotodetailService photodetailservice;
	
	@RequestMapping("/board/boardPhtoTagForm")
	public String BoardphotoTagForm(Model model,@RequestParam("board_idx")String board_idx) {
		
		String view = "home";
		String page ="";
		Board_Photo photo = service.phototagselect(board_idx);	
		System.out.println(photo);
		
		if(photo !=null) {
			page = "board/boardPhotoTagForm.jsp";
			int baord_idxs = Integer.parseInt(board_idx);
		    List<Url_Tag> urlList = photodetailservice.selectUrl(baord_idxs);
			System.out.println("adasdasdasd"+urlList); 
			System.out.println("adasdasdasd"+urlList); 
			System.out.println("adasdasdasd"+urlList); 
			System.out.println("adasdasdasd"+urlList); 
			System.out.println("adasdasdasd"+urlList); 
			
		    model.addAttribute("urlList",urlList);
			model.addAttribute("page",page);
			model.addAttribute("photo",photo);
			model.addAttribute("board_idx",board_idx);
			
		}else {
			System.out.println("2번");
			System.out.println("2번");
			System.out.println("2번");
			System.out.println("2번");
			System.out.println("2번");
			System.out.println("2번");
			System.out.println("2번");
			model.addAttribute("page",page);
			model.addAttribute("photo",photo);
		}
		
		return view;
	}
	

	
}
