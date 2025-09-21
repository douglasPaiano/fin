package com.douglas.manager.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.douglas.model.UserModel;
import com.douglas.repository.UserRepository;

@Component
public class DefaultUserManager implements UserManager {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String getLoggedUsername() {
        
        return userRepository.getLoggedUsername();
    }

    @Override
    public UserModel getUserByUsername() {
       
        return userRepository.FindByUsername(getLoggedUsername());
    }


    
}
