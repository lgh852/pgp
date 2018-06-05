package p.g.p.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import p.g.p.model.Board;
import p.g.p.model.Board_Photo;
import p.g.p.model.Join_board_boardphoto;
import p.g.p.model.Member_info;
import p.g.p.service.MemberService;

@Controller
public class Mp_main_controller {

	
	@Autowired
	MemberService service;
	
	@RequestMapping("/mypage/mp_main")
	public String mypage(HttpSession session, Model model,Board board) {
		
		String view = "home";
		
		String page = "mypage/mp_newmain.jsp";
		
		model.addAttribute("page",page);
		
		Member_info member = (Member_info)session.getAttribute("user");
		System.out.println(member);
		model.addAttribute("member",member);
		
		
		//사진 갯수 
		int photo_count = service.countPhoto(member.getMember_idx());
		model.addAttribute("photo_count", photo_count);
		
		String ck = "s";
		
		if (photo_count>0) {
			
			 ck="y";
			
		}else {
			
		     ck="n";	
		}
		model.addAttribute("ck",ck);
		
		//사진들 가져오쟈 
		List<Join_board_boardphoto> boardLatestPhoto = service.selectLatestPhoto(member.getMember_idx());
		model.addAttribute("boardLatestPhoto",boardLatestPhoto);
		
		//스크랩한 최근 사진 가져오쟈
		String scrapLatestPhoto = service.selectScrapLatestPhoto(member.getMember_idx());
		model.addAttribute("scrapLatestPhoto",scrapLatestPhoto);
		
		
		//좋아요한 최근 사진 가져오쟈
		String likeLatestPhoto = service.selectLikeLatestPhoto(member.getMember_idx());
		model.addAttribute("likeLatestPhoto", likeLatestPhoto);
		
		
		
		return view;
		
	}
	
	@RequestMapping("/mypage/mp_myLike")
	public String myLikePage(HttpSession session, Model model) {
		
		Member_info member = (Member_info)session.getAttribute("user");
		model.addAttribute("member",member);
		
		//좋아요 가져오쟈
		List<Join_board_boardphoto> likeList = service.selectLikeList(member.getMember_idx());
	    model.addAttribute("likeList", likeList);
	    
	    String view="home";
	    String page="mypage/mp_myLike.jsp";
	    
	    model.addAttribute("page", page);
		
		return view;
	}
	
	
	
	
	
	
}
