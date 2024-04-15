package Exercicio2;

public class Pais {

    private String nome;
    private double dimensao;
    private double populacao;

    public Pais(String nome, double dimensao, double populacao) {
        this.nome = nome;
        this.dimensao = dimensao;
        this.populacao = populacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getDimensao() {
        return dimensao;
    }

    public void setDimensao(double dimensao) {
        this.dimensao = dimensao;
    }

    public double getPopulacao() {
        return populacao;
    }

    public void setPopulacao(double populacao) {
        this.populacao = populacao;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + '\n' +
                "Dimensão: " + dimensao + '\n' +
                "População: " + populacao;
    }
}
