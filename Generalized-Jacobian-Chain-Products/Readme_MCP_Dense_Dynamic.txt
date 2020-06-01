To perform dynamic programming for dense matrices, the Naiv_Dynamic_MCP class must be opened in the DynamicProgrammingSolutions folder.
In order to reproduce example 2.1.1 from the master thesis, the following must be done. 

To recap  : A=(10x2), B=(2x5), C=(5x7), D=(7x4)

the array "arr" in the main function must be declared with => int [] arr = new int[] { 10,2,5,7,4};
This will output following result : 206

If you want to see what the parenthesis for the example is like, you have to use the class " Naiv_dynamicMCP_2" 
and assign in the main =>  runMatrixChainMultiplication(new int[] {10,2,5,7,4});

