package Exercicio1;

public class Main {
    public static void main(String[] args) {

        Contador c = new Contador();

        for (int i = 0; i < 10; i++) {
            c.incrementar();
        }

        System.out.println("Valor do contador: " + c.getValor());

        c.zerar();

        System.out.println("Valor do contador: " + c.getValor());
    }
}