package br.com.tech4me.filmes.telas;

import java.util.Scanner;

import br.com.tech4me.filmes.repositorios.FilmeRepositorio;

public class LoopPrincipal {
    
    public void loop(FilmeRepositorio filmeRepositorio) {
        int opcao;
        Scanner entrada = new Scanner(System.in);

        do {
            Tela tela = null;
            limparTela();
            
            System.out.println("**************");
            System.out.println("MENU PRINCIPAL");
            System.out.println("**************");
            System.out.println("1 - Buscar filme");
            System.out.println("2 - Incluir filme");
            System.out.println("3 - Listar filmes");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();
            entrada.nextLine();// Limpa o ENTER

            switch (opcao) {
                case 1:
                    tela = new TelaBuscarFilme();
                    break;
                case 2:
                    tela = new TelaCadastrarFilme();
                    break;
                case 3:
                    tela = new TelaListarFilmes();
                    break;
                case 0:
                    System.out.println("Fim do programa!");
                    break;
                default:
                    System.out.println("\nOpção inválida!");
                    voltarMenu(entrada);
                    break;
            }

            if(tela != null) {
                limparTela();
                tela.executar(entrada, filmeRepositorio);
                voltarMenu(entrada);
            }
        } while(opcao != 0);

        entrada.close();
    }

    public static void limparTela() {
        try {
            // Limpa toda a tela do console
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                System.out.print("\033[H\033[2J");
        } catch(Exception e) {}
    }

    private void voltarMenu(Scanner entrada) {
        System.out.print("\nPressione ENTER para continuar...");
        entrada.nextLine();

        limparTela();
        System.out.flush();
    }
}