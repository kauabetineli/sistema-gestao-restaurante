package entity;

public class Mesa {

    private int mesa_id;
    private int numero;
    private int capacidade;
    private String status;

    public void setMesa_id(int mesa_id) {
        this.mesa_id = mesa_id;
    }

    public int getMesa_id() {
        return mesa_id;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }


}
