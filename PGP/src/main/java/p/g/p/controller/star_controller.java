package p.g.p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class star_controller {

	@RequestMapping("/star/sidebar")
	public String mypage(Model model) {
		
		String board_idx="15";
		String storyboard_idx="1";
		String member_idx="1";
		System.out.println();
		String view="home";
		String page ="star/sidebar.jsp";
		System.out.println(board_idx);
		System.out.println(storyboard_idx);
		System.out.println(member_idx);
		model.addAttribute("page",page);
		model.addAttribute("board_idx",board_idx);
		model.addAttribute("storyboard_idx",storyboard_idx);
		model.addAttribute("member_idx",member_idx);
		return view;
		
		
	}
	
}
