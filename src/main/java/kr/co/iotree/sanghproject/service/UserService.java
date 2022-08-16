package kr.co.iotree.sanghproject.service;

import kr.co.iotree.sanghproject.vo.UserVo;
import kr.co.iotree.sanghproject.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    // 회원 정보 조회
    public List<UserVo> getUserById(int id) {
        return userMapper.getUserById(id);
    }
    // 전체 회원 조회
    public List<UserVo> getUserList() {
        return userMapper.getUserList();
    }

}
