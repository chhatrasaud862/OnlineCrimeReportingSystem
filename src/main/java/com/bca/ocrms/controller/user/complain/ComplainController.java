package com.bca.ocrms.controller.user.complain;

import com.bca.ocrms.dto.user.ComplainDto;
import com.bca.ocrms.service.impl.user.ComplainServiceImpl;
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
@RequestMapping("/complain")
public class ComplainController {
    private final ComplainServiceImpl complainService;
    private final RegisterServiceImpl registerService;

    public ComplainController(ComplainServiceImpl complainService, RegisterServiceImpl registerService) {
        this.complainService = complainService;
        this.registerService = registerService;
    }

    @GetMapping("/home")
    public String openHome(Model model)
    {
        model.addAttribute("complainDto",new ComplainDto());
        model.addAttribute("complainList",complainService.findAll());
//        model.addAttribute("userName",registerService.findAll());
        return "user/complainHome";
    }
    @GetMapping("/page")
    public String complainPage(Model model)
    {
        model.addAttribute("complainDto",new ComplainDto());
        return "user/complainPage";
    }
    @PostMapping("/create")
    public String createComplain(@Valid @ModelAttribute ComplainDto complainDto,
                                 BindingResult bindingResult, Model model)
    {
        if(!bindingResult.hasErrors()) {
            try {
                complainDto = complainService.save(complainDto);
                model.addAttribute("message", "Complain successfully added");
            } catch (Exception e) {
                model.addAttribute("message", "Complain failed added");
                e.printStackTrace();
            }
        }
        model.addAttribute("complainDto",complainDto);
        return "user/complainPage";
    }
}
