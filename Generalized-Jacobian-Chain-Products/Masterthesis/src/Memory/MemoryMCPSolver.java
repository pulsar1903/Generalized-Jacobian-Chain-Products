package Memory;
import Graph.GraphMCP;
import Graph.Vertex;

import java.util.ArrayList;
import java.util.List;

public class MemoryMCPSolver {

    public static long minimumCost = Long.MAX_VALUE;
    public static long memory;
    public static long counter;
    public static long global_memory = 10; //threshold
    // TODO find a way to store bracketing in Node
    //von private auf public, damit ich das in eine File eintragen kann von einem anderen Package aus//
    public static Node__new bestBracketing;
    private static int level = 0;


    public static MemoryMCPNode createTree(MemoryMCPNode currentNode) {
        System.out.println(" ");
        System.out.println("Current Node is");
        for (MatrixInfo__new m : currentNode.matrices) {
            System.out.print(m.name);
        }
        System.out.println("");
        System.out.println("with cost " + currentNode.costs);
        System.out.println("Memory with cost " + currentNode.memory_costs);




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
            memory = currentNode.memory_costs;
            bestBracketing = currentNode;
            for (MatrixInfo__new m : currentNode.matrices) {
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

            List<MatrixInfo__new> adaptedList = new ArrayList(currentNode.matrices);
            currentNode.successors.add(createTree(currentNode.createSuccessor(adaptedList, i, global_memory)));

        }
        level++;

        // if we returned to root, all nodes have been finished
        if (currentNode.costs == 0) {
            System.out.print("Best Bracketing is ");
            for (MatrixInfo__new m : bestBracketing.matrices) {
                System.out.print(m.name);
            }
            System.out.print(" with cost of " + bestBracketing.costs);
            System.out.println(" ");
            System.out.println("Memory threshold: " + global_memory);
            System.out.println("memory costs: " + bestBracketing.memory_costs);
            System.out.println("Number of pruned nodes: "+ counter);
        }


        return currentNode;
    }


