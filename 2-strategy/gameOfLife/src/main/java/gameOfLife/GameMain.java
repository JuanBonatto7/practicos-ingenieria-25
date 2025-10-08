package gameOfLife;

public class GameMain {
    private GameOfLife game = new GameOfLife(
        10, 10,
        new NewRules(),
        new ClassicColorStrategy(),
        new BlackAndWhiteDisplay() // 👈 Display agregado desde el constructor
    );
    
    public void execute() {
        int i = 5;
        ColorStrategy color = game.getColorStrategy();

        game.setCell(1, 1, color);
        game.setCell(1, 2, color);
        game.setCell(1, 3, color);

        // 🔔 El display se va a actualizar automáticamente en cada iteración
        while (i > 0) {
            game.nextState();
            i--;
            try {
                Thread.sleep(500); // Pausa para ver el cambio entre generaciones
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


