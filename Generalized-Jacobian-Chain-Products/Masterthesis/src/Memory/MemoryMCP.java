package Memory;

import Graph.GraphMCP;
import Graph.Vertex;
import Graph.tuple_;

import java.util.ArrayList;
import java.util.List;

public class MemoryMCP extends MatrixInfo__new{

    final int dim1;
    final int dim2;
    public List<Vertex_> inputNodes;
    public List<Vertex_>  outputNodes;
    public List<Vertex_>  allNodes;
   // public List<tuple__>   edges;
    public int edges;
    public MemoryMCP(String n, int d1, int d2,List<Vertex_> o,List<Vertex_> i,int e){
        super(n);
        this.dim1 = d1;
        this.dim2 = d2;
        this.inputNodes = i;
        this.outputNodes= o;
        //this.allNodes = a;
        this.edges = e;
    }


    public static MemoryMCP combine(MemoryMCP first, MemoryMCP second){
        List<Vertex_> resultNodes = new ArrayList<>();
        //List<tuple__> combinedEdges = new ArrayList<>();

        int combinedEdges = first.edges + second.edges;


        /*
        //NonSparse = bipartit Graph
        //in a bipartit graph all input nodes have a connection to all output nodes.
        // therefor amount of edges = (amount of inputnodes) * (amount of outputnodes)
        int edges_ = second.inputNodes.size() * first.outputNodes.size();
        tuple__ [] t_ = new tuple__[edges_];

        //Add as edges from Graph1-output[i] to Graph2-input[i] for all i
        int z = 0;
        for(int i=0;i<first.outputNodes.size();i++){
            for(int j=0;j<second.inputNodes.size();j++){
                //t_[z+j] = new tuple_(second.inputNodes.get(i),first.outputNodes.get(j));
                t_[z+j] = new tuple__(first.outputNodes.get(i),second.inputNodes.get(j));
                combinedEdges.add(t_[z+j]);
            }
            z= z +second.inputNodes.size();
        }
        */




        return new MemoryMCP("(" + first.name + "*" + second.name + ")",first.dim1,second.dim2,first.outputNodes,second.inputNodes,combinedEdges);
    }

}
