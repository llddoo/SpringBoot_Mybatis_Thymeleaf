package com.iu.s1.member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// Spring Security에서 사용하는 VO가 존재
// UserDetails
// 따로 생성 또는 구현

public class MemberVO implements UserDetails {
	
	private String username;
	private String password1;
	@Length(max=10, min=2)
	private String password;
	@NotEmpty
	private String name;
	@NotEmpty
	private String email;
	@NotEmpty
	private String phone;
	
	private boolean enabled;
	//Role
	private List<RoleVO> roles;
	
	//Role 저장
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() { //어떤 타입이 오던 상관없는데 부모는 그렌트를 써야됨
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			
			for(RoleVO roleVO:this.roles) {
				authorities.add(new SimpleGrantedAuthority(roleVO.getRoleName()));
			}
			
			return authorities;
		}

		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return false;
		}
	
	
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
