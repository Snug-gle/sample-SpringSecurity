package kr.co.iotree.sanghproject.config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


// Allows customization to the WebSecurity.
// In most instances users will use EnableWebSecurity and create a Configuration that expose a SecurityFilterChain bean.
@EnableWebSecurity //@Configuration 포함
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                /*
                사용자가 인증을 받지 않은 상태로 요청을 하게 되면 서버에서는 사용자에게 401 Unauthorized 응답과 함께
                WWW-Authenticate 헤더를 기술해서 인증을 어떤 방식으로 해야 하는지에 대한 설명을 동봉
                - HttpBasic 인증은 Http 프로토콜에서 정의한 기본 인증, 세션 방식의 인증이 아닌 서버로부터 요청 받은 인증 방식대로 구성
                - Form 인증의 경우 서버에 해당 사용자의 session 상태가 유효한지를 판단해서 인증처리를 한다고 함
                formLogin 을 같이 설정하면 formLogin이 우선적으로 적용이 되는데..?
                */

                .authorizeHttpRequests((authorize) -> authorize
                                .anyRequest().authenticated()
                )
                // withDefaults()?
                .httpBasic(withDefaults());
//                .formLogin()
//                    .loginPage("/login")  // 사용자 정의 로그인 페이지
//                .defaultSuccessUrl("")  // 로그인 성공 후 이동 페이지
//                .failureUrl("") // 로그인 실패 후 이동 페이지


        // @formatter:on
        return http.build();
    }

    //@formatter:off
    @Bean
    public UserDetailsManager userDetailsService() {    // InmemoryUserDetailSManager와 차이?
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("1111")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}
