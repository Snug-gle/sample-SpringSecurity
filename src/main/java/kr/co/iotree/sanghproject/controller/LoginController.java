package kr.co.iotree.sanghproject.controller;

import kr.co.iotree.sanghproject.config.UserDetailsImpl;
import kr.co.iotree.sanghproject.service.UserService;
import kr.co.iotree.sanghproject.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    // 로그인 화면 요청 처리
    @GetMapping("/login")
    public String loginForm() {
        return "loginForm";
    }

    // 회원 정보 상세 페이지 - 로그인, 회원 가입, 정보 수정 성공 시 이동
    // 코드를 더 줄일 수 있을 거 같은데?
    @GetMapping("/userDetail")
    public String userDetail(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        UserVo userVo = userService.getUserByPassword(userDetails.getUsername(), userDetails.getPassword());
        model.addAttribute("user", userVo);

        return "userDetail";
    }

    // 로그아웃 요청 처리
    @PostMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}
