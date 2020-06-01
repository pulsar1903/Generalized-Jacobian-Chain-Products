package naivMCP;

import Generic.*;


public class SimpleMCP extends MatrixInfo {
    final int dim1;
    final int dim2;
    public SimpleMCP(String n, int dimension1, int dimension2){
        super(n);
        this.dim1 = dimension1;
        this.dim2 = dimension2;

    }

    public static SimpleMCP combine(SimpleMCP first, SimpleMCP second){

        return new SimpleMCP("(" + first.name + "*" + second.name + ")", first.dim1, second.dim2);
    }
}