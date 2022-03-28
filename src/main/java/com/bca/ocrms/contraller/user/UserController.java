package com.bca.ocrms.contraller.user;

import com.bca.ocrms.dto.UserDto;
import com.bca.ocrms.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String openLogin() {
        return "user/loginUser";
    }

    @GetMapping("/register")
    public String openRegister(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "user/registration";
    }

    @PostMapping("/create")
    public String openUserCreate(@ModelAttribute UserDto userDto,Model model) {
        try {
            userDto = userService.saveUser(userDto);
            model.addAttribute("message","Register successfully added");
        } catch (Exception e) {
            model.addAttribute("message","register failed!! Try again");
            e.printStackTrace();
            return "redirect:/user/register";
        }
        return "redirect:/user/register";
    }
}