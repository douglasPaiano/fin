package com.douglas.repository;

import org.springframework.stereotype.Repository;

import com.douglas.model.UsuarioModel;

@Repository
public class UsuarioRepository extends BaseJPA<UsuarioModel, Integer>{

    public UsuarioRepository() {
        super(UsuarioModel.class);
    }

    

}
