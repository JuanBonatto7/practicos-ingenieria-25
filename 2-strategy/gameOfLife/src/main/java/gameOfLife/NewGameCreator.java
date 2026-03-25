package gameOfLife;

public class NewGameCreator extends GameFactory {
    
    @Override
    public GameOfLife CreateGame(int rows, int cols){
        return new GameOfLife(rows,cols, new NewRules(), new NewColorStrategy());
    }

}
