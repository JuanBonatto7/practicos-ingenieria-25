package gameOfLife;
public class GameMain {
    private GameOfLife game = new GameOfLife(10,10, new NewRules());
    
    public void execute(){
        int i = 5;
        game.setCelula(1,1);
        game.setCelula(1,2);
        game.setCelula(2,1);
        while(i > 0){
            System.out.println(game.toString());
            game.nextState();
            i--;
        }
    }


    public static void main(String[] args) {
        GameMain main = new GameMain();
        main.execute();
    }
    
}

