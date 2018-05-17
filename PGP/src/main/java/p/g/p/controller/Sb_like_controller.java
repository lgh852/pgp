package p.g.p.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import p.g.p.model.Like;
import p.g.p.service.Sb_like_service;

@Controller 
public class Sb_like_controller {
	
	@Autowired
	Sb_like_service service;

	
	@RequestMapping(value="/sidebar/like", method=RequestMethod.GET)
	@ResponseBody
	public String sbLike(Like like,Model model){

	    String ck="n";
		
	    Like likeck = service.likeck(like);
	    
	    if(likeck ==null) {
	    	int result = service.Likeup(like);
	    	
	    	if(result>0) {
	    		
	    		int resultCnt = service.updateLikecntUp(like);
	    		
	    		if(resultCnt >0) {
	    			ck="y";
	    		}else {
	    			ck="s";
	    		}
	    		}else {
	    			ck="s";
	    		}
	    }else {
	    	//값이 있으면 삭제후 -1 감소 실행
	    	
	    	int resultcnt=service.deletelike(likeck);
	    	if(resultcnt>0) {
	    		int result= service.updateLikecntDown(like);
	    		
	    		ck="n";
	    		
	    		if(result>0) {
	    			
	    		}else {
	    			ck="s";
	    		}
	    	}else {
	    		ck="s";
	    	}
	    }
	
	    model.addAttribute("likeck", likeck);
	
	  return ck;
		
	}
}
