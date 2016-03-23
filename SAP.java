import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;

public class SAP {  
    private Digraph graph;
    
    public SAP(Digraph G) {
        graph = G;
    }
    
    public int length(int v, int w) {
        BreadthFirstDirectedPaths BFsearch_v = new BreadthFirstDirectedPaths(graph, v);
        BreadthFirstDirectedPaths BFsearch_w = new BreadthFirstDirectedPaths(graph, w);
        
        
        return 0;  
    }
    
//    public int ancestor(int v, int w) {
//        
//    }
    
    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        SAP sap = new SAP(G);
        
        {
            int v = 3;
            int w = 11;
            int length = sap.length(v, w);
//            int ancestor = sap.ancestor(v, w);
            StdOut.printf("length = %d", length);
        }
    }
}
