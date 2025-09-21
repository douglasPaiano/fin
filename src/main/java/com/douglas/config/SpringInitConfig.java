package com.douglas.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override // padrão
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {RootConfig.class};
    }

    @Override // padrão
    protected Class<?>[] getServletConfigClasses() {

     return new Class[] {SpringMvcConfig.class};
    }   

    @Override // padrão
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
    
}
