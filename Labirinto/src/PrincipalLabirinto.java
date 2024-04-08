import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.InvalidPathException;
import java.util.Scanner;

public class PrincipalLabirinto {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Labirinto l = new Labirinto();
        String nomeArquivo = lerEntradaLabirinto();
        boolean resultado = l.labirinto(nomeArquivo);
        imprimirSaidaLabirinto(resultado);
    }

    public static String lerEntradaLabirinto() {
        while (true) {
            try {
                System.out.println("Olá! Digite o nome do arquivo que contém as informações" +
                        " sobre o labirinto.");
                String nomeArquivo = "src/arquivo/" + scanner.nextLine();
                File f = new File(nomeArquivo);

                if (nomeArquivo.lastIndexOf('.') <= 0) {
                    System.out.println("Por favor, inclua a extensão do arquivo (ex: .txt)");
                    continue;
                }

                if (!f.exists()) {
                    System.out.println("Arquivo não existe no caminho src/arquivo/nomeArquivo.txt!");
                } else if (!f.canRead()) {
                    System.out.println("Arquivo não pode ser lido!");
                } else {
                    return nomeArquivo;
                }
            } catch (NullPointerException e) {
                System.out.println("O caminho fornecido é nulo.");
            } catch (InvalidPathException e) {
                System.out.println("O caminho fornecido é inválido.");
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            }
        }
    }

    public static void imprimirSaidaLabirinto(boolean existeCaminhoLabirinto) {
        try {
            FileWriter file = new FileWriter("src/arquivo/saidaLabirinto.txt");
            PrintWriter pw = new PrintWriter(file);

            if (existeCaminhoLabirinto) {
                pw.println("Existe um caminho para o labirinto");
            } else {
                pw.println("Não existe um caminho para o labirinto");
            }

            pw.close();
            System.out.println("As informações do labirinto foram escritas no arquivo " +
                    "saidaLabirinto.txt");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro! Não foi possível gravar as informações" +
                    " sobre o caminho do labirinto.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }

}