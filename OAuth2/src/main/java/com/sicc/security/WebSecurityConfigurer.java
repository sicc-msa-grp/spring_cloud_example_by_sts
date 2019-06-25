package com.sicc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 애플리케이션에 대한 사용자 ID와 패스워드, 역할 정의
 * @author Woongs
 */
@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth
			.inMemoryAuthentication()
			.passwordEncoder(encoder)
			.withUser("msa_team").password(encoder.encode("msateampassword")).roles("USER") // msa_team계정은 USER역할
			.and()
			.withUser("msa_team_leader").password(encoder.encode("msateamleaderpassword")).roles("USER", "ADMIN"); // msa_team_leader계정은 USER, ADMIN 역할
    }		
}
