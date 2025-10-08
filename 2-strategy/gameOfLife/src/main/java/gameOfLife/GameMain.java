package gameOfLife;

public class GameMain {
    private GameFactory factory = new ClasicGameCreator();
    private GameOfLife game = factory.CreateGame(10, 10);
    
    public void execute() {
        int i = 5;
        game.addDisplay(new BlackAndWhiteDisplay());
        game.addDisplay(new StadisticsDisplay());

        game.setCell(1, 1);
        game.setCell(1, 2);
        game.setCell(1, 3);
        game.setCell(7, 7);
        game.setCell(7, 8);
        game.setCell(8, 8);
        game.setCell(2, 2);
        game.setCell(8,6);

        // 🔔 El display se va a actualizar automáticamente en cada iteración
        while (i > 0) {
            game.nextState();
            i--;
            try {
                Thread.sleep(2000); // Pausa para ver el cambio entre generaciones
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        GameMain main = new GameMain();
        main.execute();
    }
}


