package com.trabalho.restaurante.model.db;

import com.trabalho.restaurante.model.Endereco;

import java.sql.*;

public class EnderecoDAO {
    private Connection conexao;

    public EnderecoDAO() throws ClassNotFoundException, SQLException {
        conexao = ConexaoDB.getConexao();
    }

    public int inserir(Endereco endereco) throws SQLException {
        String sql = "INSERT INTO endereco (cep, cidade, bairro, rua, numero, estado) VALUES (?,?,?,?,?,?)";

        PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, endereco.getCep());
        stmt.setString(2, endereco.getCidade());
        stmt.setString(3, endereco.getBairro());
        stmt.setString(4, endereco.getRua());
        stmt.setString(5, endereco.getNumero());
        stmt.setString(6, endereco.getEstado());

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        int idGerado = 0;
        if (rs.next()) {
            idGerado = rs.getInt(1);
        }
        stmt.close();
        return idGerado;
    }


    public Endereco selecionar(int id) throws SQLException {
        String sql = "SELECT * FROM endereco WHERE id = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet resultado = stmt.executeQuery();
        if (resultado.next()) {
            String cep = resultado.getString("cep");
            String cidade = resultado.getString("cidade");
            String bairro = resultado.getString("bairro");
            String rua = resultado.getString("rua");
            String numero = resultado.getString("numero");
            String estado = resultado.getString("estado");

            return new Endereco(id, numero, rua, bairro, cidade, estado, cep);
        } else {
            return null;
        }
    }

    public boolean atualizar(Endereco endereco) throws SQLException {
        String sql = "UPDATE endereco SET rua = ?, numero = ?, cep = ?, cidade = ?, estado = ?, bairro = ? WHERE id = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setString(1, endereco.getRua());
        stmt.setString(2, endereco.getNumero());
        stmt.setString(3, endereco.getCep());
        stmt.setString(4, endereco.getCidade());
        stmt.setString(5, endereco.getEstado());
        stmt.setString(6, endereco.getBairro());
        stmt.setInt(7, endereco.getId());

        int linhasAfetadas = stmt.executeUpdate();
        stmt.close();

        return linhasAfetadas > 0;
    }


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
