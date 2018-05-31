package p.g.p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/sidebar/share")
public class Sb_share_controller {
	

    public String share() {
    	
    	
    	return "sidebar/share";
	}

}
