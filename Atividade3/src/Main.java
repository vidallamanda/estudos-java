import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {
            int escolha;

            while (true) {
                System.out.println("\nOlá! Qual das atividades você deseja executar. Por " +
                        "favor, informe o número correspondente [1-10].");

                try {
                    escolha = scanner.nextInt();

                    if (escolha < 1 || escolha > 10)
                        throw new RuntimeException();

                    break;
                } catch (RuntimeException e) {
                    System.out.println("Erro: Entrada inválida. Por favor, insira um número " +
                            "válido [1-10] para executar.");
                    scanner.nextLine();
                }
            }

            chamarAtividadePeloNumero(escolha);

            System.out.println("\nVocê quer continuar a execução de atividades? Se sim," +
                    " pressione s e enter");
            String continua = scanner.next().toLowerCase().trim();
            continuar = (continua.equals("s"));
        }

    }

    public static void atividade1() throws InterruptedException {
        // 1 - Crie um programa que realize uma contagem regressiva de 10 até 1,
        // mostrando cada número na tela.

        System.out.println("Contagem regressiva...");
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            Thread.sleep(1000);
        }
        System.out.println("Fim!");
    }

    public static void atividade2() {
        // 2 - Escreva um programa que solicite um número ao usuário e exiba a tabuada
        // desse número de 1 a 10.

        Scanner scanner = new Scanner(System.in);

        int numero;

        System.out.println("--------------Tabuada--------------");

        while (true) {
            try {
                System.out.println("Olá! Informe um número inteiro: ");
                numero = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Não foi informado um número inteiro.\n");
                scanner.nextLine();
            }
        }

        for (int i = 1; i < 11; i++) {
            int produto = i * numero;
            System.out.println(numero + " x " + i + " = " + produto);
        }

    }

    public static void atividade3() {
        // 3 - Desenvolva um algoritmo que calcule a soma dos números pares de 1 a 100.

        int soma = 0;

        System.out.println("Soma dos números pares de 1 até 100");
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                soma += i;
            }
        }
        System.out.println("Resultado da soma: " + soma);
    }

    public static void atividade4() {
        // 4 - Escreva um programa que verifique se um número digitado pelo usuário é
        // primo ou não.

        Scanner scanner = new Scanner(System.in);

        int numero;

        while (true) {
            try {
                System.out.println("Olá! Informe um número inteiro: ");
                numero = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Não foi informado um número inteiro.");
                scanner.nextLine();
            }
        }

        if (numero <= 1) {
            System.out.println(numero + " não é primo.");
            return;
        }

        // Se um número não é primo, ele possui pelo menos dois divisores distintos,
        // então se não encontrar um divisor até a metade do número, ele também não
        // será encontrado após a outra metade. Então, dividir o número por 2 no 'for'
        // diminuirá a quantidade de vezes que precisaremos testar. O teste mais
        // preciso de tentativas é com raiz quadrada, porém, teríamos que utilizar
        // biblioteca, e eu queria algo mais simples.
        for (int i = 2; i <= numero / 2; i++) {
            if (numero % i == 0) {
                System.out.println(numero + " não é primo.");
                return;
            }
        }

        // Passou por todas as verificações e não retornou a função, é primo.
        System.out.println(numero + " é primo.");
    }

    public static void atividade5() {
        // 5 - Implemente um algoritmo que exiba os primeiros 20 números da sequência
        // de Fibonacci.

        int numeroTermos = 20, anterior = 0, fibonacci = 0;

        // Considerei o 0 nesse algoritmo, mas poderia começar direto no 1.
        for (int i = 0; i < numeroTermos; i++) {

            if (i <= 1) {
                fibonacci = i;
                anterior = 0;
            } else {
                fibonacci += anterior;
                anterior = fibonacci - anterior;
            }

            System.out.println(fibonacci);
        }
    }

    public static void atividade6() {
        // 6 - Faça um programa que solicite ao usuário números inteiros positivos.
        // Quando o usuário digitar um número negativo, o programa deve exibir a média
        // dos números inseridos até aquele momento.

        Scanner scanner = new Scanner(System.in);

        int numero = 0, acc = 0, count = -1;
        double media = 0.0;

        while (numero >= 0) {

            acc += numero;
            count++;

            try {
                System.out.println("Olá! Informe um número inteiro: ");
                numero = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Erro: Não foi informado um número inteiro.\n");
                numero = -1;
            }

        }

        media = (double) acc / count;

        System.out.println("A média dos números inteiros e positivos inseridos é : " + media);
    }

    public static void atividade7() throws InterruptedException {
        // 7 - Crie uma calculadora simples que permita ao usuário realizar operações
        // de soma, subtração, multiplicação e divisão entre dois números, utilizando
        // um laço de repetição para continuar operando até que o usuário decida sair.

        int escolha = 0, n1, n2;
        Scanner scanner = new Scanner(System.in);

        while (true) {

            try {

                System.out.println("--------------Calculadora--------------");
                System.out.println("Informe a operação desejada digitando o número " +
                        "correspondente: ");
                System.out.println("1. Adição ");
                System.out.println("2. Subtração ");
                System.out.println("3. Multiplicação ");
                System.out.println("4. Divisão ");
                System.out.println("5. Sair");

                escolha = scanner.nextInt();

                if (escolha == 5) {
                    System.out.println("Calculadora encerrada.");
                    return;
                } else if (escolha < 1 || escolha > 5) {
                    throw new RuntimeException();
                }
            } catch (RuntimeException e) {
                System.out.println("Erro: Entrada inválida. Infome um número inteiro " +
                        "[1-5]");
                scanner.nextLine();
                continue;
            }

            try {
                System.out.println("Informando os valores para realizar a operação de " +
                        "número " + escolha);

                System.out.println("Informe o primeiro número: ");
                n1 = scanner.nextInt();

                System.out.println("Informe o segundo número: ");
                n2 = scanner.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida.");
                scanner.nextLine();
                continue;
            }

            if (escolha == 1) {
                System.out.println(n1 + " + " + n2 + " = " + (n1 + n2));
            } else if (escolha == 2) {
                System.out.println(n1 + " - " + n2 + " = " + (n1 - n2));

            } else if (escolha == 3) {
                System.out.println(n1 + " * " + n2 + " = " + (n1 * n2));
            } else {
                if (n2 == 0) {
                    System.out.println("Operação inválida! Não é possível realizar " +
                            "divisão com denominador 0.");
                } else {
                    double divisao = (double) n1 / n2;
                    System.out.println(n1 + " / " + n2 + " = " + divisao);
                }
            }

            Thread.sleep(1000);
        }
    }

    public static void atividade8() {
        // 8 - Implemente um jogo no qual o programa escolhe um número aleatório entre
        // 1 e 100, e o jogador deve tentar adivinhá-lo. O programa deve fornecer dicas
        // do tipo "maior" ou "menor" conforme necessário.

        int numeroAleatorio, palpite = 0, count = 0;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        numeroAleatorio = random.nextInt(100) + 1;

        System.out.println("-----------Jogo de adivinhar o número-----------");
        while (palpite != numeroAleatorio) {
            System.out.println("Olá! Dê seu palpite: ");

            try {
                palpite = scanner.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("Erro: Entrada inválida. Precisa ser um número inteiro");
                palpite = 0;
                continue;
            }

            if (palpite > numeroAleatorio) {
                System.out.println("O número precisa ser menor");
            } else if (palpite < numeroAleatorio) {
                System.out.println("O número precisa ser maior");
            }

            count++;
        }
        System.out.println("Parabénsss!!!!!!");
        System.out.println("Você utilizou " + count + " tentativa(s) para acertar.");
    }

    public static void atividade9() {
        // 9 - Escreva um programa que converta a temperatura de Celsius para
        // Fahrenheit ou vice-versa, solicitando ao usuário qual conversão deseja fazer
        // . O programa deve continuar executando até que o usuário decida sair.
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;
        int tipoConversao;
        double temp, tempConvertida;
        while (continuar) {
            try {
                System.out.println("Informe a conversão que você deseja realizar: ");
                System.out.println("1. Celsius para Fahrenheit ");
                System.out.println("2. Fahrenheit para Celsius ");

                tipoConversao = scanner.nextInt();

                if (tipoConversao < 0 || tipoConversao > 2) {
                    throw new RuntimeException();
                }

                System.out.println("Informe a temperatura para realizar a conversão: ");
                temp = scanner.nextDouble();

                if (tipoConversao == 1) {
                    tempConvertida = (temp * 9 / 5) + 32;
                } else {
                    tempConvertida = (temp - 32) * 5 / 9;
                }

                System.out.println("Temperatura inserida: " + temp + (tipoConversao == 1
                        ? "ºC" : "ºF"));
                System.out.println("Temperatura convertida: " + tempConvertida + (tipoConversao == 1
                        ? "ºF" : "ºC"));

                System.out.println("Deseja encerrar a atividade? Digite 0 ");
                continuar = scanner.nextInt() != 0;

            } catch (RuntimeException e) {
                System.out.println("Erro: Entrada inválida. Precisa ser um número [1-2]");
                scanner.nextLine();
            }
        }
    }

    public static void atividade10() {
        // 10 - Desenvolva um programa que permita ao usuário inserir itens em uma
        // lista de compras. O programa deve exibir a lista de compras atualizada após
        // cada inserção e perguntar se o usuário deseja adicionar mais itens. O
        // programa deve continuar executando até que o usuário decida sair.

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> listaCompras = new ArrayList<>();

        boolean exit = false;

        while (!exit) {
            System.out.println("Inserção de itens em lista de compras");
            System.out.println("Informe o item que deseja inserir: ");
            String item = scanner.nextLine();

            listaCompras.add(item);

            for (String it : listaCompras) {
                int index = listaCompras.indexOf(it) + 1;
                System.out.println(index + ". " + it);
            }

            System.out.println("Você deseja adicionar mais itens? Digite s para sim, e " +
                    "qualquer outra tecla para não");
            String verifica = scanner.nextLine();
            exit = !verifica.trim().equalsIgnoreCase("s");
        }
        System.out.println("Lista de compras: ");
        for (String it : listaCompras) {
            int index = listaCompras.indexOf(it) + 1;
            System.out.println(index + ". " + it);
        }
    }

    public static void chamarAtividadePeloNumero(int numero) {
        try {
            String nomeMetodo = "atividade" + numero;
            Method metodo = Main.class.getDeclaredMethod(nomeMetodo);

            try {
                System.out.println("\nChamando atividade " + numero + "...\n");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            metodo.invoke(null);
        } catch (InvocationTargetException | NoSuchMethodException |
                 IllegalAccessException e) {
            System.out.println("Erro: Não foi possível executar atividade.");
        }
    }
}