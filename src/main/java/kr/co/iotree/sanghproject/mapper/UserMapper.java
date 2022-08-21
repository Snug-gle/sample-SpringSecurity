package kr.co.iotree.sanghproject.mapper;

import kr.co.iotree.sanghproject.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    // 신규 회원 생성
    void insertUser(UserVo userVo); // void or int??

    // 회원 정보 변경
    void updateUser(UserVo userVo);

    // 회원 정보 삭제
    void deleteUser(int id);

    // 회원 정보 조회
    UserVo getUserById(int id);

    // 전체 사용자 조회
    List<UserVo> getUserList();

    // 로그인 아이디, 비밀번호 조회
    UserVo getUserByPassword(String name, String password);

    // 회원 가입 시 중복 체크
    int checkByName(String name);
}
