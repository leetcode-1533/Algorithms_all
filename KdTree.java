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
        
        private Node(Point2D inp, RectHV inrect) {
            p = inp;
            rect = inrect;
        }
    }
    
    public KdTree() {
        
    }
    
    public int size() {
        if(root == null)
            return 0;
        else 
            return subSize(root);
    }
    
    private static int subSize(Node sroot) {
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
    
    private Node put(Node rot, Point2D p, boolean isVertical) {
        if(rot == null)
            return new Node(p, null);
        
        if(isVertical) { // compare by x
            if(p.x() < rot.p.x()) // less and not the same to the left
                rot.lb = put(rot.lb, p, !isVertical);
            else 
                rot.rt = put(rot.rt, p, !isVertical);
        } else { // horizontal
            if(p.y() < rot.p.y())
                rot.lb = put(rot.lb, p, !isVertical);
            else
                rot.rt = put(rot.rt, p, !isVertical);   
        }
        return rot;
    }
    
    public void insert(Point2D p) {
        root = put(root, p, true);      
    }
    
    public boolean contains(Point2D p) {
        return contains(root, p, true);       
    }
    
    private boolean contains(Node rot, Point2D p, boolean isVertical) {
        if(rot == null) 
            return false;
        if(rot.p.equals(p))
            return true;
        
        if(isVertical) {
            if(p.x() < rot.p.x())
                return contains(rot.lb, p, !isVertical);
            else 
                return contains(rot.rt, p, !isVertical);
        } else {
            if(p.y() < rot.p.y())
                return contains(rot.lb, p, !isVertical);
            else 
                return contains(rot.rt, p, !isVertical);
        }      
    }
   
    public void draw() {
        
    }
    
    public static void main(String[] args) {      
        String filename = args[0];
        In in = new In(filename);

//        StdDraw.show(0);

        // initialize the two data structures with point from standard input
        KdTree kdtree = new KdTree();
        while (!in.isEmpty()) {
            double x = in.readDouble();
            double y = in.readDouble();
            Point2D p = new Point2D(x, y);
            kdtree.insert(p);
        }        
        in = new In(filename);
        while (!in.isEmpty()) {
            double x = in.readDouble();
            double y = in.readDouble();
            Point2D p = new Point2D(x, y);
            StdOut.println(kdtree.contains(p));
        } 
        Point2D test = new Point2D(0.0, 0.6);
        StdOut.println(kdtree.contains(test));
    }
}
