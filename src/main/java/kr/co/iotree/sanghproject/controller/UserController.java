package kr.co.iotree.sanghproject.controller;

import kr.co.iotree.sanghproject.service.UserService;
import kr.co.iotree.sanghproject.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // 로그인 화면 요청
    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    // 로그인 처리 요청
    @PostMapping("/login")
    public String doLogin(@ModelAttribute UserVo userVo, HttpSession session) {
        session.setAttribute("userInfo", userVo);
        return "user";
    }

    // 회원 상세 페이지
    @GetMapping("/user")
    public String userInfo(HttpSession session, Model model) {
        /*userService.getUserById()
        session.getAttribute("userInfo")*/
        return "user";
    }

    // 회원 정보 수정 페이지 요청
    @GetMapping("/user/user_modify")
    public String modifyFormUser() {
        return "user_modify";
    }

    //회원 정보 수정 요청
    @PostMapping("/user")
    public String modifyUser() {
        return "user";
    }

    // 회원 정보 삭제 페이지 요청
    @GetMapping("/user/delete/{id}")
    public String delete(@PathVariable int id) {
        return "/";
    }

    // 회원 가입 화면 요청
    @GetMapping("/user/signup")
    public String singUpForm() {
        return "signup";
    }

    // 회원 가입 요청
    @PostMapping("/signup")
    public String signUp(UserVo userVo) {
       userService.insertUser(userVo);
       return "user";
    }
}
