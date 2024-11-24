package command;

import DAO.ClienteDAO;
import DAO.MesaDAO;
import DAO.ReservaDAO;
import conexao.Conexao;
import entity.Cliente;
import entity.Mesa;
import entity.Reserva;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class Executer {

    public void cadastrarCliente(){
        Scanner sc = new Scanner(System.in);
        Cliente cliente = new Cliente();
        System.out.println("Cadastrando novo cliente");
        System.out.print("Nome: ");
        cliente.setNome(sc.next());
        System.out.print("Telefone: ");
        cliente.setTelefone(sc.next());
        System.out.print("Email: ");
        cliente.setEmail(sc.next());
        new ClienteDAO().cadastrarCliente(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void cadastrarMesa(){
        Scanner sc = new Scanner(System.in);
        Mesa mesa = new Mesa();
        System.out.println("Cadastrando nova mesa");
        System.out.print("Numero: ");
        mesa.setNumero(sc.nextInt());
        System.out.print("Capacidade: ");
        mesa.setCapacidade(sc.nextInt());
        mesa.setStatus("disponivel");
        new MesaDAO().cadastrarMesa(mesa);
        System.out.println("Mesa cadastrada com sucesso!");
    }

    public void cadastrarReserva(){
        Scanner sc = new Scanner(System.in);
        Reserva reserva = new Reserva();
        System.out.println("Cadastrando nova reserva");
        System.out.print("ID Cliente: ");
        reserva.setCliente_id(sc.nextInt());
        System.out.print("ID Mesa: ");
        reserva.setMesa_id(sc.nextInt());
        System.out.print("Data (DD/MM/YYYY): ");
        reserva.setData_reserva(sc.next());
        System.out.print("Hora (HH:MM:SS): ");
        reserva.setHora_reserva(sc.next());
        reserva.setStatus("confirmada");
        new ReservaDAO().cadastrarReserva(reserva);
    }

    public void update(String tabela, String coluna, String novoValor, String colunaCondicao, String valorCondicao){

        String sql = "UPDATE " + tabela + " SET " + coluna + " = ? WHERE " + colunaCondicao + " = ?";

        PreparedStatement ps = null;

        try {

            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, novoValor);
            ps.setString(2, valorCondicao);
            ps.executeUpdate();
            ps.close();

            System.out.println("Tabela " + tabela + " atualizada com sucesso!");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void select(String tabela){

        String sql = "SELECT * FROM " + tabela;

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int qtdeColunas = rsmd.getColumnCount();

            System.out.println("Tabela: " + tabela.toUpperCase());
            System.out.println();

            for (int i = 1; i <= qtdeColunas; i++) {
                System.out.printf("%-20s", rsmd.getColumnName(i));
            }
            System.out.println();

            while (rs.next()) {
                for (int i = 1; i <= qtdeColunas; i++) {
                    System.out.printf("%-20s", rs.getString(i));
                }
                System.out.println();
            }
            System.out.println();


            ps.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void select(String tabela, String coluna, String valorCondicao){

        String sql = "SELECT * FROM " + tabela + " WHERE " + coluna + " = ?";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, valorCondicao);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int qtdeColunas = rsmd.getColumnCount();

            System.out.println("Tabela: " + tabela.toUpperCase());
            System.out.println();

            for (int i = 1; i <= qtdeColunas; i++) {
                System.out.printf("%-20s", rsmd.getColumnName(i));
            }
            System.out.println();

            while (rs.next()) {
                for (int i = 1; i <= qtdeColunas; i++) {
                    System.out.printf("%-20s", rs.getString(i));
                }
                System.out.println();
            }
            System.out.println();


            ps.close();
            rs.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void delete(String tabela){
        String sql = "DELETE FROM " + tabela;

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void delete(String tabela, String coluna, String valorCondicao){
        String sql = "DELETE FROM " + tabela + " WHERE " + coluna + " = ?";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, valorCondicao);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
