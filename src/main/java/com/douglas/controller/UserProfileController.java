package com.douglas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.douglas.enums.BancoType;
import com.douglas.manager.user.DefaultUserManager;
import com.douglas.model.InvoiceCycleModel;
import com.douglas.repository.InvoiceCycleRepository;
import com.douglas.service.UserProfileService;

@Controller
@RequestMapping("Perfil")
public class UserProfileController {

    @Autowired
    InvoiceCycleRepository invoiceCycleRepository;
    @Autowired
    DefaultUserManager defaultUserManager;
    @Autowired
    UserProfileService userProfileService;

    @GetMapping("")
    public ModelAndView loadUserProfileView() {
        return loadUserProfileNewCycle();
    }

    public ModelAndView loadUserProfileNewCycle() {
        ModelAndView model = new ModelAndView("userProfileView");
        model.addObject("cycle", userProfileService.findOneByUserId());
        model.addObject("bankEnum", BancoType.values());
        return model;
    }

    @PostMapping("/Salvar")
    public String saveCycle(@Validated InvoiceCycleModel cycleModel) {
        userProfileService.saveNewCycleModel(cycleModel);
        return "redirect:/Perfil";
    }

}
