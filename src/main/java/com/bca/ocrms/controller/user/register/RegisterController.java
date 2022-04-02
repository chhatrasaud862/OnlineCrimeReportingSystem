package com.bca.ocrms.controller.user.register;

import com.bca.ocrms.dto.user.RegisterDto;
import com.bca.ocrms.service.impl.user.RegisterServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/registration")
public class RegisterController {
    private final RegisterServiceImpl registerService;
    public RegisterController(RegisterServiceImpl registerService) {
        this.registerService= registerService;
    }
    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("registerDto", new RegisterDto());

        return "user/registration";
    }
    @PostMapping
    public String createPage(@Valid @ModelAttribute RegisterDto registerDto,
                             BindingResult bindingResult, Model model)
    {
        //check the binding result
        if (!bindingResult.hasErrors()) {
            try {
                //save the database
                registerDto=registerService.save(registerDto);
                model.addAttribute("message","register successfully added");
            } catch (Exception e) {
                model.addAttribute("message","register failed added!!try again ?");
                e.printStackTrace();
            }
        }
        model.addAttribute("registerDto",registerDto);
        //return
//        return "redirect:/registration?success";
        return "user/registration";
    }

}
