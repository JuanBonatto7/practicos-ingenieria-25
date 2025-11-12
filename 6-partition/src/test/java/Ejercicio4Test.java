
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import testing.partition.practico.ejercicio4.ej4;

public class Ejercicio4Test {

    public ej4 eme = new ej4();
    //-------------------TESTS ECC---------------------

    //TEST1 = (v1 = B1), (v2 = B1), (op = B1)
    @Test
    public void eccTest1(){
        assertEquals(-20 , eme.m((-15), (-5), "+"));
    }

    @Test
    //TEST2 = (v1 = B2), (v2 = B2), (op = B2)
    public void eccTest2(){
        assertEquals(0, (short) eme.m((0),(0),"-"));
    }

    //TEST3 = (v1 = B3), (v2 = B3), (op = B3)
    @Test
    public void eccTest3(){
        assertEquals(20 , eme.m(4, 5, "x"));
    }

    //TEST4 = (v1 = B3), (v2 = B3), (op = B4)
    @Test
    public void eccTest4(){
        assertEquals(5 , eme.m(20, 4, "%"));
    }

    //-------------------TEST BCC---------------------

    //Test1= test base = (v1 = B2),(v2 = B2),(op = B3)
    // alta paja hacerlos
    
   
}
