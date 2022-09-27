package kr.co.iotree.sanghproject.service;

import kr.co.iotree.sanghproject.mapper.UserMapper;
import kr.co.iotree.sanghproject.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserSecurityService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 여기서 받은 유저 패스워드와 비교하여 로그인 인증
        UserVo userVo = userMapper.getUserByEmail(username);
        if (userVo == null) {
            throw new UsernameNotFoundException("User not authorized. ");
        }

        return new User(username, userVo.getPassword(), userVo.getAuthorities());
    }
}
