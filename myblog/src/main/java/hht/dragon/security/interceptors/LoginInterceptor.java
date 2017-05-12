package hht.dragon.security.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户登录验证拦截器
 * <p>
 * User : Dragon_hht
 * Date : 17-5-12
 * Time : 下午5:39
 */
public class LoginInterceptor implements HandlerInterceptor {
	/**
	 * 用于验证用户是否登录
	 * @param httpServletRequest httpServletRequest
	 * @param httpServletResponse httpServletResponse
	 * @param o 0
	 * @return 验证结果
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
		HttpSession session = httpServletRequest.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		System.out.println(userId);
		if ( userId != null) {
			return true;
		}
		httpServletRequest.getRequestDispatcher("/tologin").forward(httpServletRequest, httpServletResponse);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

	}
}
