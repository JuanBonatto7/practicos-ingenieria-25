package gameOfLifeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import gameOfLife.Cell;
import gameOfLife.ClasicRules;
import gameOfLife.ClassicColorStrategy;
import gameOfLife.Color;
import gameOfLife.ColorStrategy;
import gameOfLife.GameOfLife;

public class GameOfLifeTest {
    
    @Test
    public void celulaSinVecinos(){
        GameOfLife game = new GameOfLife(3,3, new ClasicRules(), new ClassicColorStrategy());
        ColorStrategy color = game.getColorStrategy();
        game.setCell(1,1,color);

        game.nextState();
        Cell cel = game.getCell(1,1);
        assertFalse(cel.isAlive());
    }

    @Test
    public void celulaConVecinos(){
        GameOfLife game = new GameOfLife(3,3, new ClasicRules(), new ClassicColorStrategy());
        ColorStrategy color = game.getColorStrategy();
        game.setCell(1,1,color);
        game.setCell(2,1,color);
        game.setCell(1,2,color);

        game.nextState();
        Cell cel = game.getCell(2,2);
        assertTrue(cel.isAlive());
    }

    @Test
    public void newRulesTest(){
        GameOfLife game = new GameOfLife(3,3, new ClasicRules(), new ClassicColorStrategy());
        ColorStrategy color = game.getColorStrategy();
        game.setCell(1,1,color);
        game.setCell(2,1,color);
        game.setCell(1,2,color);

        game.nextState();
        Cell cel = game.getCell(2,2);
        assertTrue(cel.isAlive());
    }

    @Test
    public void ColorStrategy(){
        GameOfLife game = new GameOfLife(3,3, new ClasicRules(), new ClassicColorStrategy());
        ColorStrategy color = game.getColorStrategy();
        game.setCell(1,1,color);
        game.setCell(2,1,color);
        game.setCell(1,2,color);

        game.nextState();
        Cell cel = game.getCell(2,2);
        
        assertEquals(new Color("BLACK"), cel.getColor());
    }

}
