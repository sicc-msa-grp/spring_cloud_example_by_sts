package com.sicc.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * ���� ���� ��� ����
 * @author Woongs
 */
@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	
	/**
	 * ��� ���� ��Ģ �������� configure()
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		//http.authorizeRequests().anyRequest().authenticated(); // �޼ҵ�� ���޵� HttpSecurity ��ü�� ��� ���� ��Ģ�� ������
		http
			.authorizeRequests()
			.antMatchers(HttpMethod.DELETE, "/organizations/**") // ��ȣ�� URL, HTTP �޼ҵ� ����
			.hasRole("ADMIN") // ���� ������ ����
			.anyRequest()
			.authenticated();
	}
}

