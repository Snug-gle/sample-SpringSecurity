package kr.co.iotree.sanghproject.controller;

import kr.co.iotree.sanghproject.service.UserService;
import kr.co.iotree.sanghproject.util.SessionConst;
import kr.co.iotree.sanghproject.util.UserRepository;
import kr.co.iotree.sanghproject.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;

    // 전체 유저 리스트
    @GetMapping("/userList")
    public String userList(Model model) {

        List<UserVo> userList = userService.getUserList();
        model.addAttribute("user", userList);
        return "userList";
    }

}
