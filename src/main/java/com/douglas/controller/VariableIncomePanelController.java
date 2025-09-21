package com.douglas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.douglas.model.VariableIncomeModel;
import com.douglas.service.VariableIncomeService;



@Controller
@RequestMapping("ReceitaVariavel")
public class VariableIncomePanelController {

    @Autowired
    private VariableIncomeService variableIncomePanelService;
    
    @GetMapping("/Cadastro")
    public ModelAndView variableIncomeRegisterLoad() {
        ModelAndView model = new ModelAndView("variableIncomeRegisterView");
        model.addObject("variableIncome", new VariableIncomeModel());
        return model;
    }

    @PostMapping("/Cadastrar")
    public String variableIncomeRegisterSave(@Validated VariableIncomeModel variableIncome) {
        variableIncomePanelService.saveVariableIncome(variableIncome);
        return "redirect:/ReceitaVariavel/Lista";
    }
    
    @GetMapping("/Lista")
    public ModelAndView listAllVariableIncome() {
        ModelAndView model = new ModelAndView("variableIncomePanelView");
        model.addObject("variableIncome", variableIncomePanelService.listAllVariableIncome());
        return model;
    }
    
}
