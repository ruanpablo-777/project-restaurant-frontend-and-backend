package com.trabalho.restaurante.model.db;

import com.trabalho.restaurante.model.Cliente;
import com.trabalho.restaurante.model.Endereco;

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
            int idEndereco = resultado.getInt("endereco_id");

            Endereco endereco = enderecoDAO.selecionar(idEndereco);
            return new Cliente(id, nome, idade, email, senha,  endereco);
        } else {
            return null;
        }
    }

    public Cliente login(String email, String senha) throws SQLException, ClassNotFoundException {
        EnderecoDAO enderecoDAO = new EnderecoDAO();

        String sql = "SELECT * from cliente WHERE email = ? and senha = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setString(2, senha);

        ResultSet resultado = stmt.executeQuery();
        if (resultado.next()) {
            int id = resultado.getInt("id");
            String nome = resultado.getString("nome");
            int idade = resultado.getInt("idade");
            int idEndereco = resultado.getInt("endereco_id");

            Endereco endereco = enderecoDAO.selecionar(idEndereco);
            return new Cliente(id, nome, idade, email, senha,  endereco);
        } else {
            return null;
        }
    }



    public Cliente atualizar(Cliente cliente, int id) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE cliente SET nome = ?, email = ?, idade = ? WHERE id = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setInt(4,id);
        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getEmail());
        stmt.setInt(3, cliente.getIdade());


        int linhasAfetadas = stmt.executeUpdate();

        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente1 = clienteDAO.selecionarID(id);

        return cliente1;
    }

    public boolean deletar(int id) throws SQLException {
        String sql = "DELETE FROM cliente WHERE id = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setInt(1, id);

        int linhasAfetadas = stmt.executeUpdate();
        if (linhasAfetadas > 0) {
            return true;
        } else {
            return false;
        }
    }
}