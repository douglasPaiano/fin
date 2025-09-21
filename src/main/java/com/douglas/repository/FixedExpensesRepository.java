package com.douglas.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.douglas.model.FixedExpensesModel;
import com.douglas.model.UserModel;

@Repository
public class FixedExpensesRepository extends BaseJPA<FixedExpensesModel, String> {

    public FixedExpensesRepository() {
        super(FixedExpensesModel.class);

    }

    public List<FixedExpensesModel> FindAllByUserId(UserModel user) {

        List<FixedExpensesModel> filteredByUserId = findAll().stream()
                .filter(fixedExpenses -> fixedExpenses.getUsuario().getId().equals(user.getId()))
                .collect(Collectors.toList());

        return filteredByUserId;
    }
}
