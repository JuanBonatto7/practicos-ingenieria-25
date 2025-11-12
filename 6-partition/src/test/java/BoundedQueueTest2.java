import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import testing.partition.practico.ejercicio5.BoundedQueue;
public class BoundedQueueTest2 {
    /*
     * C1 capacity
     *      B1 = capacity < 0
     *      B2 = capacity > 0
     *      B3 = capacity == 0
     * 
     * C2 o
     *      B1 = o == null
     *      b2 = o != null
     * 
     * C3 estado de la cola
     *      B1 = cola llena (size == capacity)
     *      B2 = cola vacia (size == 0)
     *      B3 = cola parcial (0 < size < capacity)
     * 
     * BCC = C1.B2, C2.B2, C3.B3
     * 
    */

    BoundedQueue queue;

    @BeforeEach
    void setUp() {
        // C1.B2: capacity > 0 
        queue = new BoundedQueue(7);
        // C3.B3: Estado Parcial (Agregamos 1 elemento)
        queue.enQueue("A");
    }

    //Caso Base c1.b2, c2.b2, c3.b3
    @Test
    public void testBaseEnqueue(){
        //C2.B2 o != null
        Object o = "B";
        queue.enQueue(o);

        assertFalse(queue.isFull());
        assertFalse(queue.isEmpty());
    }

    //Caso Base c1.b2, c2.b2, c3.b3
    @Test
    public void testBasedequeue(){
        Object obj = queue.deQueue();
        assertEquals(obj, "A");
        assertTrue(queue.isEmpty());
    }

    //Caso Base c1.b2, c2.b2, c3.b3
    @Test
    public void testBaseIsEmpty(){
        assertFalse(queue.isEmpty());
    }

    //Caso Base c1.b2, c2.b2, c3.b3
    @Test
    public void testBaseIsFul(){
        assertFalse(queue.isFull());
    }

}
