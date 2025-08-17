package com.trabalho.restaurante.model.db;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    public static Connection getConexao() throws ClassNotFoundException, SQLException {
        try {
            // Busca o banco dentro do JAR
            InputStream dbStream = ConexaoDB.class.getResourceAsStream("/meubanco.db");
            if (dbStream == null) {
                throw new RuntimeException("Banco de dados não encontrado no JAR!");
            }

            // Cria arquivo temporário para SQLite
            File tempFile = File.createTempFile("meubanco", ".db");
            tempFile.deleteOnExit();

            try (OutputStream out = new FileOutputStream(tempFile)) {
                dbStream.transferTo(out);
            }

            String url = "jdbc:sqlite:" + tempFile.getAbsolutePath();
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(url);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao abrir conexão com SQLite", e);
        }
    }
}
