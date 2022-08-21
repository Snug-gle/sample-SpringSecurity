package kr.co.iotree.sanghproject.controller;

import kr.co.iotree.sanghproject.mapper.UserMapper;
import kr.co.iotree.sanghproject.service.LoginService;
import kr.co.iotree.sanghproject.service.UserService;
import kr.co.iotree.sanghproject.util.SessionConst;
import kr.co.iotree.sanghproject.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;

    // 로그인 화면 요청 처리
    @GetMapping("/login")
    public String loginForm() {
        return "loginForm";
    }

    // 로그인 요청 처리
    @PostMapping("/login")
    public String login(@ModelAttribute UserVo userVo, HttpServletRequest request, Model model, RedirectAttributes RAttr) {
        logger.info("login post");
        UserVo user = userService.getUserByPassword(userVo.getName(), userVo.getPassword());
        if (user == null) {
            String message = "아이디와 비밀번호를 확인해주시기 바랍니다.";
            RAttr.addFlashAttribute("message", message);
            return "redirect:/login";
        }

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
