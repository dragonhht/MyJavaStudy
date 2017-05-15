package hht.dragon.security;

import hht.dragon.security.security.LoginSuccessHandler;
import hht.dragon.security.security.WebUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



/**
 *	安全配置类
 * <p>
 * User : Dragon_hht
 * Date : 17-5-13
 * Time : 上午8:47
 */
@Configuration
@EnableWebSecurity //开启Spring Security的功能
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private WebUserDetailsService webUserDetailsService;

	// 配置相应的URL及其访问权限
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				//无需权限访问的URL 使用permitAll()
				.antMatchers("/index", "/login", "/tologin", "/toregister", "/single/**",
						"/articles/**", "/visituser/**", "/search/**", "/regist", "/contact", "/forgetPassword",
						"/checkuser", "/updatepassword", "/setpassword")
				.permitAll()
				.antMatchers("/css/**", "/js/**", "/img/**")
				.permitAll()
				//需要有用户权限(ROLE_USER)才能访问
				.antMatchers("/user/**")
				.hasRole("USER")
				// 任何未匹配的URL只需进行身份验证
				.anyRequest().authenticated()
				.and()
				// 登录设置
				.formLogin()
				.loginPage("/tologin") //设置登录页面
				.loginProcessingUrl("/login") // 设置登录处理的URL
				.usernameParameter("userId") //设置输入的用户名参数字段
				.passwordParameter("password") // 设置输入的用户登录密码
				.successHandler(getLoginSuccessHandler()) //设置登录成功后的处理器
				.permitAll()
				.and()
				.logout()
				.logoutUrl("/user/loginout") // 设置登出的路径
				.logoutSuccessUrl("/index") // 设置登出成功后显示的页面
				.invalidateHttpSession(true) // 清除session
				.permitAll()
				.and()
				.httpBasic();
	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 密码加密
		auth.userDetailsService(webUserDetailsService).passwordEncoder(passwordEncoder());
		auth.eraseCredentials(false);
	}

	// 使用BCryptPasswordEncoder算法加密密码
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	/**
	 * 获取一个登录成功的处理器实例
	 * @return
	 */
	private LoginSuccessHandler getLoginSuccessHandler() {
		return new LoginSuccessHandler();
	}

}
