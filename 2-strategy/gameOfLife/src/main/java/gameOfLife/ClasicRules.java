package gameOfLife;

public class ClasicRules implements Rules {
    
    public Cell applyRules(int neighborsAlives, Cell cell){
        boolean isAlive = cell.isAlive();
        boolean state;
        if(isAlive){
            state = neighborsAlives == 2 || neighborsAlives == 3;
        } else {
            state = neighborsAlives == 3;
        }
        return new Cell(state, cell.getColorStrategy());
    }
}
