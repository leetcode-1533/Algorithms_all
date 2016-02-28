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
    
    private static class MaxNode {
        private double max;
        private Node Nod;
        MaxNode(Node initn, double initmax) {
            Nod = initn;
            max = initmax;            
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
            if(prev.p.equals(p))
                return null;
            
            if(!isVertical) { // is vertical for determining rect
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
        if(p == null)
            throw new NullPointerException();
        root = put(root, null, p, true);   
//        StdOut.println(p);
    }
    
    public boolean contains(Point2D p) {
        if(p == null)
            throw new NullPointerException();
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
    
    public Point2D nearest(Point2D p) {
        Node temp = nearest(root, null, p);
        return temp.p;
    }
    
    private Node nearest(Node current, Node pbest, Point2D p) {
        if(current == null) {
            return pbest;         
        }
//        StdDraw.clear();
//        this.draw();
//        StdDraw.setPenColor(StdDraw.GREEN);
//        StdDraw.setPenRadius(.02);
//        current.p.draw();
//        StdDraw.setPenColor(StdDraw.BLUE);
//        p.draw();


        Node best;
        double dist = current.p.distanceSquaredTo(p);
        
        if(pbest == null) {
            best = nearest(current.lb, current, p);
            if(current.rt == null)
                return best;
            else if(best.p.distanceSquaredTo(p) > current.rt.rect.distanceSquaredTo(p)) {
                best = nearest(current.rt, best, p);
                return best;
            } else
                return best;
        } else {
            if(dist < pbest.p.distanceSquaredTo(p)) {
                best = nearest(current.lb, current, p);
                if(current.rt == null)
                    return current;
                else if(best.p.distanceSquaredTo(p) > current.rt.rect.distanceSquaredTo(p)) {
//                    StdOut.println("Rect" + current.rt.rect + "Points:" );
                    best = nearest(current.rt, best, p);
                    return best;
                } else 
                    return current;
            } else {
                best = nearest(current.lb, pbest, p);
                if(current.rt == null)
                    return best;
                else if(best.p.distanceSquaredTo(p) > current.rt.rect.distanceSquaredTo(p)) {
                    best = nearest(current.rt, best, p);
                    return best;
                } else 
                    return best;
            }
        }
    }
    
    public static void main(String[] args) {      
        String filename = args[0];
        In in = new In(filename);

//        StdDraw.show(0);

        // initialize the two data structures with point from standard input
        KdTree kdtree = new KdTree();
//        StdOut.println(kdtree.size());
        while (!in.isEmpty()) {
            double x = in.readDouble();
            double y = in.readDouble();
            Point2D p = new Point2D(x, y);
            kdtree.insert(p);
        }        
        Point2D test = new Point2D(0.3, 0.3);
        Point2D bt = kdtree.nearest(test);
        kdtree.draw();
        

        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(.02);
        bt.draw();

        StdDraw.setPenColor(StdDraw.BLUE);
        test.draw();

    }
}
