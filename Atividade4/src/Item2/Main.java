package Item2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("\nCadastro do colaborador 1");
        Colaborador colaborador1 = cadastrarColaborador();

        System.out.println("\nCadastro do colaborador 2");
        Colaborador colaborador2 = cadastrarColaborador();

        System.out.println();

        System.out.println("Salário anual Colaborador 1: " + colaborador1.getSalarioMensal() * 12);
        System.out.println("Salário anual Colaborador 2: " + colaborador2.getSalarioMensal() * 12);

        colaborador1.setSalarioMensal(colaborador1.getSalarioMensal() * 1.10);

        colaborador2.setSalarioMensal(colaborador2.getSalarioMensal() * 1.10);

        System.out.println("Salário anual Colaborador 1 após o aumento: " + colaborador1.getSalarioMensal() * 12);
        System.out.println("Salário anual Colaborador 2 após o aumento: " + colaborador2.getSalarioMensal() * 12);

        System.out.println("\n" + colaborador1.toString());

        System.out.println("\n" + colaborador2.toString());

    }

    public static Colaborador cadastrarColaborador() {

        Scanner scanner = new Scanner(System.in);

        String primeiro_nome;
        String sobrenome;
        double salario_mensal;

        System.out.println("Informe o primeiro nome: ");
        primeiro_nome = scanner.nextLine();

        System.out.println("Informe o sobrenome: ");
        sobrenome = scanner.nextLine();

        System.out.println("Informe o salário mensal: ");
        salario_mensal = Double.parseDouble(scanner.nextLine());

        return new Colaborador(primeiro_nome, sobrenome, salario_mensal);
    }

}