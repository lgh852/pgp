package p.g.p.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import p.g.p.model.Notice;
import p.g.p.model.report;
import p.g.p.service.Mg_manage_service;

@Controller
public class Mg_manage_controller {

	@Autowired
	private Mg_manage_service service;
	
	@RequestMapping(value="/manager/noticedelete",method = RequestMethod.GET)
	public String noticeDelete(@RequestParam("notice_idx") int notice_idx) {
		
		int resultCnt = service.deleteNoticeList(notice_idx);
		
		if(resultCnt>0) {
			System.out.println("실행ㅇㅇㅇ");
		}else {
			System.out.println("망");
		}
		
		
	return "redirect:/manager/noticelist";
		
	}
	
	@RequestMapping(value="/manager/noticeupdate",method=RequestMethod.GET)
	public String noticeUpdateForm(@RequestParam("notice_idx") int notice_idx,Model model) {
		
		Notice notice = service.updateSelect(notice_idx);
		System.out.println("먹냐????");
		
		model.addAttribute("notice",notice);
		
		String view="home";
		String page="manager/noticeupdateform.jsp";
		
		model.addAttribute("page",page);
		
		return view;
		
	}
	
	@RequestMapping(value="/manager/noticeupdate",method=RequestMethod.POST)
	public String noticeUpdate(Notice notice,Model model,HttpServletRequest request) {
		
		System.out.println(notice);
		
		
		if(notice!=null) {
			
			int resultC = service.updateNoticeList(notice, request);
			
			if(resultC>0) {
				System.out.println("정상적으로 업데이트");
			}else {
				System.out.println("놉");
			}
		}
		
		return "redirect:/manager/noticelist";
	}
	
	@RequestMapping("/manager/reportview")
	public String reportView(Model model) {
		
		
	    List<report> report=service.selectReportList();
		
		model.addAttribute("report",report);
		
		String view="home";
		String page="manager/reportview.jsp";
		
		model.addAttribute("page", page);
		
		return view;
	}
	
	
	
	
	
}
