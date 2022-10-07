package kr.co.iotree.sanghproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableWebSecurity
public class SecurityConfig {

    // HttpSecurity : It allows configuring web based security for specific http requests.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // authorizeHttpRequest() : Allows restricting access based upon the HttpServletRequest using RequestMatcher implementations (i.e. via URL patterns).
        http.authorizeHttpRequests()    //authorizeRequest 보다 추천 https://docs.spring.io/spring-security/reference/servlet/authorization/authorize-http-requests.html
                .antMatchers("/", "/login", "/join").permitAll()
                .anyRequest().authenticated();

        // 로그인
        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/loginProcess")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/user/home")
                .failureUrl("/");

        // 로그아웃
        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new CustomAuthenticationProvider();
    }
}
