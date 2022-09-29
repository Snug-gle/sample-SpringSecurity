package kr.co.iotree.sanghproject.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.ArrayList;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    // 암호화 전략....
    // 난 여기서 뭘 해야 하는가.. ㅅㅂ ... ㅅㅂ..
    // 회원 가입 시 받은 username과 password로 DB 에 있는지 검색하는 ....


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        if () {

            return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
        } else {
            return null;
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
