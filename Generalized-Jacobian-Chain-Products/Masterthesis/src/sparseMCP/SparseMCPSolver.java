package sparseMCP;
import Generic.*;

import java.util.*;

public class SparseMCPSolver {
    public static long minimumCost = Long.MAX_VALUE;
    public static Node bestBracketing;
    private static int level=0;
    private static int tmp;
    public static int counter;
    List<Tuple> output = new ArrayList<>();


    public static void main(String[]args){
        //Example 3.1.1
        /*
        List<Tuple> a1 = new ArrayList<>();
        Tuple t1 = new Tuple(0,0);
        Tuple t2 = new Tuple(1,2);
        Tuple t3 = new Tuple(3,4);
        Tuple aa1 = new Tuple(2,2);

        a1.add(t1);
        a1.add(t2);
        a1.add(t3);
        a1.add(aa1);


        List<Tuple> b1 = new ArrayList<>();
        Tuple t4 = new Tuple(0,1);
        Tuple b4 = new Tuple(1,0);
        Tuple t5 = new Tuple(2,1);
        Tuple t6 = new Tuple(4,2);

        b1.add(t4);
        b1.add(t5);
        b1.add(t6);
        b1.add(b4);

        List<Tuple> c1 = new ArrayList<>();
        //Tuple t10 = new Tuple (2,2);
        Tuple t11 = new Tuple (0,0);
        Tuple t12 = new Tuple (1,0);
        Tuple t00 = new Tuple (1,3);
        Tuple c11 = new Tuple (2,4);

        // c1.add(t10);
        c1.add(t00);
        c1.add(t11);
        c1.add(t12);
        c1.add(c11);


        SparseMCP a = new SparseMCP( "A", 4,6,a1);
        SparseMCP b = new SparseMCP("B",6,3,b1);
        SparseMCP c = new SparseMCP("C",3,5,c1);

        List<MatrixInfo> matrices = new ArrayList<>();
        matrices.add(a);
        matrices.add(b);
        matrices.add(c);
*/


        //example 3.2.2


        List<Tuple> a1 = new ArrayList<>();
        Tuple t1 = new Tuple(0,0);
        Tuple t2 = new Tuple(1,1);
        a1.add(t1);
        a1.add(t2);

        List<Tuple> b1 = new ArrayList<>();
        Tuple t4 = new Tuple(0,1);
        Tuple b4 = new Tuple(1,1);
        Tuple t5 = new Tuple(1,3);

        b1.add(t4);
        b1.add(t5);
        b1.add(b4);


        List<Tuple> c1 = new ArrayList<>();

        Tuple t11 = new Tuple (0,0);
        Tuple t12 = new Tuple (0,2);
        Tuple t00 = new Tuple (2,1);
        Tuple c11 = new Tuple (3,2);

        c1.add(t00);
        c1.add(t11);
        c1.add(t12);
        c1.add(c11);

        List<Tuple> d1 = new ArrayList<>();
        Tuple d11 = new Tuple (0,0);
        Tuple d12 = new Tuple (1,1);
        Tuple d13 = new Tuple (2,1);

        d1.add(d11);
        d1.add(d13);
        d1.add(d12);

        List<Tuple> e1 = new ArrayList<>();
        Tuple e11 = new Tuple (1,2);
        Tuple e12 = new Tuple (1,0);
        Tuple e13 = new Tuple (1,3);
        Tuple e14 = new Tuple (1,1);
        e1.add(e11);
        e1.add(e12);
        e1.add(e13);
        e1.add(e14);

        List<Tuple> f1 = new ArrayList<>();
        Tuple f11 = new Tuple(3,3);
        Tuple f12 = new Tuple(4,5);
        Tuple f13 = new Tuple(1,1);
        Tuple f14 = new Tuple(1,3);
        Tuple f15 = new Tuple(4,1);
        Tuple f16 = new Tuple(2,2);
        f1.add(f11);
        f1.add(f12);
        f1.add(f13);
        f1.add(f14);
        f1.add(f15);
        f1.add(f16);

        List<Tuple>g1 = new ArrayList<>();
        Tuple g11 = new Tuple(2,2);
        Tuple g12 = new Tuple(3,3);
        Tuple g13 = new Tuple(1,3);
        Tuple g14 = new Tuple(5,2);
        Tuple g15 = new Tuple(0,0);

        g1.add(g11);
        g1.add(g12);
        g1.add(g13);
        g1.add(g14);
        g1.add(g15);

        List<Tuple>h1 = new ArrayList<>();
        Tuple h11 = new Tuple(0,2);
        Tuple h12 = new Tuple(3,2);
        Tuple h13 = new Tuple(2,1);
        Tuple h14 = new Tuple(0,0);

        h1.add(h11);
        h1.add(h12);
        h1.add(h13);
        h1.add(h14);

        List<Tuple>i1 = new ArrayList<>();
        Tuple i11 = new Tuple(2,4);
        Tuple i12 = new Tuple(1,3);
        Tuple i13 = new Tuple(0,2);
        Tuple i14 = new Tuple(0,0);
        Tuple i15 = new Tuple(1,1);

        i1.add(i11);
        i1.add(i12);
        i1.add(i13);
        i1.add(i14);
        i1.add(i15);

        List<Tuple> j1 = new ArrayList<>();
        Tuple j11 = new Tuple(3,3);
        Tuple j12 = new Tuple(2,0);
        Tuple j13 = new Tuple(4,4);
        Tuple j14 = new Tuple(1,2);
        Tuple j15 = new Tuple(2,1);
        Tuple j16 = new Tuple(3,4);

        j1.add(j11);
        j1.add(j12);
        j1.add(j13);
        j1.add(j14);
        j1.add(j15);
        j1.add(j16);

        SparseMCP a = new SparseMCP( "A", 2,2,a1);
        SparseMCP b = new SparseMCP("B",2,4,b1);
        SparseMCP c = new SparseMCP("C",4,3,c1);
        SparseMCP d = new SparseMCP("D",3,2,d1);
        SparseMCP e = new SparseMCP( "E", 2,5,e1);
        SparseMCP f = new SparseMCP( "F", 5,6,f1);
        SparseMCP g = new SparseMCP("G",6,4,g1);
        SparseMCP h = new SparseMCP("H",4,3,h1);
        SparseMCP i = new SparseMCP("I",3,5,i1);
        SparseMCP j = new SparseMCP("J",5,6,j1);

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





        // do not change this section!!
        SparseMCPNode root = new SparseMCPNode(matrices,0);

        long startTime = System.nanoTime();
        createTree(root);
        long stopTime = System.nanoTime();
        long result_execution = (stopTime - startTime);


        /*
        for(int u=0;u<= level ; u++){
            root.printTree(u);
            System.out.println("\n");
        }
        */

        System.out.println("The result of the matrix in tuples:");
        SparseMCP matr = (SparseMCP) bestBracketing.matrices.get(0);
        System.out.print(((SparseMCP) bestBracketing.matrices.get(0)).nonZeros.toString());

        /*
        for(Tuple t : matr.){
            System.out.print(t.toString());
        }

         */
    }



public static SparseMCPNode createTree(SparseMCPNode currentNode){
        System.out.println(" ");
    System.out.println("Current Node is");
    for (MatrixInfo m : currentNode.matrices) {
        System.out.print(m.name);
    }
    System.out.println("");
    //System.out.println("Current level is: " + level);
    System.out.println("with cost " + currentNode.costs);
    // check if node costs already higher than global minimum then prune
    if (currentNode.costs > minimumCost) {
        System.out.println("current Costs already higher than lowest costs prune this node");
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

        return currentNode;
    }
    // else Node is not a leaf and costs are still below minimum so build all possible subtrees (all possible bracket variations and recursively search through them)
    // the recursion will automatically perform Depth First search
    // this will copy the list of the current Node, combine two consecutive matrices to a new one, remove the two from the list and add the combined one in place.
    // then this new list is put into a new node which is one of the successors of the current Node
    for (int i = 0; i < currentNode.matrices.size() - 1; i++) {
        List<MatrixInfo> adaptedList = new ArrayList(currentNode.matrices);
        currentNode.successors.add(createTree(currentNode.createSuccessor(adaptedList, i)));
    }
    level++;
    // if we returned to root, all nodes have been finished
    if(currentNode.costs == 0){
        System.out.print("Best Bracketing is ");
        for(MatrixInfo m: bestBracketing.matrices){
            System.out.print(m.name);
        }
        System.out.println(" with cost of " + bestBracketing.costs);
        System.out.println("Number of pruned nodes : " + counter);
    }

    return currentNode;
}
}