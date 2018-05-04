package p.g.p.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import p.g.p.service.Sb_like_service;

@Controller 
public class Sb_like_controller {
	
	@Autowired
	Sb_like_service service;

	@RequestMapping(value="/like", method=RequestMethod.POST)
	public String sbLike(){
		return null;
		
	}
}
