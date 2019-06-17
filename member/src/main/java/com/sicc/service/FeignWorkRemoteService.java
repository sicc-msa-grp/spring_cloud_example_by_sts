package com.sicc.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Feign을 이용 Work 프로젝트 호출 인터페이스
 * @author Woongs
 *
 */
@FeignClient(name="work", url="http://localhost:8082/") // Feighn 명칭, 경로 설정
public interface FeignWorkRemoteService {
	@RequestMapping(path="/works/{workId}")
	String getWorkInfo(@PathVariable("workId") String workId);
}
