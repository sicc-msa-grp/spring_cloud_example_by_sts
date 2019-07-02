package com.sicc.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 실제 부르자
 * @author Woongs
 *
 */
@Service
public class WorkRemoteServiceImpl implements WorkRemoteService {

	public static final String URL = "http://localhost:8082/works/"; // 요청할 URL 주소
	
	@Autowired
	private OAuth2RestTemplate restTemplate;
	
	@Override
	@HystrixCommand(commandKey = "workInfo", fallbackMethod = "getWorkInfoFallback") // 폴벡 메소드 발동 영역
	public String getWorkInfo(String workId) {
		return restTemplate.getForObject(URL+workId, String.class); // work프로젝트의 URL에 따라 Object데이터 가져옴
	}
	
	// 폴벡 메소드 선언
	public String getWorkInfoFallback(String workId, Throwable t) {
		System.out.println("t = "+t);
		return "[This Work is called as fallback]";
	}
}
