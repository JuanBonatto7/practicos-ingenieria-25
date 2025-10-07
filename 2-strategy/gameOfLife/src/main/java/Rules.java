package gameOfLife;
public interface Rules {
    public boolean applyRules(int neighborsAlives, boolean isAlive);
}
