package kr.co.iotree.sanghproject.controller;

import kr.co.iotree.sanghproject.service.LoginService;
import kr.co.iotree.sanghproject.util.SessionConst;
import kr.co.iotree.sanghproject.vo.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor    // 이거 사용안하면 아래 userRepository 빨간줄 생김
public class LoginController {

    @Autowired
    private LoginService loginService;

    // 로그인 화면 요청
    @GetMapping("/login")
    public String loginForm() {
        return "loginForm";
    }

    // 로그인 요청
    @PostMapping("login")
    public String login(@ModelAttribute UserVo userVo,
                        BindingResult bindingResult,
                        HttpServletResponse response,
                        HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "home";
        }

        UserVo loginUser = loginService.login(userVo.getName(), userVo.getPassword());

        if (loginUser == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다");
            return "home";
        }

        // 로그인 성공 처리
        // 세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성
        // getSession()의 파라미터에 불린형이 올 수 있고, 트루일 경우 세션을 생성하고 false이면 null을 반환
        HttpSession session = request.getSession();

        // 세션에 로그인 회원 정보 보관함
        session.setAttribute(SessionConst.LOGIN_USER, loginUser);

        return "user";
    }

    @PostMapping("/logout") // 로그아웃은 왜 포스트 방식 요청일까? 쿼리로 넘기지 않으면 다 POST 방식 일까?
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        return "home";
    }
}
