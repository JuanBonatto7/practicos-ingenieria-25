package gameOfLife;

public class Cell {
    private boolean state;
    private ColorStrategy colorStrategy;

    public Cell(boolean state, ColorStrategy colorStrategy){
        this.state = state;
        this.colorStrategy = colorStrategy;
    }

    public void setColorStrategy(ColorStrategy strategy){
        colorStrategy = strategy;
    }

    public Color getColor(){
        return colorStrategy.setColor(state);
    }

    public boolean isAlive(){
        return state;
    }

    public void setState(boolean state){
        this.state = state;
    }
    
    public ColorStrategy getColorStrategy(){
        return colorStrategy;
    }
}
