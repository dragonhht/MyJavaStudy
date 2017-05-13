package hht.dragon.security.security;



import hht.dragon.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录成功后的处理
 * <p>
 * User : Dragon_hht
 * Date : 17-5-13
 * Time : 下午7:10
 */
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
		User user = (User) authentication.getPrincipal();
		Integer id = user.getUserId();
		String name = user.getUserName();
		HttpSession session = request.getSession();
		session.setAttribute("userId", id);
		session.setAttribute("userName", name);
		log.info("登录的用户: " + name);
		log.info("登录的IP:" + getIpAddress(request));

		response.sendRedirect("/MyBlog/visituser/" + id + "/0");
	}

	public String getIpAddress(HttpServletRequest request){
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
