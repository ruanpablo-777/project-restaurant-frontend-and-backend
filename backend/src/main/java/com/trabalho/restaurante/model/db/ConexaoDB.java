package com.trabalho.restaurante.model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    public static Connection getConexao() throws ClassNotFoundException, SQLException {

        String url = "jdbc:sqlite:src/main/resources/meubanco.db";

        return DriverManager.getConnection(url);

    }
}
