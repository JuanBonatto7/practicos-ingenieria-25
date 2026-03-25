package gameOfLife;

public class NewColorStrategy implements ColorStrategy {

    @Override
    public Color setColor(boolean isAlive){
        if(isAlive){
            return new Color("GREEN");
        }else{
            return new Color("RED");
        }
    }
    
}
