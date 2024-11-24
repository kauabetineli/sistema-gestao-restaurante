package command;

import conexao.Conexao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Comando {

    public void executaComando() {
        String operacao;
        String tabela;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite a operação desejada: ");
            System.out.println("[1] Create | [2] Select | [3] Update | [4] Delete | [0] Sair");
            operacao = sc.nextLine();

            if(operacao.equals("0")) break;

            System.out.println("Digite a tabela desejada: ");
            System.out.println("[1] Clientes | [2] Mesas | [3] Reservas");
            tabela = sc.nextLine();

            tabela = switch (tabela) {
                case "1" -> "CLIENTES";
                case "2" -> "MESAS";
                case "3" -> "RESERVAS";
                default -> tabela;
            };

            switch (operacao) {
                case "1": create(tabela); break;
                case "2": select(tabela); break;
                case "3": update(tabela); break;
                case "4": delete(tabela); break;
                default: System.out.println("Ocorreu um erro. Tente novamente!"); break;

            }



        } while (!operacao.equalsIgnoreCase("0"));

        System.out.println("Saindo do programa.");

    }

    private void create(String tabela){
        switch (tabela) {
            case "CLIENTES": new Executer().cadastrarCliente(); break;
            case "MESAS": new Executer().cadastrarMesa(); break;
            case "RESERVAS": new Executer().cadastrarReserva(); break;
        }
    }

    private void select(String tabela){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a operação desejada: ");
        System.out.println("[1] Tudo | [2] Linha especifica");
        String opcao = sc.nextLine();

        switch (opcao) {

            case "1": new Executer().select(tabela); break;
            case "2":
                System.out.print("Digite a condicão:");
                String condicao = sc.nextLine();

                System.out.print("Digite o valor da condição:");
                String valorCondicao = sc.nextLine();

                new Executer().select(tabela, condicao, valorCondicao);
                break;

        }


    }

    private void update(String tabela){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome da coluna a ser alterada:");
        String coluna = scanner.nextLine();

        System.out.println("Digite o novo valor:");
        String novoValor = scanner.nextLine();

        System.out.println("Digite a coluna para a condição:");
        String colunaCondicao = scanner.nextLine();

        System.out.println("Digite o valor da condição:");
        String valorCondicao = scanner.nextLine();

        new Executer().update(tabela, coluna, novoValor, colunaCondicao, valorCondicao);

    }

    private void delete(String tabela){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o tipo de deleção: ");
        System.out.println("[1] Todos os dados da tabela | [2] Linha especifica");
        String opcao = scanner.nextLine();

        switch (opcao){
            case "1": new Executer().delete(tabela); break;
            case "2":
                System.out.println("Digite a coluna para a condição:");
                String colunaCondicao = scanner.nextLine();

                System.out.println("Digite o valor da condição:");
                String valorCondicao = scanner.nextLine();

                new Executer().delete(tabela, colunaCondicao, valorCondicao);
                break;
        }



    }

}
