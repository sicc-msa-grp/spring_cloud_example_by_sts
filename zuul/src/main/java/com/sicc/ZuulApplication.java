package com.sicc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * zuul 프로젝트 시작점 (어노테이션 선언으로 zuul 기능 구현하도록)
 * @author Woongs
 */
@EnableZuulProxy		// zuulProxy 선언
@EnableDiscoveryClient	// discoveryClient 선언
@SpringBootApplication
public class ZuulApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}
}
