package com.trabalho.restaurante;

import com.trabalho.restaurante.model.*;
import com.trabalho.restaurante.model.db.ConexaoDB;
import com.trabalho.restaurante.model.db.EnderecoDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;

@SpringBootApplication
public class RestauranteApplication implements CommandLineRunner{

	public static void main(String[] args){
		SpringApplication.run(RestauranteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		EnderecoDAO enderecoDAO = new EnderecoDAO();

		Endereco endereco = enderecoDAO.selecionar(1);
		Cliente cliente = new Cliente("bernardo", 20, "email@emial.com", "senha", endereco);

		cliente.getEndereco().getId();

	}
}
