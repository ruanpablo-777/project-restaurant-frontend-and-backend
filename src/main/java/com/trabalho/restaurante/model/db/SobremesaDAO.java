package com.trabalho.restaurante.model.db;

import com.trabalho.restaurante.model.Bebida;
import com.trabalho.restaurante.model.Sobremesa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SobremesaDAO {
    private Connection conexao;

    public SobremesaDAO() throws ClassNotFoundException, SQLException {
        conexao = ConexaoDB.getConexao();
    }

    public int inserir(Sobremesa sobremesa) throws SQLException {

        String sql = "INSERT INTO bebida (nome, preco, temacucar, peso) VALUES (?,?,?,?)";

        PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, sobremesa.getNome());
        stmt.setString(2, String.valueOf(sobremesa.getPreco()));
        stmt.setString(3, String.valueOf(sobremesa.isTemAcucar()));
        stmt.setString(4, String.valueOf(sobremesa.getPeso()));

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        int idGerado = 0;
        if(rs.next()){
            idGerado = rs.getInt(1);
        }
        stmt.close();
        return idGerado;
    }

    public Sobremesa selecionarById(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * from sobremesa WHERE id = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet resultado = stmt.executeQuery();
        if (resultado.next()) {
            String nome = resultado.getString("nome");
            double preco = resultado.getDouble("preco");
            boolean temacucar = resultado.getBoolean("temacucar");
            double peso = resultado.getDouble("peso");
            return new Sobremesa(id, nome, preco, temacucar, peso);
        } else {
            return null;
        }
    }

    public List<Sobremesa> selecionarAll() throws SQLException, ClassNotFoundException {

        String sql = "SELECT * from sobremesa";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet resultado = stmt.executeQuery();

        List<Sobremesa> listaSobremesas = new ArrayList<>();
        while (resultado.next()) {
            int id = resultado.getInt("sobremesaid");
            String nome = resultado.getString("nome");
            double preco = resultado.getDouble("preco");
            double peso = resultado.getDouble("peso");
            boolean temacucar = resultado.getBoolean("temacucar");
            Sobremesa sobremesa =  new Sobremesa(id, nome, preco, temacucar, peso);
            listaSobremesas.add(sobremesa);
        }
        return listaSobremesas;
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