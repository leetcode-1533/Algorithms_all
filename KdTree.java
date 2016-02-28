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
        
        public Node(Point2D inp, RectHV inrect) {
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
    
    private Node put(Node rot, Node prev, Point2D p, boolean isVertical) {
        if(rot == null) {   
            if(prev == null)
                return new Node(p, new RectHV(0.0, 0.0, 1.0, 1.0));
            
            if(isVertical) {
                if(p.x() < prev.p.x())
                    return new Node(p, new RectHV(prev.rect.xmin(), prev.rect.ymin(), prev.p.x(), prev.rect.ymax()));
                else 
                    return new Node(p, new RectHV(prev.p.x(), prev.rect.ymin(), prev.rect.xmax(), prev.rect.ymax())); 
            } else {
                if(p.y() < prev.p.y())
                    return new Node(p, new RectHV(prev.rect.xmin(), prev.rect.ymin(), prev.rect.xmax(), prev.p.y())); 
                else 
                    return new Node(p, new RectHV(prev.rect.xmin(), prev.p.y(), prev.rect.xmax(), prev.rect.ymax()));                   
                }
            }
             
        if(isVertical) { // compare by x
            if(p.x() < rot.p.x()) // less and not the same to the left
                rot.lb = put(rot.lb, rot, p, !isVertical);
            else 
                rot.rt = put(rot.rt, rot, p, !isVertical);
        } else { // horizontal
            if(p.y() < rot.p.y())
                rot.lb = put(rot.lb, rot, p, !isVertical);
            else
                rot.rt = put(rot.rt, rot, p, !isVertical);   
        }
        return rot;
    }
    
    public void insert(Point2D p) {
        root = put(root, null, p, true);      
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
        draw(root, true);       
    }
    
    private void draw(Node current, boolean isVertical) {
        if(current == null)
            return;
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(.01);
        current.p.draw();
        if(isVertical) {
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.setPenRadius();
            StdDraw.line(current.p.x(), current.rect.ymin(), current.p.x(), current.rect.ymax());
        } else {
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.setPenRadius();
            StdDraw.line(current.rect.xmin(), current.p.y(), current.rect.xmax(), current.p.y());
        }
        draw(current.rt, !isVertical);             
        draw(current.lb, !isVertical);
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
        kdtree.draw();
    }
}
