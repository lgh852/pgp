package p.g.p.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import p.g.p.model.Faq;
import p.g.p.model.Manager;
import p.g.p.model.Member_info;
import p.g.p.model.Notice;
import p.g.p.model.PageMaker;
import p.g.p.model.report;
import p.g.p.service.ManagerService;

@Controller
public class ManagerController {

	@Autowired
	ManagerService mangerservice;

	// 매니져 로그인
	@RequestMapping(value = "/manager/managerloginform", method = RequestMethod.GET)
	public String loginform(Model model) {

		String page = "manager/managerloginform.jsp";
		String view = "home";
		model.addAttribute("page", page);

		return view;

	}

	@RequestMapping(value = "/manager/managerloginform", method = RequestMethod.POST)
	public String login(@RequestParam("manager_id") String id, @RequestParam("manager_pw") String pw, Model model,
			Manager manager, HttpSession session) {

		String view = "home";
		manager = mangerservice.loginService(manager, id, pw);
		if (manager != null) {

			// null아니면 성공
			session.setAttribute("manager", manager);
			session.setMaxInactiveInterval(60 * 60 * 60);
			model.addAttribute("msg", "관리자 로그인 성공");

		} else {
			model.addAttribute("msg", "관리자 로그인 실패 ㅠㅠ");
			// 에러페이지 나누셈
		}
		return view;
	}

	@RequestMapping(value = "/manager/main")
	public String mgMainPage(Model model) {

		String page = "manager/main.jsp";
		String view = "home";
		model.addAttribute("page", page);

		return view;
	}

	/////////////////////////////////////////////////////////////////////////// FAQ
	@RequestMapping(value = "/manager/faqlist")
	public String faqList(Model model, HttpSession session,HttpServletRequest request) {

		
		

		PageMaker pagemaker = new PageMaker();
		
		String pagenum = request.getParameter("pagenum");
		String contentnum = request.getParameter("contentnum");	
		
	    int cpagenum = Integer.parseInt(pagenum);
		int ccontentnum=Integer.parseInt(contentnum);
		
		//전체 게시물 갯수
		pagemaker.setTotalcount(mangerservice.faqtestcount());
		
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
		
		
	    List<Faq> faq = mangerservice.faqList(pagemaker);
		
	    String page="";
	    String view="";
		
		if (faq != null) {
			model.addAttribute("faq", faq);
			model.addAttribute("pagenum", pagemaker);
			 page = "manager/faqlist.jsp";
			 view = "home";
		} else {

			// 에러페이지
         }

		model.addAttribute("page", page);

		return view;
	}

	@RequestMapping(value = "/manager/faqinsert", method = RequestMethod.GET)
	public String faqInsertForm(Model model) {

		String page = "manager/faqinsertform.jsp";
		String view = "home";
		model.addAttribute("page", page);
		return view;
	}

	@RequestMapping(value = "/manager/faqinsert", method = RequestMethod.POST)
	public String faqInsert(Faq faq, Model model, HttpSession session) {

		Manager manager = (Manager) session.getAttribute("manager");
		String view = "";
		if (manager != null) {

			faq.setManager_idx(manager.getManager_idx());

			int resultCnt = mangerservice.faqInsert(faq);

			if (resultCnt > 0) {
				view = "redirect:/manager/faqlist";
			} else {
				// 에러페이지 내나
			}
		} else {
			// 에러페이지 내나
		}

		return view;
	}

	
	@RequestMapping(value = "/manager/faqdelete", method = RequestMethod.GET)
	public String faqDelete(@RequestParam("faq_idx") int faq_idx) {
		String view = "";
		
		if (faq_idx >0 ) {
			int result = mangerservice.deleteFaqList(faq_idx);
            
			if (result > 0) {
				view = "redirect:/manager/faqlist";
				
			} else {
                     //에러페이지
			}
		} else {
			// 실패 에러페이지 내나
		}

		return view;

	}

	@RequestMapping(value = "/manager/faqupdate", method = RequestMethod.GET)
	public String FaqUpdateForm(@RequestParam("faq_idx") int faq_idx, Model model) {
		String view = "";
		String page = "";
		Faq faq = mangerservice.updateSelectFaq(faq_idx);
		if (faq != null) {
			view = "home";
			page = "manager/faqupdateform.jsp";
		} else {

			// 에러페이지 내나
		}

		model.addAttribute("faq", faq);
		model.addAttribute("page", page);

		return view;
	}

