//2.3.1 Runtime Analysis


  //[6,2,1,5,8,9,12,3,8,7,10,4]
        SimpleMCP a = new SimpleMCP("A", 6, 2);//6x2
        SimpleMCP b = new SimpleMCP("B", 2, 1); //2x1
        SimpleMCP c = new SimpleMCP("C", 1, 5); //1x5
        SimpleMCP d = new SimpleMCP("D", 5,8 );//5x8
        SimpleMCP e = new SimpleMCP("E", 8, 9);//8x9
        SimpleMCP f = new SimpleMCP("F", 9, 12);//9x12
        SimpleMCP g = new SimpleMCP("G", 12,3 );//12x3
        SimpleMCP h = new SimpleMCP("H", 3, 8);//3x8
        SimpleMCP i = new SimpleMCP("I", 8, 7);//8x7
        SimpleMCP j = new SimpleMCP("J", 7, 10);//7x10
        SimpleMCP k = new SimpleMCP("K",10,4); //10x4
        

        List<MatrixInfo> matrices = new ArrayList<>();
        matrices.add(a);
        matrices.add(b);
        matrices.add(c);
        matrices.add(d);
		matrices.add(e);
        matrices.add(f);
        matrices.add(g);
        matrices.add(h);
        matrices.add(i);
        matrices.add(j);
        matrices.add(k);
        


        SimpleMCPNode root = new SimpleMCPNode(matrices, 0);
        long startTime = System.nanoTime();
        createTree(root);
        long stopTime = System.nanoTime();
        long result_execution = (stopTime - startTime);
        System.out.println(" Execution time in nano: "+ result_execution);
        System.out.println(" ");
