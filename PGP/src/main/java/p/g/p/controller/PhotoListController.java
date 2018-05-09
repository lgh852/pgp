package p.g.p.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import p.g.p.model.PhotoListmodel;
import p.g.p.service.PhotoService;
@Controller
public class PhotoListController {
	@Autowired
	PhotoService service;

	@RequestMapping("/photo/photoList")
	public String photoList(Model model) {
		
		String view = "home";
		String page = "photo/photolist.jsp";
		model.addAttribute("page",page);
		
		List<PhotoListmodel> list = service.photolistview();
		model.addAttribute("list",list);
		return view;
	}
}
