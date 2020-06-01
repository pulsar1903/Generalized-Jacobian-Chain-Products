The Graph folder contains several classes. Here the class GraphMCPSolver is interesting. 
The example 4.1.2 is already predefined in the code and can be executed easily. 
To reconstruct the problem, three lists have to be created. One for the outputs, inputs and for all nodes in the graph. 
Let us assume a graph A with 5 edges, 2 outputs and 3 inputs. Then you get the following lines code

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

// Later on this created object "g1" has to be added to another final list of graphes at the end. 

         List<MatrixInfo_new> graphes = new ArrayList<>();
         graphes.add(g1);




// Another aspect, in code the example 4.1.2 is predefined. When you compile it, it will calculate g1....g8. 
// if you want to run the example for g1...g4, just make a comment for g5...g8. 
 List<MatrixInfo_new> graphes = new ArrayList<>();
        graphes.add(g1);
        graphes.add(g2);
        graphes.add(g3);
        graphes.add(g4);
    //    graphes.add(g5);
    //    graphes.add(g6);
    //    graphes.add(g7);
  //      graphes.add(g8);