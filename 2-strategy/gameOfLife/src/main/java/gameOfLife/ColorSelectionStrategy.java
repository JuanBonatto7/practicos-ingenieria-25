package gameOfLife;

import java.util.List;

public interface ColorSelectionStrategy {
    Color choseColor(List<Cell> neighborCells);
}
