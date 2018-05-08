package p.g.p.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import p.g.p.model.Url_Tag;
import p.g.p.service.BoardService;

@Controller
public class BoardTagInfoController {
	@Autowired
	BoardService service;
		
	@RequestMapping("/board/taginfo")
	@ResponseBody
	public String taginfo(Url_Tag tag) {
			System.out.println(tag);
			System.out.println(tag);
			System.out.println(tag);
			System.out.println(tag);
			System.out.println(tag);
			System.out.println(tag);
			System.out.println(tag);
			System.out.println(tag);
			System.out.println(tag);
			System.out.println(tag);
			
		String url_tag = service.selectTagInfo(tag);
		System.out.println(url_tag);
		System.out.println(url_tag);
		System.out.println(url_tag);
		System.out.println(url_tag);
		System.out.println(url_tag);
		System.out.println(url_tag);
		System.out.println(url_tag);
		System.out.println(url_tag);
		System.out.println(url_tag);
		
		
		
		return url_tag;
	}
}
