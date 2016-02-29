import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

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
    
    private int size;
    
    public KdTree() {       
        size = 0;
    }
    
    public int size() {
        return size;
    }
    
//    private static int subSize(Node sroot) {
//        if(sroot.lb == null && sroot.rt == null)
//            return 1;
//        else if (sroot.lb != null && sroot.rt == null)
//            return 1 + subSize(sroot.lb);
//        else if (sroot.lb == null && sroot.rt != null)
//            return 1 + subSize(sroot.rt);
//        else 
//            return 1 + subSize(sroot.lb) + subSize(sroot.rt);
//    }
    
    public boolean isEmpty() {
        return size() == 0;       
    }
    
    private Node put(Node rot, Node prev, Point2D p, boolean isVertical) {
        if(rot == null) {   
            if(prev == null) {
                size++;
                return new Node(p, new RectHV(0.0, 0.0, 1.0, 1.0));
            }
            
            if(prev.p.equals(p))
                return null;
            
            size++;
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
        Node temp = nearest(root, root, p, true);
        return temp.p;
    }
    
    private Node nearest(Node current, Node best, Point2D p, boolean isVertical) {
        if(current == null) {
            return best;         
        }
//        StdDraw.clear();
//        this.draw();
//        StdDraw.setPenColor(StdDraw.GREEN);
//        StdDraw.setPenRadius(.02);
//        current.p.draw();
//        StdDraw.setPenColor(StdDraw.BLUE);
//        p.draw();
        
        if(current.p.distanceSquaredTo(p) < best.p.distanceSquaredTo(p))
            best = current;
        
        if(isVertical) {
            if(current.p.x() < p.x()) { // target at the right
                best = nearest(current.rt, best, p, !isVertical);
            if(current.lb != null
                    && current.lb.rect.distanceSquaredTo(p) < best.p.distanceSquaredTo(p))
                best = nearest(current.lb, best, p, !isVertical);    
            } else { // target at the left
                best = nearest(current.lb, best, p, !isVertical);
                if(current.rt != null
                        && current.rt.rect.distanceSquaredTo(p) < best.p.distanceSquaredTo(p))
                    best = nearest(current.rt, best, p, !isVertical);               
            }                      
        } else {
            if(current.p.y() < p.y()) { // target at the right
                best = nearest(current.rt, best, p, !isVertical);
            if(current.lb != null
                    && current.lb.rect.distanceSquaredTo(p) < best.p.distanceSquaredTo(p))
                best = nearest(current.lb, best, p, !isVertical);    
            } else { // target at the left
                best = nearest(current.lb, best, p, !isVertical);
                if(current.rt != null
                        && current.rt.rect.distanceSquaredTo(p) < best.p.distanceSquaredTo(p))
                    best = nearest(current.rt, best, p, !isVertical);               
            }         
        }
        return best;
    }
    public Iterable<Point2D> range(RectHV rect) {
        if(rect == null) {
            throw new NullPointerException();
        }
        Bag<Point2D> container = new Bag<Point2D>();
        range(root, rect, container);
        return container;
    }
    
    private void range(Node rot, RectHV rect, Bag<Point2D> acc) {
        if(rot == null)
            return;
        
        if(rot.p != null)
            if(rect.contains(rot.p))
                acc.add(rot.p);
        
        if(rot.lb != null) 
            if(rot.lb.rect != null)
                if(rect.intersects(rot.lb.rect))
                    range(rot.lb, rect, acc);   
        
        if(rot.rt != null)
            if(rot.rt.rect != null)
                if(rect.intersects(rot.rt.rect))
                    range(rot.rt, rect, acc);
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
        StdOut.println(kdtree.size());
        Point2D test = new Point2D(0.9, 0.1);
        Point2D bt = kdtree.nearest(test);
        kdtree.draw();
        

        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(.02);
        bt.draw();

        StdDraw.setPenColor(StdDraw.BLUE);
        test.draw();

    }
}