    public static void main(String[]args){
        // for Graph 1
        List<Vertex_> input_g1 = new ArrayList<>();
        List<Vertex_> output_g1 = new ArrayList<>();
        int edges_g1=7;


        Vertex_ i_1 = new Vertex_("A");
        Vertex_ i_2 = new Vertex_("B");
        Vertex_ i_3 = new Vertex_("C");
        Vertex_ as = new Vertex_( "as");
        Vertex_ as1 = new Vertex_( "as");

        input_g1.add(as1);
        input_g1.add(as);
        input_g1.add(i_1);
        //input_g1.add(i_2);
        //  input_g1.add(i_3);

        Vertex_ u1 = new Vertex_("X");
        Vertex_ o_2 = new Vertex_("D");
        Vertex_ o_3 = new Vertex_("E");
        Vertex_ o_4 = new Vertex_("E");
        Vertex_ o_33 = new Vertex_("asd");
        Vertex_ we2 = new Vertex_("asd");

        output_g1.add(u1);
        output_g1.add(o_2);
        output_g1.add(o_4);
        // output_g1.add(o_3);
        //   output_g1.add(o_33);
        //  output_g1.add(we2);

        MemoryMCP g1 = new MemoryMCP("G1",3,3,output_g1, input_g1, edges_g1);

        // For Graph 2
        List<Vertex_> input_g2 = new ArrayList<>();
        List<Vertex_> output_g2 = new ArrayList<>();
        int edges_g2 = 11;

        Vertex_ ii_1 = new Vertex_("F");
        Vertex_ ii_33 = new Vertex_ ("H_");
        Vertex_ ui_33 = new Vertex_ ("H_");
        Vertex_ z67 = new Vertex_("W");
        Vertex_ u78 = new Vertex_("sdsd");
        Vertex_ u718 = new Vertex_("sdsd");
        Vertex_ u738 = new Vertex_("sdsd");
        input_g2.add(ii_33);
        input_g2.add(ii_1);
        input_g2.add(ui_33);
        input_g2.add(z67);
        //  input_g2.add(u78);
        //  input_g2.add(u718);
        //  input_g2.add(u738);

        Vertex_ x12 = new Vertex_("asd");
        Vertex_ oo_1 = new Vertex_("I");
        Vertex_ ooo = new Vertex_("O");
        Vertex_ xxx = new Vertex_("as");
        Vertex_ yy = new Vertex_("sd");
        output_g2.add(ooo);
        output_g2.add(xxx);
        output_g2.add(oo_1);
        // output_g2.add(x12);
        //  output_g2.add(yy);

        MemoryMCP g2 = new MemoryMCP("G2",3,4,output_g2,input_g2, edges_g2);


        //For graph 3
        List<Vertex_> input_g3 = new ArrayList<>();
        List<Vertex_> output_g3 = new ArrayList<>();
        int edges_g3 = 10;

        Vertex_ ooo_1 = new Vertex_("L");//R
        Vertex_ o23 = new Vertex_("K");
        Vertex_ o13 = new Vertex_("K");
        Vertex_ se2 = new Vertex_( "ok");
        Vertex_ srf = new Vertex_("asdsd");
        Vertex_ s1rf = new Vertex_("asdsd");
        Vertex_ sr2f = new Vertex_("asdsd");
        output_g3.add(s1rf);
        output_g3.add(sr2f);
       output_g3.add(se2);
          output_g3.add(o23);
        // output_g3.add(ooo_1);
        //  output_g3.add(o13);
        //  output_g3.add(srf);

        Vertex_ iii_1 = new Vertex_("O"); //M
        Vertex_ ol = new Vertex_("j");
        Vertex_ sj = new Vertex_("o");
        Vertex_ we = new Vertex_("q");
        Vertex_ we0 = new Vertex_("q");
        input_g3.add(iii_1);
        input_g3.add(ol);
        input_g3.add(sj);
        input_g3.add(we);
        input_g3.add(we0);


        MemoryMCP g3 = new MemoryMCP("G3",4,5,output_g3,input_g3,edges_g3);


        //For graph 4
        List<Vertex_> input_g4 = new ArrayList<>();
        List<Vertex_> output_g4 = new ArrayList<>();
        int edges_g4 = 11;

        Vertex_ z1 = new Vertex_("1");
        Vertex_ z2 = new Vertex_("2");
        Vertex_ z3 = new Vertex_("3");
        Vertex_ z4 = new Vertex_("4");
        Vertex_ z5 = new Vertex_("4");
        output_g4.add(z1);
        output_g4.add(z2);
        output_g4.add(z3);
        output_g4.add(z4);
        output_g4.add(z5);

        Vertex_ f1 = new Vertex_("f1");
        Vertex_ f2 = new Vertex_("f2");
        Vertex_ f22 = new Vertex_("f2");
        Vertex_ f23 = new Vertex_("f2");
        Vertex_ f24 = new Vertex_("f2");
        Vertex_ f25 = new Vertex_("f2");
        Vertex_ f55 = new Vertex_("f2");
        input_g4.add(f1);
        input_g4.add(f2);
        input_g4.add(f22);
        input_g4.add(f23);
        input_g4.add(f24);
        input_g4.add(f25);
        // input_g4.add(f55);

        MemoryMCP g4 = new MemoryMCP("G4",5,6,output_g4,input_g4,edges_g4);

/*

        //For graph 5
        List<Vertex_> input_g5 = new ArrayList<>();
        List<Vertex_> output_g5 = new ArrayList<>();
        int edges_g5 = 5;

        Vertex_ q42 = new Vertex_("a");
        Vertex_ q123 = new Vertex_("sa");
        Vertex_ q145 = new Vertex_("sa");
        Vertex_ q1113 = new Vertex_("sa");
        Vertex_ q178 = new Vertex_("sa");
        Vertex_ q1728 = new Vertex_("sa");
        Vertex_ q1228 = new Vertex_("sa");
        output_g5.add(q1228);
        output_g5.add(q1728);
   //        output_g5.add(q123);
   //      output_g5.add(q42);
    //      output_g5.add(q145);
   //      output_g5.add(q1113);
        // output_g5.add(q178);

        Vertex_ op = new Vertex_("asd");
        Vertex_ qa = new Vertex_("sdw");
        Vertex_ s2 = new Vertex_("sd");
        Vertex_ s20 = new Vertex_("sd");
        Vertex_ s24 = new Vertex_("sd");
        Vertex_ s267 = new Vertex_("sd");
        Vertex_ s2671 = new Vertex_("sd");
        input_g5.add(op);
        input_g5.add(s2);
        input_g5.add(qa);
   //       input_g5.add(s20);
    //     input_g5.add(s24);
   //      input_g5.add(s267);
  //       input_g5.add(s2671);
        MemoryMCP g5 = new MemoryMCP("G5",2,3,output_g5,input_g5,edges_g5);
*/

        List<MatrixInfo__new> graphes = new ArrayList<>();
        graphes.add(g1);
        graphes.add(g2);
        graphes.add(g3);
        graphes.add(g4);
    //    graphes.add(g5);

        MemoryMCPNode root = new MemoryMCPNode(graphes,0,0);
        long startTime = System.nanoTime();
        createTree(root);
        long stopTime = System.nanoTime();
        long result_execution = (stopTime - startTime);
        System.out.println(" Execution time in nano: "+ result_execution);
        System.out.println(" ");
    }

}


