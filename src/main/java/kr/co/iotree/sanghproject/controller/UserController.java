package kr.co.iotree.sanghproject.controller;

import kr.co.iotree.sanghproject.service.UserService;
import kr.co.iotree.sanghproject.util.SessionConst;
import kr.co.iotree.sanghproject.vo.UserVo;
import lombok.RequiredArgsConstructor;
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

    // 회원 가입 화면 요청
    @GetMapping("/signup")
    public String singUpForm() {
        return "signup";
    }

    // 회원 가입 요청
    @PostMapping("/signup")
    public String signUp(@ModelAttribute UserVo userVo, HttpSession session) {
        userService.insertUser(userVo);
        session.setAttribute(SessionConst.LOGIN_USER, userVo.getNum());
        return "user";
    }

    // 회원 상세 페이지
    @GetMapping("/user")
    public String userInfo(@ModelAttribute UserVo userVo, HttpSession session, Model model) {
        UserVo userInfo = userService.getUserById(((UserVo)(session.getAttribute(SessionConst.LOGIN_USER))).getId());
        model.addAttribute("user", userInfo);
        return "user";
    }

    // 회원 정보 수정 페이지 요청
    @GetMapping("/user/modify")
    public String modifyFormUser() {
        return "userModify";
    }

    //회원 정보 수정 요청
    @PostMapping("/user")
    public String modifyUser(@ModelAttribute UserVo userVo) {
        userService.updateUser(userVo);
        return "user";
    }

    // 회원 정보 삭제 페이지 요청
    @GetMapping("/user/delete/{id}")
    public String delete(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/userList";
    }

    // 전체 유저 리스트
    @GetMapping("/userList")
    public String userList(Model model) {
        List<UserVo> userList = userService.getUserList();
        model.addAttribute("user", userList);
        return "userList";
    }
}
