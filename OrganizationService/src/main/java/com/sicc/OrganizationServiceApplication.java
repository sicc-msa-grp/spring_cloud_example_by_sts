package com.sicc;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateFactory;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.client.RestTemplate;

import com.sicc.utils.UserContextFilter;

@EnableEurekaClient // ����ī Ŭ���̾�Ʈ�ν� ���
@EnableCircuitBreaker // ��Ŷ�극��Ŀ ��� ���
@EnableResourceServer // ����ũ�μ��񽺸� ��ȣ �ڿ����� ����
@SpringBootApplication
public class OrganizationServiceApplication {
	
	// organizations -> Work�� ����� ���Ͽ� ����
    @Bean
    public OAuth2RestTemplate oauth2RestTemplate(UserInfoRestTemplateFactory factory) {
      return factory.getUserInfoRestTemplate();
    }	

	@Bean
	public Filter userContextFilter() {
		UserContextFilter userContextFilter = new UserContextFilter();
		return userContextFilter;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}
}
