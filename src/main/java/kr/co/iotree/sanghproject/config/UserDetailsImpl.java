package kr.co.iotree.sanghproject.config;

import kr.co.iotree.sanghproject.vo.UserVo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {

    private final UserVo userVo;

    public UserDetailsImpl(UserVo userVo) {
        this.userVo = userVo;
    }

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

    // 1년 이상 로그인을 하지 않으면
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
