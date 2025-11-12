package testing.partition.practico.ejercicio4;

public class ej4 {
    public int m(int v1, int v2, String op){
        if("+".equals(op))
            return v1 + v2;

        if("-".equals(op))
            return v1 - v2;

        if("x".equals(op))
            return v1 * v2;

        if("%".equals(op))
            return v1 / v2;

        return 0;
    }
}
