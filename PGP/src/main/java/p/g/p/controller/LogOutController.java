package p.g.p.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import p.g.p.model.Manager;
import p.g.p.model.Member_info;

@Controller
public class LogOutController {

	
	@RequestMapping("/member/logout")
	public String logout(HttpSession session) {
		
		Member_info member = (Member_info) session.getAttribute("user");

		Manager manager = (Manager) session.getAttribute("manager");
		
		

		String check="";
		//유저 로그인 정보가 있을경우 
		  if(session!=null) {
	           
	         
		if(member!=null) {
			 session.invalidate();
			 check = "U";
		}
		//관리자 로그인 정보가 있을경우 
		if(manager!=null) {
			 session.invalidate();
			 check = "u";
		}
		  }
		
		return "home";
		
	}
}
