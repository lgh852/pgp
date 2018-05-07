package p.g.p.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCkInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		ModelAndView andView = new ModelAndView();
		//세션생성 
		HttpSession session = request.getSession();
		//로그인 세션 정보 가져옴
		if(session != null) {
			Object obj = session.getAttribute("user");
			if(obj!=null) {
				//로그인 정보가 존재하면 
				//모델에 include할 페이지 경로 저장
				//바뀌지 않는 절대경로로 저장 
			System.out.println("실행");
					//객체 값이 있을시 정상적인 실행
		
			return true;
			}
		
		}
		response.sendRedirect(request.getContextPath()+"/member/loginform");
		
		System.out.println("실행x");
		//정상이 아닐시 컨트롤러 실행 x
		
		// TODO Auto-generated method stub
		return false;
	}

	

	
}
