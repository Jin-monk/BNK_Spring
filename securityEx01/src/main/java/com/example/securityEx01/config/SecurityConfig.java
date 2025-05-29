package com.example.securityEx01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // 설정하는 파일 어노테이션
@EnableWebSecurity
public class SecurityConfig {

	@Bean // 스테레오 어노테이션 , 컴포넌트 어노테이션 외에 메서드에 붙이는게 있음. 그게 Bean. 이 메서드의 반환되는 자료가 Bean으로 등록됨.
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(auth -> auth
//				.requestMatchers("/").permitAll() // "/" 의 경로는 모두에게 개방해라. 
//				.anyRequest().permitAll()  // 모든 요청에서 개방해라 .  -> 쓸 일 없음. 
				.anyRequest().authenticated()
				);

		http.formLogin(auth -> auth
				.loginPage("/login")
				.loginProcessingUrl("/loginProc")
				.defaultSuccessUrl("/welcome")
				.permitAll()
				);
//		http.formLogin(Customizer.withDefaults()); // 웹으로 로그인
//		http.httpBasic(Customizer.withDefaults()); // 컨펌창에서 로그인.
		
		http.csrf(csrf -> csrf.disable());
		
		http.logout(Customizer.withDefaults()) ; //기본 /logout 처리
		
		
		return http.build();
	}
		
}
