package kr.co.iotree.sanghproject.service;

import kr.co.iotree.sanghproject.util.UserRepository;
import kr.co.iotree.sanghproject.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
//파이널일 때 생성자를 만들시 사용?? 추가 공부 할것
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    public UserVo login(String name, String password) {
        return userRepository.findByName(name)
                .filter(userVo -> userVo.getPassword().equals(password))
                .orElse(null);  // NULL이 넘어가면 컨트롤러에서 걸러짐

    }

}
