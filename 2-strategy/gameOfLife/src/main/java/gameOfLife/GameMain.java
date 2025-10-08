package gameOfLife;

public class GameMain {


    public static void main(String[] args) {
        GameFactory factory = new ClasicGameCreator();
        GameModel model = factory.CreateGame(10, 10);

        // 2. Creamos el Controlador y lo conectamos con el Modelo
        ControllerInterface controller = new GameOfLifeController(model);

        // 3. Creamos las Vistas
        DisplaysGameOfLife consoleDisplay = new BlackAndWhiteDisplay();
        DisplaysGameOfLife statsDisplay = new StadisticsDisplay();

        // 4. Registramos las Vistas como observadoras del Modelo
        model.addObserver(consoleDisplay);
        model.addObserver(statsDisplay);
        
        // --- INICIO DE LA APLICACIÓN ---
        
        // Pre-configuramos el estado inicial a través del Modelo
        model.setCell(1, 2);
        model.setCell(2, 2);
        model.setCell(3, 2);

        // 5. Le damos el control al Controlador para que inicie la simulación
        controller.start();
    }
}


