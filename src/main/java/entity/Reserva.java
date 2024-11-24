package entity;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reserva {

    private int reserva_id;
    private int cliente_id;
    private int mesa_id;
    private java.sql.Date data_reserva;
    private java.sql.Time hora_reserva;
    private String status;

    public void setReserva_id(int reserva_id) {
        this.reserva_id = reserva_id;
    }

    public int getReserva_id() {
        return reserva_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }
    public int getCliente_id() {
        return cliente_id;
    }

    public void setMesa_id(int mesa_id) {
        this.mesa_id = mesa_id;
    }

    public int getMesa_id() {
        return mesa_id;
    }

    public void setData_reserva(String data_reserva) {

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date utilDate = dateFormat.parse(data_reserva);
            this.data_reserva = new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public java.sql.Date getData_reserva() {
        return data_reserva;
    }
    public void setHora_reserva(String hora_reserva) {

        try {
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            java.util.Date utilTime = timeFormat.parse(hora_reserva); // Parse para java.util.Date
            this.hora_reserva = new java.sql.Time(utilTime.getTime()); // Converte para java.sql.Time
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    public java.sql.Time getHora_reserva() {
        return hora_reserva;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }


}
