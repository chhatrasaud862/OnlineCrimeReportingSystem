package com.bca.ocrms.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping
    public String openUserHomePage()
    {
        return "user/userLandingPage";
    }
    @GetMapping("/home")
    public String openHomePage()
    {
        return "homePage";
    }
    @GetMapping("/login")
    public String openLogin()
    {
        return "user/loginUser";
    }
}
