package com.trabalho.restaurante;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestauranteApplication implements CommandLineRunner {

	public static void main(String[] args){
		SpringApplication.run(RestauranteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Usem esse como main para testar o código
		System.out.println("Testa aqui");
	}
}
