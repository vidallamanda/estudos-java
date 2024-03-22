package Item1;

public class Suprimentos {

    private int codigo;
    private String descricao;
    private int quantidade;
    private double preco_unitario;

    public Suprimentos(int codigo, String descricao, int quantidade, double preco_unitario) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.quantidade = Math.max(quantidade, 0);
        this.preco_unitario = Math.max(preco_unitario, 0.0);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = Math.max(quantidade, 0);
    }

    public double getPrecoUnitario() {
        return preco_unitario;
    }

    public void setPrecoUnitario(double preco_unitario) {
        this.preco_unitario = Math.max(preco_unitario, 0.0);
    }

    public double getInvoiceAmount() {
        return this.quantidade * this.preco_unitario;
    }

    @Override
    public String toString() {
        return "Suprimento: " +
                "Código: " + this.codigo + "\n" +
                "Descrição: " + this.descricao + "\n" +
                "Quantidade:" + this.quantidade + "\n" +
                "Preço unitário: " + this.preco_unitario + "\n" +
                "Valor total: " + this.quantidade * this.preco_unitario;
    }
}
