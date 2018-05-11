package p.g.p.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import p.g.p.model.Like;
import p.g.p.model.Member_info;
import p.g.p.service.PhotoListLeeService;

@Controller
public class PhotoListLikeController {
	@Autowired
	PhotoListLeeService service;

	@RequestMapping("/board/photolistlike")
	@ResponseBody
	public String listlikeajax(Like like, HttpSession session) {
		Member_info member = (Member_info) session.getAttribute("user");
		String ck = "n";
		System.out.println("member 값" + member);
		like.setMember_idx(like.getMember_idx());
		if (member != null) {
			int member_idx = member.getMember_idx();

			like.setMember_idx(member_idx);

			/* board 와 member_idx 기준으로 조회하는 select 문 */
			Like likeck = service.likeck(like);
			System.out.println(likeck);
			System.out.println(likeck);
			System.out.println(likeck);
			System.out.println(likeck);
			System.out.println("체크 있는지 여부 " + likeck);
			if (likeck == null) {
				// 실행
							
				int result = service.listLikeup(like);
				System.out.println("like테이블 증가+1" + result);
				System.out.println("like테이블 증가+1" + like);
				if (result > 0) {
					// 성공
					int resultCnt = service.updateLikecntUP(like);
					System.out.println("board테이블 +1 " + resultCnt);
					System.out.println("board테이블 +1 " + like);
					if (resultCnt > 0) {

						ck = "y";

					} else {

						ck = "s";
					}

				} else {
					ck = "s";
				}
			} else {
				// 값이 있으면 삭제후 -1 감소 실행
				int resultcnt = service.deltelike(likeck);
				if (resultcnt > 0) {
					int result = service.udateLikecntDown(like);
					System.out.println("감소여부" + result);
					// 실패
					ck = "n";
					// 감소문 실행
					if (result > 0) {
						// 성공
					} else {
						// 실패
						ck = "s";
					}
				} else {
					ck = "s";
				}
				// 조회해서 값이 있으면 -1 감수 실행 없으면

			}

		} else {
			ck = "s";
		}

		return ck;
	}
}
