package p.g.p.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import p.g.p.service.PhotodetailService;

@Controller
public class PhotofeedAllDeleteController {
	@Autowired
	PhotodetailService photodetailservice;

	@RequestMapping("photo/photofeedAllDelete")
	public String feedAllDelete(@RequestParam(value = "board_idx") int board_idx) {
		int resultCnt = photodetailservice.AllDelete(board_idx);
		System.out.println("욕데게ㅔ게게리절트 !===>"+resultCnt);
		String page = "../";
		if (resultCnt > 0) {
			page="redirect:photoList?Alignment=board_idx&room=&space=";
		}
		
		
		return page;
		
		
		
	}

}
