import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ejercicio3.TriTyp;

public class TriTypTest {

    public TriTyp tri;

    @BeforeEach
    public void setUp(){
        tri = new TriTyp();
    }

    @Test
    public void D1(){
        int triangle = tri.trinag(0, 5,7);
        assertEquals(4,triangle);
    }

    @Test
    public void D7(){
        int triangle = tri.triangle(7,7,7);
        assertEquals(3, triangle);
    }

    @Test
    public void D6_1(){
        int triangle = tri.triangle(1,2,3);
        assertEquals(4, triangle);
    }
    @Test
    public void D6_2(){
        int triangle = tri.triangle(4,5,7);
        assertEquals(3, triangle);
    }
    
}
