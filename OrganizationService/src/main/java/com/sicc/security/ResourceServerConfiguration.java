package com.sicc.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * 서비스 접근 대상 정의
 * @author Woongs
 */
@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	
	/**
	 * 모든 접근 규칙 재정의한 configure()
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		//http.authorizeRequests().anyRequest().authenticated(); // 메소드로 전달된 HttpSecurity 객체로 모든 접근 규칙이 구성됨
		http
			.authorizeRequests()
			.antMatchers(HttpMethod.DELETE, "/organizations/**") // 보호할 URL, HTTP 메소드 제한
			.hasRole("ADMIN") // 접근 가능한 역할
			.anyRequest()
			.authenticated();
	}
}

