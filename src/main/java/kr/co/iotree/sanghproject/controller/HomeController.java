package kr.co.iotree.sanghproject.controller;

import kr.co.iotree.sanghproject.service.UserService;
import kr.co.iotree.sanghproject.util.SessionConst;
import kr.co.iotree.sanghproject.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String homeLogin(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession(false);

        // 세션이 없으면 홈으로
        if (session == null) {
             return "home";
        }

        UserVo loginUser = (UserVo) session.getAttribute(SessionConst.LOGIN_USER);

        // 세션에 회원 데이터가 없으면 home
        if (loginUser == null) {
            return "home";
        }

        // 세션이 유지되면 유저페이지로 이동
        model.addAttribute("user",loginUser);
        return "user";
    }
}
