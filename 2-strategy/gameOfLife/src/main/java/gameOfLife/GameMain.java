package gameOfLife;


public class GameMain {
    private GameOfLife game = new GameOfLife(10,10, new NewRules(), new ClassicColorStrategy());
    
    public void execute(){
        int i = 5;
        ColorStrategy color= game.getColorStrategy();
        game.setCell(1,1, color);
        game.setCell(1,2, color);
        game.setCell(2,1, color);
        
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

