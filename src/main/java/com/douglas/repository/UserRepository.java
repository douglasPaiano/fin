package com.douglas.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.douglas.model.UserModel;

@Repository
public class UserRepository extends BaseJPA<UserModel, Integer> {

    public UserRepository() {
        super(UserModel.class);
    }

    public UserModel FindByUsername(String username) {

        List<UserModel> allUsers = findAll();

        List<UserModel> filteredUser = allUsers.stream().filter(x -> x.getUsuario().equals(username))
                .collect(Collectors.toList());

        return filteredUser.get(0);
    }

    public String getLoggedUsername() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName().toString();

        return username;
    }

    @EntityGraph(value = "userWithFixedIncome", type = EntityGraph.EntityGraphType.LOAD)
    public UserModel userWithFixedIncome(UserModel user){

        Optional<UserModel> filteredUser = findAll().stream().filter(filterUser -> filterUser.getId().equals(user.getId())).findFirst();

        return filteredUser.get();
    }

}
