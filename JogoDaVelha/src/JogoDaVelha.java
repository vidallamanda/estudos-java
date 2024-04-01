public class JogoDaVelha {

    private char[][] tabuleiro;
    private int size;

    public JogoDaVelha(int size) {
        this.tabuleiro = new char[size][size];
        // Guardar o tamanho do tabuleiro para simplificar futuras verificações
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpate() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (tabuleiro[i][j] == '\u0000') {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean realizaJogada(int row, int col, char typeXO) {
        // Verifica se a jogada está dentro das dimensões do tabuleiro
        if (row < 0 || row >= this.size || col < 0 || col >= this.size) {
            return false;
        }

        // Verifica se o caractere da jogada é válido
        if (Character.toUpperCase(typeXO) != 'X' && Character.toUpperCase(typeXO) != 'O') {
            return false;
        }

        // Verifica se o campo da jogada está vazio (em char, \u0000)
        if (this.tabuleiro[row][col] == '\u0000') {
            this.tabuleiro[row][col] = typeXO;
            return true;
        }

        return false;
    }

    public boolean verificaGanhador(int row, int col, char typeX0) {
        // Verifica se todos os caracteres na linha são iguais a typeXO
        boolean rowWin = check(row, 0, 0, 1, typeX0);

        if (rowWin) {
            return true;
        }

        // Verifica se todos os caracteres na coluna são iguais a typeXO
        boolean columnWin = check(0, col, 1, 0, typeX0);

        if (columnWin) {
            return true;
        }

        // Verifica se todos os caracteres na diagonal principal são iguais a typeXO
        boolean mainDiagonalWin = check(0, 0, 1, 1, typeX0);

        if (mainDiagonalWin) {
            return true;
        }

        // Verifica se todos os caracteres na diagonal secundária são iguais a typeXO
        boolean secondaryDiagonalWin = check(0, size - 1, 0, -1, typeX0);

        return secondaryDiagonalWin;
    }


    private boolean check(int row, int col, int incRow,
                          int incCol, char typeXO) {
        // Se chegar no limite das dimensões do tabuleiro, significa que todos os
        // caracteres são iguais
        if (row < 0 || row >= this.size || col < 0 || col >= this.size) {
            return true;
        }

        // Se encontrar algum caractere diferente, siginifica que o jogo não está ganho
        // naquela parte
        if (tabuleiro[row][col] != typeXO) {
            return false;
        }

        return check(row + incRow, col + incCol, incRow, incCol, typeXO);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  ");
        for (int i = 0; i < size; i++) {
            sb.append(i).append("  ");
        }
        sb.append("\n");

        for (int i = 0; i < size; i++) {
            sb.append(i).append("  ");
            for (int j = 0; j < size; j++) {
                sb.append(tabuleiro[i][j]);
                if (j < size - 1) {
                    sb.append("|");
                }
            }
            sb.append("\n");
            if (i < size - 1) {
                sb.append("  ").append("-".repeat(size * 2 - 1)).append("\n");
            }
        }
        return sb.toString();
    }
}
