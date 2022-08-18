package kr.co.iotree.sanghproject.controller;

import kr.co.iotree.sanghproject.service.UserService;
import kr.co.iotree.sanghproject.util.UserRepository;
import kr.co.iotree.sanghproject.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final UserRepository userRepository;

    @GetMapping("/signup")
    public String addForm(@ModelAttribute("user") UserVo userVo) {
        return "signup";
    }

    //BindingResult : 검증 오류가 발생할 경우 오류 내용을 보관하는 스프링 프레임워크에서 제공하는 객체.
    //@ModelAttribute에 데이터 바인딩 시 오류가 발생해도 오류 정보를 FieldError 개체를 BindingResult가 담은 뒤 컨트롤러가 호출
    @PostMapping("/signup")
    public String save(@ModelAttribute UserVo userVo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user";
        }

        userRepository.save(userVo);

        return "user";
    }

    // 회원 상세 페이지
    @GetMapping("/user")
    public String userInfo(@ModelAttribute UserVo userVo, HttpSession session, Model model) {
        List<UserVo> userInfo = userService.getUserById(userVo.getId());
        model.addAttribute("user",userInfo);
        return "user";
    }

    // 회원 정보 수정 페이지 요청
    @GetMapping("/user/modify")
    public String modifyFormUser() {
        return "user_modify";
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
        return "user";
    }

//    // 회원 가입 화면 요청
//    @GetMapping("/signup")
//    public String singUpForm() {
//        return "signup";
//    }

//    // 회원 가입 요청
//    @PostMapping("/signup")
//    public String signUp(@ModelAttribute UserVo userVo, HttpSession session) {
//       userService.insertUser(userVo);
//       session.setAttribute("userInfo",userVo.getId());
//       return "user";
//    }
}
