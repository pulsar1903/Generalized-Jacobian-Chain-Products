In order to run the program, the class SimpleMCPSolver in the folder naivMCP must be used.
To reproduce the example 2.1.1 from the masterthesis. M= [10,2,5,7,4]

Following must be add or changed in the main method:

        SimpleMCP a = new SimpleMCP("A", 10, 2);//10x2
        SimpleMCP b = new SimpleMCP("B", 2, 5); //2x5
        SimpleMCP c = new SimpleMCP("C", 5, 7); //5x7
        SimpleMCP d = new SimpleMCP("D", 7,4 );//7x4


       List<MatrixInfo> matrices = new ArrayList<>();
        matrices.add(a);
        matrices.add(b);
        matrices.add(c);
        matrices.add(d);

If you want to add a new matrix for example E=(4x10) , then you need to add following lines:
  
    SimpleMCP e= new SimpleMCP("E",4,x10)
    matrices.add(e);


The example 2.3.1 is also in the main function but in comments. To use it, just uncomment it and comment the example 2.1.1.


To print out the created search-tree for this example, just remove the comments in the last lines of the main method: 

/*
        for(int t=0;t<= level ; t++){
            root.printTree(t);
            System.out.println("\n");
        }
*/

If the examples are too large, the output becomes very confusing. For this reason, the lines are commented out
