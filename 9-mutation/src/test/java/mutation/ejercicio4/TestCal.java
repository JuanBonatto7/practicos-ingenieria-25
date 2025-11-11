package mutation.ejercicio4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestCal {

	@Test
	void test() {
		int diaEsperado = Cal.cal(6, 1, 6, 2, 2024);
		assertEquals(1, diaEsperado);
	}

	@Test
	void testBisiesto(){
		assertEquals(10, Cal.cal(5,27,6,6,2025));
	}
	
	@Test
	void testBisiesto2(){
		assertEquals(10, Cal.cal(5,27,6,6,4000));
	}

	@Test
	void febreroTest(){
		assertEquals(29, Cal.cal(2,1,3,1,4000));
	}

	@Test
	void mesesIntermedios(){
		assertEquals(59, Cal.cal(1,1,3,1,2023));
	}

	@Test
    void testNoBisiestoDivisiblePor100() {
        // Año 2100 NO es bisiesto (Feb tiene 28 días)
        // Probamos del 1 de Feb al 1 de Mar en 2100.
        // El resultado debe ser 28 días.
        
        int dias = Cal.cal(2, 1, 3, 1, 2100);
        
        // El mutante que cambie la lógica del "m400"
        // pensará que 2100 es bisiesto y devolverá 29.
        // Este assert(28, 29) fallará y el mutante morirá.
        assertEquals(28, dias);
    }
}
