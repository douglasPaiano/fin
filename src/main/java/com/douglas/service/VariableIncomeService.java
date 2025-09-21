package com.douglas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.manager.user.DefaultUserManager;
import com.douglas.model.VariableIncomeModel;
import com.douglas.repository.VariableIncomeRepository;

@Service
public class VariableIncomeService {
    
    @Autowired
    private VariableIncomeRepository variableIncomeRepository;
    @Autowired
    private DefaultUserManager defaultUserManager;
  
    public void saveVariableIncome(VariableIncomeModel variableIncome){
        variableIncome.setIdUsuario(defaultUserManager.getUserByUsername()); 
        variableIncomeRepository.save(variableIncome);
    }

    public List<VariableIncomeModel> listAllVariableIncome(){
        
        return variableIncomeRepository.findAll().stream().filter(variable -> variable.getIdUsuario().getId().equals(defaultUserManager.getUserByUsername().getId())).collect(Collectors.toList());
    }

    

}
