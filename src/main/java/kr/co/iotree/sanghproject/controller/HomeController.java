package kr.co.iotree.sanghproject.controller;

import kr.co.iotree.sanghproject.service.UserService;
import kr.co.iotree.sanghproject.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    // 회원 목록
    @GetMapping("/")
    public String userList(Model model) {
        List<UserVo> userList = userService.getUserList();
        model.addAttribute("user", userList);
        return "index";
    }

}
