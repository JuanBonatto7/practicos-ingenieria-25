package gameOfLife;

public abstract class GameFactory {
    //factory method
    public abstract GameOfLife CreateGame(int rows, int cols);
}
