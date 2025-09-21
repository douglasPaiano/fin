package com.douglas.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.enums.CompraType;
import com.douglas.enums.MesFiscalType;
import com.douglas.manager.user.DefaultUserManager;
import com.douglas.model.BillModel;
import com.douglas.model.DebitModel;
import com.douglas.model.FixedExpensesModel;
import com.douglas.model.UserModel;
import com.douglas.model.VariableIncomeModel;
import com.douglas.repository.BillRepository;
import com.douglas.repository.DebitRepository;
import com.douglas.repository.FixedExpensesRepository;
import com.douglas.repository.UserRepository;
import com.douglas.repository.VariableIncomeRepository;
import com.douglas.utils.DateUtils;

@Service
public class BillService {

    @Autowired
    private DefaultUserManager defaultUserManager;
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private FixedExpensesRepository fixedExpensesRepository;
    @Autowired
    private DebitRepository debitRepository;
    @Autowired
    private VariableIncomeRepository variableIncomeRepository;
    @Autowired
    private UserRepository userRepository;

    public Boolean verifyFiscalDate(UserModel user) {

        List<BillModel> allBillsForUserId = billRepository.findAllByUserId(user);

        if (allBillsForUserId.size() != 0) {
            return true;
        } else {
            return false;

        }
    }

    public void saveBill(UserModel user) {
        BillModel bill = new BillModel();
        bill.setUsuario(user);
        bill.setMesFiscal(MesFiscalType.fromId(String.valueOf(findCurrentDate())));
        ///////////////////////////////////
        // adicionar o id do ciclo no bill//
        ///////////////////////////////////

        billRepository.save(bill);

    }

    public Integer findCurrentDate() {
        LocalDate currentDate = DateUtils.currentDate();

        Integer date = null;

        if (currentDate.getDayOfMonth() >= 13) {
            date = currentDate.getMonthValue();
        } else if (currentDate.getDayOfMonth() < 13) {
            date = (currentDate.getMonthValue() + 1);
        } else {

        }
        return date;
    }

    public BillModel findCurrentBill(UserModel user) {


        Optional<BillModel> currentBill = billRepository.findAllByUserId(user).stream()
                .filter(x -> x.getMesFiscal().getId().equals(String.valueOf(findCurrentDate()))).findFirst();

        currentBill.get().setGastoFixo(fixedExpensesRepository.findAll().stream().map(FixedExpensesModel::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add));
        currentBill.get()
                .setGastoProprio(debitRepository.findAll().stream()
                        .filter(debit -> debit.getTipoCompra().getNome().equals(CompraType.PROPRIA.getNome()))
                        .map(DebitModel::getValor).reduce(BigDecimal.ZERO, BigDecimal::add));
        currentBill.get()
                .setGastoTerceiros(debitRepository.findAll().stream()
                        .filter(debit -> debit.getTipoCompra().getNome().equals(CompraType.TERCEIROS.getNome()))
                        .map(DebitModel::getValor).reduce(BigDecimal.ZERO, BigDecimal::add));
        currentBill.get().setGastoVariavel(
                debitRepository.findAll().stream().map(DebitModel::getValor).reduce(BigDecimal.ZERO, BigDecimal::add));
        currentBill.get().setGastoTotal(currentBill.get().getGastoFixo().add(currentBill.get().getGastoVariavel()));

        currentBill.get().setReceitaFixa(
                userRepository.FindByUsername(defaultUserManager.getLoggedUsername()).getFixedIncome().getIncome());
        currentBill.get().setReceitaVariavel(variableIncomeRepository.findAll().stream()
                .map(VariableIncomeModel::getValor).reduce(BigDecimal.ZERO, BigDecimal::add));
        currentBill.get()
                .setReceitaTotalMes(userRepository.userWithFixedIncome(user).getFixedIncome().getIncome().add(currentBill.get().getReceitaVariavel()));


        billRepository.save(currentBill.get());
        return currentBill.get();
    }

    public List<BillModel> findAllBillsByUserId(){

        List<BillModel> allBills = billRepository.findAllByUserId(defaultUserManager.getUserByUsername());

        return allBills;
    }

}
