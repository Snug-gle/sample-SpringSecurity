package kr.co.iotree.sanghproject.util;

import kr.co.iotree.sanghproject.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j  // 넌 뭐니?
@Repository // 저장소
public class UserRepository {

    private static Map<Integer, UserVo> store = new HashMap<>(); // static을 사용했네 언제든지 사용하기 위함인가?
    private static int sequence = 0;  // key값을 왜 Long으로 했을까?

    public UserVo save(UserVo userVo) {
        userVo.setId(++sequence);   // 아 여기 VO에서 롱으로 선언했네. 나는 Integer이니 바꿔보자
        log.info("save: member={}", userVo);
        return userVo;
   }

   public UserVo findById(int id) {
        return store.get(id);
   }

   public Optional<UserVo> findByLoginId(String name) {
       List<UserVo> all = findAll();

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
