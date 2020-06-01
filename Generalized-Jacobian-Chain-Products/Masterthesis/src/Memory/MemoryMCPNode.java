package Memory;

import java.util.ArrayList;
import java.util.List;

import static Memory.MemoryMCPSolver.global_memory;
import static Memory.MemoryMCPSolver.memory;

public class MemoryMCPNode extends Node__new {

    public MemoryMCPNode(List<MatrixInfo__new> matrices, long parentCosts, long mem) {
        super(matrices, parentCosts, mem);
    }

    public boolean isLeaf() {
        return matrices.size() <= 1;
    }

    public MemoryMCPNode createSuccessor(List<MatrixInfo__new> adaptedMatrices, int index, long limit) {
        // combine the two matrices at index and index+1 to a new Matrix and set cost of new node
        MemoryMCP first = (MemoryMCP) adaptedMatrices.get(index);
        MemoryMCP second = (MemoryMCP) adaptedMatrices.get(index + 1);
        // calculate costs of First * Second
        //long multiplicationCosts = calculationGraphMultiplicationCosts(first,second);

        List<Long> mult_costs = new ArrayList<>();

        List<Long> x = graph_costs2(first, second, limit);
        mult_costs.add(x.get(0));
        mult_costs.add(x.get(1));


        //long mem_costs = calculationMemoryCosts(first,second);
        // create new combined Matrix
        MemoryMCP combined = MemoryMCP.combine(first, second);
        //replace first and second in List by new combined matrix
        adaptedMatrices.remove(index);
        adaptedMatrices.remove(index);
        adaptedMatrices.add(index, combined);
        System.out.println("Creating successor ...");
        for (MatrixInfo__new m : adaptedMatrices) {
            System.out.print(m.name);
        }
        System.out.println("");
        return new MemoryMCPNode(adaptedMatrices, mult_costs.get(0) , mult_costs.get(1) + this.memory_costs);
    }


    //the case when memoy is M1*G2 with costs...
    public List<Long> graph_costs2(MemoryMCP first, MemoryMCP second,long limit) {
        List<Long> res1 = new ArrayList<>();
        List<Long> cost1 = new ArrayList<>();
        List<Long> cost2 = new ArrayList<>();
        List<Long> cost3 = new ArrayList<>();
        long costs_1;
        long result;
        long mem1 = 0;
        long mem2 = 0;

        //algorithm for the memory cost calculation. (G1*G2 => M1*G2)

        mem1 = second.edges;
        if (first.outputNodes.size() < first.inputNodes.size()) {
            mem1 += first.edges;
            long transform_costsG1 = first.edges * (Math.min(first.inputNodes.size(), first.outputNodes.size()));
            costs_1 = transform_costsG1 + (first.outputNodes.size() * second.edges);
        } else {
            mem1 = mem1 + 0;
            long transform_costsG1 = first.edges * (Math.min(first.inputNodes.size(), first.outputNodes.size()));
            costs_1 = transform_costsG1 + (first.outputNodes.size() * second.edges);
        }
        cost1.add(costs_1);
        cost1.add(mem1);


        //Second option : Transform costs of Graph2 to M2 and costs of the calculation of G1*M2
        long transform_costsG2 = second.edges * Math.min(second.inputNodes.size(), second.outputNodes.size());
        long costs_2 = transform_costsG2 + (second.inputNodes.size() * first.edges);

        mem2 = 0;
        cost2.add(costs_2);
        cost2.add(mem2);

        //third option
        long costs_3 = first.edges * (Math.min(first.inputNodes.size(), first.outputNodes.size())) + second.edges * Math.min(second.inputNodes.size(), second.outputNodes.size()) + (first.dim1*first.dim2*second.dim2);
        cost3.add(costs_3);
        cost3.add(mem2);


        result = Math.min(cost1.get(0),cost2.get(0));
        // if the memory costs still


        /*
        // Calculate the two options for the costs of graph multiplication
        //if first option is lower then second AND the limit is not reached, then cost1 else cost2(option2).
        if(cost1.get(0) <= cost2.get(0) && cost1.get(0) <= cost3.get(0) && (memory_costs + cost1.get(1)) <= limit){
       // if(cost1.get(0) <= cost2.get(0) && (memory_costs + cost1.get(1)) <= limit){
            System.out.println("option1: M*G");
            return cost1; //
        }else{
            if(cost2.get(0)< cost3.get(0)){
                System.out.println("option2 : G*M");
                return cost2;
            }else{
                System.out.println("option 3 : M1*M2");
                return cost3;
            }

        }
*/
        if(cost1.get(0) <= cost2.get(0) && (memory_costs + cost1.get(1)) <= limit){
            return cost1;
        }else{
            return cost2;
        }




            /*
           if((memory_costs + cost1.get(1)) <= limit ){
               return cost1;
           }else{
               return cost2;
           }

             */

    }

    //the case when memory is G1*M1 = 0
    public List<Long> graph_costs1(MemoryMCP first, MemoryMCP second) {
        List<Long> res1 = new ArrayList<>();
        long tmp = 0;

        long transform_costsG2 = second.edges * Math.min(second.inputNodes.size(), second.outputNodes.size());
        long costs_2 = transform_costsG2 + (second.inputNodes.size() * first.edges);
        tmp += 0;
        res1.add(costs_2);
        res1.add(tmp);
        return res1;


    }


}
