package com.sicc.service;

import org.springframework.stereotype.Component;

/**
 * Feign용 Hystrix fallback 구현 클레스
 * @author Woongs
 *
 */
@Component
public class FeignWorkRemoteServiceFallbackImpl implements FeignWorkRemoteService {
	@Override
	public String getWorkInfo(String workId) {
		return "[ this work is finished ]";
	}
}
