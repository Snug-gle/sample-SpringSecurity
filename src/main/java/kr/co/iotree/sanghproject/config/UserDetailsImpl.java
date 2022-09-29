package kr.co.iotree.sanghproject.config;

import kr.co.iotree.sanghproject.vo.UserVo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {
    // !왜 final을 추천할까? update시 영향을 받을까?
    private UserVo userVo;

    public UserDetailsImpl(UserVo userVo) {
        this.userVo = userVo;
    }

    // singletonList?? 메모리 절약을 위해 단일 요소 혹은 요소가 빈 경우 Arrays.asList 보다 Collections.singletonList를 추천
    // java.util.Arrays와 java.util.ArrayList 차이 주말에 봐둘 것
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return userVo.getPassword();
    }

    @Override
    public String getUsername() {
        return userVo.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
