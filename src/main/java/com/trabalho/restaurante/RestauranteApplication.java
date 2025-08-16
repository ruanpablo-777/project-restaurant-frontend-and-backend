package com.trabalho.restaurante;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RestauranteApplication implements CommandLineRunner{

	public static void main(String[] args){
		SpringApplication.run(RestauranteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// EnderecoDAO enderecoDAO = new EnderecoDAO();

		//Endereco endereco = enderecoDAO.selecionar(1);
		//Cliente cliente = new Cliente("bernardo", 20, "email@emial.com", "senha", endereco);

		//System.out.println(cliente.getEndereco().getId());
	}
}
