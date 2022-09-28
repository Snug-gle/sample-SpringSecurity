package kr.co.iotree.sanghproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    // Http Request 관련 Web 보안 설정
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()

                .authorizeHttpRequests()    //authorizeRequest 보다 추천 https://docs.spring.io/spring-security/reference/servlet/authorization/authorize-http-requests.html
                // 루트 페이지 접근
                .antMatchers("/","/login","/join").permitAll()
                .antMatchers("/userDetail").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                // 로그인
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/loginProcess")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/userDetail")
                .failureUrl("/")
                .and()
                // 로그아웃
                .logout()
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
