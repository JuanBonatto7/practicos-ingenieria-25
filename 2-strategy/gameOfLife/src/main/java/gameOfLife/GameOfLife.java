package gameOfLife;

import java.util.ArrayList;
import java.util.List;

public class GameOfLife implements GameModel {
    private Cell[][] matrix;
    private Rules rule;
    private ColorStrategy colorStrategy;
    private int rows;
    private int cols;
    private List<DisplaysGameOfLife> displays = new ArrayList<>();

    public GameOfLife(int rows, int cols, Rules rule, ColorStrategy colorStrategy) {
    this.rows = rows;
    this.cols = cols;
    this.matrix = new Cell[rows][cols];
    this.rule = rule; 
    this.colorStrategy = colorStrategy;
    this.displays = new ArrayList<>(); // Solo inicializamos la lista

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            matrix[i][j] = new Cell(false, this.colorStrategy);
        }
    }
}

    @Override
    public Cell[][] getBoard() {
        // TODO Auto-generated method stub
        return matrix;
    }

    // El método público para registrar observadores (que ya deberías tener de la interfaz Subject)
    public void addObserver(DisplaysGameOfLife observer) {
    this.displays.add(observer);
    }


    public void removeObserver(DisplaysGameOfLife display){
        displays.remove(display);
    }

    public void notifyDisplays(){
        for( DisplaysGameOfLife d : displays){
            d.display(this);
        }
    }
    

    public void setCell(int row, int col){
       matrix[row][col] = new Cell(true, this.colorStrategy); 
    }

    public Cell getCell(int row, int col){
        return matrix[row][col];
    }

    public ColorStrategy getColorStrategy(){
        return colorStrategy;
    }

    public void nextState(){
        Cell[][] newMatrix = new Cell[rows][cols];
        int neighbor;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                neighbor = CountLives(i, j);
                Cell cell = matrix[i][j];

                newMatrix[i][j] = rule.applyRules(neighbor, cell);
            }
        }

        this.matrix = newMatrix;
        notifyDisplays();
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
                    Cell cell = matrix[vecinoFila][vecinoCol];
                    boolean state = cell.isAlive();

                    if (state) {
                        vecinosVivos++;
                    }
                }
            }
        }
        return vecinosVivos;
    }


}
