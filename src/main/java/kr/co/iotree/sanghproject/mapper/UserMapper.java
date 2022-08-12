package kr.co.iotree.sanghproject.mapper;

import kr.co.iotree.sanghproject.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {

    // 전체 사용자 조회
    List<UserDto> selectUserList();
}
