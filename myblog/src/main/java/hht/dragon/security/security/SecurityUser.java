package hht.dragon.security.security;

import hht.dragon.entity.User;
import hht.dragon.entity.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * ClassDescription
 * <p>
 * User : Dragon_hht
 * Date : 17-5-13
 * Time : 下午4:30
 */
public class SecurityUser extends User implements UserDetails {

	public SecurityUser(User user) {
		this.setRoles(user.getRoles());
		this.setPassword(user.getPassword());
		this.setPhone(user.getPhone());
		this.setEmail(user.getEmail());
		this.setUserName(user.getUserName());
		this.setUserId(user.getUserId());
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// 获取用户的所有权限
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		Set<UserRole> roles = this.getRoles();
		if (roles != null) {
			for (UserRole role : roles) {
				SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRole());
				authorities.add(authority);
			}
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
