package sparseMCP;

import java.util.*;

import Generic.*;
import com.sun.source.tree.NewArrayTree;

import java.util.stream.Collectors;



public class SparseMCP  extends MatrixInfo {
    public List<Tuple> nonZeros;
    final int dim1;
    final int dim2;
    public SparseMCP(String n, int d1, int d2, List<Tuple> nonZeros) {
        super(n);
        this.nonZeros = nonZeros;
        this.dim1 = d1;
        this.dim2 = d2;

    }



    public static SparseMCP combine(SparseMCP first, SparseMCP second){
        List<Tuple> newNonZeros = new ArrayList<>();
        for(int i = 0; i<first.nonZeros.size();i++){
            for(int j = 0; j< second.nonZeros.size(); j++){
                if(first.nonZeros.get(i).dim2 == second.nonZeros.get(j).dim1){
                    newNonZeros.add(new Tuple(first.nonZeros.get(i).dim1,second.nonZeros.get(j).dim2));
                }
            }
        }


        List<Tuple> newList = newNonZeros.stream()
                .distinct()
                .collect(Collectors.toList());



        return new SparseMCP("(" + first.name + "*" + second.name + ")", first.dim1, second.dim2, newList);
    }
}