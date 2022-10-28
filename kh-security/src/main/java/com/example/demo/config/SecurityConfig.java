package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
/*
 * 스프링 시큐리티가 인터셉트 하는 것을 방어해서 사용자 정의 로그인 페이지로 링크하는데
 * 아래 클래스가 역할이 있다.
 * 프레임워크 관련 설정을 자바만으로 처리할 때 @Configuration 사용됨
 */

@Configuration //애네가 있으면 인터셉터를 당하지 않음 / 주석을막으면 로그인쪽으롱 이동
@EnableWebSecurity //스프링 시큐리티 필터가 스프링 필터체인에 등록
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() { // 사용자 비번 암호화 처리 역할
        return new BCryptPasswordEncoder();
    }
     
    @Bean  // 2.7 이상 -> SecurityFilterChain 무조건 이걸로!!!
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	http.csrf().disable();//스프링시큐리티를 추가하면 기본적으로 csrf에 대해 체크하기때문에 
    	// 인증만 되면 들어갈 수 있는 주소가 됨
        http.authorizeRequests()
            .antMatchers("/").authenticated()
            .antMatchers("/user/**").hasRole("USER")//user이면 들어감
            .antMatchers("/admin/**").hasRole("ADMIN")//admin이면 들어감
        	.anyRequest().permitAll()
        	.and()
        	.formLogin()
        	.loginPage("/loginForm")
        	// loginForm에서 로그인버튼을 클릭하면 loginAction 요청을 듣고
        	// 시큐리티가 인터셉트하여 대신 로그인 진행을 한다.
        	.loginProcessingUrl("/loginAction")
        	.defaultSuccessUrl("/");
        return http.build();
    }
 
}