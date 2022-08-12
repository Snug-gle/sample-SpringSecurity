package kr.co.iotree.sanghproject.service;

import kr.co.iotree.sanghproject.dto.UserDto;
import kr.co.iotree.sanghproject.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDto> selectUserList() {
        return userMapper.selectUserList();
    }
}
