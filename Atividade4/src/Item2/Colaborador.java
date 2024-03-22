package Item2;

public class Colaborador {

    private String primeiro_nome;
    private String sobrenome;
    private double salario_mensal;

    public Colaborador(String primeiro_nome, String sobrenome, double salario_mensal) {
        this.primeiro_nome = primeiro_nome;
        this.sobrenome = sobrenome;
        this.salario_mensal = Math.max(salario_mensal, 0.0);
    }

    public String getPrimeiroNome() {
        return primeiro_nome;
    }

    public void setPrimeiroNome(String primeiro_nome) {
        this.primeiro_nome = primeiro_nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public double getSalarioMensal() {
        return salario_mensal;
    }

    public void setSalarioMensal(double salario_mensal) {
        this.salario_mensal = salario_mensal;
    }

    @Override
    public String toString() {
        return "Colaborador: " + "\n" +
                "Primeiro nome: " + this.primeiro_nome + "\n" +
                "Sobrenome: " + this.sobrenome + "\n" +
                "Salário mensal: " + this.salario_mensal + "\n" +
                "Salário anual: " + this.salario_mensal * 12;
    }
}
