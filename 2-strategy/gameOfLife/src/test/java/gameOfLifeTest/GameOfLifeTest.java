package gameOfLifeTest;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import gameOfLife.ClasicRules;
import gameOfLife.GameOfLife;
import gameOfLife.NewRules;

public class GameOfLifeTest {
    
    @Test
    public void celulaSinVecinos(){
        GameOfLife game = new GameOfLife(3,3, new ClasicRules());
        game.setCelula(1,1);

        game.nextState();
        boolean cel = game.getCelula(1,1);
        assertFalse(cel);
    }

    @Test
    public void celulaConVecinos(){
        GameOfLife game = new GameOfLife(3,3, new ClasicRules());
        game.setCelula(1,1);
        game.setCelula(2,1);
        game.setCelula(1,2);

        game.nextState();
        boolean cel = game.getCelula(2,2);
        assertTrue(cel);
    }

    @Test
    public void newRulesTest(){
        GameOfLife game = new GameOfLife(10,10, new NewRules());
        game.setCelula(1,1);
        game.setCelula(2,1);
        game.setCelula(1,2);

        game.nextState();
        boolean cel = game.getCelula(2,2);
        assertTrue(cel);
    }

}
