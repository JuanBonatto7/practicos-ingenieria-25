package gameOfLife;

public class BlackAndWhiteDisplay implements DisplaysGameOfLife {
    
    public void display(GameModel model){
        Cell[][] board = model.getBoard();
        
        for (Cell[] row : board) {
            for (Cell cell : row) {
                if (cell.isAlive()) System.out.print("⬛");
                else System.out.print("⬜");
            }
            System.out.println();
        }
        System.out.println();
    }
}

