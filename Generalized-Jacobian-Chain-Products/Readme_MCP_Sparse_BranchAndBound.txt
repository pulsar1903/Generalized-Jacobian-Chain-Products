//The solver "SparseMCPSolver" for this problem can be find in the folder "sparseMCP".
//To reproduce the example 3.1.1 following steps have to do : 

Example :
A=(4x6), {(0,0),(1,2),(3,4),(2,2)}
B=(6x3); {(0,1),(1,0),(2,1),(4,2)}
C=(3x5); {(0,0),(1,0),(1,3),(2,4)}

//To reproduce this example, it is important to create an ArrayList which gets the tuples of the non zeroes.
//To do so, for A you have to write : 

 List<Tuple> a1 = new ArrayList<>();
        Tuple t1 = new Tuple(0,0);
        Tuple t2 = new Tuple(1,1);
        Tuple t3 = new Tuple(3,4);
        Tuple aa1 = new Tuple(2,2);

        a1.add(t1);
        a1.add(t2);
        a1.add(t3);
        a1.add(aa1);

//then create an object of SparseMCP which gets the dimensions and the ArrayList with its nonzeroes
 SparseMCP a = new SparseMCP( "A", 4,6,a1);

 List<Tuple> b1 = new ArrayList<>();
        Tuple t4 = new Tuple(0,1);
        Tuple b4 = new Tuple(1,0);
        Tuple t5 = new Tuple(2,1);
         Tuple t6 = new Tuple(4,2);

        b1.add(t4);
        b1.add(t5);
        b1.add(t6);
        b1.add(b4);

  SparseMCP b = new SparseMCP("B",6,3,b1);


//This list receives the matrices and is passed at the end of the create function
List<MatrixInfo> matrices = new ArrayList<>();
        matrices.add(a);
        matrices.add(b);

// In this way you can add more matrices. 
//The complete example is already mandatory to look up in the code











The
 