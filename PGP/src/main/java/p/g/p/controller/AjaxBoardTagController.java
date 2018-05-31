package p.g.p.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import p.g.p.model.Url_Tag;
import p.g.p.service.BoardService;

@Controller
public class AjaxBoardTagController {
	@Autowired
	BoardService service;

	@RequestMapping("/board/boardAjaxTag")
	@ResponseBody
	public String BoardphotoTag(Url_Tag tag,Model model) {
		int idxs = service.taginsert(tag);

		
		String idx=String.valueOf(idxs);
		model.addAttribute("idx",idx);
		
		return idx;
	}

}
