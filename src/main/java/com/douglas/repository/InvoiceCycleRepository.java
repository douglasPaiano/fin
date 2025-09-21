package com.douglas.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.douglas.model.InvoiceCycleModel;
import com.douglas.model.UserModel;

@Repository
public class InvoiceCycleRepository extends BaseJPA<InvoiceCycleModel, Integer> {

    public InvoiceCycleRepository() {
        super(InvoiceCycleModel.class);
    }

    public Boolean cycleIsTrue(UserModel user){
        
        List<InvoiceCycleModel> allInvoices = findAll();

        Boolean test = allInvoices.stream().anyMatch(x -> x.getUser().getId().equals(user.getId()));

        return test;
    }

    public List<InvoiceCycleModel> findAllById(UserModel user){

        List<InvoiceCycleModel> allInvoices = findAll().stream().filter(invoice -> invoice.getUser().getId().equals(user.getId())).toList();

        return allInvoices;
    }

    public InvoiceCycleModel findOneByUserId(UserModel user){

        InvoiceCycleModel invoiceCycleModel = findAll().stream().filter(invoice -> invoice.getUser().getId().equals(user.getId())).findFirst().get();

        return invoiceCycleModel;
    }

    public InvoiceCycleModel findOneByCycleId(Integer id){

        InvoiceCycleModel cycle = findAll().stream().filter(invoice -> invoice.getId().equals(id)).findFirst().get();

        return cycle;
    }

}
