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
