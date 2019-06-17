package com.sicc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Member 어플리케이션 (프로젝트 시작 부분)
 * @author Woongs
 */
@SpringBootApplication
public class MemberApplication {
	
	// RestTemplate 추가
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class);
    }
}
