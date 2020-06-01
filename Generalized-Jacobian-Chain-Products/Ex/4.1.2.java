  // for Graph 1
        List<Vertex> input_g1 = new ArrayList<>();
        List<Vertex> output_g1 = new ArrayList<>();
        List<tuple_> edges_g1 = new ArrayList<>();
        List<Vertex> allNodes_g1 = new ArrayList<>();

        Vertex i1 = new Vertex("A1"); Vertex i2 = new Vertex("B2");  Vertex i3 = new Vertex("C1");
        input_g1.add(i1);input_g1.add(i2); input_g1.add(i3);
        Vertex m1 = new Vertex("m1");
        Vertex o1 = new Vertex("D1"); Vertex o2 = new Vertex("E1");
        output_g1.add(o1); output_g1.add(o2);
        tuple_ t1= new tuple_(i1,m1);tuple_ t2= new tuple_(i2,m1);tuple_ t3= new tuple_(i3,m1);tuple_ t4= new tuple_(m1,o1);tuple_ t5= new tuple_(i1,o2);
        edges_g1.add(t1); edges_g1.add(t2); edges_g1.add(t3); edges_g1.add(t4); edges_g1.add(t5);
        GraphMCP g1 = new GraphMCP("G1",2,3,output_g1, input_g1, edges_g1, allNodes_g1);

        // For Graph 2
        List<Vertex> input_g2 = new ArrayList<>();
        List<Vertex> output_g2 = new ArrayList<>();
        List<tuple_> edges_g2 = new ArrayList<>();
        List<Vertex> allNodes_g2 = new ArrayList<>();


        Vertex i11 = new Vertex("A2"); Vertex i22 = new Vertex("B2");
        input_g2.add(i11); input_g2.add(i22);
        Vertex o11= new Vertex("C2"); Vertex o22 = new Vertex("D2"); Vertex o33 = new Vertex("E2");
        output_g2.add(o11); output_g2.add(o22); output_g2.add(o33);
        Vertex m11 = new Vertex("m2"); Vertex m22 = new Vertex("m3");
        tuple_ t11 = new tuple_(i11,m11); tuple_ t22 = new tuple_(i11,m22); tuple_ t33 = new tuple_(i22,m11); tuple_ t44 = new tuple_(i22,m22);
        tuple_ t55 = new tuple_(m11,o11); tuple_ t66 = new tuple_(m11,o22); tuple_ t77 = new tuple_(m11,o33);
        tuple_ t88 = new tuple_(m22,o11); tuple_ t99 = new tuple_(m22,o22); tuple_ t100 = new tuple_(m22,o33);
        edges_g2.add(t11); edges_g2.add(t22); edges_g2.add(t33); edges_g2.add(t44); edges_g2.add(t55); edges_g2.add(t66); edges_g2.add(t77);
        edges_g2.add(t88); edges_g2.add(t99);edges_g2.add(t100);

        GraphMCP g2 = new GraphMCP("G2",3,2,output_g2,input_g2, edges_g2,allNodes_g2);

        // For Graph 3
        List<Vertex> input_g3 = new ArrayList<>();
        List<Vertex> output_g3 = new ArrayList<>();
        List<tuple_> edges_g3 = new ArrayList<>();
        List<Vertex> allNodes_g3 = new ArrayList<>();

        Vertex i111= new Vertex("A3"); Vertex i222 = new Vertex("B3"); Vertex i333 = new Vertex("C3"); Vertex i444 = new Vertex("D3");
        input_g3.add(i111); input_g3.add(i222); input_g3.add(i333); input_g3.add(i444);
        Vertex m111 = new Vertex("m4");
        Vertex o111 = new Vertex("E3"); Vertex o222 = new Vertex("D3"); output_g3.add(o111); output_g3.add(o222);
        tuple_ t_1 = new tuple_(i111,m111); tuple_ t_2 = new tuple_(i222,m111); tuple_ t_3 = new tuple_(i333,m111); tuple_ t_4 = new tuple_(i444,m111);
        tuple_ t_5 = new tuple_(m111,o111); tuple_ t_6 = new tuple_(m111,o222);
        edges_g3.add(t_1); edges_g3.add(t_2); edges_g3.add(t_3); edges_g3.add(t_4); edges_g3.add(t_5); edges_g3.add(t_6);

        GraphMCP g3 = new GraphMCP("G3",2,4,output_g3,input_g3,edges_g3,allNodes_g3);

        //Graph g4
        List<Vertex> input_g4 = new ArrayList<>();
        List<Vertex> output_g4 = new ArrayList<>();
        List<tuple_> edges_g4 = new ArrayList<>();
        List<Vertex> allNodes_g4 = new ArrayList<>();
        Vertex in1 = new Vertex("A4"); Vertex in2 = new Vertex("B4"); input_g4.add(in1); input_g4.add(in2);
        Vertex Mid1 = new Vertex("M5"); Vertex Mid2 = new Vertex("M6");
        Vertex ou1 = new Vertex("C4"); Vertex ou2 = new Vertex("D4"); Vertex ou3 = new Vertex ("E4"); Vertex ou4 = new Vertex("D4");
        output_g4.add(ou1); output_g4.add(ou2); output_g4.add(ou3); output_g4.add(ou4);
        tuple_ tt1 = new tuple_(in1,Mid1); tuple_ tt2 = new tuple_(in1,Mid2); tuple_ tt3 = new tuple_(in2,Mid1); tuple_ tt4 = new tuple_(in2,Mid2);
        tuple_ tt5 = new tuple_(Mid1,ou1); tuple_ tt6 = new tuple_(Mid1,ou2); tuple_ tt7 = new tuple_(Mid1,ou3); tuple_ tt8 = new tuple_(Mid1,ou4);
        tuple_ tt9 = new tuple_(Mid2,ou1); tuple_ tt10 = new tuple_(Mid2,ou2); tuple_ tt11 = new tuple_(Mid2,ou3); tuple_ tt22 = new tuple_(Mid2,ou4);
        tuple_ tt33 = new tuple_(in1,ou1); tuple_ tt44 = new tuple_(in2,ou4);
        edges_g4.add(tt1); edges_g4.add(tt2); edges_g4.add(tt3); edges_g4.add(tt4); edges_g4.add(tt5); edges_g4.add(tt6); edges_g4.add(tt7); edges_g4.add(tt8);
        edges_g4.add(tt9); edges_g4.add(tt10); edges_g4.add(tt11); edges_g4.add(tt22); edges_g4.add(tt33); edges_g4.add(tt44);

        GraphMCP g4 = new GraphMCP("G4",4,2,output_g4,input_g4,edges_g4,allNodes_g4);

        //Grpah g5
        List<Vertex> input_g5 = new ArrayList<>();
        List<Vertex> output_g5 = new ArrayList<>();
        List<tuple_> edges_g5 = new ArrayList<>();
        List<Vertex> allNodes_g5 = new ArrayList<>();

        Vertex in11 = new Vertex("A5"); Vertex in22 = new Vertex("B5"); Vertex in33 = new Vertex("C5"); input_g5.add(in11); input_g5.add(in22); input_g5.add(in33);
        Vertex mid11 = new Vertex("M7");
        Vertex ou11 = new Vertex("D5"); Vertex ou22 = new Vertex("E5"); output_g5.add(ou11); output_g5.add(ou22);
        tuple_ t1t = new tuple_(in11,mid11); tuple_ t2t = new tuple_(in22,mid11); tuple_ t3t = new tuple_(in33,mid11); tuple_ t4t = new tuple_(mid11,ou11); tuple_ t5t = new tuple_(mid11,ou22);
        edges_g5.add(t1t); edges_g5.add(t2t); edges_g5.add(t3t); edges_g5.add(t4t); edges_g5.add(t5t);

        GraphMCP g5 = new GraphMCP("G5",2,3,output_g5,input_g5,edges_g5,allNodes_g5);

        //Grpah g6
        List<Vertex> input_g6 = new ArrayList<>();
        List<Vertex> output_g6 = new ArrayList<>();
        List<tuple_> edges_g6 = new ArrayList<>();
        List<Vertex> allNodes_g6 = new ArrayList<>();

        Vertex in111 = new Vertex("A6"); input_g6.add(in111);
        Vertex mid111 = new Vertex("M8"); Vertex mid222 = new Vertex("M9");
        Vertex ou111 = new Vertex("B7"); Vertex ou222 = new Vertex("C7"); Vertex ou333 = new Vertex("D7");
        output_g6.add(ou111); output_g6.add(ou222); output_g6.add(ou333);
        tuple_ tup1 = new tuple_(in111,mid111); tuple_ tup2 = new tuple_(in111,mid222); tuple_ tup3 = new tuple_(mid111,ou111); tuple_ tup4 = new tuple_(mid222,ou222);
        tuple_ tup5 = new tuple_(mid222,ou333);
        edges_g6.add(tup1); edges_g6.add(tup2); edges_g6.add(tup3); edges_g6.add(tup4); edges_g6.add(tup5);

        GraphMCP g6 = new GraphMCP("G6",3,1,output_g6,input_g6,edges_g6,allNodes_g6);


        //Graph g7
        List<Vertex> input_g7 = new ArrayList<>();
        List<Vertex> output_g7 = new ArrayList<>();
        List<tuple_> edges_g7 = new ArrayList<>();
        List<Vertex> allNodes_g7 = new ArrayList<>();

        Vertex inp1 = new Vertex("A7"); Vertex inp2 = new Vertex("B7"); input_g7.add(inp1); input_g7.add(inp2);
        Vertex id1 = new Vertex("m10"); Vertex id2 = new Vertex("m11");
        Vertex out1 = new Vertex("C7"); output_g7.add(out1);
        tuple_ tup11 = new tuple_(inp1,id1); tuple_ tup22 = new tuple_(inp2,id1); tuple_ tup33 = new tuple_(inp2,id2);
        tuple_ tup44 = new tuple_(id1,out1); tuple_ tup55 = new tuple_(id2,out1);
        edges_g7.add(tup11);edges_g7.add(tup22);edges_g7.add(tup33);edges_g7.add(tup44);edges_g7.add(tup55);

        GraphMCP g7 = new GraphMCP("G7",1,2,output_g7,input_g7,edges_g7,allNodes_g7);



        //Graph g8
        List<Vertex> input_g8 = new ArrayList<>();
        List<Vertex> output_g8 = new ArrayList<>();
        List<tuple_> edges_g8 = new ArrayList<>();
        List<Vertex> allNodes_g8 = new ArrayList<>();

        Vertex inpu1 = new Vertex("A8");Vertex inpu2 = new Vertex("B8"); Vertex inpu3 = new Vertex("C8");Vertex inpu4 = new Vertex("D8");
        Vertex inpu5 = new Vertex("E8");
        input_g8.add(inpu1); input_g8.add(inpu2); input_g8.add(inpu3); input_g8.add(inpu4); input_g8.add(inpu5);
        Vertex inte1 = new Vertex("M12");
        Vertex outp1 = new Vertex("F8"); Vertex outp2 = new Vertex("G9"); output_g8.add(outp1); output_g8.add(outp2);
        tuple_ j1 = new tuple_(inpu1,inte1); tuple_ j2 = new tuple_(inpu2,inte1); tuple_ j3 = new tuple_(inpu3,inte1);
        tuple_ j4 = new tuple_(inpu4,inte1); tuple_ j5 = new tuple_(inpu5,inte1); tuple_ j6 = new tuple_(inte1,outp1); tuple_ j7 = new tuple_(inte1,outp2);
        edges_g8.add(j1); edges_g8.add(j2); edges_g8.add(j3); edges_g8.add(j4); edges_g8.add(j5); edges_g8.add(j6); edges_g8.add(j7);

        GraphMCP g8 = new GraphMCP("G8",2,5,output_g8,input_g8,edges_g8,allNodes_g8);



        //Graph g9
        List<Vertex> input_g9 = new ArrayList<>();
        List<Vertex> output_g9 = new ArrayList<>();
        List<tuple_> edges_g9 = new ArrayList<>();
        List<Vertex> allNodes_g9 = new ArrayList<>();

        Vertex input1 = new Vertex("A9"); Vertex input2 = new Vertex("B9"); Vertex input3 = new Vertex("C10");
        input_g9.add(input1); input_g9.add(input2); input_g9.add(input3);
        Vertex lol1 = new Vertex("M13"); Vertex lol2 = new Vertex("M14"); Vertex lol3 = new Vertex("M15");
        Vertex output1 = new Vertex("D9"); Vertex output2 = new Vertex("E9"); Vertex output3= new Vertex("F9");
        Vertex output4 = new Vertex("G9"); Vertex output5 = new Vertex("H9");
        output_g9.add(output1); output_g9.add(output2); output_g9.add(output3); output_g9.add(output4); output_g9.add(output5);
        tuple_ q1 = new tuple_(input1,lol1); tuple_ q2 = new tuple_(input2,lol1); tuple_ q3 = new tuple_(input3,lol1);
        tuple_ q4 = new tuple_(input2,lol2); tuple_ q5 = new tuple_(input3,lol3);
        tuple_ q6 = new tuple_(lol1,output1); tuple_ q7 = new tuple_(lol1,output2); tuple_ q8 = new tuple_(lol1,output3);
        tuple_ q9 = new tuple_(lol1,output4); tuple_ q10 = new tuple_(lol1,output5);

        edges_g9.add(q1); edges_g9.add(q2); edges_g9.add(q3); edges_g9.add(q4); edges_g9.add(q5); edges_g9.add(q6); edges_g9.add(q7);
        edges_g9.add(q8); edges_g9.add(q9); edges_g9.add(q10);

        GraphMCP g9 = new GraphMCP("G9",5,3,output_g9, input_g9,edges_g9,allNodes_g9);


        //Graph 10
        List<Vertex> input_g10 = new ArrayList<>();
        List<Vertex> output_g10 = new ArrayList<>();
        List<tuple_> edges_g10 = new ArrayList<>();
        List<Vertex> allNodes_g10 = new ArrayList<>();

        Vertex i_i = new Vertex("A10"); input_g10.add(i_i);
        Vertex o_o = new Vertex("B10"); Vertex o1_o = new Vertex("C10"); Vertex o2_o = new Vertex("D10");
        output_g10.add(o_o); output_g10.add(o1_o); output_g10.add(o2_o);
        tuple_ w1 = new tuple_(i_i,o_o); tuple_ w2 = new tuple_(i_i,o1_o); tuple_ w3 = new tuple_(i_i,o2_o);
        edges_g10.add(w1); edges_g10.add(w2); edges_g10.add(w3);

        GraphMCP g10 = new GraphMCP("G10",3,1,output_g10, input_g10,edges_g10,allNodes_g10);


        List<MatrixInfo_new> graphes = new ArrayList<>();
        graphes.add(g1);
        graphes.add(g2);
        graphes.add(g3);
        graphes.add(g4);
        graphes.add(g5);
        graphes.add(g6);
        graphes.add(g7);
        graphes.add(g8);
        graphes.add(g9);
        graphes.add(g10);

        GraphMCPNode root = new GraphMCPNode(graphes,0,0);
        long startTime = System.nanoTime();
        createTree(root);
        long stopTime = System.nanoTime();
        long result_execution = (stopTime - startTime);
        System.out.println(" Execution time in nano: "+ result_execution);
        System.out.println(" ");