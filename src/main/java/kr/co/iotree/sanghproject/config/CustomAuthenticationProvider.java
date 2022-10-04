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
        // todo
        //  - 상황 : Controller에는 credential 값이 null로 넘어 옴
        //  - 인증이 완료 되면 credential이 null로 변환 되는 것으로 보임
        //  - 인증이 된 Authentication을 반환해 줄 때, credential을 null로 넘기는게 보안에 유리할까? Credential Container / eraseCredential 디버깅 돌려보기..
        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
    }

    // support의 경우 단순히 해당 object를 면밀히 평가할수 있는지 여부만을 확인
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
