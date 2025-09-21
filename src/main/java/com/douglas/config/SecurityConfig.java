package com.douglas.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.core.userdetails.User;

@Configuration
public class SecurityConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authz) -> authz
                .requestMatchers("/login", "/home","/css/**","/js/**","/imagens/**","/cadastro","/cadastro/cadastrar").permitAll() // Permite acesso a determinados locais
                .anyRequest().authenticated() // Protege todas as outras rotas
        )
                .formLogin(form -> form
                        .loginPage("/home/login")
                        .loginProcessingUrl("/login") // Define a página de login customizada
                        .defaultSuccessUrl("/Inicio", true) // Redireciona após login bem-sucedido
                        .permitAll())
                .logout(logout -> logout
                        .permitAll())
                .userDetailsService(users(dataSource));

        // http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS));

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/teste");
    }

    @Bean
    public UserDetailsManager users(DataSource dataSource) {
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        //UserDetails u = User.builder().username("user").password(passwordEncoder().encode("1234")).roles("USER").build();
        // users.createUser(u);
        return users;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
/* User.builder().username("user").password("teste").roles("USER").build(); */