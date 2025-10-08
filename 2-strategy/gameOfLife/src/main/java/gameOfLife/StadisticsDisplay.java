package gameOfLife;

import java.util.HashMap;
import java.util.Map;

public class StadisticsDisplay implements DisplaysGameOfLife {
    public void display(Cell[][] table) {
        // Usamos un Map para contar las células de cada tipo (color).
        Map<String, Integer> conteoPorTipo = new HashMap<>();
    
        // Iteramos sobre la matriz para contar.
        for (int i = 0; i < table.length; i++) {
          for (int j = 0; j < table[0].length; j++) {
                Cell cell = table[i][j]; 
            
                // Obtenemos el tipo de célula directamente de la estrategia de color.
                // Esto funciona tanto para vivas como para muertas.
                ColorStrategy c = cell.getColorStrategy();
                Cell cell3 = new Cell(cell.isAlive(), c); // Creamos una celda temporal para obtener el color correcto
                Color color2 = cell3.getColor();
                String type2 = color2.getName();

                // Actualizamos el contador para ese tipo en el mapa.
                // getOrDefault es útil: si el tipo no está en el mapa, empieza en 0.
                int conteoActual = conteoPorTipo.getOrDefault(type2, 0);
                conteoPorTipo.put(type2, conteoActual + 1);
            }
        }

        // Mostramos las estadísticas por pantalla.
        System.out.println("--- Estadísticas de la Generación ---");
    
        // Iteramos sobre el mapa para mostrar todos los conteos.
        for (Map.Entry<String, Integer> entry : conteoPorTipo.entrySet()) {
            String tipo = entry.getKey();
            Integer cantidad = entry.getValue();
            System.out.println("Cells " + tipo + ": " + cantidad);
        }
    
        System.out.println("------------------------------------");
    }
}
