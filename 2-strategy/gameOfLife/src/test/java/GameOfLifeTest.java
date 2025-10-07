package gameOfLife;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class GameOfLifeTest {
    
    @Test
    public void celulaSinVecinos(){
        GameOfLife game = new GameOfLife(3,3, new ClasicRules());
        game.setCelula(1,1);

        boolean cel = game.getCelula(1,1);

        game.nextState();
        assertFalse(cel);
    }


}
