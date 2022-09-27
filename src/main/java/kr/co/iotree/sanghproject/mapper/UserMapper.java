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

    // 전체 사용자 조회
    List<UserVo> getUserList();

    // 로그인 아이디, 비밀번호 조회
    UserVo getUserByPassword(String name, String password);

    // 회원 정보 조회
    int getUserByName(String name);

    // 스프링 시큐리티 로그인 위해 임시 생성
    UserVo getUserByEmail(String email);
}
