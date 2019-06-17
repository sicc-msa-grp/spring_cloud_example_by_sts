package com.sicc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
	public String getWorkInfo(String workId) {
		return restTemplate.getForObject(URL+workId, String.class); // work프로젝트의 URL에 따라 Object데이터 가져옴
	}

}
