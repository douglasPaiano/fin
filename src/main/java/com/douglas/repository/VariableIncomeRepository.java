package com.douglas.repository;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.douglas.model.UserModel;
import com.douglas.model.VariableIncomeModel;

@Repository
public class VariableIncomeRepository extends BaseJPA<VariableIncomeModel,String> {

    public VariableIncomeRepository() {
        super(VariableIncomeModel.class);
    }


    public List<VariableIncomeModel> FindAllById(UserModel user){

        List<VariableIncomeModel> allVariableIncome = findAll();

        List<VariableIncomeModel> filteredAllVariableIncome = allVariableIncome.stream().filter(x -> x.getIdUsuario().getId().equals(user.getId())).collect(Collectors.toList());

        return filteredAllVariableIncome;
    }
}
