package com.cos.photogramstart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity//해당파일로 시큐리티를 활성화
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
		.antMatchers("/","user/**","/image/**","subscribe/**","/comment/**").authenticated()
		.anyRequest().permitAll()
		.and()
		.formLogin()
		.loginPage("/auth/signin")//GET
		.loginProcessingUrl("/auth/signin")//POST -> 스프링 시큐리티가 로그인 프로세스 진행
		.defaultSuccessUrl("/");
	}
}
