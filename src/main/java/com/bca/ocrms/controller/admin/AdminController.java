package com.bca.ocrms.controller.admin;

import com.bca.ocrms.components.AuthorizeUser;
import com.bca.ocrms.dto.user.ComplainDto;
import com.bca.ocrms.enums.ComplainStatus;
import com.bca.ocrms.service.impl.user.ComplainServiceImpl;
import com.bca.ocrms.service.impl.user.RegisterServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;
import java.util.TreeMap;

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
    public String showCrime(Model model) throws IOException
    {
        model.addAttribute("complainList",complainService.findAllComplain());
        model.addAttribute("registerList",registerService.findAll());
        return "admin/viewComplain";
    }

    @GetMapping("/approve/{id}")
    public String verifyPage(@PathVariable("id")Integer id) throws ParseException {
      ComplainDto complainDto=complainService.findById(id);
      complainDto.setComplainStatus(ComplainStatus.APPROVE);
      complainService.save(complainDto);
       return "redirect:/admin/show";
    }
    @GetMapping("/report")
    public String CrimeReport(Model model)
    {
        Map<String, Integer> graphData = new TreeMap<>();
        graphData.put("Totoal Complain",complainService.getTotalComplain());
        graphData.put("Pending Complain",complainService.getTotalPending());
        graphData.put("Complete Complain",complainService.getTotalApprove());
        model.addAttribute("chartData", graphData);
        return "admin/viewReport";
    }
    @GetMapping("/delete/{id}")
    public String deleteComplain(@PathVariable("id")Integer id,Model model)
    {
        complainService.deleteById(id);
        return "redirect:/admin/show";
    }
    @GetMapping("/view/{id}")
    public String userView(@PathVariable("id")Integer id,Model model) throws IOException
    {
        model.addAttribute("complainList",complainService.findAllComplain());
        model.addAttribute("registerList",registerService.findAll());
        return "admin/viewComplain";
    }
 /*   @GetMapping("/details/{id}")
    public String userDetail(@PathVariable("id")Integer id,Model model) throws IOException
    {
        model.addAttribute("complainView",complainService.findById(id));
        model.addAttribute("registerView",registerService.findById(id));
        return "admin/userDetails";
    }*/
   /* @PutMapping("/updateStatus/{id}")
    public void updateStatus(@PathVariable("id") Integer id){
        complainService.updateStatus(id);

    }*/

}
