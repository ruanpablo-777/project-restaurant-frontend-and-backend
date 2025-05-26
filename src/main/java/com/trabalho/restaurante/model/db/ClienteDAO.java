package com.trabalho.restaurante.model.db;

import com.trabalho.restaurante.model.Cliente;
import com.trabalho.restaurante.model.Endereco;
import com.trabalho.restaurante.model.Restaurante;

import java.sql.*;

public class ClienteDAO  {
    private Connection conexao;

    public ClienteDAO() throws ClassNotFoundException, SQLException {
        conexao = ConexaoDB.getConexao();
    }

    public int inserir(Cliente cliente) throws SQLException {

        String sql = "INSERT INTO cliente (nome, idade, email, senha, endereco_id) VALUES (?,?,?,?,?)";

        PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, cliente.getNome());
        stmt.setString(2, String.valueOf(cliente.getIdade()));
        stmt.setString(3, cliente.getEmail());
        stmt.setString(4, cliente.getSenha());
        stmt.setString(5, String.valueOf(cliente.getEndereco().getId()));

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        int idGerado = 0;
        if(rs.next()){
            idGerado = rs.getInt(1);
        }
        stmt.close();
        return idGerado;
    }

    public Cliente selecionarID(int id) throws SQLException, ClassNotFoundException {
        EnderecoDAO enderecoDAO = new EnderecoDAO();

        String sql = "SELECT * from cliente WHERE id = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet resultado = stmt.executeQuery();
        if (resultado.next()) {
            String nome = resultado.getString("nome");
            int idade = resultado.getInt("idade");
            String email = resultado.getString("email");
            String senha = resultado.getString("senha");
            int idEndereco = resultado.getInt("endereco");

            Endereco endereco = enderecoDAO.selecionar(idEndereco);
            return new Cliente(id, nome, idade, email, senha,  endereco);
        } else {
            return null;
        }
    }

    public Cliente selecionarEmail(String email) throws SQLException, ClassNotFoundException {
        EnderecoDAO enderecoDAO = new EnderecoDAO();

        String sql = "SELECT * FROM cliente WHERE email = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, email);

        ResultSet resultado = stmt.executeQuery();
        if (resultado.next()) {
            int id = resultado.getInt("id");
            String nome = resultado.getString("nome");
            int idade = resultado.getInt("idade");
            String senha = resultado.getString("senha");
            int idEndereco = resultado.getInt("endereco_id");

            Endereco endereco = enderecoDAO.selecionar(idEndereco);
            return new Cliente(id, nome, idade, email, senha, endereco);
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