package p.g.p.controller;

import static org.junit.Assume.assumeNoException;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import p.g.p.model.Member_info;
import p.g.p.service.Mp_update_service;

@Controller
@RequestMapping("/mypage/mp_update")

public class Mp_update_controller {

	@Autowired
	private Mp_update_service service;

	@RequestMapping(method = RequestMethod.GET)
	public String mypageUpdateForm(@RequestParam("member_idx") String member_idx, Model model, Member_info member) {
		String page = "";
		String view = "";
		String phone1="";
		String phone2="";
		String phone3="";
		member = service.Mp_update_select(member_idx);
		if (member != null) {
			
			if(member.getMember_phone()!=null) {
				 phone1 = member.getMember_phone().substring(0, 3);
				 phone2 = member.getMember_phone().substring(3, 7);
				 phone3 = member.getMember_phone().substring(7, 11);
			}
			if(member.getMember_birth()!=null) {
				
		
			System.out.println(member.getMember_birth());
			String birth = member.getMember_birth();
			if (birth != null) {
				String[] births = birth.split("-");
				if (births.length > 1) {
					for (int i = 0; i < births.length; i++) {
						System.out.println(births[i]);
					}
					String year = births[0];
					String month = births[1];
					String day = births[2];
					model.addAttribute("year", year);
					model.addAttribute("month", month);
					model.addAttribute("day", day);
				}

			}
			}
			
			page = "mypage/mp_update_form.jsp";
			view = "home";
			model.addAttribute("member", member);

			model.addAttribute("phone1", phone1);
			model.addAttribute("phone2", phone2);
			model.addAttribute("phone3", phone3);

		} else {

			// 값이 없을때
		}

		model.addAttribute("page", page);

		return view;

	}

	@RequestMapping(method = RequestMethod.POST)
	public String mypageUpdate(Member_info member, HttpServletRequest request, Model model,
			@RequestParam("year") String year, @RequestParam("month") String month, @RequestParam("day") String day,
			@RequestParam("phone1") String phone1, @RequestParam("phone2") String phone2,
			@RequestParam("phone3") String phone3) throws IllegalStateException, IOException {
		System.out.println(day);
		System.out.println(month);
		System.out.println(year);
		System.out.println(phone1);
		System.out.println(phone2);
		System.out.println(phone3);
	
		if (member != null) { // 값이 있으면 update 실행
			member.setMember_phone(phone1 + phone2 + phone3);
			member.setMember_birth(year + "-" + month + "-" + day);
			
		
			
			int resultCnt = service.Mp_update(member, request);

			System.out.println(resultCnt);
			if (resultCnt > 0) {
				System.out.println("정상적으로 실행");

		

			} else {
				System.out.println("비어있는 값이 있습니다.");
			}
		}

		String page = "mypage/mp_update.jsp";
		String view = "home";
		model.addAttribute("page", page);

		return view;

	}

}
