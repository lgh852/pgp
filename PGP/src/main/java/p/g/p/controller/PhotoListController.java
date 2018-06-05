package p.g.p.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import p.g.p.model.Like;
import p.g.p.model.Member_info;
import p.g.p.model.PhotoListmodel;
import p.g.p.model.Scrap;
import p.g.p.model.scrapFN;
import p.g.p.service.PhotoService;
import p.g.p.service.Sb_scrap_service;
@Controller
public class PhotoListController {
	@Autowired
	PhotoService service;


	 @Autowired
	   Sb_scrap_service service2;
	
	@RequestMapping("/photo/photoList")
	public String photoList(Model model,HttpSession session,Like like,PhotoListmodel photolist,Scrap scrap) {
		
		String view = "home";
		String page = "photo/photolist.jsp";
		model.addAttribute("page",page);
		Member_info member = (Member_info)session.getAttribute("user");
		
		System.out.println(member);
		//1번 
	
			//Like 체크 를 위해 
			
	    	
			System.out.println(photolist);
			
			
			
			//스크랩 목록
			List<PhotoListmodel> list = service.photolistview(like,photolist,member);
			
			System.out.println(list);
			System.out.println(list);
			System.out.println(list);
			System.out.println(list);
			System.out.println(list);
			System.out.println(list);
			System.out.println(list);
			System.out.println(list);
			System.out.println(list);
			System.out.println(list);
			System.out.println(list);
			System.out.println(list);
			System.out.println(list);
			System.out.println(list);
			
			if(member!=null) {
				
				 scrap.setMember_idx(member.getMember_idx());
			
				List<scrapFN> scrapNameList = service2.folder(member.getMember_idx());
			       model.addAttribute("scrapNameList", scrapNameList);
			     
			     //스크랩 체크
			     
			     list= service2.Listscrapck(list,scrap);
			    System.out.println(list);

			    
				
			}
		      
			
			
			
			
		model.addAttribute("list",list);
		model.addAttribute("Alignment",photolist.getAlignment());	//1.최신순 2.인기순 ,3 좋아요순 1 ==default 값 
		model.addAttribute("room",photolist.getRoom()); //romm 0==default 값 모든 공간 
		model.addAttribute("space",photolist.getSpace());//space =="";
		model.addAttribute("member",member);
		

		
	
		return view;
	
	}
	
	@RequestMapping("/photo/photoListdwon")

	public 	@ResponseBody String photolistdown(	@RequestBody String bno) {
		

		
		return "Stringss";
	}
	
	
	
}
