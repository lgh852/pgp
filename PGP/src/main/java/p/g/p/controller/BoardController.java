package p.g.p.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import p.g.p.model.Board;
import p.g.p.model.Board_Photo;
import p.g.p.model.Category_Room;
import p.g.p.model.Category_Space;
import p.g.p.model.Like;
import p.g.p.model.Member_info;
import p.g.p.model.PhotoListmodel;
import p.g.p.model.Url_Tag;
import p.g.p.service.BoardService;
import p.g.p.service.PhotodetailService;

@Controller
public class BoardController {

	@Autowired
	BoardService service;
	@Autowired
	Category_Room room;
	@Autowired
	Category_Space space;
	@Autowired
	private PhotodetailService photodetailservice;
	
	@RequestMapping("/board/boardAjaxTag")
	@ResponseBody
	public String BoardphotoTag(Url_Tag tag,Model model) {
		int idxs = service.taginsert(tag);

		
		String idx=String.valueOf(idxs);
		model.addAttribute("idx",idx);
		
		return idx;
	}
	
	@RequestMapping("/board/boardPhtoTagForm")
	public String BoardphotoTagForm(Model model,@RequestParam("board_idx")String board_idx) {
		
		String view = "home";
		String page ="";
		Board_Photo photo = service.phototagselect(board_idx);	
		System.out.println(photo);
		
		if(photo !=null) {
			page = "board/boardPhotoTagForm.jsp";
			int baord_idxs = Integer.parseInt(board_idx);
		    List<Url_Tag> urlList = photodetailservice.selectUrl(baord_idxs);
			
		    model.addAttribute("urlList",urlList);
			model.addAttribute("page",page);
			model.addAttribute("photo",photo);
			model.addAttribute("board_idx",board_idx);
			
		}else {
		
			model.addAttribute("page",page);
			model.addAttribute("photo",photo);
		}
		
		return view;
	}
	
	@RequestMapping(value = "/board/boardserach", method = RequestMethod.POST)
	public String boardserch(Model model, PhotoListmodel photoListmodel, Like like, HttpSession session) {

		String page = "photo/photolist.jsp";

		String ck = photoListmodel.getSearch();
		
		if (ck != null) {

			Member_info member = (Member_info) session.getAttribute("user");
			if(member!=null) {
				like.setMember_idx(member.getMember_idx());	
					
			}
			
			List<PhotoListmodel> list = service.search(like, photoListmodel);
			model.addAttribute("list", list);

			model.addAttribute("page", page);
			String search = photoListmodel.getSearch();
			String choice = photoListmodel.getChoice();
			String Alignment = photoListmodel.getAlignment();
			model.addAttribute("search", search);
			model.addAttribute("choice", choice);
			model.addAttribute("Alignment", Alignment);

		} else {

		}

		return "home";
	}

	@RequestMapping(value = "/board/boardserach", method = RequestMethod.GET)
	public String boardserchAlignment(Model model, PhotoListmodel photoListmodel, Like like, HttpSession session) {
		
		String search = photoListmodel.getSearch();
		String choice = photoListmodel.getChoice();
		String room = photoListmodel.getRoom();
		String space = photoListmodel.getSpace();
		String Alignment = photoListmodel.getAlignment();
	
		model.addAttribute("search", search);
		model.addAttribute("choice", choice);
		model.addAttribute("Alignment", Alignment);
		model.addAttribute("room", room);
		model.addAttribute("Alignment", Alignment);
		model.addAttribute("space", space);
		String page = "board/boardserach.jsp";
		String ck = photoListmodel.getSearch();
		Member_info member = (Member_info) session.getAttribute("user");
		like.setMember_idx(member.getMember_idx());

		if (ck != null) {
			List<PhotoListmodel> list = service.search(like, photoListmodel);
			model.addAttribute("list", list);
			model.addAttribute("page", page);
		}

		return "home";

	}
	
	@RequestMapping("/board/tagdelete")
	@ResponseBody
	public String tagdelete(Url_Tag tag) {
		
		String check = service.deletetag(tag);
		
		
		
		return check;
	}
	
	
	@RequestMapping("/board/taginfo")
	@ResponseBody
	public String taginfo(Url_Tag tag) {
		
		
		String url_tag = service.selectTagInfo(tag);

		
		
		
		return url_tag;
	}
	
	
	///////////////////////////////////////////////////////글쓰기
	@RequestMapping(value = "/board/boardFrom", method = RequestMethod.GET)
	public String WritingPhotoForm(Model model) {

		String view = "home";
		String page = "board/boardFrom.jsp";

		model.addAttribute("page", page);

		return view;
	}

	@RequestMapping(value = "/board/boardFrom", method = RequestMethod.POST)
	public String bo(Model model, @RequestParam(value = "category_room", defaultValue = "null") String category_room,
			Board board, @RequestParam(value = "category_space", defaultValue = "null") String category_space,
			Board_Photo photo, HttpServletRequest request, HttpSession session)
			throws IllegalStateException, IOException {
		// 받은값들 넣어주기
		
		String page = "";
		String msg = "";
		String view = "";
		space.setCategory_space(category_space);
		room.setCategory_room(category_room);
		
		int resultCnt = service.BoardAllService(request, photo, room, space, board, session);
		
		if (resultCnt > 0) {
			
			// 성공
		//	page = "board/boardPhotoPage.jsp";
	
			
			model.addAttribute("page", page);
			view ="redirect:../photo/photodetail?board_idx="+photo.getBoard_idx();
			// 사진을 보여눌 select 문
			board.getBoard_idx();
			List<Board_Photo> listPhoto = service.photoSelect(board);
		
			// 사진 정보 전달
			model.addAttribute("listPhoto",listPhoto);
		} else {
			// 예외상황
			page = "board/PhotoUpException.jsp";
			msg = "다른 어떤상황";
			view = "home";
			model.addAttribute("msg", msg);
			model.addAttribute("page", page);
			
		}

		return view;
	}
}
