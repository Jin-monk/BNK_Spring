package com.example.jpaEx04.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests((auth) -> auth 
				.requestMatchers("/","/registMember","/regist").permitAll()
				.requestMatchers("/member/**").hasAnyRole("ADMIN","MEMBER")
				.requestMatchers("/admin").hasRole("ADMIN")
				.anyRequest().authenticated()
				);
		http.formLogin((auth) -> auth
				.loginPage("/login")
				.loginProcessingUrl("/loginProc")
				.defaultSuccessUrl("/member/welcome")
				.failureUrl("/fail")
				.permitAll()
				);
		
		http.csrf(csrf -> csrf.disable());
		
		return http.build();
	}
}
