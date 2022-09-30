package kr.co.iotree.sanghproject.config;

import kr.co.iotree.sanghproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    // 이전에는 username만 비교하여 검증하였다
    // 1. username -> principal name
//      - DB email과 같아야 하고
    // 2. password -> credeintials
    //  - 암호화 후 비교해야 해야 한다

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetailsImpl userDetails = (UserDetailsImpl) userService.loadUserByUsername(username);

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("BadCredentialsException");   // 비밀번호가 틀리면 Provider manager에서 예외 처리됨
        }
        // DB에 있는 데이터와 비교 후 이상이 없는 경우 토근 반환
        return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
    }

    // support의 경우 단순히 해당 object를 면밀히 평가할수 있는지 여부만을 확인
    // 폼로그인으로 받은 정보를 UsernamePasswordAuthenticationToken 지원 가능 여부 확인
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
