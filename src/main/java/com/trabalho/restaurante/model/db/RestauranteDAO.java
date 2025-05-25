package com.trabalho.restaurante.model.db;

import com.trabalho.restaurante.model.Endereco;
import com.trabalho.restaurante.model.Restaurante;

import java.sql.*;

public class RestauranteDAO {
    private Connection conexao;

    public RestauranteDAO() throws ClassNotFoundException, SQLException {
        conexao = ConexaoDB.getConexao();
    }

    public int inserir(Restaurante restaurante) throws SQLException {

        String sql = "INSERT INTO restaurante (nome, avaliacao, endereco) VALUES (?,?,?)";

        PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, restaurante.getNome());
        stmt.setString(2, String.valueOf(restaurante.getAvaliacao()));
        stmt.setString(3, String.valueOf(restaurante.getEndereco().getId()));

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        int idGerado = 0;
        if(rs.next()){
            idGerado = rs.getInt(1);
        }
        stmt.close();
        return idGerado;
    }

    public Endereco selecionar(int id) throws SQLException {
        String sql = "SELECT * from restaurante WHERE id = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet resultado = stmt.executeQuery();
        if (resultado.next()) {
            String nome = resultado.getString("nome");
            int avaliacao = resultado.getInt("avaliacao");
            Endereco
            return new Restaurante(id, numero, rua, bairro, cidade, cep);
        } else {
            return null;
        }
    }

//    public boolean atualizar(Endereco endereco) throws SQLException {
//        String sql = "UPDATE endereco SET rua = ?, numero = ?, cep = ?, cidade = ?, estado = ? WHERE id = ?";
//        PreparedStatement stmt = conexao.prepareStatement(sql);
//
//        stmt.setString(1, endereco.getRua());
//        stmt.setInt(2, endereco.getNumero());
//        stmt.setString(3, endereco.getCep());
//        stmt.setString(4, endereco.getCidade());
//        stmt.setString(5, endereco.getEstado());
//        stmt.setInt(6, endereco.getId());
//
//        int linhasAfetadas = stmt.executeUpdate();
//
//        if (linhasAfetadas > 0) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    public boolean deletar(Endereco endereco) throws SQLException {
        String sql = "DELETE FROM endereco WHERE id = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setInt(1, endereco.getId());

        int linhasAfetadas = stmt.executeUpdate();
        if (linhasAfetadas > 0) {
            return true;
        } else {
            return false;
        }
    }
}