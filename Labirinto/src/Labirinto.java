import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Labirinto {

    public Labirinto() {

    }

    public char[][] carregaLabirinto(String nomeArquivo) {
        try (BufferedReader in = new BufferedReader(new FileReader(nomeArquivo))) {
            int L = Integer.parseInt(in.readLine().trim());
            int C = Integer.parseInt(in.readLine().trim());

            char[][] labirinto = new char[L][C];

            int existDestino = 0;

            for (int i = 0; i < L; i++) {
                String linha = in.readLine();

                if (linha == null || linha.length() > C) {
                    throw new IllegalArgumentException("O número de colunas informado " +
                            "não condiz com o número de colunas do arquivo.");
                }

                if (linha.toUpperCase().contains("D")) {
                    existDestino++;
                }

                for (int j = 0; j < C; j++) {
                    labirinto[i][j] = (j < linha.length()) ? linha.charAt(j) : ' ';
                }
            }

            if (in.readLine() != null) {
                throw new IllegalArgumentException("O número de linhas informado não " +
                        "condiz com o número de linhas do arquivo.");
            }

            if (labirinto[0][0] != ' ') {
                throw new IllegalArgumentException("O primeiro campo do labirinto " +
                        "precisa ser um espaço em branco.");
            }

            if (existDestino != 1) {
                throw new IllegalArgumentException("O labirinto deve conter exatamente " +
                        "um campo de destino marcado com 'D'.");
            }

            in.close();
            return labirinto;
        } catch (NumberFormatException e) {
            System.out.println("Valores inválidos! Os primeiros registros não " +
                    "representam linha ou/e coluna.");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + nomeArquivo);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo.", e);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("O labirinto no arquivo não está bem formado.", e);
        }
        return new char[0][];
    }

    public boolean labirinto(String nomeArquivo) {
        char[][] labirinto = carregaLabirinto(nomeArquivo);

        // Verifica se o labirinto está vazio. Demais verificações já foram feitas no
        // método carrega labirinto. esse if é só para verificar se carregou direito.
        if (labirinto == null || labirinto.length == 0 || labirinto[0].length == 0) {
            throw new IllegalArgumentException("Labirinto inválido.");
        }

        return labirinto(labirinto, 0, 0);
    }

    private boolean labirinto(char[][] labirinto, int linha, int coluna) {
        if (linha < 0 || linha >= labirinto.length || coluna < 0 || coluna >= labirinto[0].length) {
            return false;
        }

        if (labirinto[linha][coluna] == 'D') {
            return true;
        }

        if (labirinto[linha][coluna] != ' ') {
            return false;
        }

        labirinto[linha][coluna] = '+';

        if (labirinto(labirinto, linha + 1, coluna) || // Baixo
                labirinto(labirinto, linha - 1, coluna) || // Cima
                labirinto(labirinto, linha, coluna + 1) || // Direita
                labirinto(labirinto, linha, coluna - 1)) { // Esquerda
            return true;
        }

        labirinto[linha][coluna] = ' ';
        return false;
    }
}