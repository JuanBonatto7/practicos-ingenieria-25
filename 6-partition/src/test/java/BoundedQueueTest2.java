
import org.junit.jupiter.api.*;

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

    private BoundedQueue queue;


    //Caso Base c1.b2, c2.b2, c3.b3
    @Test
    public void testBase(){
        queue = new BoundedQueue(7);
        queue.enQueue("A");
        Object o = "B";

        queue.enQueue(o);
        Object deletd = queue.deQueue();
        assertEquals("B", deletd);
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());
    }

    //Segundo caso: c1.B2, c2.B2, c3.B1
    @Test
    public void test2(){
        queue = new BoundedQueue(3);
        queue.enQueue("A");
        queue.enQueue("A");
        queue.enQueue("A");
        
        assertTrue(queue.isFull());
        assertFalse(queue.isEmpty());

        Object o = "B";
        assertThrows(IllegalStateException.class, queue.enQueue(o));

    }
    
}
