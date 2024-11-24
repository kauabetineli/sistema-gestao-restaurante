package DAO;

import conexao.Conexao;
import entity.Cliente;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ClienteDAO {

    public void cadastrarCliente(Cliente usuario) {

        String sql = "INSERT INTO CLIENTES (NOME, TELEFONE, EMAIL) VALUES (?,?,?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getTelefone());
            ps.setString(3, usuario.getEmail());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
