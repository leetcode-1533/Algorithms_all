import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stack;

 

public class PointSET {
    
    private SET<Point2D> container;
    public PointSET() {
        container = new SET<Point2D>();
    }
    
    public boolean isEmpty() {
        return container.isEmpty();
    }
    
    public int size() {
        return container.size();      
    }
    
    public void draw() {
        for(Point2D item : container) {
            item.draw();
        }
    }
    
    public void insert(Point2D p) {
        container.add(p);
    }
    
    public boolean containers(Point2D p) {
        return container.contains(p);     
    }
    
    public Point2D nearest(Point2D p) {
        Point2D ans = container.min();
        double mindist = ans.distanceSquaredTo(p);

        for(Point2D item : container) {
            if(item.distanceSquaredTo(p) < mindist)
                ans = item;           
        }
        return ans;
        
    }
    
    public Iterable<Point2D> range(RectHV rect) {
        Stack<Point2D> con = new Stack<Point2D>();
        for(Point2D item : container) {
            if(rect.contains(item))
                con.push(item);
        }
        return con;      
    }
    
    public static void main(String[] args) {
        StdOut.println("Hello Ass5");
        
    }

}
