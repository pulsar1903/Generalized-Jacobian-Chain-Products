package Graph;


import java.util.ArrayList;
import java.util.List;

public class Node_new {
    public final List<MatrixInfo_new> matrices;
    public long costs;
    public List<Node_new> successors = new ArrayList<>();
    public long memory_costs;


    public Node_new(List<MatrixInfo_new> matrices, long parentCosts, long memory){
        this.matrices = matrices;
        costs = parentCosts;
        this.memory_costs = memory;


    }

    public void printTree(int level){
        //System.out.print("|");
        if (level == 0)
            for(MatrixInfo_new m: this.matrices){
                System.out.print(m.name+ " ");
            }

        else if(level>0)
            for(Node_new n:this.successors ){
                n.printTree(level-1);
            }
    }

}