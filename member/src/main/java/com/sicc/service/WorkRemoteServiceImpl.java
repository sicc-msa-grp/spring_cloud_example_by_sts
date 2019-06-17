package com.sicc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * Work 프로젝트 호출 인터페이스 구현
 * @author Woongs
 */
@Service
public class WorkRemoteServiceImpl implements WorkRemoteService {

	public static final String URL = "http://localhost:8082/works/"; // 요청할 URL 주소
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	@HystrixCommand(commandKey = "workInfo", fallbackMethod = "getWorkInfoFallback") // 폴벡 메소드 발동 영역
	public String getWorkInfo(String workId) {
		return restTemplate.getForObject(URL+workId, String.class); // work프로젝트의 URL에 따라 Object데이터 가져옴
	}

	@HystrixCommand(commandKey = "workInfo2")
	public String getWorkInfo2(String workId2) {
		return restTemplate.getForObject(URL+workId2, String.class);
	}	
	
	// 폴벡 메소드 선언
	public String getWorkInfoFallback(String workId, Throwable t) {
		System.out.println("t = "+t);
		return "[This Work is called as fallback]";
	}
}
