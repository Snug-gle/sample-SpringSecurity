package kr.co.iotree.sanghproject.controller;

import kr.co.iotree.sanghproject.service.UserService;
import kr.co.iotree.sanghproject.util.SessionConst;
import kr.co.iotree.sanghproject.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // 회원 가입 화면 요청
    @GetMapping("/join")
    public String joinForm() {
        return "joinForm";
    }

    //! 회원 가입 요청
    @PostMapping("/join")
    public String join(@ModelAttribute UserVo userVo, RedirectAttributes redirectAttributes, HttpServletRequest request, Model model) {
        int checkResult = userService.getUserByName(userVo.getName());

        if (checkResult == 1) {
            String message = "중복되는 아이디가 있습니다.";
            redirectAttributes.addFlashAttribute("message", message);
            return "redirect:/join";
        } else {
            userService.insertUser(userVo);
            HttpSession session = request.getSession();
            session.setAttribute(SessionConst.LOGIN_USER,userVo);
            model.addAttribute("user", userVo);
        }
        return "userDetail";
    }

    // 회원 정보 수정 페이지 요청
    @GetMapping("/user/modify")
    public String modifyFormUser(HttpSession session, Model model) {
        UserVo user = (UserVo) session.getAttribute(SessionConst.LOGIN_USER);
        model.addAttribute("user", user);
        return "userModify";
    }

    //! 회원 정보 수정 요청
    @PostMapping("/user/modify")
    public String modifyUser(@ModelAttribute UserVo userVo, HttpSession session, Model model) {
        userService.updateUser(userVo);
        session.setAttribute(SessionConst.LOGIN_USER, userVo);
        model.addAttribute("user", userVo);
        return "userDetail";
    }

    // 회원 정보 삭제 요청
    @GetMapping("/user/delete/{id}")
    public String delete(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/userList";
    }

    // 전체 유저 리스트 조회
    @GetMapping("/userList")
    public String userList(Model model) {
        List<UserVo> userList = userService.getUserList();
        model.addAttribute("user", userList);
        return "userList";
    }
}
