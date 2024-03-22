package Item1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int codigo, quantidade;
        String descricao;
        double preco_unitario;

        System.out.println("\nCadastro de suprimento");
        System.out.println("Informe o código do item: ");
        codigo = Integer.parseInt(scanner.nextLine());

        System.out.println("Informe a descrição do item: ");
        descricao = scanner.nextLine();

        System.out.println("Informe a quantidade do item: ");
        quantidade = Integer.parseInt(scanner.nextLine());

        System.out.println("Informe o preço unitário do item: ");
        preco_unitario = Double.parseDouble(scanner.nextLine());

        Suprimentos suprimento = new Suprimentos(codigo, descricao, quantidade, preco_unitario);

        System.out.println("\nO valor total da fatura é: R$" + suprimento.getInvoiceAmount());
        System.out.println("\n" + suprimento.toString());
    }

}