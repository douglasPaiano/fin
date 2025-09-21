
package com.douglas.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration // padrão
@ComponentScan("br.douglas.fin") // define qual o caminho será analisado
@EnableWebMvc // padrão
public class RootConfig {
    
}
