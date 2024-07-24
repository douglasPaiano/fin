package com.douglas.repository;

import org.springframework.stereotype.Repository;

import com.douglas.model.ContaModel;

@Repository
public class ContaRepository extends BaseJPA<ContaModel, Integer>{

    public ContaRepository() {
        super(ContaModel.class);
    }

}
