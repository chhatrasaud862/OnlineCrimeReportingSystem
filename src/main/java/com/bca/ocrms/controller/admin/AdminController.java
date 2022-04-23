package com.bca.ocrms.controller.admin;

import com.bca.ocrms.dto.user.ComplainDto;
import com.bca.ocrms.enums.ComplainStatus;
import com.bca.ocrms.service.impl.user.ComplainServiceImpl;
import com.bca.ocrms.service.impl.user.RegisterServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final RegisterServiceImpl registerService;
    private final ComplainServiceImpl complainService;

    public AdminController(RegisterServiceImpl registerService, ComplainServiceImpl complainService) {
        this.registerService = registerService;
        this.complainService = complainService;
    }

    @GetMapping("/home")
    public String openLoginPage()
    {
      return "admin/adminRegisterPage";
    }
    @GetMapping("/show")
    public String showCrime(Model model)
    {
        model.addAttribute("complainList",complainService.findAllComplain());
        model.addAttribute("registerList",registerService.findAll());
        return "admin/viewComplain";
    }

    @GetMapping("/verify/{id}")
    public String verifyPage(@PathVariable("id")Integer id) throws ParseException {
       ComplainDto complainDto= complainService.findById(id);
       complainDto.setComplainStatus(ComplainStatus.VERIFY);
       complainService.save(complainDto);
       return "redirect:/admin/show";
    }
    @GetMapping("/report")
    public String CrimeReport()
    {
        return "admin/viewReport";
    }

}
