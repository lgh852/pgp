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
import p.g.p.service.Mg_faq_service;
import p.g.p.service.Mg_manage_service;

@Controller
public class Mg_main_controller {

	@Autowired
	private Mg_manage_service service;

	@Autowired
	private Mg_faq_service faq_service;

	@RequestMapping(value = "/manager/main")
	public String mgMainPage(Model model) {

		String page = "manager/main.jsp";
		String view = "home";
		model.addAttribute("page", page);

		return view;
	}

	
	//////////////////////////////////////////////////faq
	@RequestMapping(value = "/manager/faqlist")
	public String faqList(Model model, HttpSession session) {

		List<Faq> faq = faq_service.getFaqList();
		String page = "";
		String view = "";
		if (faq != null) {
			model.addAttribute("faq", faq);
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

			int resultCnt = faq_service.faqInsert(faq);

			if (resultCnt > 0) {
				view = "redirect:/manager/faqlist";
				System.out.println("공지사항 입력 성공");
			} else {
				// 에러페이지 내나
				System.out.println("실패 ㅠㅠ");
			}
		} else {
			// 에러페이지 내나
		}

		return view;
	}

	@RequestMapping(value = "/manager/faqview")
	public String faqView(@RequestParam("faq_idx") int faq_idx, Model model, HttpSession session) {

		Faq faq = faq_service.viewFaqContents(faq_idx);

		Manager manager = (Manager) session.getAttribute("manager");

		faq.setManager_idx(manager.getManager_idx());

		// 여기set 왜해주시는거에요
		// 여기set 왜해주시는거에요
		// 여기set 왜해주시는거에요
		// 여기set 왜해주시는거에요
		// 여기set 왜해주시는거에요
		// 여기set 왜해주시는거에요
		// 여기set 왜해주시는거에요
		// 여기set 왜해주시는거에요
		// 여기set 왜해주시는거에요
		// 여기set 왜해주시는거에요
		// 여기set 왜해주시는거에요
		// 여기set 왜해주시는거에요
		// 여기set 왜해주시는거에요
		// 여기set 왜해주시는거에요
		// 여기set 왜해주시는거에요
		// 여기set 왜해주시는거에요
		// 여기set 왜해주시는거에요
		// 여기set 왜해주시는거에요
		// 여기set 왜해주시는거에요
		// 여기set 왜해주시는거에요
		// 여기set 왜해주시는거에요
		// 여기set 왜해주시는거에요
		// 여기set 왜해주시는거에요
		// 여기set 왜해주시는거에요
		// 여기set 왜해주시는거에요
		// 여기set 왜해주시는거에요
		// 여기set 왜해주시는거에요
		model.addAttribute("faq", faq);

		String page = "manager/faqview.jsp";
		String view = "home";
		model.addAttribute("page", page);

		return view;

	}

	@RequestMapping(value = "/manager/faqdelete", method = RequestMethod.GET)
	public String faqDelete(@RequestParam("faq_idx") int faq_idx) {
		String view = "";
		if (faq_idx < 0) {
			int result = faq_service.deleteFaqList(faq_idx);

			if (result > 0) {
				view = "redirect:/manager/faqlist";
				System.out.println("삭제");

			} else {

				System.out.println("삭제실패 망");

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
		Faq faq = faq_service.updateSelectFaq(faq_idx);
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
				int r = faq_service.updateFaqList(faq, request);

				if (r > 0) {
					System.out.println("정상 업데이트");
				} else {
					System.out.println("놉놉놉");
				}
			} else {
				System.out.println("faq정보 필요함 ㅠ퓨");
			}
		} else {
			// 에러페이 내나

		}

		return page;
	}

}
