package testing.partition.practico.ejercicio4;

/**
 * Solución al Ejercicio 4: Particionado del Espacio de Entradas.
 *
 * SUT: m(int p1, int p2, char p3)
 *
 * Características Corregidas:
 * C1 (Value 1, p1):
 * B1.1: < 0 (ej: -5)
 * B1.2: = 0 (ej: 0)
 * B1.3: > 0 (ej: 5)
 * C2 (Value 2, p2):
 * B2.1: < 0 (ej: -10)
 * B2.2: = 0 (ej: 0)
 * B2.3: > 0 (ej: 10)
 * C3 (Operation, p3):
 * B3.1: '+'
 * B3.2: '-'
 * B3.3: '*'
 * B3.4: '/'
 */
public class Ejercicio4Test {

    // ---------------------------------------------------------------------
    // a) Pruebas para Each Choice Coverage (ECC)
    // ---------------------------------------------------------------------

    class EachChoiceCoverage {

        /**
         * ECC requiere un test para cada bloque.
         * Mínimo de tests = max(3, 3, 4) = 4 tests.
         */

        void testECC1() {
            // p1 < 0, p2 < 0, p3 = '+'
            assertEquals(-15.0, m(-5, -10, '+'));
        }


        void testECC2() {
            // p1 = 0, p2 = 0, p3 = '-'
            assertEquals(0.0, m(0, 0, '-'));
        }

        @Test
        @DisplayName("T3: Cubre C1.B3, C2.B3, C3.B3")
        void testECC3() {
            // p1 > 0, p2 > 0, p3 = '*'
            assertEquals(50.0, m(5, 10, '*'));
        }

        @Test
        @DisplayName("T4: Cubre C3.B4 (y C1.B1, C2.B3)")
        void testECC4() {
            // p1 < 0, p2 > 0, p3 = '/'
            // Usamos C1.B1 y C2.B3 (ya cubiertos) para cubrir el bloque restante C3.B4
            assertEquals(-0.5, m(-5, 10, '/'));
        }
    }

    // ---------------------------------------------------------------------
    // b) Pruebas para Base Choice Coverage (BCC)
    // ---------------------------------------------------------------------
    @Nested
    @DisplayName("b) Base Choice Coverage (BCC)")
    class BaseChoiceCoverage {

        // Base: p1 > 0 (C1.B3), p2 > 0 (C2.B3), p3 = '+' (C3.B1)
        // Valores Base: p1=5, p2=10, p3='+'
        // Total de Tests = 1 + (3-1) + (3-1) + (4-1) = 1 + 2 + 2 + 3 = 8 tests.

        @Test
        @DisplayName("Test Base: (p1>0, p2>0, p3='+')")
        void testBase() {
            // Base: (C1.B3, C2.B3, C3.B1)
            assertEquals(15.0, m(5, 10, '+'));
        }

        // Variaciones de C1
        @Test
        @DisplayName("Varia C1.B1: (p1<0, p2>0, p3='+')")
        void testVaryC1_B1() {
            // (C1.B1, C2.B3, C3.B1)
            assertEquals(5.0, m(-5, 10, '+'));
        }

        @Test
        @DisplayName("Varia C1.B2: (p1=0, p2>0, p3='+')")
        void testVaryC1_B2() {
            // (C1.B2, C2.B3, C3.B1)
            assertEquals(10.0, m(0, 10, '+'));
        }

        // Variaciones de C2
        @Test
        @DisplayName("Varia C2.B1: (p1>0, p2<0, p3='+')")
        void testVaryC2_B1() {
            // (C1.B3, C2.B1, C3.B1)
            assertEquals(-5.0, m(5, -10, '+'));
        }

        @Test
        @DisplayName("Varia C2.B2: (p1>0, p2=0, p3='+')")
        void testVaryC2_B2() {
            // (C1.B3, C2.B2, C3.B1)
            assertEquals(5.0, m(5, 0, '+'));
        }

        // Variaciones de C3
        @Test
        @DisplayName("Varia C3.B2: (p1>0, p2>0, p3='-')")
        void testVaryC3_B2() {
            // (C1.B3, C2.B3, C3.B2)
            assertEquals(-5.0, m(5, 10, '-'));
        }

        @Test
        @DisplayName("Varia C3.B3: (p1>0, p2>0, p3='*')")
        void testVaryC3_B3() {
            // (C1.B3, C2.B3, C3.B3)
            assertEquals(50.0, m(5, 10, '*'));
        }

