package gameOfLife;
public interface Rules {
    public Cell applyRules(int neighborsAlives, Cell cell);
}
