package kr.co.iotree.sanghproject.controller;

import kr.co.iotree.sanghproject.util.SessionConst;
import kr.co.iotree.sanghproject.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homeLogin(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            UserVo loginUser = (UserVo) session.getAttribute(SessionConst.LOGIN_USER);
            model.addAttribute("user", loginUser);
        }
        return "home";
    }
}
