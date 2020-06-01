package Graph;

public class tuple_ {

    public final Vertex a;
    public final Vertex b;

    public tuple_(Vertex x, Vertex y){
        this.a = x;
        this.b = y;
    }

    public String toString(){
        return  "(" + this.a + "," + this.b +")";
    }
}
