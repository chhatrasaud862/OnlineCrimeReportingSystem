package com.bca.ocrms.controller.user.complain;

import com.bca.ocrms.dto.user.ComplainDto;
import com.bca.ocrms.service.impl.user.ComplainServiceImpl;
import com.bca.ocrms.service.impl.user.RegisterServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @GetMapping("/view/{id}")
    public String viewComplain(@PathVariable("id")Integer id,Model model)
    {
        model.addAttribute("complainView",complainService.findById(id));
        return "user/viewComplain";
    }
    @GetMapping("/update/{id}")
    public String updateComplain(@PathVariable ("id") Integer id,Model model,
                                 RedirectAttributes redirectAttributes)
    {
        ComplainDto complainDto=complainService.findById(id);
        model.addAttribute("complainDto",complainDto);
        return "user/complainUpdatePage";
    }
    @PostMapping("/update")
    public String updateComplain(@Valid @ModelAttribute ComplainDto complainDto,
                                 BindingResult bindingResult, Model model)
    {
        if(!bindingResult.hasErrors()) {
                try {
                    complainDto = complainService.updateComplain(complainDto);
                    model.addAttribute("message", "Complain update Successfully");
                } catch (Exception e) {
                    model.addAttribute("message", "Complain update  failed");
                    e.printStackTrace();
                }
            }
            model.addAttribute("complainDto", complainDto);
            return "user/complainUpdatePage";
    }
}
