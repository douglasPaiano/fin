package com.douglas.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.douglas.model.BillModel;
import com.douglas.model.UserModel;

@Repository
public class BillRepository extends BaseJPA<BillModel, Integer> {

    public BillRepository() {
        super(BillModel.class);
    }

    public List<BillModel> findAllByUserId(UserModel user) {
        List<BillModel> bills = findAll().stream()
                .filter(billFilter -> billFilter.getUsuario().getId().equals(user.getId()))
                .collect(Collectors.toList());
        return bills;
    }

}
