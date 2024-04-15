package Exercicio2;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("===== CADASTRO DE CONTINENTE =====");
        System.out.println("Informe o nome do continente: ");
        String nomeContinente = scanner.nextLine();

        Continente continente = new Continente(nomeContinente);
        System.out.println("Continente " + nomeContinente + " cadastrado com sucesso!");

        int escolha;
        do {
            System.out.println("===== CADASTRO DE PAÍSES =====");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar países manualmente");
            System.out.println("2 - Cadastrar países da África (10)");
            System.out.println("3 - Cadastrar países da América do Norte (3)");
            System.out.println("4 - Cadastrar países da América Central (7)");
            System.out.println("5 - Cadastrar países da América do Sul (10)");
            System.out.println("6 - Cadastrar países da Ásia (10)");
            System.out.println("7 - Cadastrar países da Europa (10)");
            System.out.println("8 - Cadastrar países da Oceania (10)");
            System.out.println("Digite o número correspondente ao tipo de cadastro que deseja realizar: ");

            try {
                escolha = Integer.parseInt(scanner.nextLine());
                if (escolha < 1 || escolha > 8) {
                    System.out.println("Deve ser informado um número entre 1 e 8.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Deve ser informado um número inteiro e positivo " +
                        "como opção.");
                escolha = 0;
                continue;
            }

            switch (escolha) {
                case 1:
                    while (true) {
                        Pais p = CadastroPais.cadastraPais();
                        continente.adicionaPais(p);

                        System.out.println("Deseja continuar cadastrando países para esse continente? Digite sim para continuar");
                        String res = scanner.nextLine().trim();

                        if (!res.equalsIgnoreCase("sim")) {
                            System.out.println("Todos os países desejados foram cadastrados");
                            break;
                        }
                    }
                    break;
                case 2:
                    continente.setPaises(CadastroPais.cadastraAfrica());
                    break;
                case 3:
                    continente.setPaises(CadastroPais.cadastraAmericaDoNorte());
                    break;
                case 4:
                    continente.setPaises(CadastroPais.cadastraAmericaCentral());
                    break;
                case 5:
                    continente.setPaises(CadastroPais.cadastraAmericaDoSul());
                    break;
                case 6:
                    continente.setPaises(CadastroPais.cadastraAsia());
                    break;
                case 7:
                    continente.setPaises(CadastroPais.cadastraEuropa());
                    break;
                case 8:
                    continente.setPaises(CadastroPais.cadastraOceania());
                    break;
            }

        } while (escolha < 1 || escolha > 8);

        System.out.println("\nPaíses do continente " + continente.getNome() + " foram " +
                "cadastrados com sucesso!");
        System.out.println("Quantidade de países cadastrados: " + continente.getCountPaises());

        System.out.println("\nInformações sobre o continente: ");
        System.out.println("Dimensão total: " + continente.dimensaoTotal());
        System.out.println("População total: " + continente.populacaoTotal());
        System.out.println("Densidade populacional: " + continente.densidadePopulacional());
        System.out.println("\nPaís com maior população: " + continente.maiorPopulacao());
        System.out.println("País com menor população: " + continente.menorPopulacao());
        System.out.println("\nPaís de maior dimensão territorial no continente: " + continente.maiorDimensao());
        System.out.println("País de menor dimensão territorial no continente: " + continente.menorDimensao());
        System.out.println("Razão territorial do maior país em relação ao menor país: " + continente.razaoTerritorialMaiorMenorPais());
    }
}