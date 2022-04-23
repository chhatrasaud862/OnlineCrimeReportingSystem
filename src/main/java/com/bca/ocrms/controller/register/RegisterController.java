package com.bca.ocrms.controller.register;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author CHHATRA SAUD
 * @product IntelliJ IDEA
 * @project ocrms
 * @Date 2022-04-08
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
    @GetMapping
    public String openRegisterPage()
    {
        return "registerPage";
    }
}
