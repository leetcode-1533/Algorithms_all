import java.util.Arrays;
import java.util.Comparator;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class BruteCollinearPoints {
    private LineSegment[] segments;
    
    public BruteCollinearPoints(Point[] points) {
        // finds all line segments containing 4 points
        if(points == null)
            throw new NullPointerException();
        
        int len = points.length;
        segments = new LineSegment[len/4];
        
        Arrays.sort(points);
        
        for(int i = 0; i < len - 1; i++) {
            if(points[i].compareTo(points[i + 1]) == 0)
                throw new IllegalArgumentException();                
        }
        int index = 0;
        for(int i = 0; i < len; i++) {
            if(points[i] == null)
                throw new NullPointerException();        
            for(int j = 1; j < len; j++) {
                for(int m = 2; m < len; m++) {
                    for(int n = 3; n < len; n++) {
                        if(points[i].slopeTo(points[j]) == points[m].slopeTo(points[n])) {
                            segments[index++] = new LineSegment(points[i],points[n]);
                        }                        
                    }
                }
            }
        }
    }
    public int numberOfSegments() {
        // the number of line segments
        return segments.length;
    }
    
    public LineSegment[] segments() {
        // the line segments
        return segments;
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
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();
        Comparator<Point> test = points[0].slopeOrder();
        Arrays.sort(points,test);
        StdOut.println(points[0].slopeTo(points[3]));
    } 
}