	@RequestMapping(value = "/manager/faqupdate", method = RequestMethod.POST)
	public String FaqUpdate(Faq faq, Model model, HttpServletRequest request, HttpSession session) {

		Manager manager = (Manager) session.getAttribute("manager");
		String page = "";
		if (manager != null) {
			faq.setManager_idx(manager.getManager_idx());
			page = "redirect:/manager/faqlist";
			if (faq != null) {
				int r = mangerservice.updateFaqList(faq, request);

				if (r > 0) {
                  } else {
                             //서비스 실행 안되는 에러
                  }
			} else {
                            //FAQ정보 없는 에러
               }
		} else {
			// 매니저 없는 에러페이 내나

		}

		return page;
	}
	
	//////////////////////////////////////////////////////////////////////////////////Notice
	
	@RequestMapping(value="/manager/noticedelete",method = RequestMethod.GET)
	public String noticeDelete(@RequestParam("notice_idx") int notice_idx) {
		
		int resultCnt = mangerservice.deleteNoticeList(notice_idx);
		
		if(resultCnt>0) {
			
		}else {
			//실행 에러페이지
		}
		
		return "redirect:/manager/noticelist";
		
	}
	
	@RequestMapping(value="/manager/noticeupdate",method=RequestMethod.GET)
	public String noticeUpdateForm(@RequestParam("notice_idx") int notice_idx,Model model) {
		
		Notice notice = mangerservice.updateSelect(notice_idx);
		
		model.addAttribute("notice",notice);
		
		String view="home";
		String page="manager/noticeupdateform.jsp";
		
		model.addAttribute("page",page);
		
		return view;
		
	}
	
	@RequestMapping(value="/manager/noticeupdate",method=RequestMethod.POST)
	public String noticeUpdate(Notice notice,Model model,HttpServletRequest request) {
		
		if(notice!=null) {
			
			int resultC = mangerservice.updateNoticeList(notice, request);
			
			if(resultC>0) {
				
			}else {
				// 실행 에러페이지 
			}
		}
		
		return "redirect:/manager/noticelist";
	}
	

	@RequestMapping(value="/manager/noticeinsert",method=RequestMethod.GET)
	public String noticeInsertForm(Model model) {
		
		String page = "manager/noticeinsertform.jsp";
		String view = "home";
		model.addAttribute("page", page);
		return view;
	}
	
	@RequestMapping(value="/manager/noticeinsert",method=RequestMethod.POST)
	public String noticeInsert(Notice notice,Model model,HttpSession session) {
	
		//requestparam으로 manager안가져와도 된다.
		//jsp에서 hidden으로 넘겨주지 않아도 이렇게 해주면 된다.
		Manager manager =(Manager) session.getAttribute("manager");
		
		notice.setManager_idx(manager.getManager_idx());
		
		int resultCnt = mangerservice.noticeInsert(notice);
		
	     if(resultCnt==-1) {
			
			//실행 에러페이지
			
         }else if(resultCnt>0) {
			
		
         }
	
          return "redirect:/manager/noticelist";
		
		}
	
	
	@RequestMapping(value="/manager/noticelist")
	public String noticeList(Model model,HttpServletRequest request) {
	
	
		PageMaker pagemaker = new PageMaker();
		
		String pagenum = request.getParameter("pagenum");
		String contentnum = request.getParameter("contentnum");	
		
	    int cpagenum = Integer.parseInt(pagenum);
		int ccontentnum=Integer.parseInt(contentnum);
		
		//전체 게시물 갯수
		pagemaker.setTotalcount(mangerservice.noticetestcount());
		
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
		
		
		List<Notice> notices = mangerservice.noticeList(pagemaker);
		
		
		model.addAttribute("notices", notices);
		model.addAttribute("pagenum", pagemaker);
		
		String page = "manager/noticelist.jsp";
		String view = "home";
		model.addAttribute("page", page);

		return view;
	}
	
	
	
	//////////////////////////////////////////////////////////////////////////////////신고
	
	@RequestMapping("/manager/reportview")
	public String reportView(Model model) {
		
		
	    List<report> report=mangerservice.selectReportList();
		
		model.addAttribute("report",report);
		
		String view="home";
		String page="manager/reportview.jsp";
		
		model.addAttribute("page", page);
		
		return view;
	}
	

}
