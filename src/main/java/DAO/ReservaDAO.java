package DAO;

import conexao.Conexao;
import entity.Cliente;
import entity.Mesa;
import entity.Reserva;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservaDAO {

    public void cadastrarReserva(Reserva reserva) {

        String sql = "INSERT INTO RESERVAS (CLIENTE_ID, MESA_ID, DATA_RESERVA, HORA_RESERVA, STATUS) VALUES (?,?,?,?,?)";

        PreparedStatement ps = null;

        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, reserva.getCliente_id());
            ps.setInt(2, reserva.getMesa_id());
            ps.setDate(3, reserva.getData_reserva());
            ps.setTime(4, reserva.getHora_reserva());
            ps.setString(5, reserva.getStatus());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e){
            e.printStackTrace();
        }


    }

}
