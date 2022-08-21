package kr.co.iotree.sanghproject.controller;

import kr.co.iotree.sanghproject.mapper.UserMapper;
import kr.co.iotree.sanghproject.service.LoginService;
import kr.co.iotree.sanghproject.util.SessionConst;
import kr.co.iotree.sanghproject.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserMapper userMapper;

    // 로그인 화면 요청 처리
    @GetMapping("/login")
    public String loginForm() {
        return "loginForm";
    }

    // 로그인 요청 처리
    @PostMapping("/login")
    public String login(@ModelAttribute UserVo userVo, HttpServletRequest request, Model model) {
        UserVo user = userMapper.getUserByPassword(userVo.getName(), userVo.getPassword());
        if (user == null)
            return "loginForm";

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_USER, user);

        model.addAttribute("user", user);
        return "user";
    }

    // 로그아웃 요청 처리
    @PostMapping("/logout") // 로그아웃은 왜 포스트 방식 요청일까? 쿼리로 넘기지 않으면 다 POST 방식 일까?
    public String logout() {
        return "home";
    }

}
