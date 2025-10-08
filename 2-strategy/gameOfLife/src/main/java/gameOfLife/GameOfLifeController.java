package gameOfLife;

public class GameOfLifeController implements ControllerInterface {
    private final GameModel model;
    private boolean isRunning = false;

    
    public GameOfLifeController(GameModel model) {
        this.model = model;
    }

    public void start(){
        isRunning=true;
        for (int i = 0; i < 5; i++) {
            model.nextState();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isRunning = false;
    }

    @Override
    public void stop() {
        isRunning = false;
    }
}
