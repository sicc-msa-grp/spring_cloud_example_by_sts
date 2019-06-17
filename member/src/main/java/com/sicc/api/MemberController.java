package com.sicc.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Member 컨트롤러
 * @author Woongs
 */
@RestController						// RestController 선언
@RequestMapping(path = "/members")	// path 설정 (http://localhost:8081/members 로써 접근 가능)
public class MemberController {

	/**
	 * Member 정보 함수
	 * @param memberId : 멤버아이디
	 * @return 문자열(멤버아이디, 현시간, work정보)
	 */
    @GetMapping(path = "/{memberId}") // path 설정 (http://localhost:8081/members/xxxx 로써 접근 가능)
    public String getMemberDetail(@PathVariable String memberId) {
        String workInfo = "[unknown]";
        return String.format("[display id = %s at %s %s ]", memberId, System.currentTimeMillis(), workInfo);
    }
}