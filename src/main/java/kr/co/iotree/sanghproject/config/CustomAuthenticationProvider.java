package kr.co.iotree.sanghproject.config;

import kr.co.iotree.sanghproject.service.UserService;
import kr.co.iotree.sanghproject.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserVo userVo = userService.loadUserByUsername(username);
        if (!passwordEncoder.matches(password, userVo.getPassword())) {
            throw new BadCredentialsException("BadCredentialsException");
        }

        userVo.setPassword(null);
        userVo.setPhone(null);
        return new UsernamePasswordAuthenticationToken(userVo, null, Collections.singletonList(new SimpleGrantedAuthority("USER")));
    }

    public boolean supports(Class<?> authentication) {
        return true;
    }
}
