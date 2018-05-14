package p.g.p;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import p.g.p.service.MainPageService;

@Controller
public class HomeController {

	@Autowired
	MainPageService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
	
		String page ="member/main.jsp";
		String maxcntimgPhotoName = service.mainimg();
		
		
		model.addAttribute("page",page);
		model.addAttribute("maxcntimgPhotoName",maxcntimgPhotoName);
		System.out.println(maxcntimgPhotoName);
		System.out.println(maxcntimgPhotoName);
		System.out.println(maxcntimgPhotoName);
		System.out.println(maxcntimgPhotoName);
		System.out.println(maxcntimgPhotoName);
		System.out.println(maxcntimgPhotoName);
		
		
		return "home";
	}
	
}
