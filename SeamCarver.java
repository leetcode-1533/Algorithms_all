import java.awt.Color;
import edu.princeton.cs.algs4.Picture;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class SeamCarver {
    private Picture pic;
    private int[][] energy, verticTo, dist;
    
    public SeamCarver(Picture picture) {
        pic = new Picture(picture);
        energy = new int[pic.height()][pic.width()];
        verticTo = new int[pic.height()][pic.width()];
        dist = new int[pic.height()][pic.width()];
        
        calEnergy();
             
    }
    
    private int[] adj(int x) {
        // for point at column x, give it adjacency neighbors at next row
        // Constrained by width
        if(x == 0) {
            return new int[] {0, 1};
        } else if(x == pic.width() - 1) {
            return new int[] {pic.width() - 2, pic.width() - 1};
        } else {
            return new int[] { x - 1, x, x + 1};
        }      
    }
    
    private void refresh(int[] vFrom, int[] vTo) {
        // vFrom[0] for row, vFrom[1] for column
        if(dist[vFrom[0]][vFrom[1]] + energy[vTo[0]][vTo[1]] < dist[vTo[0]][vTo[1]]) {
            verticTo[vTo[0]][vTo[1]] = vFrom[1];  // record the above row column
            dist[vTo[0]][vTo[1]] = dist[vFrom[0]][vFrom[1]] + energy[vTo[0]][vTo[1]];
        }
    }
    
    public double energy(int x, int y) {
        // at column x, row y
        if(x == 0 || x == pic.width() - 1  || y == 0 || y == pic.height() - 1)
            return 1000;
        return Math.sqrt(energy[y][x]); // energy per row is picture per row
    }
    
    private void calEnergy() {
        for(int i = 1; i < pic.height() - 1; i++) { // Iterator for rows
            for(int j = 1; j < pic.width() - 1; j++) { // Iterator for Columns
                energy[i][j] = centerDiff(j, i);
            }
        }
    }
        
    private int centerDiff(int col, int row) {
        Color above = pic.get(col, row - 1);
        Color below = pic.get(col, row + 1);      
        int bdiff = above.getBlue() - below.getBlue();
        int rdiff = above.getRed() - below.getRed();
        int gdiff = above.getGreen() - below.getGreen();
        int vertDiff = bdiff * bdiff + rdiff * rdiff + gdiff * gdiff;

        above = pic.get(col - 1, row);
        below = pic.get(col + 1, row);    
        bdiff = above.getBlue() - below.getBlue();
        rdiff = above.getRed() - below.getRed();
        gdiff = above.getGreen() - below.getGreen();
        int horiDiff = bdiff * bdiff + rdiff * rdiff + gdiff * gdiff;
        
        return vertDiff + horiDiff;        
    }
    
    public int width() {
        return pic.width();
    }
    
    public int height() {
        return pic.height();
    }
 
}
