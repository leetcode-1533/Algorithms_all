import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdDraw;

public class KdTree {
    private Node root;
    private static class Node {
        private Point2D p;
        private RectHV rect;
        private Node lb;
        private Node rt;
    }
    
    public KdTree() {
        
    }
    
    public int size() {
        if(root == null)
            return 0;
        else 
            return subSize(root);
    }
    
    private int subSize(Node sroot) {
        if(sroot.lb == null && sroot.rt == null)
            return 1;
        else if (sroot.lb != null && sroot.rt == null)
            return 1 + subSize(sroot.lb);
        else if (sroot.lb == null && sroot.rt != null)
            return 1 + subSize(sroot.rt);
        else 
            return 1 + subSize(sroot.lb) + subSize(sroot.rt);
    }
    
    public boolean isEmpty() {
        return size() == 0;       
    }
    
    public void insert(Point2D p) {
        
    }
    
    public void draw() {
        
    }
    
    public static void main(String[] args) {      
        String filename = args[0];
        In in = new In(filename);

        StdDraw.show(0);

        // initialize the two data structures with point from standard input
        KdTree kdtree = new KdTree();
        while (!in.isEmpty()) {
            double x = in.readDouble();
            double y = in.readDouble();
            Point2D p = new Point2D(x, y);
            kdtree.insert(p);
        }
        
    }

}
