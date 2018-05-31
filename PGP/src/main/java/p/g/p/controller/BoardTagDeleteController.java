package p.g.p.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import p.g.p.model.Url_Tag;
import p.g.p.service.BoardService;

@Controller
public class BoardTagDeleteController {
	
	@Autowired
	BoardService service;
	
	@RequestMapping("/board/tagdelete")
	@ResponseBody
	public String tagdelete(Url_Tag tag) {
		
		String check = service.deletetag(tag);
		
		
		
		return check;
	}
}
