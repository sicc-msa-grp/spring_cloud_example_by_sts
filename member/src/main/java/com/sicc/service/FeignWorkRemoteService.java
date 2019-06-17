package com.sicc.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Feign을 이용 Work 프로젝트 호출 인터페이스
 * @author Woongs
 *
 */
//@FeignClient(name="work", url="http://localhost:8082/") // Feighn 명칭, 경로 설정
//Feign + Eureka + Ribbon 적용, fallback, fallback Factory 추가
@FeignClient(name="work",
	//fallback=FeignWorkRemoteServiceFallbackImpl.class,
	fallbackFactory=FeignWorkRemoteServiceFallbackFactory.class)
public interface FeignWorkRemoteService {
	@RequestMapping(path="/works/{workId}")
	String getWorkInfo(@PathVariable("workId") String workId);
}
