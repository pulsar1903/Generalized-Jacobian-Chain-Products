package Memory;

import Graph.Vertex;

public class tuple__ {

    public final Vertex_  a;
    public final Vertex_ b;

    public tuple__(Vertex_ x, Vertex_ y){
        this.a = x;
        this.b = y;
    }

    public String toString(){
        return  "(" + this.a + "," + this.b +")";
    }
}

