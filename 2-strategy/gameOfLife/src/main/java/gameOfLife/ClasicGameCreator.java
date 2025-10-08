package gameOfLife;

public class ClasicGameCreator extends GameFactory {
    
    @Override
    public GameOfLife CreateGame(int rows, int col){
        return new GameOfLife(rows, col, new ClasicRules(), new ClassicColorStrategy());
    }
}
