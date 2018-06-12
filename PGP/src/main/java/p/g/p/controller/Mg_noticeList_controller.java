package p.g.p.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import p.g.p.dao.PageMakerDao;
import p.g.p.model.Notice;
import p.g.p.model.PageMaker;
import p.g.p.service.Mg_noticeList_service;

@Controller
public class Mg_noticeList_controller {
	
	@Autowired
	Mg_noticeList_service service;
	
	
	@RequestMapping(value="/manager/noticelist")
	public String noticeList(Model model,HttpServletRequest request) {
	
	
		PageMaker pagemaker = new PageMaker();
		
		String pagenum = request.getParameter("pagenum");
		String contentnum = request.getParameter("contentnum");	
		
	    int cpagenum = Integer.parseInt(pagenum);
		int ccontentnum=Integer.parseInt(contentnum);
		
		//전체 게시물 갯수
		pagemaker.setTotalcount(service.noticetestcount());
		
		//쿼리에서 첫 페이지 0이라 페이지에서 -1해줘야함
		pagemaker.setPagenum(cpagenum-1);
		
	    //한 페이지에 몇개씩 게시글을 보여줄지 지정
		pagemaker.setContentnum(ccontentnum);
		
		//현재 페이지 블록의 몇번인지 현재 페이지 번호를 통해서 
		pagemaker.setCurrentblock(cpagenum);
		
	   
		
		
		//마지막 블록 번호를 전체 게시글 수를 통해 
		pagemaker.setLastblock(pagemaker.getTotalcount());
		
		//쿼리에 들어가는 페이지 시작 글 idx 
		pagemaker.setPageChecknum(pagemaker.getPagenum());
		
		//화살표
		pagemaker.prevnext(cpagenum);
		
		pagemaker.setStartPage(pagemaker.getCurrentblock());
		
	    pagemaker.setEndPage(pagemaker.getLastblock(),pagemaker.getCurrentblock());
		
		
		List<Notice> notices = service.noticeList(pagemaker);
		
		
		model.addAttribute("notices", notices);
		model.addAttribute("pagenum", pagemaker);
		
		String page = "manager/noticelist.jsp";
		String view = "home";
		model.addAttribute("page", page);

		return view;
	}
	

}
