package kr.co.iotree.sanghproject.service;

import kr.co.iotree.sanghproject.mapper.UserMapper;
import kr.co.iotree.sanghproject.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 신규 회원 생성
    public void insertUser(UserVo userVo) {
        userVo.setPassword(passwordEncoder.encode(userVo.getPassword()));
        userMapper.insertUser(userVo);
    }

    // 회원 정보 변경
    public void updateUser(UserVo userVo) {
        userVo.setPassword(passwordEncoder.encode(userVo.getPassword()));
        userMapper.updateUser(userVo);
    }

    // 회원 삭제
    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }

    // 전체 회원 조회
    public List<UserVo> getUserList() {
        return userMapper.getUserList();
    }

    // 이메일로 회원 조회
    public UserVo getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }

    // 회원 정보 검색 결과 반환
    public int getCountUserByEmail(String email) {
        return userMapper.getCountUserByEmail(email);
    }

    // 로그인 정보 유효성 검사
    public UserVo loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVo userVo = userMapper.getUserByEmail(username);
        if (userVo == null) {
            throw new UsernameNotFoundException("User not authorized. ");
        }
        return userVo;
    }
}
