package com.iu.s1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.iu.s1.security.SecurityException;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// Security를 무시(제외)
		web.ignoring()
		   .antMatchers("/resources/**")	
		   .antMatchers("/images/**")
		   .antMatchers("/css/**")
		   .antMatchers("/js/**")
		   .antMatchers("/vendor/**")
		   .antMatchers("/favicon/**")
		   ;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// URL에 따른 로그인, 권한 설정
		http
			//권한 에러 발생(403)
			//사용하지 않으면 기본 제공 에러 처리 방법 사용
			.exceptionHandling()
//				.accessDeniedPage("/member/error") //error page 경로
				.accessDeniedHandler(new SecurityException())//error 처리 class
				.and()
			.cors().and()
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/notice/list", "/notice/select").permitAll()
				.antMatchers("/notice/**").hasRole("ADMIN")
				.antMatchers("/qna/list").permitAll()
				.antMatchers("/qna/**").hasAnyRole("ADMIN", "MEMBER")
				.antMatchers("/member/join").permitAll()
				.antMatchers("/member/*").hasAnyRole("ADMIN", "MEMBER")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				//로그인페이지를 따로 만들지 않아도 기본 내장된 폼으로 이동
				//개발자가 만든 로그인폼을 사용하려면 다음과 같이 작성
				.loginPage("/member/login")
				.defaultSuccessUrl("/member/memberLoginResult")
				//login 실패 처리
				//.failureUrl("/member/loginFail")
				.permitAll()
				.and()
			.logout()
				.logoutUrl("/member/logout") //로그아웃을 할거니깐 로그아웃 페이지로 넘어가게하라
				.logoutSuccessUrl("/") //로그아웃이되면 어디로 가고싶닝
				.invalidateHttpSession(true) // 세션을 임벨리드할걸 참으로 하겠다
				.deleteCookies("JSESSIONID") 
				.permitAll()
				;
		
		
	}
	
}