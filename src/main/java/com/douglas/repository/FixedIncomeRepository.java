package com.douglas.repository;

import org.springframework.stereotype.Repository;

import com.douglas.model.FixedIncomeModel;

@Repository
public class FixedIncomeRepository extends BaseJPA<FixedIncomeModel, Integer> {

    public FixedIncomeRepository() {
        super(FixedIncomeModel.class);
    }

}
