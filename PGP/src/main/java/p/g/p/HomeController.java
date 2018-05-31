package p.g.p;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import p.g.p.model.Board_Photo;
import p.g.p.service.MainPageService;

@Controller
public class HomeController {

	@Autowired
	MainPageService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model,HttpSession session) {
	
		String page ="member/main.jsp";
		String maxcntimgPhotoName = service.mainimg();
		
		List<Board_Photo> latelylist = (List<Board_Photo>)session.getAttribute("latelylist");
		if(latelylist!=null) {
			for(int i =0;i<latelylist.size();i++) {
		
				model.addAttribute("latelylist",latelylist);
			}
		}
		model.addAttribute("page",page);
		model.addAttribute("maxcntimgPhotoName",maxcntimgPhotoName);
	
		
		return "home";
	}
	
}
