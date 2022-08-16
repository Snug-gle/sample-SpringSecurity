package kr.co.iotree.sanghproject.mapper;

import kr.co.iotree.sanghproject.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    // 전체 사용자 조회
    List<UserVo> getUserList();

    // 사용자 생성

    // 사용자 정보 변경

    // 번호(id)를 통한 사용자 정보 조회


}
