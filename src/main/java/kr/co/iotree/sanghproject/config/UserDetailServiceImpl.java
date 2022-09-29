package kr.co.iotree.sanghproject.config;

import kr.co.iotree.sanghproject.mapper.UserMapper;
import kr.co.iotree.sanghproject.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    // 로그인 정보 유효성 검사
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 여기서 받은 유저 패스워드와 비교하여 로그인 인증
        UserVo userVo = userMapper.getUserByEmail(username);
        if (userVo == null) {
            throw new UsernameNotFoundException("User not authorized. ");
        }
        return new UserDetailsImpl(userVo);
    }
}
