package com.trabalho.restaurante.model.db;

import com.trabalho.restaurante.model.PratoPrincipal;
import com.trabalho.restaurante.model.Sobremesa;

import java.sql.*;

public class PPrincipalDAO {
    private Connection conexao;

    public PPrincipalDAO() throws ClassNotFoundException, SQLException {
        conexao = ConexaoDB.getConexao();
    }

    public int inserir(PratoPrincipal pratoPrincipal) throws SQLException {

        String sql = "INSERT INTO bebida (nome, preco, acompanhamento, isvegan) VALUES (?,?,?,?)";

        PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, pratoPrincipal.getNome());
        stmt.setString(2, String.valueOf(pratoPrincipal.getPreco()));
        stmt.setString(3, pratoPrincipal.getAcompanhamento());
        stmt.setString(4, String.valueOf(pratoPrincipal.isVegan()));

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        int idGerado = 0;
        if(rs.next()){
            idGerado = rs.getInt(1);
        }
        stmt.close();
        return idGerado;
    }

    public PratoPrincipal selecionar(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * from pratoprincipal WHERE id = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet resultado = stmt.executeQuery();
        if (resultado.next()) {
            String nome = resultado.getString("nome");
            double preco = resultado.getDouble("preco");
            boolean isVegan = resultado.getBoolean("isvegan");
            String acompanhamento = resultado.getString("acompanhamento");
            return new PratoPrincipal(id, nome, preco, acompanhamento, isVegan);
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

//    public boolean deletar(Endereco endereco) throws SQLException {
//        String sql = "DELETE FROM endereco WHERE id = ?";
//        PreparedStatement stmt = conexao.prepareStatement(sql);
//
//        stmt.setInt(1, endereco.getId());
//
//        int linhasAfetadas = stmt.executeUpdate();
//        if (linhasAfetadas > 0) {
//            return true;
//        } else {
//            return false;
//        }
//    }
}