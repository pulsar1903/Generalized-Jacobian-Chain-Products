  // for Graph 1
        List<Vertex_> input_g1 = new ArrayList<>();
        List<Vertex_> output_g1 = new ArrayList<>();
        List<tuple__> edges_g1 = new ArrayList<>();
        List<Vertex_> allNodes_g1 = new ArrayList<>();

        Vertex_ i_1 = new Vertex_("A");
        Vertex_ i_2 = new Vertex_("B");
        Vertex_ i_3 = new Vertex_("C");
        input_g1.add(i_1);
        input_g1.add(i_2);
        input_g1.add(i_3);


        Vertex_ o_2 = new Vertex_("D");
        Vertex_ o_3 = new Vertex_("E");
        Vertex_ out1 = new Vertex_("D_");
        output_g1.add(o_2);
        output_g1.add(o_3);
        output_g1.add(out1);


        Vertex_ u1 = new Vertex_("X");


        tuple__ e1 = new tuple__(i_1,o_2);//A nach D
        tuple__ e2 = new tuple__(i_1,u1); //A nach X
        tuple__ e3 = new tuple__(i_2,u1);//B nach X
        tuple__ e4 = new tuple__(i_3,u1);//C nach X
        tuple__ e5 = new tuple__(u1,o_2);// X nach D
        tuple__ e6 = new tuple__(u1,o_3);//X nach E
        tuple__ e66 = new tuple__(u1,out1);

        edges_g1.add(e1);
        edges_g1.add(e2);
        edges_g1.add(e3);
        edges_g1.add(e4);
        edges_g1.add(e5);
        edges_g1.add(e6);
        edges_g1.add(e66);



        MemoryMCP g1 = new MemoryMCP("G1",3,3,output_g1, input_g1, edges_g1);

        // For Graph 2
        List<Vertex_> input_g2 = new ArrayList<>();
        List<Vertex_> output_g2 = new ArrayList<>();
        List<tuple__> edges_g2 = new ArrayList<>();
        List<Vertex_> allNodes_g2 = new ArrayList<>();

        Vertex_ ii_1 = new Vertex_("F");
        Vertex_ ii_2 = new Vertex_("G");
        Vertex_ ii_3 = new Vertex_("H");
        Vertex_ ii_33 = new Vertex_ ("H_");
        input_g2.add(ii_33);
        input_g2.add(ii_1);
        input_g2.add(ii_2);
        input_g2.add(ii_3);

        Vertex_ oo_1 = new Vertex_("I");
        Vertex_ oo_2 = new Vertex_("J");
        Vertex_ oo_3 = new Vertex_("K");
        output_g2.add(oo_1);
        output_g2.add(oo_2);
        output_g2.add(oo_3);

        Vertex_ z = new Vertex_("W");


        tuple__ ee1 = new tuple__(ii_1,oo_1);
        tuple__ ee2 = new tuple__(ii_1,z);
        tuple__ ee3 = new tuple__(ii_2,z);
        tuple__ ee4 = new tuple__(ii_3,z);
        tuple__ ee5 = new tuple__(ii_3,oo_3);
        tuple__ ee6 = new tuple__(z,oo_3);
        tuple__ ee7 = new tuple__(z,oo_1);
        tuple__ ee8 = new tuple__(z,oo_2);
        tuple__ ee99 = new tuple__(ii_33,oo_1);
        tuple__ ee89 = new tuple__(ii_33,oo_2);
        tuple__ ee79 = new tuple__(ii_33,oo_3);

        edges_g2.add(ee1);
        edges_g2.add(ee2);
        edges_g2.add(ee3);
        edges_g2.add(ee4);
        edges_g2.add(ee5);
        edges_g2.add(ee6);
        edges_g2.add(ee7);
        edges_g2.add(ee8);
        edges_g2.add(ee99);
        edges_g2.add(ee89);
        edges_g2.add(ee79);



        MemoryMCP g2 = new MemoryMCP("G2",3,4,output_g2,input_g2, edges_g2);


        //For graph 3
        List<Vertex_> input_g3 = new ArrayList<>();
        List<Vertex_> output_g3 = new ArrayList<>();
        List<tuple__> edges_g3 = new ArrayList<>();
        List<Vertex_> allNodes_g3 = new ArrayList<>();

        Vertex_ ooo_1 = new Vertex_("L");//R
        Vertex_ ooo_2 = new Vertex_("M");//S
        Vertex_ ooo_3 = new Vertex_("N");//T
        Vertex_ ooo__4 = new Vertex_("N_");//V
        output_g3.add(ooo_1);
        output_g3.add(ooo_2);
        output_g3.add(ooo_3);
        output_g3.add(ooo__4);


        Vertex_ iii_1 = new Vertex_("O"); //M
        Vertex_ iii_2 = new Vertex_("OO"); // N
        Vertex_ iii_3 = new Vertex_("PP");//O
        Vertex_ iii_4 = new Vertex_("QW");//P
        Vertex_ iii_5 = new Vertex_("OH");//Q
        input_g3.add(iii_1);
        input_g3.add(iii_2);
        input_g3.add(iii_3);
        input_g3.add(iii_4);
        input_g3.add(iii_5);

        Vertex_ q = new Vertex_("Q");//z
        Vertex_ p = new Vertex_("P");//y

        tuple__ eee1 = new tuple__(q,ooo_1);//
        tuple__ eee2 = new tuple__(q,ooo_2);
        tuple__ eee3 = new tuple__(p,ooo_3);
        tuple__ eee5 = new tuple__(iii_1,p);
        tuple__ eee6 = new tuple__(iii_1,q);
        tuple__ eee66 = new tuple__(iii_1,ooo__4);

        tuple__ eee7 = new tuple__(iii_2,q);
        tuple__ eee8 = new tuple__(iii_2,p);
        tuple__ eee9 = new tuple__(iii_3,q);
        tuple__ eee10 = new tuple__(iii_3,p);
        tuple__ eee11 = new tuple__(iii_4,q);
        tuple__ eee12 = new tuple__(iii_4,p);
        tuple__ eee13 = new tuple__(iii_5,q);
        tuple__ eee14 = new tuple__(iii_5,p);
        tuple__ eeee15 = new tuple__(p,ooo__4);


        edges_g3.add(eee66);
        edges_g3.add(eee1);
        edges_g3.add(eee2);
        edges_g3.add(eee3);
        edges_g3.add(eee5);
        edges_g3.add(eee6);
        edges_g3.add(eee7);
        edges_g3.add(eee8);
        edges_g3.add(eee9);
        edges_g3.add(eee10);
        edges_g3.add(eee11);
        edges_g3.add(eee12);
        edges_g3.add(eee13);
        edges_g3.add(eee14);
        edges_g3.add(eeee15);


        MemoryMCP g3 = new MemoryMCP("G3",4,5,output_g3,input_g3,edges_g3);


        //For graph 4
        List<Vertex_> input_g4 = new ArrayList<>();
        List<Vertex_> output_g4 = new ArrayList<>();
        List<tuple__> edges_g4 = new ArrayList<>();
        List<Vertex_> allNodes_g4 = new ArrayList<>();

       Vertex_ a1 = new Vertex_("a1"); Vertex_ b1 = new Vertex_("b1"); input_g4.add(a1); input_g4.add(b1);
       Vertex_ z1 = new Vertex_("z1");
       Vertex_ e_2 = new Vertex_("e2"); Vertex_ e_3 = new Vertex_("e3"); Vertex_ e_4 = new Vertex_("e4"); Vertex_ e_5 = new Vertex_("e5"); Vertex_ e_6 = new Vertex_("e6");
       Vertex_ e_7 = new Vertex_("e7");
       output_g4.add(e_2); output_g4.add(e_3); output_g4.add(e_4); output_g4.add(e_5); output_g4.add(e_6); output_g4.add(e_7);
       tuple__ l1 = new tuple__(a1,z1); tuple__ l2 = new tuple__(b1,z1);
        tuple__ l3 = new tuple__(z1,e_2); tuple__ l4 = new tuple__(z1,e_3); tuple__ l5 = new tuple__(z1,e_4);tuple__ l6 = new tuple__(z1,e_5);tuple__ l7 = new tuple__(z1,e_6);
        edges_g4.add(l1);edges_g4.add(l2);edges_g4.add(l3);edges_g4.add(l4);edges_g4.add(l5);edges_g4.add(l6);edges_g4.add(l7);


        MemoryMCP g4 = new MemoryMCP("G4",5,2,output_g4,input_g4,edges_g4);


        List<MatrixInfo__new> graphes = new ArrayList<>();
        graphes.add(g1);
        graphes.add(g2);
        graphes.add(g3);
      //  graphes.add(g4);

        MemoryMCPNode root = new MemoryMCPNode(graphes,0,0);
        long startTime = System.nanoTime();
        createTree(root);
        long stopTime = System.nanoTime();
        long result_execution = (stopTime - startTime);
        System.out.println(" Execution time in nano: "+ result_execution);
        System.out.println(" ");
    }