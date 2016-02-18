import java.util.Arrays;
import java.util.ArrayList;

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
//        LineSegment[] temp = new LineSegment[10000];
        ArrayList<LineSegment> temp = new ArrayList<LineSegment>();
        Point[] local_p = points.clone();
        
        Arrays.sort(local_p);
        
        for(int i = 0; i < len - 1; i++) {
            if(local_p[i].compareTo(local_p[i + 1]) == 0)
                throw new IllegalArgumentException();                
        }
        
        for(int i = 0; i < len; i++) {
            if(local_p[i] == null)
                throw new NullPointerException();        
            for(int j = i + 1; j < len; j++) {
                for(int m = j + 1; m < len; m++) {
                    for(int n = m + 1; n < len; n++) {
                        double item1 = local_p[i].slopeTo(local_p[j]);
                        double item2 = local_p[m].slopeTo(local_p[n]);
                        double item3 = local_p[j].slopeTo(local_p[m]);
                        
                        if(item1 == item2 & item2 == item3) { 
                            temp.add(new LineSegment(local_p[i], local_p[n]));
//                            temp[index++] = new LineSegment(points[i],points[n]);
//                            StdOut.println(points[i].toString() + points[j].toString() + points[m].toString() + points[n].toString());
//                            temp[index - 1].draw();
//                            StdDraw.show();
                        }                        
                    }
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
    
    /**
     * Unit tests the Point data type.
     */
    public static void main(String[] args) {
        Point[] ptest = new Point[3];
        ptest[0] = new Point(19640, 28646);
        ptest[1] = new Point(6704, 28226);
        ptest[2] = new Point(19640, 28646);
        BruteCollinearPoints bfs = new BruteCollinearPoints(ptest);              
    }
//        // read the N points from a file
//        In in = new In(args[0]);
//        int N = in.readInt();
//        Point[] points = new Point[N];
//        
//        for (int i = 0; i < N; i++) {
//            int x = in.readInt();
//            int y = in.readInt();
//            points[i] = new Point(x, y);
//        }
//        
//
//        // draw the points
//        StdDraw.show(0);
//        StdDraw.setXscale(0, 32768);
//        StdDraw.setYscale(0, 32768);
////        for (Point p : points) {
////            p.draw();
////        }
//        BruteCollinearPoints bfs = new BruteCollinearPoints(points);
//        LineSegment[] test = bfs.segments();
//        for (int i = 0; i < test.length; i++) {
//            test[i].draw();
//            StdDraw.show();
//            StdOut.println(test[i].toString());
//        }
//        StdDraw.show();
//    } 
}



