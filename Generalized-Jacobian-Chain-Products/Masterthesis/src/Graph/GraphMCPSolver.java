package Graph;

//import Generic.MatrixInfo;

import Generic.Node;
import Memory.*;
import naivMCP.SimpleMCPNode;

import javax.sound.midi.SysexMessage;
import java.awt.font.GraphicAttribute;
import java.beans.VetoableChangeListener;
import java.lang.management.GarbageCollectorMXBean;
import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.List;



public class GraphMCPSolver {

    public static long minimumCost = Long.MAX_VALUE;
    public static long memory;
    public static long global_memory = 200; //threshold
    public static int counter;
    // TODO find a way to store bracketing in Node
    //von private auf public, damit ich das in eine File eintragen kann von einem anderen Package aus//
    public static Node_new bestBracketing;
    private static int level=0;
    private static int tmp;



    public  static GraphMCPNode createTree(GraphMCPNode currentNode) {

        System.out.println(" ");
        System.out.println("Current Node is");
        for (MatrixInfo_new m : currentNode.matrices) {
            System.out.print(m.name);
        }
        System.out.println("");
        System.out.println("with cost " + currentNode.costs);
        //System.out.println("Memory with cost " + currentNode.memory_costs);



        // check if node costs already higher than global minimum then prune
        if (currentNode.costs > minimumCost) {
            System.out.println("current Costs already higher than lowest costs prune this node");
            //System.gc();
           // System.out.println("aktueller Counter: "+ counter);
            counter++;
            return currentNode;
        }
        // else if node is a Leaf and nodes costs are lower than current minimum set new minimum
        if (currentNode.isLeaf() && currentNode.costs <= minimumCost) {
            System.out.println("Found Leaf with new minimum cost " + currentNode.costs);
            minimumCost = currentNode.costs;
            memory = currentNode.memory_costs;
            bestBracketing = currentNode;
            tmp = level;
            for (MatrixInfo_new m : currentNode.matrices) {
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
            List<MatrixInfo_new> adaptedList = new ArrayList(currentNode.matrices);
            currentNode.successors.add(createTree(currentNode.createSuccessor(adaptedList, i)));
            //System.gc();
            //adaptedList.clear();
        }
        level++;

        // if we returned to root, all nodes have been finished
        if (currentNode.costs == 0) {
            System.out.print("Best Bracketing is ");
            for (MatrixInfo_new m : bestBracketing.matrices) {
                System.out.print(m.name);
            }
            System.out.print(" with cost of " + bestBracketing.costs);
            System.out.println(" ");
            System.out.println("Memory threshold: "+ global_memory);
            System.out.println("memory costs: " + bestBracketing.memory_costs);
            System.out.println(" ");
            //System.out.println((GraphMCP)bestBracketing.matrices.get(0).edges.toString());
         //   System.out.println("Number of pruned nodes : " + counter);

        }








        return currentNode;

    }


    public static void main(String[]args){
        // for Graph 1
        List<Vertex> input_g1 = new ArrayList<>();
        List<Vertex> output_g1 = new ArrayList<>();
        int edges_g1=5;
        List<Vertex> allNodes_g1 = new ArrayList<>();

        Vertex i_1 = new Vertex("A");
        Vertex i_2 = new Vertex("B");
        Vertex i_3 = new Vertex("C");

        input_g1.add(i_1);
        input_g1.add(i_2);
        input_g1.add(i_3);

        Vertex u1  = new Vertex("F");
        Vertex o_2 = new Vertex("D");


        output_g1.add(u1);
        output_g1.add(o_2);


        GraphMCP g1 = new GraphMCP("G1",2,3,output_g1, input_g1, edges_g1,allNodes_g1);

        // For Graph 2
        List<Vertex> input_g2 = new ArrayList<>();
        List<Vertex> output_g2 = new ArrayList<>();
        int edges_g2 = 10;
        List<Vertex> allNodes_g2 = new ArrayList<>();

        Vertex ii_1 = new Vertex("Ff");
        Vertex ii_33 = new Vertex ("G");

        input_g2.add(ii_33);
        input_g2.add(ii_1);

        Vertex oo_1 = new Vertex("H");
        Vertex ooo = new Vertex("I");
        Vertex xxx = new Vertex("J");

        output_g2.add(ooo);
        output_g2.add(xxx);
        output_g2.add(oo_1);


        GraphMCP g2 = new GraphMCP("G2",3,2,output_g2,input_g2, edges_g2,allNodes_g2);


        //For graph 3
        List<Vertex> input_g3 = new ArrayList<>();
        List<Vertex> output_g3 = new ArrayList<>();
        int edges_g3 = 6;
        List<Vertex> allNodes_g3 = new ArrayList<>();


        Vertex s1rf = new Vertex("O");
        Vertex sr2f = new Vertex("P");
        output_g3.add(s1rf);
        output_g3.add(sr2f);


        Vertex iii_1 = new Vertex("K"); //M
        Vertex ol = new Vertex("N");
        Vertex sj = new Vertex("L");
        Vertex we = new Vertex("M");

        input_g3.add(iii_1);
        input_g3.add(ol);
        input_g3.add(sj);
        input_g3.add(we);



        GraphMCP g3 = new GraphMCP("G3",2,4,output_g3,input_g3,edges_g3,allNodes_g3);

        //For graph 4
        List<Vertex> input_g4 = new ArrayList<>();
        List<Vertex> output_g4 = new ArrayList<>();
        int edges_g4 = 14;
        List<Vertex> allNodes_g4 = new ArrayList<>();

        Vertex z1 = new Vertex("T");
        Vertex z2 = new Vertex("Z");
        Vertex z3 = new Vertex("V");
        Vertex z4 = new Vertex("Y");
        output_g4.add(z1);
        output_g4.add(z2);
        output_g4.add(z3);
        output_g4.add(z4);

        Vertex f1 = new Vertex("R");
        Vertex f2 = new Vertex("S");

        input_g4.add(f1);
        input_g4.add(f2);


        GraphMCP g4 = new GraphMCP("G4",4,2,output_g4,input_g4,edges_g4,allNodes_g4);


        //For graph 5
        List<Vertex> input_g5 = new ArrayList<>();
        List<Vertex> output_g5 = new ArrayList<>();
        int edges_g5 = 5;
        List<Vertex> allNodes_g5 = new ArrayList<>();

        Vertex q42 = new Vertex("a");
        Vertex q123 = new Vertex("sa");
        Vertex q145 = new Vertex("sa");
        Vertex q1113 = new Vertex("sa");
        Vertex q178 = new Vertex("sa");
        Vertex q1728 = new Vertex("sa");
        Vertex q1228 = new Vertex("sa");
        output_g5.add(q1228);
        output_g5.add(q1728);
     //   output_g5.add(q123);
       // output_g5.add(q42);
      //  output_g5.add(q145);
       // output_g5.add(q1113);
       // output_g5.add(q178);

        Vertex op = new Vertex("asd");
        Vertex qa = new Vertex("sdw");
        Vertex s2 = new Vertex("sd");
        Vertex s20 = new Vertex("sd");
        Vertex s24 = new Vertex("sd");
        Vertex s267 = new Vertex("sd");
        Vertex s2671 = new Vertex("sd");
        input_g5.add(op);
        input_g5.add(s2);
        input_g5.add(qa);
      //  input_g5.add(s20);
       // input_g5.add(s24);
       // input_g5.add(s267);
       // input_g5.add(s2671);
        GraphMCP g5 = new GraphMCP("G5",2,3,output_g5,input_g5,edges_g5,allNodes_g5);



        //For graph 6
        List<Vertex> input_g6 = new ArrayList<>();
        List<Vertex> output_g6 = new ArrayList<>();
        int edges_g6 = 5;
        List<Vertex> allNodes_g6 = new ArrayList<>();

        Vertex qs = new Vertex("s");
        Vertex tf = new Vertex("we");
        Vertex w2 = new Vertex("wes");
        Vertex w298 = new Vertex("wes");
        output_g6.add(qs);
        output_g6.add(tf);
        output_g6.add(w2);
      //  output_g6.add(w298);
        Vertex ini = new Vertex("sdsd");
        Vertex ini1 = new Vertex("sdsd");
        Vertex ini2 = new Vertex("sdsd");
        Vertex ini3 = new Vertex("sdsd");
        Vertex ini4 = new Vertex("sdsd");
     //   input_g6.add(ini);
      //  input_g6.add(ini1);
     //   input_g6.add(ini2);
     //   input_g6.add(ini3);
        input_g6.add(ini4);

        GraphMCP g6 = new GraphMCP("G6",3,1,output_g6,input_g6,edges_g6,allNodes_g6);




        //For graph 7
        List<Vertex> input_g7 = new ArrayList<>();
        List<Vertex> output_g7 = new ArrayList<>();
        int edges_g7 = 5;
        List<Vertex> allNodes_g7 = new ArrayList<>();

        Vertex g771 = new Vertex("ok");
        Vertex g071 = new Vertex("ok");
        Vertex g171 = new Vertex("ok");
        Vertex g271 = new Vertex("ok");
        Vertex g371 = new Vertex("ok");
        output_g7.add(g771);
     //   output_g7.add(g071);
    //    output_g7.add(g171);
    //    output_g7.add(g271);
    //    output_g7.add(g371);

        Vertex g125 = new Vertex("asd2");
        Vertex g232 = new Vertex("sdas2");
        Vertex g777 = new Vertex("sdas2");
        Vertex g198 = new Vertex("sdas2");
        Vertex g2c = new Vertex("sdas2");
      //  input_g7.add(g125);
      //  input_g7.add(g777);
      //  input_g7.add(g198);
        input_g7.add(g2c);
        input_g7.add(g232);

        GraphMCP g7 = new GraphMCP("G7",1,2,output_g7,input_g7,edges_g7,allNodes_g7);


        //For graph 8
        List<Vertex> input_g8 = new ArrayList<>();
        List<Vertex> output_g8 = new ArrayList<>();
        int edges_g8 = 7;
        List<Vertex> allNodes_g8 = new ArrayList<>();

        Vertex gg = new Vertex("ok");
        Vertex gg1 = new Vertex("ok");
        Vertex gg11 = new Vertex("ok");
        Vertex gg12 = new Vertex("ok");
        output_g8.add(gg);
        output_g8.add(gg12);
      //  output_g8.add(gg11);
       // output_g8.add(gg1);


        Vertex outi = new Vertex("2s");
        Vertex outi1 = new Vertex("2s");
        Vertex outi2 = new Vertex("2s");
        Vertex outi3 = new Vertex("2s");
        Vertex outi4 = new Vertex("2s");
        input_g8.add(outi);
        input_g8.add(outi1);
        input_g8.add(outi2);
        input_g8.add(outi3);
        input_g8.add(outi4);

        GraphMCP g8 = new GraphMCP("G8", 2,5 ,output_g8,input_g8,edges_g8,allNodes_g8);


        /*
        //For graph 9
        List<Vertex> input_g9 = new ArrayList<>();
        List<Vertex> output_g9 = new ArrayList<>();
        int edges_g9 = 10;
        List<Vertex> allNodes_g9 = new ArrayList<>();

        Vertex uj = new Vertex("uji");
        Vertex zz = new Vertex("asd2");
        Vertex zzw= new Vertex("asd2");
        Vertex zz2 = new Vertex("asd2");
        Vertex z1z = new Vertex("asd2");
        output_g9.add(uj);
        output_g9.add(zz);
        output_g9.add(zzw);
        output_g9.add(zz2);
        output_g9.add(z1z);
        Vertex iti = new Vertex("ok1");
        Vertex iti1 = new Vertex("ok1");
        Vertex it2 = new Vertex("ok1");
        Vertex i1t2 = new Vertex("ok1");
        input_g9.add(iti);
        input_g9.add(iti1);
        input_g9.add(it2);
      //  input_g9.add(i1t2);

        GraphMCP g9 = new GraphMCP("G9",5,3,output_g9,input_g9,edges_g9,allNodes_g9);

        //For graph 10
        List<Vertex> input_g10 = new ArrayList<>();
        List<Vertex> output_g10 = new ArrayList<>();
        int edges_g10 = 3;
        List<Vertex> allNodes_g10 = new ArrayList<>();

        Vertex hj = new Vertex("ok1");
        Vertex hj1 = new Vertex("ok1");
        Vertex hj2 = new Vertex("ok1");
        output_g10.add(hj);
        output_g10.add(hj1);
        output_g10.add(hj2);
        Vertex last1 = new Vertex("bismillah");
        input_g10.add(last1);

        GraphMCP g10 = new GraphMCP("G10",3, 1, output_g10,input_g10,edges_g10,allNodes_g10);
*/
        List<MatrixInfo_new> graphes = new ArrayList<>();
        graphes.add(g1);
        graphes.add(g2);
        graphes.add(g3);
        graphes.add(g4);
        graphes.add(g5);
        graphes.add(g6);
        graphes.add(g7);
        graphes.add(g8);
     //   graphes.add(g9);
     //   graphes.add(g10);




        GraphMCPNode root = new GraphMCPNode(graphes,0,0);
        long startTime = System.nanoTime();
        createTree(root);
        long stopTime = System.nanoTime();
        long result_execution = (stopTime - startTime);
        System.out.println(" Execution time in nano: "+ result_execution);
        System.out.println(" ");


/*
        for(int u=0;u<= level ; u++){
            root.printTree(u);
            System.out.println("\n");
        }
*/
    }
}
