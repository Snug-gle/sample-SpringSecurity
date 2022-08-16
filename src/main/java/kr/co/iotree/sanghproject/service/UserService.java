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

    public List<UserVo> getUserList() {
        return userMapper.getUserList();
    }

/*
    public void insertUser(UserDto userDto) {

    }

    public void updateUser(UserDto userDto) {

    }

    public UserDto selectUser(int id) {
        return null;
    }
*/
}
