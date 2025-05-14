package com.trabalho.restaurante;

import com.trabalho.restaurante.model.Cliente;
import com.trabalho.restaurante.model.Endereco;
import com.trabalho.restaurante.model.PratoPrincipal;
import com.trabalho.restaurante.model.Pratos;
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
		Endereco endereco = new Endereco(471, "Adduci Fulvio", "estreito", "Florianopolis", 88075002);
		Cliente cliente = new Cliente("Bernardo", 20, "email@email.com", "senha", endereco);

		Pratos pratoPrincipal = new PratoPrincipal("Feijoada", 32.5, "nao sei", "Porco", false);
		pratoPrincipal.descricao();

		System.out.println(cliente.getEndereco());
	}
}