        @Test
        @DisplayName("Varia C3.B4: (p1>0, p2>0, p3='/')")
        void testVaryC3_B4() {
            // (C1.B3, C2.B3, C3.B4)
            assertEquals(0.5, m(5, 10, '/'));
        }
    }

    // ---------------------------------------------------------------------
    // c) ¿Cuántos tests se necesitan para All Combinations Coverage (ACoC)?
    // ---------------------------------------------------------------------

    // (3 bloques en C1) x (3 bloques en C2) x (4 bloques en C3) = 3 * 3 * 4 = 36 tests.
    //
    // RESPUESTA: Se necesitan 36 tests para satisfacer ACoC.
    

    // ---------------------------------------------------------------------
    // d) Pruebas para Pair-Wise Coverage (PWC)
    // ---------------------------------------------------------------------
    @Nested
    @DisplayName("d) Pair-Wise Coverage (PWC)")
    class PairWiseCoverage {

        // PWC requiere que cada par de bloques entre características sea cubierto.
        // Pares C1xC2 (3x3=9), C1xC3 (3x4=12), C2xC3 (3x4=12). Total 33 pares.
        // Un array ortogonal o una herramienta (como ACTS) genera el conjunto mínimo.
        // El mínimo de tests es 12 (producto de las dos características más grandes, 3x4).

        // Este conjunto de 12 tests cubre los 33 pares:
        @Test void testPWC_01() { assertEquals(-15.0, m(-5, -10, '+')); } // C1.B1, C2.B1, C3.B1
        @Test void testPWC_02() { assertEquals(-5.0,  m(-5, 0, '-'));   } // C1.B1, C2.B2, C3.B2
        @Test void testPWC_03() { assertEquals(-50.0, m(-5, 10, '*'));  } // C1.B1, C2.B3, C3.B3
        @Test void testPWC_04() { assertEquals(-0.5,  m(-5, -10, '/')); } // C1.B1, C2.B1, C3.B4

        @Test void testPWC_05() { assertEquals(0.0,   m(0, 0, '+'));    } // C1.B2, C2.B2, C3.B1
        @Test void testPWC_06() { assertEquals(-10.0, m(0, 10, '-'));   } // C1.B2, C2.B3, C3.B2
        @Test void testPWC_07() { assertEquals(0.0,   m(0, -10, '*'));  } // C1.B2, C2.B1, C3.B3
        @Test
        void testPWC_08() {
            // (C1.B2, C2.B2, C3.B4) -> p1=0, p2=0, p3='/'
            // Este es un test de un caso límite (0/0)
            // Asumimos 0/0 = 0 (NaN es otra opción, pero 0 es más simple para este test)
            assertEquals(0.0, m(0, 0, '/'));
        }

        @Test void testPWC_09() { assertEquals(15.0,  m(5, 10, '+'));   } // C1.B3, C2.B3, C3.B1
        @Test void testPWC_10() { assertEquals(15.0,  m(5, -10, '-'));  } // C1.B3, C2.B1, C3.B2
        @Test void testPWC_11() { assertEquals(0.0,   m(5, 0, '*'));    } // C1.B3, C2.B2, C3.B3
        @Test void testPWC_12() { assertEquals(0.5,   m(5, 10, '/'));   } // C1.B3, C2.B3, C3.B4
    }


    // ---------------------------------------------------------------------
    // SUT (System Under Test) Simulado
    // ---------------------------------------------------------------------

    /**
     * Este es el método 'm' bajo prueba.
     * La lógica interna se implementa solo para que los tests tengan un 
     * resultado que afirmar (assert).
     */
    private double m(int p1, int p2, char p3) {
        // Imprimimos la entrada para verificar visualmente la cobertura
        System.out.printf("Test ejecutado: m(p1=%d, p2=%d, p3='%c')\n", p1, p2, p3);

        switch (p3) {
            case '+':
                return (double) p1 + p2;
            case '-':
                return (double) p1 - p2;
            case '*':
                return (double) p1 * p2;
            case '/':
                if (p2 == 0) {
                    // Si p1 también es 0, definimos 0/0 como 0 para el test
                    if (p1 == 0) return 0.0; 
                    
                    // Si p1 != 0, lanzamos una excepción (caso de error)
                    throw new ArithmeticException("División por cero");
                }
                return (double) p1 / p2;
            default:
                throw new IllegalArgumentException("Operación no válida");
        }
    }
}
