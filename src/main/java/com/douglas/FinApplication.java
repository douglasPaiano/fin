package com.douglas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.douglas.service.CicloFaturaService;

@SpringBootApplication
public class FinApplication implements CommandLineRunner{

 @Autowired
    private CicloFaturaService cicloFaturaService;

	public static void main(String[] args) {
		SpringApplication.run(FinApplication.class, args);

		System.out.println("teste");
	}

	@Override
	public void run(String... args) throws Exception {
		cicloFaturaService.init();
	}

	

}
