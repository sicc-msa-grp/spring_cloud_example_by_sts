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

@EnableEurekaClient // 유레카 클라이언트로써 등록
@EnableCircuitBreaker // 서킷브레이커 사용 등록
@EnableResourceServer // 마이크로서비스를 보호 자원으로 지정
@SpringBootApplication
public class OrganizationServiceApplication {
	
	// organizations -> Work간 통신을 위하여 포함
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
