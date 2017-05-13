package hht.dragon.security;

import hht.dragon.security.interceptors.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 拦截器队列配置.
 * <p>
 * User : Dragon_hht
 * Date : 17-5-12
 * Time : 下午5:37
 */
@Configuration
public class WebInterceptor extends WebMvcConfigurerAdapter {
	/**
	 * 在拦截器队列中添加拦截器.
	 * @param registry registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//拦截用户模块下的所有请求
		//registry.addInterceptor(getLoginInterceptor()).addPathPatterns("/user/**");
	}

	/**
	 * 获取用户登录验证拦截器的实例.
	 * @return LoginInterceptor
	 */
	private LoginInterceptor getLoginInterceptor() {
		return new LoginInterceptor();
	}
}
