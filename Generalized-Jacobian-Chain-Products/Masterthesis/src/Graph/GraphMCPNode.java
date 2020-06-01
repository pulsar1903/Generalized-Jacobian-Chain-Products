package Graph;

import Generic.MatrixInfo;
import Generic.Node;


import java.util.List;

public class GraphMCPNode extends Node_new{

    //public static long memory_costs;

    public GraphMCPNode(List<MatrixInfo_new> matrices, long parentCosts, long mem){
        super(matrices,parentCosts,mem);
    }


    public boolean isLeaf(){
        return matrices.size()<=1;
    }

    public GraphMCPNode createSuccessor(List<MatrixInfo_new> adaptedMatrices, int index){
        // combine the two matrices at index and index+1 to a new Matrix and set cost of new node
        GraphMCP first = (GraphMCP) adaptedMatrices.get(index);
        GraphMCP second = (GraphMCP) adaptedMatrices.get(index+1);
        // calculate costs of First * Second
        long multiplicationCosts = calcGraphCosts(first,second);
        long mem_costs = calculationMemoryCosts(first,second);
        // create new combined Matrix
        GraphMCP combined = GraphMCP.combine(first, second);
        // replace first and second in List by new combined matrix
        adaptedMatrices.remove(index);
        adaptedMatrices.remove(index);
        adaptedMatrices.add(index,combined);
        System.out.println("Creating successor ...");
        for(MatrixInfo_new m:adaptedMatrices){
            System.out.print(m.name);
        }
        System.out.println("");
        return new GraphMCPNode(adaptedMatrices, multiplicationCosts ,mem_costs + this.memory_costs);
    }

    public long calcGraphCosts(GraphMCP first, GraphMCP second){
        long result;
        //First option : Transform costs of Graph1 to M1 and costs of the calculation of M1*G2
        //M1*G2 bedeutet man multipliziert rückwärts, deswegen muss man die Output knoten von M1 angucken und mit den Anzahl der Kanten von G rechnen
        long transform_costsG1 = first.edges * (Math.min(first.inputNodes.size(),first.outputNodes.size()));
        long costs_1 = transform_costsG1 + (first.outputNodes.size()* second.edges);

        //Second option : Transform costs of Graph2 to M2 and costs of the calculation of G1*M2
        long transform_costsG2 = second.edges * Math.min(second.inputNodes.size(),second.outputNodes.size());
        long costs_2 = transform_costsG2 + (second.inputNodes.size()*first.edges);

        //Third option : Transform G1 to M1 and G2 to M2. Calculate the transform costs + the costs of M1*m2
        long costs_3 = transform_costsG1 + transform_costsG2 + (first.dim1*first.dim2*second.dim2);

        //forth option:
      //  long costs_4 = (first.edges + second.edges);

        //take the minimum of the three options
        //result =   Math.min(Math.min(Math.min(costs_1,costs_2),costs_3),costs_4);
        result =   Math.min(Math.min(costs_1,costs_2),costs_3);

            return result;
    }

    public long calculationMemoryCosts(GraphMCP first, GraphMCP second){
        long result;
        //First option : Transform costs of Graph1 to M1 and costs of the calculation of M1*G2
        //M1*G2 bedeutet man multipliziert rückwärts, deswegen muss man die Output knoten von M1 angucken und mit den Anzahl der Kanten von G rechnen
        long transform_costsG1 = first.edges* (Math.min(first.inputNodes.size(),first.outputNodes.size()));
        long costs_1 = transform_costsG1 + (first.outputNodes.size()* second.edges);

        //Second option : Transform costs of Graph2 to M2 and costs of the calculation of G1*M2
        long transform_costsG2 = second.edges* Math.min(second.inputNodes.size(),second.outputNodes.size());
        long costs_2 = transform_costsG2 + (second.inputNodes.size()*first.edges);

        //Third option : Transform G1 to M1 and G2 to M2. Calculate the transform costs + the costs of M1*m2
        long costs_3 = transform_costsG1 + transform_costsG2 + (first.dim1*first.dim2*second.dim2);

        //forth option:
        long costs_4 = (first.edges + second.edges);

        //take the minimum of the three options
        //result =   Math.min(Math.min(Math.min(costs_1,costs_2),costs_3),costs_4);
        result =   Math.min(Math.min(costs_1,costs_2),costs_3);



        
        long mem=0;
        if (result == costs_2)  // bei G*M  = Speicherkosten 0
            mem= 0+mem;
        if (result == costs_1){
            mem = second.edges;

            if(first.outputNodes.size() < first.inputNodes.size()){
                mem += first.edges;
            }else{
                mem = mem + 0;
            }

        }

        return mem;

    }





}
