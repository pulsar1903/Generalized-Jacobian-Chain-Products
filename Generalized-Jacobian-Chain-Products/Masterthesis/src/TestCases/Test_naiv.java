package TestCases;
import naivMCP.*;
import Generic.*;
import DynamicProgrammingSolutions.*;


import java.io.*;
import java.util.*;
import java.util.Random;
import java.util.stream.IntStream;
import java.lang.Thread;

import static naivMCP.SimpleMCPSolver.bestBracketing;
import static naivMCP.SimpleMCPSolver.minimumCost;
import static naivMCP.SimpleMCPSolver.createTree;


public class Test_naiv extends Thread {

    static String chars1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String chars = "abcdefghijklmnopqrstuvwxyz";
    static int max = 10;
    static int min = 1;
    static int counter1=0;


    public static void generator() {
        bestBracketing = null;
        minimumCost = Long.MAX_VALUE;
        //array wird random erzeugt , aktuell Größe 9a
        int[] arr = IntStream.generate(() -> new Random().nextInt((max - min) + 1) + min).limit(10).toArray();
        int le = arr.length;
        Random r_ = new Random();
        SimpleMCP[] tests = new SimpleMCP[arr.length - 1];
        List<MatrixInfo> matrices = new ArrayList<>();


        int i;
        for (i = 1; i <= arr.length - 1; i++) {
            //generate randomly the name of the Matrix
            int select = r_.nextInt(chars.length());
            int select1 = r_.nextInt(chars.length());
            int select2 = r_.nextInt(chars.length());
            String obj_ = "M" + "a" + chars.charAt(select2) + "_" + chars1.charAt(select) + chars.charAt(select1) + chars.charAt(select2);
            tests[i - 1] = new SimpleMCP(obj_, arr[i - 1], arr[i]);

            matrices.add(tests[i - 1]);
        }

        SimpleMCPNode root = new SimpleMCPNode(matrices, 0);
        //SimpleMCPNode root = new SimpleMCPNode(matrices, 0);


        long startTime = System.nanoTime();
        createTree(root);
        long stopTime = System.nanoTime();
        long result_execution = (stopTime - startTime);


        int select_ = r_.nextInt(chars.length());
        int select__ = r_.nextInt(chars.length());
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("TestCase_BB_Naiv"+ counter1 + chars1.charAt(select_) + "_" + chars.charAt(select_) + chars.charAt(select__) + ".txt", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        assert writer != null;
        writer.println("Input:");

        for (int z = 1; z <= arr.length - 1; z++) {
            writer.println(z + "matrix : " + tests[z - 1].name + " " + "Dimensions : " + arr[z - 1] + "x" + arr[z]);
        }
        writer.println(" ");
        writer.println("Output: ");
        writer.print("Array Dimensions : [ ");
        for (int a = 1; a <= arr.length; a++) {
            writer.print(arr[a - 1] + ",");
        }
        writer.print(" ] ");
        writer.println(" ");
        writer.println("Costs: " +  SimpleMCPSolver.bestBracketing.costs);
        writer.print("Best bracketing: ");

        for (MatrixInfo m :   SimpleMCPSolver.bestBracketing.matrices) {
            writer.print(m.name);
        }


        writer.println(" ");
        writer.println("number of pruned nodes : "+ SimpleMCPSolver.counter);
        writer.println("Länge des Arrays: " + arr.length);
        writer.println("Execution-time: " + result_execution + "ns");
        writer.println(" ");
        writer.println("DynamicProgramming-Approach ");
        long startTime1 = System.nanoTime();
        writer.println("Costs: " + Naiv_dynamic_MCP.MatrixChainOrder(arr, le));
        long stopTime1 = System.nanoTime();
        long result_execution1 = (stopTime1 - startTime1);
        writer.println(" Time-execution :  " + result_execution1 + "ns");
        writer.close();
        counter1++;

    }


    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Creating Process...");


        for(int i=1;i<10;i++){
            generator();
        }
    }
}





