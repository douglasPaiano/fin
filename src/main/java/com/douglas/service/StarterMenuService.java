package com.douglas.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.douglas.manager.user.DefaultUserManager;
import com.douglas.model.BillModel;
import com.douglas.model.DebitModel;
import com.douglas.model.FixedExpensesModel;
import com.douglas.model.UserModel;
import com.douglas.model.VariableIncomeModel;
import com.douglas.repository.DebitRepository;
import com.douglas.repository.FixedExpensesRepository;
import com.douglas.repository.InvoiceCycleRepository;
import com.douglas.repository.VariableIncomeRepository;
import com.douglas.utils.DateUtils;

@Service
public class StarterMenuService {

    @Autowired
    private VariableIncomeRepository variableIncomeRepository;
    @Autowired
    private DefaultUserManager defaultUserManager;
    @Autowired
    private InvoiceCycleRepository invoiceCycleRepository;
    @Autowired
    private FixedExpensesRepository fixedExpensesRepository;
    @Autowired
    private DebitRepository debitRepository;

    @Autowired
    private BillService billService;
    @Autowired
    private DateUtils dateUtils;

    StarterMenuService(BillService billService) {
        this.billService = billService;
    }

    public ModelAndView variableIncomeGetAll() {
        ModelMap model = new ModelMap();

        model.addAttribute("variableIncome",
                variableIncomeRepository.FindAllById(defaultUserManager.getUserByUsername()));
        model.addAttribute("loggedUser", defaultUserManager.getLoggedUsername());
        return new ModelAndView("starterMenuView", model);
    }

    public Boolean verifyInvoiceCycleNotIsNull() {

        return invoiceCycleRepository.cycleIsTrue(defaultUserManager.getUserByUsername());

    }

    public BigDecimal variableIncomePeriodSum() {

        List<LocalDate> list = dateUtils.startEndDate();

        List<VariableIncomeModel> allVariableIncome = variableIncomeRepository
                .FindAllById(invoiceCycleRepository.findOneByUserId(defaultUserManager.getUserByUsername()).getUser());

        List<VariableIncomeModel> filterAllVariableIncome = allVariableIncome.stream()
                .filter(dateRegister -> dateRegister.getDataEntrada().isAfter(list.get(0))
                        && dateRegister.getDataEntrada().isBefore(list.get(1)))
                .toList();

        BigDecimal totalSum = filterAllVariableIncome.stream().map(VariableIncomeModel::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalSum;
    }

    public List<VariableIncomeModel> variableIncomeLastFive() {

        List<LocalDate> list = dateUtils.startEndDate();

        List<VariableIncomeModel> variableIncome = variableIncomeRepository
                .FindAllById(defaultUserManager.getUserByUsername()).stream()
                .filter(dateRegister -> dateRegister.getDataEntrada().isAfter(list.get(0))
                        && dateRegister.getDataEntrada().isBefore(list.get(1)))
                .toList();

        List<VariableIncomeModel> lastFive = new ArrayList<>();

        if (variableIncome.size() < 5) {

            return variableIncome;

        } else {

            for (int i = 1; i < 6; i++) {
                lastFive.add(variableIncome.get(variableIncome.size() - i));
            } // trocar para o stream.skip no futuro

            return lastFive;

        }
    }

    public List<FixedExpensesModel> fixesExpensesTopFiveExpenses() {

        List<FixedExpensesModel> topFive = fixedExpensesRepository
                .FindAllByUserId(defaultUserManager.getUserByUsername());

        topFive.sort(Comparator.comparing(FixedExpensesModel::getValor).reversed());

        return topFive;
    }

    public List<DebitModel> debitList() {
        List<DebitModel> debitList = debitRepository.findAll();

        return debitList;
    }

    public BillModel fillBillPanel() {

        UserModel userLogged = defaultUserManager.getUserByUsername();

        if (billService.verifyFiscalDate(userLogged) == false) {

            billService.saveBill(userLogged);
            return billService.findCurrentBill(userLogged);
        } else {
            return billService.findCurrentBill(userLogged);
        }

    }

}
