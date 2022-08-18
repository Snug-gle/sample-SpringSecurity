package kr.co.iotree.sanghproject.util;

import kr.co.iotree.sanghproject.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;


import java.util.*;

@Slf4j  // 넌 뭐니? 로깅과 관련이 있다. 로깅은 일련의 과정들을 기록하는 것
@Repository
public class UserRepository {


    private static Map<Long, UserVo> store = new HashMap<>(); // static을 사용했네 언제든지 사용하기 위함인가?

    private static long sequence = 0L;

    // 이 메소드가 있는 의도 이해 부족
    // 변수 store의 key에 넣을 숫자를 UserVo의 id에 ++sequence를 통해 생성하고, 그 기록을 INFO 수준의 메세지로 남기는 듯하다?
    // 근데 UserVo의 아이디가 DB에서 primary Key인데 바뀌어도 되나?
    public UserVo save(UserVo userVo) {
        userVo.setNo(++sequence);
        log.info("save: user={}", userVo);
        return userVo;
    }

    // 필요없으면 지우자
    public UserVo findById(Long no) {
        return store.get(no);
    }

    // DB의 name과 password로 로그인
    // 매개로 받은 name이 UserVo에 있는 네임과 같은지 확인 후 있으면 그 첫번째를 반환
    // findFirst() vs findAny()

    public Optional<UserVo> findByName(String name) {

        return findAll().stream()
                .filter(userVo -> userVo.getName().equals(name))
                .findFirst();
    }

    public List<UserVo> findAll() {
        // 리스트에 포함되어 매핑된 모든 집합들을 반환한다
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        // 매핑된 모든것을 지움
        store.clear();
    }
}
