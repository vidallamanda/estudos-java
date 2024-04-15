package Exercicio2;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Continente {

    private String nome;
    private ArrayList<Pais> paises;

    public Continente(String nome) {
        this.nome = nome;
        this.paises = new ArrayList<Pais>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPaises(ArrayList<Pais> paises) {
        this.paises = paises;
    }

    public int getCountPaises() {
      return paises.size();
    }

    public void adicionaPais(Pais p) {
        paises.add(p);
    }

    public double dimensaoTotal() {
        double count = 0;
        for (Pais p : paises) {
            count += p.getDimensao();
        }
        return count;
    }

    public double populacaoTotal() {
        double count = 0;
        for (Pais p : paises) {
            count += p.getPopulacao();
        }
        return count;
    }

    public double densidadePopulacional() {
        return populacaoTotal() / dimensaoTotal();
    }

    public ArrayList<Pais> maiorPopulacao() {
        Pais maior = paises.getFirst();

        for (int i = 1; i < paises.size(); i++) {
            if (maior.getPopulacao() < paises.get(i).getPopulacao()) {
                maior = paises.get(i);
            }
        }

        return encontraPaisMesmaPopulacao(maior.getPopulacao());
    }

    public ArrayList<Pais> menorPopulacao() {
        Pais menor = paises.getFirst();

        for (int i = 1; i < paises.size(); i++) {
            if (menor.getPopulacao() > paises.get(i).getPopulacao()) {
                menor = paises.get(i);
            }
        }

        return encontraPaisMesmaPopulacao(menor.getPopulacao());
    }

    public ArrayList<Pais> encontraPaisMesmaPopulacao(double populacao) {
        return (ArrayList<Pais>) paises.stream().filter(pais -> pais.getPopulacao() == populacao)
                .collect(Collectors.toList());
    }

    public ArrayList<Pais> maiorDimensao() {
        Pais maior = paises.getFirst();

        for (int i = 1; i < paises.size(); i++) {
            if (maior.getDimensao() < paises.get(i).getDimensao()) {
                maior = paises.get(i);
            }
        }

        return encontraPaisMesmaDimensao(maior.getDimensao());
    }

    public ArrayList<Pais> menorDimensao() {
        Pais menor = paises.getFirst();

        for (int i = 1; i < paises.size(); i++) {
            if (menor.getDimensao() > paises.get(i).getDimensao()) {
                menor = paises.get(i);
            }
        }

        return encontraPaisMesmaDimensao(menor.getDimensao());
    }

    public ArrayList<Pais> encontraPaisMesmaDimensao(double dimensao) {
        return (ArrayList<Pais>) paises.stream().filter(pais -> pais.getDimensao() == dimensao)
                .collect(Collectors.toList());
    }

    public double razaoTerritorialMaiorMenorPais() {
        if (paises.isEmpty()) {
            return 0.0;
        }

        double maior = maiorDimensao().getFirst().getDimensao();
        double menor = menorDimensao().getFirst().getDimensao();

        return maior / menor;
    }

    @Override
    public String toString() {
        return "Continente: " +
                "Nome: " + nome + '\n' +
                "Quantidade de países: " + paises.size() + '\n' +
                "Dimensão total: " + dimensaoTotal() + '\n' +
                "População total: " + populacaoTotal() + '\n' +
                "Densidade populacional: " + densidadePopulacional();
    }
}
