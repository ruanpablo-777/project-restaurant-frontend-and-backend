package com.trabalho.restaurante.model.db;

import com.trabalho.restaurante.model.Bebida;
import com.trabalho.restaurante.model.PratoPrincipal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BebidaDAO {
    private Connection conexao;

    public BebidaDAO() throws ClassNotFoundException, SQLException {
        conexao = ConexaoDB.getConexao();
    }

    public int inserir(Bebida bebida) throws SQLException {

        String sql = "INSERT INTO bebida (nome, preco, isAcoolica, volume) VALUES (?,?,?,?)";

        PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, bebida.getNome());
        stmt.setString(2, String.valueOf(bebida.getPreco()));
        stmt.setString(3, String.valueOf(bebida.isAlcoolica()));
        stmt.setString(4, String.valueOf(bebida.getVolume()));

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        int idGerado = 0;
        if(rs.next()){
            idGerado = rs.getInt(1);
        }
        stmt.close();
        return idGerado;
    }

    public Bebida selecionarById(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * from bebidas WHERE id = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet resultado = stmt.executeQuery();
        if (resultado.next()) {
            String nome = resultado.getString("nome");
            double preco = resultado.getDouble("preco");
            boolean isAcoolica = resultado.getBoolean("isacoolica");
            int volume = resultado.getInt("volume");
            return new Bebida(id, nome, preco, isAcoolica, volume);
        } else {
            return null;
        }
    }

    public List<Bebida> selecionarAll() throws SQLException, ClassNotFoundException {

        String sql = "SELECT * from bebida";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet resultado = stmt.executeQuery();

        List<Bebida> listaBebida = new ArrayList<>();
        while (resultado.next()) {
            int id = resultado.getInt("bebidaid");
            String nome = resultado.getString("nome");
            double preco = resultado.getDouble("preco");
            boolean isalcoolica = resultado.getBoolean("isalcoolica");
            int volume = resultado.getInt("volume");
            Bebida bebida =  new Bebida(id, nome, preco, isalcoolica, volume);
            listaBebida.add(bebida);
        }
        return listaBebida;
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