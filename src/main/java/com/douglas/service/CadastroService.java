package com.douglas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.douglas.model.UserModel;
import com.douglas.repository.UserRepository;
import com.douglas.utils.DateUtils;

@Service
public class CadastroService {

    @Autowired
    private UserRepository usuarioRepository;

    @Autowired
    private UserDetailsManager userDetailsManager;

    public ModelAndView inserirUsuario(UserModel usuario, String senha, String confirmaSenha) {

        if (usuario.getId() == null) {
            usuario.setDataCadastro(DateUtils.currentDate());
        }

        UserDetails user = User.builder().username(usuario.getUsuario()).password(passwordEncoder().encode(senha))
                .roles("USER").build();
        {

            userDetailsManager.createUser(user);
            usuarioRepository.save(usuario);

            return new ModelAndView("redirect:/cadastro");
        }

    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
