import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import testing.partition.practico.ejercicio5.BoundedQueue;

public class BoundedQueueTest {
    // TESTS PARA EL CONSTRUCTOR: BoundedQueue(int capacity)
    // -----------------------------------------------------------------
    // Partición:
    // b1: capacity < 0 (Inválido)
    // b2: capacity = 0 (Válido, borde)
    // b3: capacity > 0 (Válido, general)
    
    @Test
    public void testConstructorCapacidadNegativa() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BoundedQueue(-7);
        });
    }

    @Test
    public void testConstructorCapacidadCero(){
            BoundedQueue cola = new BoundedQueue(0);

            assertNotNull(cola);
            assertTrue(cola.isEmpty());
            assertTrue(cola.isFull()); // Caso especial: una cola de cap 0 está vacía y llena a la vez
            assertEquals("[]", cola.toString());
    }

    @Test
    public void testConstructorCapacidadPositiva(){
        BoundedQueue cola = new BoundedQueue(7);

            assertNotNull(cola);
            assertTrue(cola.isEmpty());
            assertTrue(cola.isFull()); 
            assertEquals("[]", cola.toString());
    }

    // TESTS PARA EL MÉTODO: enQueue(Object o)
    // -----------------------------------------------------------------
    // Partición (Combinada):
    // Característica 1 (Objeto o):
    //   b1.1: o es null
    //   b1.2: o no es null
    // Característica 2 (Estado de la cola):
    //   b2.1: No llena (size < capacity)
    //   b2.2: Llena (size == capacity)
    //   b2.3: Capacidad 0 (caso especial de "Llena")
    //
    // Casos de Prueba (Combinaciones):
    // 1. (b1.1) + (b2.1) -> o=null, cola no llena  => NullPointerException
    // 2. (b1.2) + (b2.1) -> o!=null, cola no llena => Éxito, se agrega
    // 3. (b1.2) + (b2.2) -> o!=null, cola llena   => IllegalStateException
    // 4. (b1.2) + (b2.3) -> o!=null, cola cap 0  => IllegalStateException

    @Test
    public void testEnQueueObjetoNull(){
        BoundedQueue cola = new BoundedQueue(7);
        assertThrows(NullPointerException.class, () -> {
            cola.enQueue(null);
        });
    }

    // 2. (b1.2) + (b2.1) -> o!=null, cola no llena => Éxito, se agrega
    @Test
    public void testEnQueueObjetoNoNull1(){
        BoundedQueue cola = new BoundedQueue(7);
        Object objeto = new Object();

        cola.enQueue(objeto);
        assertFalse(cola.isEmpty());
        assertFalse(cola.isFull());
        assertEquals(objeto, cola.deQueue());
    }

    // 3. (b1.2) + (b2.2) -> o!=null, cola llena   => IllegalStateException
    @Test 
    public void testEnQueueObjetoNoNull2(){
        
    }
}
