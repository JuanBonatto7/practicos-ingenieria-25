package gameOfLife;

public class Cell {
    private boolean state;
    private ColorStrategy colorStrategy;

    public Cell(boolean state, ColorStrategy colorStrategy){
        if (colorStrategy == null) {
            // Esto hará que el programa falle inmediatamente con un mensaje claro.
            throw new IllegalArgumentException(
                "Error de diseño: Se intentó crear una Célula con una ColorStrategy nula."
            );
        }
        this.state = state;
        this.colorStrategy = colorStrategy;
    }

    public void setColorStrategy(ColorStrategy strategy){
        colorStrategy = strategy;
    }

    public Color getColor(){
        return this.colorStrategy.setColor(this.isAlive());
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
