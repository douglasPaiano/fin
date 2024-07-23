package com.douglas.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.douglas.model.UsuarioModel;
import com.douglas.service.UsuarioService;

@Controller
public class UsuarioController implements Serializable{

    private UsuarioModel usuario;
    private List<UsuarioModel> usuarios;

    @Autowired
    private UsuarioService usuarioService;

    public void init(){
        usuario = new UsuarioModel();
        usuario = usuarioService.findById(1);
    }

}
