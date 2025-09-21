package com.douglas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.douglas.model.UserModel;
import com.douglas.service.CadastroService;


@Controller
@RequestMapping("cadastro")
public class UserRegisterController {

    @Autowired
    private CadastroService cadastroService;
    
    @GetMapping("")
    public ModelAndView carregaPaginaCadastro() {
        ModelAndView model = new ModelAndView("cadastroView");
        model.addObject("usuarioModel", new UserModel());
        return model;
    }
    

    @PostMapping("/cadastrar")
    public ModelAndView cadastrarUsuario(@RequestParam(name = "confirmaSenha") String confirmaSenha,@RequestParam(name = "senha") String senha, @Validated UserModel usuario) {
       
        ModelAndView model = cadastroService.inserirUsuario(usuario, senha, confirmaSenha);
       
        return model;
    }
    
}
