public class ClasicRules implements Rules {
    
    public boolean applyRules(int neighborsAlives, boolean isAlive){
        if(isAlive){
            boolean state = neighborsAlives == 2 || neighborsAlives == 3;
            return state;
        } else {
            boolean state = neighborsAlives == 3;
            return state;
        }
    }
}
