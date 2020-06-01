package sparseMCP;

import java.util.Objects;

public class Tuple{
    public final int dim1;
    public final int dim2;


    public Tuple(int d1, int d2){
        this.dim1 = d1;
        this.dim2 = d2;
    }
    public String toString(){
        return  "(" + this.dim1 + "," + this.dim2 +")";
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple tuple = (Tuple) o;
        return dim1 == tuple.dim1 &&
                dim2 == tuple.dim2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dim1, dim2);
    }


}
