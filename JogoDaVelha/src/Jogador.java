public class Jogador {

    private String nome;
    private int quantidadePontos;

    public Jogador(String nome) {
        this.nome = nome;
        this.quantidadePontos = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadePontos() {
        return quantidadePontos;
    }

    public void setQuantidadePontos(int quantidadePontos) {
        this.quantidadePontos = quantidadePontos;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + "\n" +
                "Quantidade de pontos: " + this.quantidadePontos;
    }
}
