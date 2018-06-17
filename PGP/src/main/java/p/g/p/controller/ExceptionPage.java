package p.g.p.controller;

import java.sql.SQLDataException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.exceptions.DataTruncationException;

@ControllerAdvice
public class ExceptionPage {

	@ExceptionHandler(NullPointerException.class)	
	public ModelAndView Nullexception(NullPointerException e) {        

	        ModelAndView mav = new ModelAndView("nullpointerexception");

	        mav.addObject("name", e.getClass().getSimpleName());

	        mav.addObject("message", e.getMessage());

	        return mav;

	    }
	
	@ExceptionHandler(NumberFormatException.class)	
	public ModelAndView NumberFormatexception(NumberFormatException e) {        

	        ModelAndView mav = new ModelAndView("numberexception");

	        mav.addObject("name", e.getClass().getSimpleName());

	        mav.addObject("message", e.getMessage());

	        return mav;

	    }
	@ExceptionHandler(SQLDataException.class)	
	public ModelAndView NumberFormatexception(SQLDataException e) {        

	        ModelAndView mav = new ModelAndView("sqlexception");

	        mav.addObject("name", e.getClass().getSimpleName());

	        mav.addObject("message", e.getMessage());

	        return mav;

	    }
	
	@ExceptionHandler(DataTruncationException.class)	
	public ModelAndView NumberFormatexception(DataTruncationException e) {        

	        ModelAndView mav = new ModelAndView("truncationexception");

	        mav.addObject("name", e.getClass().getSimpleName());

	        mav.addObject("message", e.getMessage());

	        return mav;

	    }
	
	@ExceptionHandler(Exception.class)	
	public ModelAndView NumberFormatexception(Exception e) {        

	        ModelAndView mav = new ModelAndView("defaultErrorView");

	        mav.addObject("name", e.getClass().getSimpleName());

	        mav.addObject("message", e.getMessage());

	        return mav;

	    }

}
