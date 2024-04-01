import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Bem vindo ao jogo da velha!");
        Jogador jogadorX = cadastraJogador('X');
        Jogador jogadorO = cadastraJogador('O');

        boolean continuar = true;

        while (continuar) {
            JogoDaVelha jogo = cadastraJogoDaVelha();

            boolean jogoEmAndamento = true;

            while (jogoEmAndamento) {
                int[] jogadaX = realizaJogada(jogadorX, jogo, 'X');

                if (jogo.verificaGanhador(jogadaX[0], jogadaX[1], 'X')) {
                    System.out.println(jogo);
                    System.out.println("Parabéns, " + jogadorX.getNome() + ", você " +
                            "ganhou!");
                    jogadorX.setQuantidadePontos(jogadorX.getQuantidadePontos() + 1);
                    jogoEmAndamento = false;
                    continue;
                } else if (jogo.isEmpate()) {
                    System.out.println(jogo);
                    System.out.println("O jogo terminou em empate!");
                    jogoEmAndamento = false;
                    continue;
                }

                int[] jogadaO = realizaJogada(jogadorO, jogo, 'O');

                if (jogo.verificaGanhador(jogadaO[0], jogadaO[1], 'O')) {
                    System.out.println(jogo);
                    System.out.println("Parabéns, " + jogadorO.getNome() + ", você " +
                            "ganhou!");
                    jogadorO.setQuantidadePontos(jogadorO.getQuantidadePontos() + 1);
                    jogoEmAndamento = false;
                } else if (jogo.isEmpate()) {
                    System.out.println(jogo);
                    System.out.println("O jogo terminou em empate!");
                    jogoEmAndamento = false;
                }
            }


            System.out.println("Deseja permanecer jogando? Digite sim para confirmar, " +
                    "se não deseja digite qualquer outra tecla");
            continuar = scanner.nextLine().trim().equalsIgnoreCase("sim");
        }

        Jogador vencedor =
                jogadorO.getQuantidadePontos() > jogadorX.getQuantidadePontos() ?
                        jogadorO : jogadorX;
        imprimirJogadorVencedor(vencedor);
    }

    public static void imprimirJogadorVencedor(Jogador vencedor) {
        try {
            FileWriter file = new FileWriter("resultado.txt");
            PrintWriter pw = new PrintWriter(file);

            pw.println("Informações do jogador vencedor: ");
            pw.println("Nome: " + vencedor.getNome());
            pw.println("Quantidade de pontos: " + vencedor.getQuantidadePontos());

            pw.close();
            System.out.println("As informações do jogador vencedor foram escritas no arquivo resultado.txt.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro! Não foi possível gravar as informações" +
                    " do vencedor.");
        }
    }

    public static Jogador cadastraJogador(char type) {
        System.out.println("Cadastro do jogador " + type);

        System.out.println("Informe o nome: ");
        String nome = scanner.nextLine();

        return new Jogador(nome);
    }

    public static JogoDaVelha cadastraJogoDaVelha() {
        System.out.println("\nConstrução do tabuleiro");

        int tamanho = 0;

        while (true) {
            try {
                System.out.println("Informe qual o tamanho do tabuleiro desejado. Ex.: " +
                        "para um tabuleiro de dimensões 4x4, informe o número 4.");

                tamanho = Integer.parseInt(scanner.nextLine());
                if (tamanho < 0) {
                    throw new RuntimeException();
                }
                break;
            } catch (RuntimeException e) {
                System.out.println("Entrada inválida! É necessário informar um número" +
                        " inteiro e positivo\n");
            }
        }

        return new JogoDaVelha(tamanho);
    }

    public static int[] realizaJogada(Jogador jogador, JogoDaVelha jogo, char typeOX) {
        System.out.println(jogo);
        System.out.println("Vez do " + jogador.getNome() + " (" + typeOX + ")");

        int row, col;
        while (true) {
            try {
                System.out.println("Informe a linha e a coluna para realizar a jogada " +
                        "[0-" + (jogo.getSize() - 1) + "]: ");
                System.out.println("Linha: ");
                row = Integer.parseInt(scanner.nextLine());
                System.out.println("Coluna: ");
                col = Integer.parseInt(scanner.nextLine());

                if (jogo.realizaJogada(row, col, typeOX)) {
                    return new int[]{row, col};
                } else {
                    System.out.println("Jogada inválida, tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! É necessário informar um número" +
                        " inteiro e maior que 0\n");
            }
        }
    }
}