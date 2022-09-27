package kr.co.iotree.sanghproject.config;


import kr.co.iotree.sanghproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

// Allows customization to the WebSecurity.
// In most instances users will use EnableWebSecurity and create a Configuration that expose a SecurityFilterChain bean.
@EnableWebSecurity //@Configuration 포함
public class SpringSecurityConfig {

    @Autowired
    private UserService userService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                /*
                사용자가 인증을 받지 않은 상태로 요청을 하게 되면 서버에서는 사용자에게 401 Unauthorized 응답과 함께
                WWW-Authenticate 헤더를 기술해서 인증을 어떤 방식으로 해야 하는지에 대한 설명을 동봉
                - HttpBasic 인증은 Http 프로토콜에서 정의한 기본 인증, 세션 방식의 인증이 아닌 서버로부터 요청 받은 인증 방식대로 구성
                - Form 인증의 경우 서버에 해당 사용자의 session 상태가 유효한지를 판단해서 인증처리를 한다고 함
                */
                .authorizeRequests()    //authorizeHttpRequests()?
                    // 루트 페이지 접근
                    .antMatchers("/").permitAll()
                .and()
                    // 로그인
                    .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/loginProcess")
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/userDetail")
                    .permitAll()
                .and()
                    // 로그아웃
                    .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // 로그 아웃 호출할 경우 해당 경로?
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true);

        return http.build();
    }


    @Bean
    // Spring5 부터는 암호 인코더도 정의해야 한다고 함
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

/*   @Bean
    public UserDetailsManager userDetailsService(AuthenticationManagerBuilder auth) throws Exception {    // InmemoryUserDetailSManager와 차이?
        auth.userDetailsService(userService);
        return new InMemoryUserDetailsManager(user);
    }*/
}
