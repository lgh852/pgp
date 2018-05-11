package p.g.p.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import p.g.p.model.Board_Photo;
import p.g.p.service.PhotofeedService;

@Controller
@RequestMapping(value = "photo/photofeed")
public class PhotofeedController {
	
@Autowired
PhotofeedService photofeedservice;
	
	@RequestMapping(method=RequestMethod.GET)
	public String feed(Model model) {
		String view ="home";
		String page="photo/photofeed.jsp";
		model.addAttribute("page",page);
		
		
		List<Board_Photo> photoList=photofeedservice.BoardPhotoList();
		model.addAttribute("photoList",photoList);
		
		/*//글 그림 데이터 다 삭제 
		int allDeleteCnt=photodetailservice.AllDelete(board_idx);
		if(allDeleteCnt<0) {
			page = "photo/photoCommentFail.jsp";
			model.addAttribute("page", page);
		}
		*/
		
		
		
		
		
		return view;
	}

	
	
}
