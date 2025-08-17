package com.trabalho.restaurante.model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    public static Connection getConexao() throws ClassNotFoundException, SQLException {

        String nomeBaseDados = System.getenv("DATABASE_USERNAME");
        String porta = System.getenv("DATABASE_PORT");
        String enderecoBaseDados = String.format( "jdbc:postgresql://restaurante_bd_backend_user:gyMatGG7CWnJYtJBkWxVgW5c4OtilnQz@dpg-d2gus0gdl3ps73fofj10-a/restaurante_bd_backend", porta, nomeBaseDados);

        String login = System.getenv("DATABASE_USER");
        String senha = System.getenv("DATABASE_PASSWORD");

        Class.forName("org.postgresql.Driver");

        return DriverManager.getConnection(enderecoBaseDados, login, senha);

    }
}
