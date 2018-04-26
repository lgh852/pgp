package p.g.p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WritingPhotoController {

	@RequestMapping(value = "/board/boardUpload",method = RequestMethod.GET)
	public String WritingPhotoForm(Model model) {
		String view = "home";
		String page ="board/boardUpload.jsp";
		
		
		model.addAttribute("page",page);
		
		return view;
	}
	@RequestMapping(value = "/board/inputText",method = RequestMethod.POST)
	public String bo(Model model) {
		String view = "home";
		
		
		
		return view;
	}
		
	
}
