package gameOfLife;

// GameModel.java (La interfaz para nuestro Modelo)
public interface GameModel {
    void nextState();
    void setCell(int row, int col);
    Cell[][] getBoard(); // Método para que la Vista pida los datos
    void addObserver(DisplaysGameOfLife observer);
    void removeObserver(DisplaysGameOfLife observer);
}