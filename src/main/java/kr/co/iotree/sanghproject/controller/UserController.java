package kr.co.iotree.sanghproject.controller;

import kr.co.iotree.sanghproject.service.UserService;
import kr.co.iotree.sanghproject.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // 회원 화면 요청
    @GetMapping("/user/home")
    public String userHome() {
        return "userHome";
    }

    // 회원 가입 화면 요청
    @GetMapping("/join")
    public String joinForm() {
        return "joinForm";
    }

    // 회원 가입 요청
    @PostMapping("/join")
    public String join(@ModelAttribute UserVo userVo, RedirectAttributes redirectAttributes) {
        int checkResult = userService.getCountUserByEmail(userVo.getEmail());
        if (checkResult > 0) {
            String message = "중복되는 사용자가 있습니다.";
            redirectAttributes.addFlashAttribute("message", message);
            return "redirect:/join";
        } else {
            userService.insertUser(userVo);
        }
        return "redirect:/user/home";
    }

    // 회원 상세 정보 페이지
    @GetMapping("/user/userDetail")
    public String userDetail(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserVo userVo = (UserVo)authentication.getPrincipal();
        userVo = userService.getUserByEmail(userVo.getEmail());
        model.addAttribute("user", userVo);
        return "userDetail";
    }

    // 회원 정보 수정 페이지 요청
    @GetMapping("/user/modify")
    public String modifyFormUser(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserVo userVo = (UserVo)authentication.getPrincipal();
        userVo = userService.getUserByEmail(userVo.getEmail());
        model.addAttribute("user", userVo);
        return "userModify";
    }

    // 회원 정보 수정 요청
    @PostMapping("/user/modify")
    public String modifyUser(@ModelAttribute UserVo userVo) {
        userService.updateUser(userVo);
        return "redirect:/user/home";
    }

    // 회원 정보 삭제 요청
    @GetMapping("/admin/delete/{id}")
    public String delete(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/admin/userList";
    }

    // 전체 유저 리스트 페이지 요청
    @GetMapping("/admin/userList")
    public String userList(Model model) {
        List<UserVo> userList = userService.getUserList();
        model.addAttribute("user", userList);
        return "userList";
    }
}
