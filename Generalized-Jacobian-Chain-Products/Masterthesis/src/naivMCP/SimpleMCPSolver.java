package naivMCP;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.stream.IntStream;

import DynamicProgrammingSolutions.Naiv_dynamic_MCP;
import Generic.*;
public class SimpleMCPSolver {
    public static long minimumCost = Long.MAX_VALUE;

    public static  Node bestBracketing;
    private static int level=0;
    private static int tmp;
    public static int counter;




    public static void main(String[] args) {
        //[10,2,5,7,4] Example 2.1.1

        SimpleMCP a = new SimpleMCP("A", 10, 2);//4x4
        SimpleMCP b = new SimpleMCP("B", 2, 5); //4x8
        SimpleMCP c = new SimpleMCP("C", 5, 7); //8x2
        SimpleMCP d = new SimpleMCP("D", 7,4 );//2x8

        List<MatrixInfo> matrices = new ArrayList<>();
        matrices.add(a);
        matrices.add(b);
        matrices.add(c);
        matrices.add(d);



//Example 2.3.1 [6,2,1,5,8,9,12,3,8,7,10,4],
 /*
        SimpleMCP a = new SimpleMCP("A", 6, 2);//4x4
        SimpleMCP b = new SimpleMCP("B", 2, 1); //4x8
        SimpleMCP c = new SimpleMCP("C", 1, 5); //8x2
        SimpleMCP d = new SimpleMCP("D", 5, 8);//2x8
        SimpleMCP e = new SimpleMCP("E", 8, 9);//8x10
        SimpleMCP f = new SimpleMCP("F", 9, 12);//10x1
        SimpleMCP g = new SimpleMCP("G", 12,3 );//1x9
        SimpleMCP h = new SimpleMCP("H", 3, 8);//9x1
        SimpleMCP i = new SimpleMCP("I", 8, 7);//1x10
        SimpleMCP j = new SimpleMCP("J", 7, 10);//1x10
        SimpleMCP k = new SimpleMCP("K", 10, 4);//1x10


        List<MatrixInfo> matrices = new ArrayList<>();
        matrices.add(a);
        matrices.add(b);
        matrices.add(c);
        matrices.add(d);
        matrices.add(e);
        matrices.add(f);
        matrices.add(g);
        matrices.add(h);
        matrices.add(i);
        matrices.add(j);
        matrices.add(k);

 */




        // do not change this section. It is always the same!

        SimpleMCPNode root = new SimpleMCPNode(matrices, 0);
        long startTime = System.nanoTime();
        createTree(root);
        long stopTime = System.nanoTime();
        long result_execution = (stopTime - startTime);
        System.out.println(" Execution time in nano: "+ result_execution);
        System.out.println(" ");



        //This method is used to output the search tree. Be careful, the greater the input, the larger the output.

/*
        for(int t=0;t<= level ; t++){
            root.printTree(t);
            System.out.println("\n");
        }
*/



    }

    public static Node getBestBracketing(){
        return bestBracketing;
    }


    //This method creates the tree and will be called in the main Method
    public  static  SimpleMCPNode createTree(SimpleMCPNode currentNode) {
        System.out.println(" ....");
        System.out.println("Current Node is");
        for (MatrixInfo m : currentNode.matrices) {
            System.out.print(m.name);
        }
        System.out.println("");
        System.out.println("with cost " + currentNode.costs);
        // check if node costs already higher than global minimum then prune
        if (currentNode.costs > minimumCost) {
            System.out.println("current Costs already higher than lowest costs prune this node");
            //System.gc();
            System.out.println("aktueller Counter: "+ counter);
            counter++;
            return currentNode;
        }
        // else if node is a Leaf and nodes costs are lower than current minimum set new minimum
        if (currentNode.isLeaf() && currentNode.costs <= minimumCost) {
            System.out.println("Found Leaf with new minimum cost " + currentNode.costs);
            minimumCost = currentNode.costs;
            bestBracketing = currentNode;
            tmp = level;
            for (MatrixInfo m : currentNode.matrices) {
                System.out.print(m.name);
            }
            System.out.println("");
            //System.gc();
            return currentNode;
        }
        // else Node is not a leaf and costs are still below minimum so build all possible subtrees (all possible bracket variations and recursively search through them)
        // the recursion will automatically perform Depth First search
        // this will copy the list of the current Node, combine two consecutive matrices to a new one, remove the two from the list and add the combined one in place.
        // then this new list is put into a new node which is one of the successors of the current Node
        for (int i = 0; i < currentNode.matrices.size() - 1; i++) {
            List<MatrixInfo> adaptedList = new ArrayList(currentNode.matrices);
            currentNode.successors.add(createTree(currentNode.createSuccessor(adaptedList, i)));
           //System.gc();

        }
        level++;

        // if we returned to root, all nodes have been finished
        if(currentNode.costs == 0){
            System.out.print("Best Bracketing is ");
            for(MatrixInfo m: bestBracketing.matrices){
                System.out.print(m.name);
            }
            System.out.print(" with cost of " + bestBracketing.costs);
            System.out.println(" ");
            System.out.println("Number of pruned nodes : " + counter);


        }

        return currentNode;
    }



}
