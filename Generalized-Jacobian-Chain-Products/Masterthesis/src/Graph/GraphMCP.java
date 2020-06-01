package Graph;

import java.util.*;
import java.util.stream.Stream;

import Generic.*;

public class GraphMCP extends MatrixInfo_new {
        final int dim1;
        final int dim2;
        public List<Vertex>  inputNodes;
        public List<Vertex>  outputNodes;
        public List<Vertex>  allNodes;
        //public List<tuple_>   edges;
        public int edges;
        public GraphMCP(String n, int d1, int d2,List<Vertex> o,List<Vertex> i,int  e, List<Vertex> a){
            super(n);
            this.dim1 = d1;
            this.dim2 = d2;
            this.inputNodes = i;
            this.outputNodes= o;
            this.allNodes = a;
            this.edges = e;
        }


        public static GraphMCP combine(GraphMCP first, GraphMCP second){
            List<Vertex> resultNodes = new ArrayList<>();
            //List<tuple_> combinedEdges = new ArrayList<>();
            int combinedEdges = first.edges + second.edges;

                      //NonSparse = bipartit Graph
                      //in a bipartit graph all input nodes have a connection to all output nodes.
                     // therefore amount of edges = (amount of inputnodes) * (amount of outputnodes)
                        //int edges_ = second.inputNodes.size() * first.outputNodes.size();

                        /*
                    //Add as edges from Graph1-output[i] to Graph2-input[i] for all i
                    int z = 0;
                    for(int i=0;i<first.outputNodes.size();i++){
                        for(int j=0;j<second.inputNodes.size();j++){
                            //t_[z+j] = new tuple_(second.inputNodes.get(i),first.outputNodes.get(j));
                            //zB (2x3) *(3x4) => (2x4) 2=output, 4= input
                            t_[z+j] = new tuple_(first.outputNodes.get(i),second.inputNodes.get(j));
                            combinedEdges.add(t_[z+j]);
                        }
                        z= z +second.inputNodes.size();
                    }
            */


                    //add the nodes of the result matrix to "resultnodes"
                    for(Vertex v : first.inputNodes){
                        resultNodes.add(v);
                    }
                    for(Vertex v : second.outputNodes){
                        resultNodes.add(v);
                    }


            return new GraphMCP("(" + first.name + "*" + second.name + ")",first.dim1,second.dim2,first.outputNodes,second.inputNodes,combinedEdges, resultNodes);
        }






}
