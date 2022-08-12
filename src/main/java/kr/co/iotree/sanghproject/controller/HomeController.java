package kr.co.iotree.sanghproject.controller;

import kr.co.iotree.sanghproject.dto.UserDto;
import kr.co.iotree.sanghproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String userList(Model model) {
        List<UserDto> userList = userService.selectUserList();
        model.addAttribute("userList", userList);
        return "index";
    }
}
