package Generic;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public final List<MatrixInfo> matrices;
    public  long costs;
    public List<Node> successors = new ArrayList<>();


    public Node(List<MatrixInfo> matrices, long parentCosts){
        this.matrices = matrices;
        costs = parentCosts;


    }

    public void printTree(int level){
        //System.out.print("|");
        if (level == 0)
            for(MatrixInfo m: this.matrices){
                System.out.print(m.name+ " ");
            }

           else if(level>0)
            for(Node n:this.successors ){
                n.printTree(level-1);
            }
    }

}
