package com.douglas.repository;

import org.springframework.stereotype.Repository;

import com.douglas.model.CicloFaturaModel;

@Repository
public class CicloFaturaRepository extends BaseJPA<CicloFaturaModel, Integer> {

    public CicloFaturaRepository() {
        super(CicloFaturaModel.class);
    }

}
