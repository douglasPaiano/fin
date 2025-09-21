package com.douglas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.douglas.service.BillService;


@Controller
@RequestMapping("Bills")
public class billsPanelController {
    
    @Autowired
    private BillService billService;

    @GetMapping("")
    public ModelAndView loadAllbill() {
        ModelAndView model = new ModelAndView("billsPanelView");
        
        model.addObject("bills", billService.findAllBillsByUserId());

        return model;
    }
    

}
