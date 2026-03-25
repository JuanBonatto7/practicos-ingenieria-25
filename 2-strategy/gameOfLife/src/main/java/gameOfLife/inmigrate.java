package gameOfLife;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class inmigrate implements ColorSelectionStrategy {
    
    @Override
    public Color choseColor(List<Cell> neighborCells){

        Map<String, Integer> colorCount = new HashMap<>();
        for(Cell c : neighborCells){
            
            if(c.isAlive()){
                String colorName = c.getColor().getName();
                colorCount.put(colorName, colorCount.getOrDefault(colorName, 0) + 1);
            }

        }

        String majorityColor = null;
        int max = 0;
        for(Map.Entry<String, Integer> entry : colorCount.entrySet()){
            if (entry.getValue() > max) {
                max = entry.getValue();
                majorityColor = entry.getKey();
            }
        }

        return new Color(majorityColor);
    }
}
