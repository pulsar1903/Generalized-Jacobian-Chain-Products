package Memory;

import Graph.MatrixInfo_new;
import Graph.Node_new;

import java.util.ArrayList;
import java.util.List;

public class Node__new {

    public final List<MatrixInfo__new> matrices;
    public long costs;
    public List<Node__new> successors = new ArrayList<>();
    public long memory_costs;


    public Node__new(List<MatrixInfo__new> matrices, long parentCosts, long memory){
        this.matrices = matrices;
        costs = parentCosts;
        this.memory_costs = memory;


    }

    public void printTree(int level){
        System.out.print("|");
        if (level == 0)
            for(MatrixInfo__new m: this.matrices){
                System.out.print(m.name+ " ");
            }

        else if(level>0)
            for(Node__new n:this.successors ){
                n.printTree(level-1);
            }
    }
}
