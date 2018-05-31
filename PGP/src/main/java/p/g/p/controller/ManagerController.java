package p.g.p.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import p.g.p.model.Manager;
import p.g.p.model.Member_info;
import p.g.p.service.ManagerService;

@Controller
@RequestMapping(value="/manager/managerloginform")
public class ManagerController {
	
	@Autowired
	ManagerService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String loginform(Model model) {

		String page = "manager/managerloginform.jsp";
		String view = "home";
		model.addAttribute("page", page);

		return view;

	}

	@RequestMapping(method = RequestMethod.POST)
	public String login(@RequestParam("manager_id")String id,
			@RequestParam("manager_pw")String pw,Model model,Manager manager,HttpSession session) {
		
		String view ="home";
		manager = service.loginService(manager,id,pw);
		if(manager!=null) {
			//null아니면 성공
			session.setAttribute("manager",manager);
			session.setMaxInactiveInterval(60*60*60);
			
			model.addAttribute("msg","관리자 로그인 성공");			
		}else {

			model.addAttribute("msg","관리자 로그인 실패 ㅠㅠ");
		}
		
		
		return view;
	}
	

}
