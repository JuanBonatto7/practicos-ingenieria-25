import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import ejercicio1.Cal;

public class CalTest {
    
    //rama1: entra por el if, meses iguales
    @Test 
    public void testRamaIFTrue(){
       
        assertEquals(7, Cal.cal(1, 1, 1, 8, 7777));
    
    }

    //Rama2: entra por el else y por el segundo if
    @Test
    public void testRamaIFFalseIFTrue(){
        assertEquals(68, Cal.cal(1, 1, 3, 10, 2025));
    }

    // Test 3: Múltiples meses, SÍ bisiesto, bucle se ejecuta
    // (Cubre D1-False, D2-False, D3-True)
    // 1 de enero a 10 de marzo de 2000 (Bisiesto)
    // Días restantes en Enero: (31 - 1) = 30
    // Días en Febrero: 29
    // Días en Marzo: 10
    // Total: 30 + 29 + 10 = 69
    @Test
    public void testMultiMonthLeapLoopExecutes() {
        assertEquals(69, Cal.cal(1, 1, 3, 10, 2000));
    }

    // Test 4: Meses consecutivos, bucle se salta
    // (Cubre D1-False, D3-False)
    // 1 de enero a 10 de febrero de 2025 (No bisiesto)
    // Días restantes en Enero: (31 - 1) = 30
    // Días en Febrero: 10
    // (El bucle 'for' va de i=2 a i=1, por lo que no se ejecuta)
    // Total: 30 + 10 = 40
    @Test
    public void testConsecutiveMonthsLoopSkips() {
        assertEquals(40, Cal.cal(1, 1, 2, 10, 2025));
    }
}
