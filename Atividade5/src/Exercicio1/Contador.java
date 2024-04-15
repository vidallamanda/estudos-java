package Exercicio1;

public class Contador {

    private int valor;

    public Contador() {
        this.valor = 0;
    }

    public void zerar() {
        this.valor = 0;
    }

    public void incrementar() {
        this.valor++;
    }

    public int getValor() {
        return valor;
    }
}
