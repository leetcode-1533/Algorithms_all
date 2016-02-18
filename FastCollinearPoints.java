import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

public class FastCollinearPoints {
    private LineSegment[] segments;
    
    public FastCollinearPoints(Point[] points) {
        // finds all line segments containing 4 points
        if(points == null)
            throw new NullPointerException();
        
        int len = points.length;
        LineSegment[] temp = new LineSegment[10000];
        
        Arrays.sort(points);
        
//        for (Point p : points) {
//            p.draw();
//            StdDraw.show();
//        }
        
        for(int i = 0; i < len - 1; i++) {
            if(points[i].compareTo(points[i + 1]) == 0)
                throw new IllegalArgumentException();                
        }
        
        int index = 0;        
        double current_slope;
        int inc;
        
        for(int i = 0; i < len; i++) {
            Arrays.sort(points, points[i].slopeOrder());
            
            current_slope = points[i].slopeTo(points[0]);
            inc = 0;            
            StdOut.println();
            StdOut.printf("Point %d\n", i);
            for(int j = 0; j < len; j++) {
                double t_slope = points[i].slopeTo(points[j]);
                StdOut.printf("With %d, slope: %f\n", j, t_slope);
                if(t_slope == current_slope) {
                    inc++;
                } 
                else {
                    current_slope = points[i].slopeTo(points[j]);         
                    
                    if(inc >= 4) {
                        // stable sort
                        if(points[j - 1].compareTo(points[i]) < 0 & points[j - inc].compareTo(points[i]) < 0) {
                            temp[index++] = new LineSegment(points[i], points[j - inc]);
                        } else if(points[j - 1].compareTo(points[i]) > 0 & points[j - inc].compareTo(points[i]) > 0) {
                            temp[index++] = new LineSegment(points[i], points[j - 1]);                   
                        }
                        else {
                            temp[index++] = new LineSegment(points[j - inc], points[j - 1]);
                        }                           
                    }     
                    inc = 1;
                }
            }
        }
        // shrink
        this.segments = new LineSegment[index];
        for(int i = 0; i < index; i++) {
            this.segments[i] = temp[i];
        }    
    }
    public int numberOfSegments() {
        // the number of line segments
        return this.segments.length;
    }
    
    public LineSegment[] segments() {
        // the line segments
        return this.segments;
    }
    
    /**
     * Unit tests the Point data type.
     */
    public static void main(String[] args) {
        // read the N points from a file
        In in = new In(args[0]);
        int N = in.readInt();
        Point[] points = new Point[N];
        
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.show(0);
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
//        for (Point p : points) {
//            p.draw();
//        }
        FastCollinearPoints fs = new FastCollinearPoints(points);
        LineSegment[] test = fs.segments();
        for (int i = 0; i < test.length; i++) {
            test[i].draw();
            StdDraw.show();
        }
        StdDraw.show();
    } 
}