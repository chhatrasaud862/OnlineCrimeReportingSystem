package com.bca.ocrms.controller.register;

import com.bca.ocrms.dto.admin.AdminRegisterDto;
import com.bca.ocrms.service.impl.admin.AdminRegisterServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @author CHHATRA SAUD
 * @product IntelliJ IDEA
 * @project ocrms
 * @Date 2022-04-08
 */
@Controller
@RequestMapping("/adminRegister")
public class AdminRegisterController {
    private final AdminRegisterServiceImpl adminRegisterService;

    public AdminRegisterController(AdminRegisterServiceImpl adminRegisterService) {
        this.adminRegisterService = adminRegisterService;
    }

    @GetMapping
    public String openAdminPage(Model model)
    {
        model.addAttribute("adminRegisterDto",new AdminRegisterDto());
        return "admin/adminRegisterPage";
    }
    @PostMapping("/create")
    public String createAdmin(@Valid @ModelAttribute AdminRegisterDto adminRegisterDto,
                              BindingResult bindingResult, Model model)
    {
        if (!bindingResult.hasErrors()) {
            try {
                adminRegisterDto= adminRegisterService.save(adminRegisterDto);
                model.addAttribute("message","Admin register successfully added!");
            } catch (Exception e) {
                model.addAttribute("message","Admin register failed added!!");
                e.printStackTrace();
            }
        }
        model.addAttribute("adminRegisterDto",adminRegisterDto);
       return "admin/adminRegisterPage";
    }
}
