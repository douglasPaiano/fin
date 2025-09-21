package com.douglas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.douglas.service.StarterMenuService;




@Controller
@RequestMapping("Inicio")
public class StarterMenuController {

    @Autowired
    private StarterMenuService starterMenuService;

    @GetMapping("")
    public String carrega() {

        if (!starterMenuService.verifyInvoiceCycleNotIsNull()) {
            return "redirect:/Perfil";
        } else {
            return "redirect:/Inicio/menu";
        }

    }

    @GetMapping("/Perfil")
    public String redirectProfile() {
        return "redirect:/Perfil";
    }

    @GetMapping("/menu")
    public ModelAndView listAllVariables() {
        ModelAndView model = new ModelAndView("starterMenuView");

        model.addObject("variableIncome", starterMenuService.variableIncomeLastFive());
        model.addObject("periodSum", starterMenuService.variableIncomePeriodSum());

        model.addObject("fixedExpenses", starterMenuService.fixesExpensesTopFiveExpenses());

        model.addObject("debit", starterMenuService.debitList());
        
        model.addObject("bill", starterMenuService.fillBillPanel());

        return model;
    }

    @GetMapping("/ReceitaVariavel/Cadastro")
    public String redirectVariableIncomeRegister() {
        return "redirect:/ReceitaVariavel/Cadastro";
    }

    @GetMapping("/ReceitaVariavel/Lista")
    public String redirectVariableIncomeList() {
        return "redirect:/ReceitaVariavel/Lista";
    }

    @GetMapping("/GastoFixo")
    public String redirectFixedExpensesList() {
        return "redirect:/GastoFixo";
    }

    @GetMapping("/Debito")
    public String redirectDebit() {
        return "redirect:/Debito";
    }
    @GetMapping("/Bills")
    public String redirectBills() {
        return "redirect:/Bills";
    }
    

}
