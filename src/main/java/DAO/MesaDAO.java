package DAO;

import conexao.Conexao;
import entity.Mesa;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MesaDAO {

    public void cadastrarMesa(Mesa mesa) {

        String sql = "INSERT INTO MESAS (NUMERO, CAPACIDADE, STATUS) VALUES (?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, mesa.getNumero());
            ps.setInt(2, mesa.getCapacidade());
            ps.setString(3, mesa.getStatus());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
