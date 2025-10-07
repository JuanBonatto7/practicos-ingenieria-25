package gameOfLife;
public class ClassicColorStrategy implements ColorStrategy {
    
    @Override
    public Color setColor(boolean isAlive) {
        return isAlive ? new Color("BLACK") : new Color("WHITE");
    
    }
}
