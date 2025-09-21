package com.douglas.repository;

import org.springframework.stereotype.Repository;

import com.douglas.model.DebitModel;

@Repository
public class DebitRepository extends BaseJPA<DebitModel, Integer>{

    public DebitRepository() {
        super(DebitModel.class);
    }

}
