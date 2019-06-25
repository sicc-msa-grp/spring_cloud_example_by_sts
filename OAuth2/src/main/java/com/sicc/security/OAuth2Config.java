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
 * OAuth2 ���񽺿� ��ϵ� ���ø����̼ǰ� ����� �ڰ� ���� ���� Ŭ����
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
			.inMemory()	// ���� �� DB�� ��ü
			.withClient("sicc_client")	// Ŭ���̾�Ʈ ��
			.secret(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("sicc_secret"))	// Ŭ���̾�Ʈ ��ũ��
			.authorizedGrantTypes("refresh_token", "password", "client_credentials")	// OAuth2���� �����ϴ� �ΰ� ũ��Ʈ Ÿ��
			.scopes("webclient", "mobileclient");	// OAuth2 ������ �׼��� ��ū ��û�� ���ø����̼��� ���� ��� ����
    }
    
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
      endpoints
        .authenticationManager(authenticationManager)
        .userDetailsService(userDetailsService);
    }
}
