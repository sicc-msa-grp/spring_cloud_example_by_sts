package com.sicc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController				// Rest 컨트롤러 역할
@EnableResourceServer		// 자원서버
@EnableAuthorizationServer	// 인증서버
@SpringBootApplication
public class OAuth2Application {

	// 인증 받은 토큰으로 url 접근시 조회될 유저 정보
    @RequestMapping(value = { "/user" }, produces = "application/json")
    public Map<String, Object> user(OAuth2Authentication user) {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("user", user.getUserAuthentication().getPrincipal());
        userInfo.put("authorities", AuthorityUtils.authorityListToSet(
        								user.getUserAuthentication().getAuthorities()));
        return userInfo;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(OAuth2Application.class, args);
	}

}
