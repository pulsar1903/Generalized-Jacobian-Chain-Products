//The class "Sparce_dynamic" for this problem can be find in the folder "DynamicProgrammingSolutions"
// It is the same procedure as with the BranchAndBound approach. Therefore read the declaration there


  //Example 3.1.1
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
        matrices.add(a);
        matrices.add(b);
        matrices.add(c);