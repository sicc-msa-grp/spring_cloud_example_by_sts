package com.sicc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

/**
 * OAuth2 서비스에 등록된 애플리케이션과 사용자 자격 증명 정의 클레스
 * @author Woongs
 */
@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;
    
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients
			.inMemory()	// 차후 실 DB로 교체
			.withClient("sicc_client")	// 클라이언트 명
			.secret(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("sicc_secret"))	// 클라이언트 시크릿
			.authorizedGrantTypes("refresh_token", "password", "client_credentials")	// OAuth2에서 지원하는 인가 크랜트 타입
			.scopes("webclient", "mobileclient");	// OAuth2 서버에 액세스 토큰 요청시 애플리케이션의 수행 경계 정의
    }
    
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
      endpoints
        .authenticationManager(authenticationManager)
        .userDetailsService(userDetailsService);
    }
}
