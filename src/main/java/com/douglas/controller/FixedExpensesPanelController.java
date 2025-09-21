package com.douglas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.douglas.enums.EstadoType;
import com.douglas.enums.TipoGastoType;
import com.douglas.manager.user.DefaultUserManager;
import com.douglas.model.FixedExpensesModel;
import com.douglas.repository.FixedExpensesRepository;

@Controller
@RequestMapping("GastoFixo")
public class FixedExpensesPanelController {

    @Autowired
    private FixedExpensesRepository fixedExpensesRepository;
    @Autowired
    private DefaultUserManager defaultUserManager;

    @PostMapping("Cadastrar")
    public ModelAndView loadRegister(@Validated FixedExpensesModel fixedExpensesNew) {
        fixedExpensesNew.setEstado(EstadoType.SIM);
        fixedExpensesNew.setUsuario(defaultUserManager.getUserByUsername());
        fixedExpensesRepository.save(fixedExpensesNew);
        return loadList();
    }

    @GetMapping("")
    public ModelAndView loadList() {
        ModelAndView model = new ModelAndView("fixedExpensesPanelView");
        model.addObject("fixedExpenses",
                fixedExpensesRepository.FindAllByUserId(defaultUserManager.getUserByUsername()));
        model.addObject("fixedExpensesNew", new FixedExpensesModel());
        model.addObject("tipoGastoEnum", TipoGastoType.values());
        return model;
    }

}
