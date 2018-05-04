package p.g.p.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import p.g.p.model.Board;
import p.g.p.model.Join_board_boardphoto;
import p.g.p.service.Mp_myphoto_service;



@Controller
@RequestMapping("/mypage/mp_myphoto")
public class Mp_myphoto_contorller {
	
	@Autowired
	private Mp_myphoto_service service;

	@RequestMapping(method=RequestMethod.GET)
	public String mypageMyphoto(@RequestParam("member_id")String member_id,Model model) {
		
		List<Join_board_boardphoto> myphoto = service.Mp_MyphotoList(member_id);
		
		model.addAttribute("myphoto", myphoto);
		
		String page = "mypage/mp_myphoto.jsp";
		String view = "home";
		model.addAttribute("page", page);

		return view;
		
	
	}
	
}
