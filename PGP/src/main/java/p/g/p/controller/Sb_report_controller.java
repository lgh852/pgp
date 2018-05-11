package p.g.p.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import p.g.p.model.report;
import p.g.p.service.Sb_report_service;

@Controller
@RequestMapping(value="/sidebar/sb_report")
public class Sb_report_controller {
	
	
	@Autowired 
	Sb_report_service service;
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public String sidebarReport(report report) {
		
				
		String ck ="";
		
		int resultCnt = service.reportSubmit(report);
		
		if(resultCnt>0) {
			//성공
		ck = "y";
		
		}else {
			
			ck = "n";	
		}
		
		return ck;
	
	}

}
