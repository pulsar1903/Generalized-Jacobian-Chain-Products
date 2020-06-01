// 2.3.2
//[4,4,8,2,8,10,1,9,1,10]
        SimpleMCP a = new SimpleMCP("A", 4, 4);//4x4
        SimpleMCP b = new SimpleMCP("B", 4, 8); //4x8
        SimpleMCP c = new SimpleMCP("C", 8, 2); //8x2
        SimpleMCP d = new SimpleMCP("D", 2,8 );//2x8
        SimpleMCP e = new SimpleMCP("E", 8, 10);//8x10
        SimpleMCP f = new SimpleMCP("F", 10, 1);//10x1
        SimpleMCP g = new SimpleMCP("G", 1,9 );//1x9
        SimpleMCP h = new SimpleMCP("H", 9, 1);//9x1
        SimpleMCP i = new SimpleMCP("I", 1, 10);//1x10



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

