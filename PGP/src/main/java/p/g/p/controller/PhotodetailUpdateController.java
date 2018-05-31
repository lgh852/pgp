package p.g.p.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import p.g.p.model.Board;
import p.g.p.model.Board_Photo;
import p.g.p.model.Join_Board_Category_RoomNSpace;
import p.g.p.service.BoardPhotoUpLoad;
import p.g.p.service.PhotoDetailUpdateService;
import p.g.p.service.PhotodetailService;

@Controller
@RequestMapping(value = "photo/updatePhotodetail")
public class PhotodetailUpdateController {
	@Autowired
	PhotodetailService photodetailservice;

	@Autowired
	PhotoDetailUpdateService photodetailupdateservice;

	@Autowired
	BoardPhotoUpLoad photoup;

	@RequestMapping(method = RequestMethod.GET)
	public String UpdateDetail(Model model, @RequestParam(value = "board_idx", defaultValue = "0") int board_idx) {
		String view = "home";
		String page = "photo/updatePhotodetail.jsp";
		model.addAttribute("page", page);

		// 글 제목
		Board board = photodetailservice.boardSelectView(board_idx);
		model.addAttribute("board", board);

		// 사진
		String photoName = photodetailservice.photodetailView(board_idx);
		model.addAttribute("photoName", photoName);
		
	

		return view;

	}

	@RequestMapping(method = RequestMethod.POST)
	public String UpdateDetailSend(HttpServletRequest request, HttpSession session, Model model,
			Board board,
			Board_Photo board_photo, Join_Board_Category_RoomNSpace joinBoardRoomNSpace)
			throws IllegalStateException, IOException {
		
		String page = "../";
		
		photoup.fileupload(request, session, board_photo);

		int result = photodetailupdateservice.AllPhotoDetailUpdate(board, board_photo, joinBoardRoomNSpace);
		System.out.println("RESULT값===>"+result);
		if (result > 0) {
			System.out.println("이것보세요~!!!!!!!!!!!!!!!=>"+board.getBoard_idx());
			page = "redirect:photodetail?board_idx="+board.getBoard_idx();
	
		}

	

		return page;

	}

	
}
