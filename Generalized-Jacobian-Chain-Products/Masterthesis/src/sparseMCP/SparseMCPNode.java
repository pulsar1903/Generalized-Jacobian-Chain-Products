package sparseMCP;
import Generic.*;
import java.util.List;

public class SparseMCPNode extends Node {

    public SparseMCPNode(List<MatrixInfo> matrices, long parentCosts){
            super(matrices, parentCosts);
    }

    public boolean isLeaf(){
        return matrices.size()<=1;
    }

    public SparseMCPNode createSuccessor(List<MatrixInfo> adaptedMatrices, int index){
        // combine the two matrices at index and index+1 to a new Matrix and set cost of new node
        SparseMCP first = (SparseMCP) adaptedMatrices.get(index);
        SparseMCP second = (SparseMCP) adaptedMatrices.get(index+1);
        // calculate costs of First * Second
        long multiplicationCosts = calcMultCosts(first, second);
        // create new combined Matrix
        SparseMCP combined = SparseMCP.combine(first, second);
        // replace first and second in List by new combined matrix
        adaptedMatrices.remove(index);
        adaptedMatrices.remove(index);
        adaptedMatrices.add(index,combined);
        System.out.println("Creating successor ...");
        for(MatrixInfo m:adaptedMatrices){
            System.out.print(m.name);
        }
        System.out.println("");
        return new SparseMCPNode(adaptedMatrices, multiplicationCosts + this.costs);
    }

    public long calcMultCosts(SparseMCP first, SparseMCP second){
        long result = 0;
        for(int i = 0; i<first.nonZeros.size(); i++){
            for( int j =0; j< second.nonZeros.size(); j++){
                if(first.nonZeros.get(i).dim2 == second.nonZeros.get(j).dim1){
                    result += 1;
                }
            }
        }
        return result;
    }
}
