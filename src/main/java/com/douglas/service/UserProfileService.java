package com.douglas.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.manager.user.DefaultUserManager;
import com.douglas.model.InvoiceCycleModel;
import com.douglas.repository.InvoiceCycleRepository;

@Service
public class UserProfileService {
    
    @Autowired
    private InvoiceCycleRepository invoiceCycleRepository;
    @Autowired
    private DefaultUserManager defaultUserManager;

    public InvoiceCycleModel findOneByUserId(){

        InvoiceCycleModel invoiceCycle = null;

        try {
        
            invoiceCycle = invoiceCycleRepository.findOneByUserId(defaultUserManager.getUserByUsername());

        } catch (NoSuchElementException e) {
            
        }

        if (invoiceCycle == null) {
            
            return new InvoiceCycleModel();
        }else{
            return invoiceCycle;
        }

    }


    //adicinar return para verificar o status da operacao
    public void saveNewCycleModel(InvoiceCycleModel cycleModel){
        cycleModel.setUser(defaultUserManager.getUserByUsername());
        invoiceCycleRepository.save(cycleModel);
    }
}
