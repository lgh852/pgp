package p.g.p.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.model.Member_info;

public class Mp_MyPageList {
	
	@Autowired
	MypageService services;

	public Member_info userck(HttpSession session, Member_info member) {
		
		if(member!=null&&member.getMember_idx()>0) {
			System.out.println("1");
			String member_idx = String.valueOf(member.getMember_idx());
			member = services.Mp_update_select(member_idx);
			System.out.println(member);
		}else {
			System.out.println("2");
			member = (Member_info)session.getAttribute("user");
				
		}
		return member;
	}
}
