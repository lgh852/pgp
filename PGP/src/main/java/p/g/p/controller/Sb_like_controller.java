package p.g.p.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import p.g.p.service.Sb_like_service;

@Controller 
public class Sb_like_controller {
	
	@Autowired
	Sb_like_service service;

	
	@RequestMapping(value="/like", method=RequestMethod.GET)
	@ResponseBody
	public String sbLike(int board_idx, String member_id){
		
		
		
		return null;
		
	}
}
