package com.douglas.manager.user;

import com.douglas.model.UserModel;

public interface UserManager {
    
    String getLoggedUsername();
    UserModel getUserByUsername();
}
