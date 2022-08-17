package kr.co.iotree.sanghproject.service;

import kr.co.iotree.sanghproject.util.UserRepository;
import kr.co.iotree.sanghproject.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
//파이널일 때 사용 추가 공부 할것
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    public UserVo login(String name, String password) {
        return userRepository.findByLoginId(name)
                .filter(userVo -> userVo.getPassword().equals(password))
                .orElse(null);  // NULL 로 한 이유?

    }

}
