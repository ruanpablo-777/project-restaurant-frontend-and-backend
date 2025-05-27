package com.trabalho.restaurante.model.db;

import com.trabalho.restaurante.model.*;
import com.trabalho.restaurante.model.db.ConexaoDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComidaDAO {

    public List<Comida> listarTodas() {
        List<Comida> comidas = new ArrayList<>();
        String sql = "SELECT * FROM comida";

        try (Connection conn = ConexaoDB.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                double preco = rs.getDouble("preco");
                String tipo = rs.getString("tipo");
                String imagens = rs.getString("imagens");

                switch (tipo) {
                    case "sobremesa":
                        comidas.add(new Sobremesa(id, nome, descricao, preco, tipo, imagens));
                        break;
                    case "pratoPrincipal":
                        comidas.add(new PratoPrincipal(id, nome, descricao, preco, tipo, imagens));
                        break;
                    case "bebida":
                        boolean isAlcoolica = rs.getBoolean("isAlcoolica");
                        String volume = rs.getString("volume");
                        comidas.add(new Bebida(id, nome, descricao, preco, isAlcoolica, volume, tipo, imagens));
                        break;
                    default:
                        System.out.println("Tipo desconhecido: " + tipo);
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar comidas: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return comidas;
    }

    public Comida buascarPorId(int id) {
        String sql = "SELECT * FROM comida WHERE id = ?";

        try(Connection conn = ConexaoDB.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                double preco = rs.getDouble("preco");
                String tipo = rs.getString("tipo");
                String imagens = rs.getString("imagens");

                return new Comida(id, nome, descricao, preco, tipo, imagens) {
                    @Override
                    public void mostrarDetalhes() {

                    }
                };

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
}
