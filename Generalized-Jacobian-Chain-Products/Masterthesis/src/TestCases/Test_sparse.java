package TestCases;
import DynamicProgrammingSolutions.Sparse_dynamic;
import sparseMCP.*;
import Generic.*;

import java.io.*;
import java.util.*;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.concurrent.ThreadLocalRandom;

import static sparseMCP.SparseMCPSolver.bestBracketing;
import static sparseMCP.SparseMCPSolver.minimumCost;
import static sparseMCP.SparseMCPSolver.createTree;

public class Test_sparse {

    private static String chars1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String chars = "abcdefghijklmnopqrstuvwxyz";
    private static int max = 10;
    private static int min = 1;
    //generate random array for the dimensions e.g [2,3,4,5] means (2x3),(3x4),(4x5)
    // static int[] arr = IntStream.generate(() -> new Random().nextInt((max - min) + 1) + min).limit(4).toArray();


    public static void startGenerator() {
        bestBracketing = null;
        minimumCost = Long.MAX_VALUE;
        Random r_ = new Random();
         int[] arr = IntStream.generate(() -> new Random().nextInt((max - min) + 1) + min).limit(6).toArray();
        //Array Tuple Objects
        Tuple[] tuples_ = new Tuple[(arr.length)-2];
        //Array SparseMCP Objects
        SparseMCP[] tests = new SparseMCP[arr.length - 1];
        //ArrayList of matrixes
        List<MatrixInfo> matrices = new ArrayList<>();
        //Multiple Array List to store the tuples of each matrix.
        ArrayList<Tuple> lists[] = new ArrayList[arr.length - 1];


        for (int i = 1; i <= arr.length - 1; i++) {
            //generate randomly the name of the Matrix
            int select = r_.nextInt(chars.length());
            int select1 = r_.nextInt(chars.length());
            int select2 = r_.nextInt(chars.length());
            String obj_ = "M" + "a" + "_" + chars1.charAt(select) + chars.charAt(select1) + chars.charAt(select2);


            lists[i - 1] = new ArrayList<>();
            //List<Tuple> a = new ArrayList<>();

            //generate randomly tuples. Pay attention to the dimensions of the tuples. Don't exceed the size
            //each matrix gets arr.length-4 tuple combinations
            for (int x = 0; x < (arr.length)-2; x++) {


             int t1,t2;
             t1 = ThreadLocalRandom.current().nextInt(0,arr[i-1]);
             t2 = ThreadLocalRandom.current().nextInt(0,arr[i]);


                tuples_[x] = new Tuple(t1, t2);
                lists[i - 1].add(tuples_[x]);

                //System.out.println(tuples_[x].toString());

            }
            tests[i - 1] = new SparseMCP(obj_, arr[i - 1], arr[i], lists[i - 1]);
            matrices.add(tests[i - 1]);
        }


        SparseMCPNode root = new SparseMCPNode(matrices, 0);
        long startTime = System.nanoTime();
        createTree(root);
        long stopTime = System.nanoTime();
        long result_execution = (stopTime - startTime);
        //System.out.println("Costs for dynamic : "+ Sparse_dynamic.MatrixChainOrder(matrices.size(),matrices));


        int select_ = r_.nextInt(chars.length());
        int select__ = r_.nextInt(chars.length());
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("TestCase_BB_Sparse" + "_" + chars.charAt(select_) + chars.charAt(select__) + ".txt", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        writer.println("Input:");
        for (int z = 1; z <= arr.length - 1; z++) {
            writer.println(z + "matrix : " + tests[z - 1].name + " " + "Dimensions : " + arr[z - 1] + "x" + arr[z] + " tuples of the matrix" + lists[z - 1]);
        }

        writer.println(" ");
        writer.println("Output: ");
        writer.print("Array Dimensions : [ ");
        for (int a = 1; a <= arr.length; a++) {
            writer.print(arr[a - 1] + ",");
        }
        writer.print(" ] ");
        writer.println(" ");
        writer.println("Costs: " + bestBracketing.costs);
        writer.print("Best bracketing: ");
        for (MatrixInfo m : bestBracketing.matrices) {
            writer.print(m.name);
        }
        writer.println(" ");
        writer.println("Länge des Arrays: " + arr.length);
        writer.println("Execution-time: " + result_execution + "ns");
        writer.println(" ");
        //writer.println("The result of the matrix in tuples: ");
        writer.println(((SparseMCP) bestBracketing.matrices.get(0)).nonZeros.toString());
        writer.println(" ");
        writer.println("Now the dynamic Approach ");
        long startTime1 = System.nanoTime();
        writer.println("Costs: "+ Sparse_dynamic.MatrixChainOrder(matrices.size()+1,matrices));
        long stopTime1 = System.nanoTime();
        long result_execution1 = (stopTime1 - startTime1);
        writer.println("Execution-time: " + result_execution1 + "ns");
        writer.close();


    }





    public static void main(String[]args){

            for(int i=0;i<15;i++){
                startGenerator();
            }

        }


    }


