package com.sicc.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * ���� �θ���
 * @author Woongs
 *
 */
@Service
public class WorkRemoteServiceImpl implements WorkRemoteService {

	public static final String URL = "http://localhost:8082/works/"; // ��û�� URL �ּ�
	
	@Autowired
	private OAuth2RestTemplate restTemplate;
	
	@Override
	@HystrixCommand(commandKey = "workInfo", fallbackMethod = "getWorkInfoFallback") // ���� �޼ҵ� �ߵ� ����
	public String getWorkInfo(String workId) {
		return restTemplate.getForObject(URL+workId, String.class); // work������Ʈ�� URL�� ���� Object������ ������
	}
	
	// ���� �޼ҵ� ����
	public String getWorkInfoFallback(String workId, Throwable t) {
		System.out.println("t = "+t);
		return "[This Work is called as fallback]";
	}
}
