package com.sicc.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * work 컨트롤러
 * @author Woongs
 */
@RestController						// RestController 선언
@RequestMapping(path = "/works")	// path 설정 (http://localhost:8082/works 로써 접근 가능)
public class WorkController {
	
	/**
	 * Work 정보 함수
	 * @param workId : 워크아이디
	 * @return 문자열(워크아이디, 현시간)
	 */
	@RequestMapping(path = "/{workId}", method = RequestMethod.GET) // path 설정 (http://localhost:8082/works/xxxx 로써 접근 가능)
	public String getWorkDetail(@PathVariable String workId) {
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		return "[work id = "+workId+" at "+System.currentTimeMillis()+"]";
		//return String.format("[work id = %s at %s]", workId, System.currentTimeMillis());
		throw new RuntimeException("I/O ERROR"); // fallback 테스트를 위한 코드
	}
}
