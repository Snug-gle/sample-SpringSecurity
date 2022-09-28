package kr.co.iotree.sanghproject.service;

import kr.co.iotree.sanghproject.vo.UserVo;
import kr.co.iotree.sanghproject.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    // 신규 회원 생성
    public void insertUser(UserVo userVo) {
        userMapper.insertUser(userVo);
    }

    // 회원 정보 변경
    public void updateUser(UserVo userVo) {
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

    // 로그인 아이디, 비밀번호 조회
    public UserVo getUserByPassword(String name, String password) {
        return userMapper.getUserByPassword(name, password);
    }


    public int getCountUserByName(String email) {
        return userMapper.getCountUserByEmail(email);
    }
}
