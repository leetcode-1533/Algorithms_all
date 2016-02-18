import java.util.Arrays;
import java.util.ArrayList;
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
        
//        LineSegment[] temp = new LineSegment[10000];
        ArrayList<LineSegment> temp = new ArrayList<LineSegment>();
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
        Point[] ext;
        
        Point[] copy_p = points.clone();
        
        for(int i = 0; i < len; i++) {
            Arrays.sort(points);
            Arrays.sort(points, copy_p[i].slopeOrder());
            
            current_slope = copy_p[i].slopeTo(points[0]);
            inc = 0;            
//            StdOut.println();
            int j = 1;
//            StdOut.printf("Point %d\n", i);
            for(j = 1; j < len; j++) {
                double t_slope = copy_p[i].slopeTo(points[j]);
//                StdOut.printf("With %d, slope: %f, loc: %s\n", j, t_slope, points[j].toString());
                if(t_slope == current_slope) {
                    inc++;
                } 
                else {
                    current_slope = copy_p[i].slopeTo(points[j]);                            
                    if(inc >= 3) {
                        // stable sort
                        if(points[j - 1].compareTo(copy_p[i]) < 0 & points[j - inc].compareTo(copy_p[i]) < 0) {
                            ext = find_ext(copy_p[i], points[j - inc]);
                        } else if(points[j - 1].compareTo(copy_p[i]) > 0 & points[j - inc].compareTo(copy_p[i]) > 0) {
                            ext = find_ext(copy_p[i], points[j - 1]);                   
                        }
                        else {
                            ext = find_ext(points[j - inc], points[j - 1]);
                        }
                        if(ext[0].slopeTo(copy_p[i]) == Double.NEGATIVE_INFINITY) {
                            temp.add(new LineSegment(ext[0], ext[1]));                       
                        }
                    }     
                    inc = 1;
                }
            }
            
            if(inc >= 3) {
                // stable sort
                if(points[j - 1].compareTo(copy_p[i]) < 0 & points[j - inc].compareTo(copy_p[i]) < 0) {
                    ext = find_ext(copy_p[i], points[j - inc]);
                } else if(points[j - 1].compareTo(copy_p[i]) > 0 & points[j - inc].compareTo(copy_p[i]) > 0) {
                    ext = find_ext(copy_p[i], points[j - 1]);                   
                }
                else {
                    ext = find_ext(points[j - inc], points[j - 1]);
                }
                if(ext[0].slopeTo(copy_p[i]) == Double.NEGATIVE_INFINITY) {
                    temp.add(new LineSegment(ext[0], ext[1]));                       
                }
            }                          
        }
        // shrink
        this.segments = temp.toArray(new LineSegment[0]);  
    }
    public int numberOfSegments() {
        // the number of line segments
        return this.segments.length;
    }
    
    public LineSegment[] segments() {
        // the line segments
        return this.segments.clone();
    }
    
    private Point[] find_ext(Point p1, Point p2) {
        Point[] ext = new Point[2];
        if(p1.compareTo(p2) < 0) {
            ext[0] = p1;
            ext[1] = p2;
        } else{
            ext[0] = p2;
            ext[1] = p1;
        }  
        return ext;
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
        StdOut.println(test[0].equals(test[1]) );
        for (int i = 0; i < test.length; i++) {
            test[i].draw();
            StdDraw.show();
            StdOut.println(test[i].toString());
        }
        StdDraw.show();
    } 
}