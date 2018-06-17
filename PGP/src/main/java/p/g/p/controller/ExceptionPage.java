package p.g.p.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionPage {
/*
	@ExceptionHandler(NullPointerException.class)	
	public ModelAndView Nullexception(NullPointerException e) {        

	        ModelAndView mav = new ModelAndView("exception");

	        mav.addObject("name", e.getClass().getSimpleName());

	        mav.addObject("message", e.getMessage());

	        return mav;

	    }
	
	@ExceptionHandler(NumberFormatException.class)	
	public ModelAndView NumberFormatexception(NullPointerException e) {        

	        ModelAndView mav = new ModelAndView("exception");

	        mav.addObject("name", e.getClass().getSimpleName());

	        mav.addObject("message", e.getMessage());

	        return mav;

	    }
	

	@ExceptionHandler(.class)	
	public ModelAndView NumberFormatexception(NullPointerException e) {        

	        ModelAndView mav = new ModelAndView("exception");

	        mav.addObject("name", e.getClass().getSimpleName());

	        mav.addObject("message", e.getMessage());

	        return mav;

	    }
*/

}
