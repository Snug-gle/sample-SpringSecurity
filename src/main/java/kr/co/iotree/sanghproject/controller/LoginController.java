package kr.co.iotree.sanghproject.controller;

import kr.co.iotree.sanghproject.service.UserService;
import kr.co.iotree.sanghproject.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    // 로그인 화면 요청 처리
    @GetMapping("/login")
    public String loginForm() {
        return "loginForm";
    }

    // 로그인 성공 페이지
    @GetMapping("/userDetail")
    public String userDetail(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        UserVo userVo = userService.getUserByPassword(userDetails.getUsername(), userDetails.getPassword());
        model.addAttribute("user", userVo);

        return "userDetail";
    }

    // 로그아웃 요청 처리
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "home";
    }
    /*
   // 로그인 요청 처리
    @PostMapping("/loginProcess")
    public String login(@ModelAttribute UserVo userVo, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
        UserVo user = userService.getUserByPassword(userVo.getEmail(), userVo.getPassword());
        if (user == null) {
            String message = "아이디와 비밀번호를 확인해주시기 바랍니다.";
            redirectAttributes.addFlashAttribute("message", message);
            return "redirect:/login";
        }
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_USER, user);
        model.addAttribute("user", user);
        return "redirect:/userDetail";
    }
*/
}
