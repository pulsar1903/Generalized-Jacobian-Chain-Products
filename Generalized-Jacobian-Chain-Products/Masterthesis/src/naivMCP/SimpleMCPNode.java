package naivMCP;
import java.util.List;
import Generic.*;
public class SimpleMCPNode extends Node{

    public SimpleMCPNode(List<MatrixInfo> matrices, long parentCosts){
        super(matrices, parentCosts);
    }


    public boolean isLeaf(){
        return matrices.size()<=1;
    }


    //This function is used to create the successor in the search tree.
    //Hereby, the logic of the cost fct and the combination of two matrices to one are implemented
    public SimpleMCPNode createSuccessor(List<MatrixInfo> adaptedMatrices, int index){
        // combine the two matrices at index and index+1 to a new Matrix and set cost of new node
        SimpleMCP first = (SimpleMCP)adaptedMatrices.get(index);
        SimpleMCP second = (SimpleMCP) adaptedMatrices.get(index+1);
        // calculate costs of First * Second
        long multiplicationCosts = first.dim1*first.dim2*second.dim2;
        // create new combined Matrix
        SimpleMCP combined = SimpleMCP.combine(first, second);
        // replace first and second in List by new combined matrix
        adaptedMatrices.remove(index);
        adaptedMatrices.remove(index);
        adaptedMatrices.add(index,combined);
        System.out.println("Creating successor ...");
        for(MatrixInfo m:adaptedMatrices){
            System.out.print(m.name);
        }
        System.out.println("");
        return new SimpleMCPNode(adaptedMatrices, multiplicationCosts + this.costs);
    }
}
