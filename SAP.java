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
        int min = -1;
        for(int i = 0; i < graph.V(); i++) {
            if(BFsearch_v.hasPathTo(i) && BFsearch_w.hasPathTo(i)) {
                int temp = BFsearch_v.distTo(i) + BFsearch_w.distTo(i);
                if(temp < min || min < 0) {
                    min = temp;
                }
            }
        }
        return min;
    }
    
    public int ancestor(int v, int w) {
        BreadthFirstDirectedPaths BFsearch_v = new BreadthFirstDirectedPaths(graph, v);
        BreadthFirstDirectedPaths BFsearch_w = new BreadthFirstDirectedPaths(graph, w);
        int min = -1;
        int anc = -1;
        for(int i = 0; i < graph.V(); i++) {
            if(BFsearch_v.hasPathTo(i) && BFsearch_w.hasPathTo(i)) {
                int temp = BFsearch_v.distTo(i) + BFsearch_w.distTo(i);
                if(temp < min || min < 0) {
                    min = temp;
                    anc = i;
                }
            }
        }
        return anc;      
    }
    
    public int length(Iterable<Integer> v, Iterable<Integer> w) {   
        BreadthFirstDirectedPaths BFsearch_v = new BreadthFirstDirectedPaths(graph, v);
        BreadthFirstDirectedPaths BFsearch_w = new BreadthFirstDirectedPaths(graph, w);
        int min = -1;
        for(int i = 0; i < graph.V(); i++) {
            if(BFsearch_v.hasPathTo(i) && BFsearch_w.hasPathTo(i)) {
                int temp = BFsearch_v.distTo(i) + BFsearch_w.distTo(i);
                if(temp < min || min < 0) {
                    min = temp;
                }
            }
        }
        return min;
        
    }
    
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        BreadthFirstDirectedPaths BFsearch_v = new BreadthFirstDirectedPaths(graph, v);
        BreadthFirstDirectedPaths BFsearch_w = new BreadthFirstDirectedPaths(graph, w);
        int min = -1;
        int anc = -1;
        for(int i = 0; i < graph.V(); i++) {
            if(BFsearch_v.hasPathTo(i) && BFsearch_w.hasPathTo(i)) {
                int temp = BFsearch_v.distTo(i) + BFsearch_w.distTo(i);
                if(temp < min || min < 0) {
                    min = temp;
                    anc = i;
                }
            }
        }
        return anc;     
        
    }
     
    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        SAP sap = new SAP(G);
        
        {
            int v = 1;
            int w = 6;
            int length = sap.length(v, w);
            int ancestor = sap.ancestor(v, w);
            StdOut.printf("length = %d, ancestor = %d", length, ancestor);
        }
    }
}
