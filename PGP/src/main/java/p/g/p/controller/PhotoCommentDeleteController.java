package p.g.p.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import p.g.p.service.PhotodetailService;


@Controller
public class PhotoCommentDeleteController {
	@Autowired
	PhotodetailService photodetailservice;
	
	@RequestMapping("photo/photoCommentDelete")
	
	public String CommentDelete(@RequestParam(value="board_idx")int board_idx,@RequestParam(value="board_comment_idx") int board_comment_idx) {
		int resultCnt= photodetailservice.ListdeleteComment(board_comment_idx);
		//System.out.println("ㅇ야양야양양!!!!"+board_idx);
		String  del="del_success";
		String page="../";
		if(resultCnt>0) {
		page="redirect:photodetail?board_idx="+board_idx+"&del="+del;
		}
		return page;
	}
	

}
