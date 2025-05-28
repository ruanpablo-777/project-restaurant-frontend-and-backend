package com.trabalho.restaurante.model.db;

import com.trabalho.restaurante.model.Cliente;
import com.trabalho.restaurante.model.Endereco;

import java.sql.*;

public class ClienteDAO {
    private Connection conexao;

    public ClienteDAO() throws ClassNotFoundException, SQLException {
        conexao = ConexaoDB.getConexao();
    }

    public ClienteDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public int inserir(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente (nome, idade, email, senha, endereco_id) VALUES (?,?,?,?,?)";

        PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, cliente.getNome());
        stmt.setInt(2, cliente.getIdade());
        stmt.setString(3, cliente.getEmail());
        stmt.setString(4, cliente.getSenha());
        stmt.setInt(5, cliente.getEndereco().getId());

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        int idGerado = 0;
        if (rs.next()) {
            idGerado = rs.getInt(1);
        }
        stmt.close();
        return idGerado;
    }

    public Cliente selecionarID(int id) throws SQLException, ClassNotFoundException {
        EnderecoDAO enderecoDAO = new EnderecoDAO();

        String sql = "SELECT * FROM cliente WHERE id = ?";
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
            return new Cliente(id, nome, idade, email, senha, endereco);
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

    public Cliente login(String email, String senha) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM cliente WHERE email = ? AND senha = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setString(2, senha);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            int idade = rs.getInt("idade");
            int idEndereco = rs.getInt("endereco_id");

            EnderecoDAO enderecoDAO = new EnderecoDAO();
            Endereco endereco = enderecoDAO.selecionar(idEndereco);

            return new Cliente(id, nome, idade, email, senha, endereco);
        }

        return null;
    }

    public String buscarEndereco(Long clienteId) throws SQLException {
        String sql = "SELECT endereco_id FROM cliente WHERE id = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setLong(1, clienteId);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getString("endereco_id");
        }

        return null;
    }

    public Endereco buscarEnderecoPorClienteId(Long clienteId) throws SQLException {
        String sql = "SELECT e.id, e.rua, e.numero, e.bairro, e.cidade, e.estado, e.cep " +
                "FROM cliente c " +
                "JOIN endereco e ON c.endereco_id = e.id " +
                "WHERE c.id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setLong(1, clienteId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setId(rs.getInt("id"));
                endereco.setRua(rs.getString("rua"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setCep(rs.getString("cep"));
                return endereco;
            } else {
                return null;
            }
        }
    }

}
