package com.douglas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.douglas.DTO.DebitDTO;
import com.douglas.enums.CompraType;
import com.douglas.enums.PagamentoType;
import com.douglas.model.DebitModel;
import com.douglas.service.DebitService;



@Controller
@RequestMapping("Debito")
public class DebitPanelController {

    @Autowired
    private DebitService debitPanelService;

    @GetMapping("")
    public ModelAndView LoadList() {
        ModelAndView model = new ModelAndView("debitPanelView");
        model.addObject("newDebit", new DebitModel());
        model.addObject("debit", debitPanelService.debitList());
        model.addObject("buyType", CompraType.values());
        model.addObject("paymentType", PagamentoType.values());
        model.addObject("allUserCycle", debitPanelService.allCycleByUser());

        return model;
    }

    @PostMapping("/Cadastro")
    public String saveDebit(@ModelAttribute DebitDTO dto) {
        
        return debitPanelService.saveDebit(dto);
    }
    
    
}
