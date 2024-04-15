package Exercicio2;

import java.util.ArrayList;
import java.util.Scanner;

public class CadastroPais {

    static Scanner scanner = new Scanner(System.in);

    public static Pais cadastraPais() {
        while (true) {
            try{
                System.out.println("Informe os dados do país para cadastro: ");
                System.out.println("Nome: ");
                String nome = scanner.nextLine();
                System.out.println("Dimensão (em km²): ");
                double dimensao = Double.parseDouble(scanner.nextLine());
                System.out.println("População: ");
                double populacao = Double.parseDouble(scanner.nextLine());

                return new Pais(nome, dimensao, populacao);
            } catch (NumberFormatException e) {
                System.out.println("Não foi informado um valor válido para o campo.");
            }
        }
    }

    public static ArrayList<Pais> cadastraAmericaDoNorte() {
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(new Pais("Estados Unidos", 9_826_675, 331_002_651));
        paises.add(new Pais("Canadá", 9_984_670, 37_742_154));
        paises.add(new Pais("México", 1_964_375, 128_932_753));
        return paises;
    }

    public static ArrayList<Pais> cadastraAmericaCentral() {
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(new Pais("Guatemala", 108889, 17_915_568));
        paises.add(new Pais("Cuba", 110860, 11_326_616));
        paises.add(new Pais("Honduras", 112492, 9_904_607));
        paises.add(new Pais("Nicarágua", 130373, 6_624_554));
        paises.add(new Pais("El Salvador", 21040, 6_486_205));
        paises.add(new Pais("Costa Rica", 51100, 5_094_118));
        paises.add(new Pais("Panamá", 75_417, 4_314_767));
        return paises;
    }


    public static ArrayList<Pais> cadastraAmericaDoSul() {
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(new Pais("Brasil", 8_515_767, 213_993_437));
        paises.add(new Pais("Argentina", 2_780_400, 45_376_763));
        paises.add(new Pais("Colômbia", 1_138_910, 50_882_891));
        paises.add(new Pais("Peru", 1_285_220, 32_971_854));
        paises.add(new Pais("Venezuela", 916445, 28_435_940));
        paises.add(new Pais("Chile", 756950, 19_116_201));
        paises.add(new Pais("Equador", 276841, 17_643_054));
        paises.add(new Pais("Bolívia", 1_098_581, 11_673_021));
        paises.add(new Pais("Paraguai", 406752, 7_132_538));
        paises.add(new Pais("Uruguai", 181034, 3_473_730));
        return paises;
    }


    public static ArrayList<Pais> cadastraEuropa() {
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(new Pais("Rússia", 17_098_242, 145_934_462));
        paises.add(new Pais("França", 551_695, 65_273_511));
        paises.add(new Pais("Alemanha", 357_022, 83_783_942));
        paises.add(new Pais("Reino Unido", 242_495, 67_886_011));
        paises.add(new Pais("Itália", 301_340, 60_461_826));
        paises.add(new Pais("Espanha", 505_992, 46_754_778));
        paises.add(new Pais("Ucrânia", 603_500, 41_660_982));
        paises.add(new Pais("Polônia", 312_696, 37_846_611));
        paises.add(new Pais("Romênia", 238_397, 19_237_691));
        paises.add(new Pais("Holanda", 41_543, 17_134_872));
        return paises;
    }


    public static ArrayList<Pais> cadastraAsia() {
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(new Pais("China", 9_596_961, 1_439_323_776));
        paises.add(new Pais("Índia", 3_287_263, 1_380_004_385));
        paises.add(new Pais("Indonésia", 1_904_569, 273_523_615));
        paises.add(new Pais("Paquistão", 881_913, 220_892_340));
        paises.add(new Pais("Bangladesh", 143_998, 164_689_383));
        paises.add(new Pais("Japão", 377_975, 126_476_461));
        paises.add(new Pais("Filipinas", 300_000, 109_581_078));
        paises.add(new Pais("Vietnã", 331_212, 97_338_579));
        paises.add(new Pais("Irã", 1_648_195, 83_992_949));
        paises.add(new Pais("Turquia", 783_562, 84_339_067));
        return paises;
    }


    public static ArrayList<Pais> cadastraOceania() {
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(new Pais("Austrália", 7_692_024, 25_499_884));
        paises.add(new Pais("Nova Zelândia", 270_467, 4_822_233));
        paises.add(new Pais("Papua-Nova Guiné", 462_840, 8_947_024));
        paises.add(new Pais("Fiji", 18_274, 896_445));
        paises.add(new Pais("Ilhas Salomão", 28_896, 686_884));
        paises.add(new Pais("Samoa", 2_831, 198_414));
        paises.add(new Pais("Kiribati", 811, 119_449));
        paises.add(new Pais("Vanuatu", 12_189, 307_145));
        paises.add(new Pais("Tonga", 747, 105_695));
        paises.add(new Pais("Micronésia", 702, 115_023));
        return paises;
    }

    public static ArrayList<Pais> cadastraAfrica() {
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(new Pais("Nigéria", 923_768, 206_139_589));
        paises.add(new Pais("Egito", 1_010_408, 102_334_404));
        paises.add(new Pais("Etiópia", 1_104_300, 114_963_588));
        paises.add(new Pais("República Democrática do Congo", 2_344_858, 89_561_403));
        paises.add(new Pais("Tanzânia", 947_303, 59_734_218));
        paises.add(new Pais("África do Sul", 1_221_037, 59_308_690));
        paises.add(new Pais("Quênia", 580367, 54_985_698));
        paises.add(new Pais("Uganda", 241, 45_741_007));
        paises.add(new Pais("Argélia", 2_381_741, 43_851_044));
        paises.add(new Pais("Sudão", 1_886_068, 44_909_353));
        return paises;
    }
}
