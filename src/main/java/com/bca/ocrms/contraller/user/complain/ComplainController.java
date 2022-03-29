package com.bca.ocrms.contraller.user.complain;

import com.bca.ocrms.dto.user.ComplainDto;
import com.bca.ocrms.service.impl.user.ComplainServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/complain")
public class ComplainController {
    private final ComplainServiceImpl complainService;

    public ComplainController(ComplainServiceImpl complainService) {
        this.complainService = complainService;
    }

    @GetMapping("/home")
    public String openHome(Model model)
    {
        model.addAttribute("complainDto",new ComplainDto());
        model.addAttribute("complainList",complainService.findAll());
        return "user/complain";
    }
    @GetMapping("/page")
    public String complainPage(Model model)
    {
        model.addAttribute("complainDto",new ComplainDto());
        return "user/complain";
    }
    @PostMapping("/create")
    public String createComplain(@ModelAttribute ComplainDto complainDto,
                                 Model model)
    {
        try{
            complainDto=complainService.save(complainDto);
        }catch (Exception e)
        {
            e.printStackTrace();
            return "user/complain";
        }
        return "user/complain";
    }
}
