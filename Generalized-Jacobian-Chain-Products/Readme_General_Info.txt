The Project is divided into the specific problems. 
Following folders are given : 

"naivMCP" => denotes the MCP   for dense matrictes.
"sparseMCP" => MCP for sparse matrices
"DynamicProgrammingSolutions" => contains the dynamic programming approaches for the MCP with dense matrices and sparse matrices
"Graph" => calculates the multiplication of two graphs.
"Memory"=> Graph multiplication + memory bound.

These folders mainly consist of a solver, node and the name of the problem.

In the solver, the main function is the one that executes the problem with the particular instance.

In the file "node" is the important method "createSuccessor", which ensures that the successors are determined and merged. 
In it the costs of the successor are calculated.
 In the latter the important function combine is defined, 
which merges two matrices/graphs into one.