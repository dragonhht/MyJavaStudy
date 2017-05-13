package hht.dragon.security.security;

import hht.dragon.entity.User;
import hht.dragon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * ClassDescription
 * <p>
 * User : Dragon_hht
 * Date : 17-5-13
 * Time : 下午1:35
 */
@Component
public class WebUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		// 判断用户是否存在
		User user = null;
		Integer id = Integer.parseInt(userId);
		user = userRepository.getUserById(id);
		if (user == null) {
			throw  new UsernameNotFoundException("编号为: " + userId + " 的用户不存在");
		}
		return new SecurityUser(user);
	}
}
