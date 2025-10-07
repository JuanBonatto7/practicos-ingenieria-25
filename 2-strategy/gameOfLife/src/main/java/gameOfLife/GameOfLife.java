package gameOfLife;
public class GameOfLife {
    private boolean[][] matrix;
    private Rules rule;
    private int rows;
    private int cols;

    public GameOfLife(int rows, int cols, Rules rule){
        this.rows = rows;
        this.cols = cols;
        this.matrix = new boolean[rows][cols];
        this.rule = rule; 
    }

    public void setCelula(int row, int col){
        matrix[row][col] = true;
    }

    public boolean getCelula(int row, int col){
        return matrix[row][col];
    }

    public void nextState(){
        boolean[][] newMatrix = new boolean[rows][cols];
        int neighbor;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                neighbor = CountLives(i, j);
                boolean state = matrix[i][j];

                newMatrix[i][j] = rule.applyRules(neighbor, state);
            }
        }

        this.matrix = newMatrix;
    }

    public int CountLives(int fila, int col){
        int vecinosVivos = 0;

        // Iteramos en un cuadrado de 3x3 alrededor de la célula (fila, col)
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // Si estamos en la célula del centro, la saltamos.
                if (i == 0 && j == 0) {
                    continue;
                }

                int vecinoFila = fila + i;
                int vecinoCol = col + j;

                // Verificamos que el vecino esté DENTRO de los límites del tablero.
                // Esta es la parte clave para evitar errores en los bordes.
                if (vecinoFila >= 0 && vecinoFila < this.rows &&
                    vecinoCol >= 0 && vecinoCol < this.cols) {
                    
                    // Si el vecino está vivo, lo contamos.
                    if (matrix[vecinoFila][vecinoCol]) {
                        vecinosVivos++;
                    }
                }
            }
        }
        return vecinosVivos;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Generation:\n");
        
        for (boolean[] matrix1 : matrix) {
            for (int j = 0; j < matrix1.length; j++) {
                sb.append(matrix1[j] ? 'X' : '_');
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
