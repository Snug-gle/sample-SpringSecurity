package kr.co.iotree.sanghproject.service;

import kr.co.iotree.sanghproject.dto.UserDto;

import java.util.List;

public interface UserService {

   List<UserDto> selectUserList();
}
