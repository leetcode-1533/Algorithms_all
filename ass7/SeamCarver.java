import java.awt.Color;

import edu.princeton.cs.algs4.Picture;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.ResizingArrayStack;

public class SeamCarver {
    private int height;
    private int width;
    private double[][] P_energy;
    private int[][] pic;
    private boolean transposed;

    
    private void initEnergy() {
        for(int i = 0; i < height; i++) { // Iterator for rows
            for(int j = 0; j < width; j++) { // Iterator for Columns
                P_energy[i][j] = centerDiff(j, i);
            }
        }
    }
        
    private double centerDiff(int col, int row) {
        int width = pic[0].length;
        int height = pic.length;
                
        if(col == 0 || col == width - 1  || row == 0 || row == height - 1)
            return 1000;
        
        Color above = new Color(pic[row - 1][col]);
        Color below = new Color(pic[row + 1][col]);      
        int bdiff = above.getBlue() - below.getBlue();
        int rdiff = above.getRed() - below.getRed();
        int gdiff = above.getGreen() - below.getGreen();
        int vertDiff = bdiff * bdiff + rdiff * rdiff + gdiff * gdiff;

        above = new Color(pic[row][col - 1]);
        below = new Color(pic[row][col + 1]);    
        bdiff = above.getBlue() - below.getBlue();
        rdiff = above.getRed() - below.getRed();
        gdiff = above.getGreen() - below.getGreen();
        int horiDiff = bdiff * bdiff + rdiff * rdiff + gdiff * gdiff;
        
        return Math.sqrt(vertDiff + horiDiff);        
    }
    
    public SeamCarver(Picture picture) {
        if(picture == null)
            throw new NullPointerException();
        
        height = picture.height();
        width = picture.width();
        pic = new int[height][width];    
        P_energy = new double[height][width];
        
        for(int col = 0; col < picture.width(); col++) {
            for(int row = 0; row < picture.height(); row++) {
                pic[row][col] = picture.get(col, row).getRGB();
            }
        }
        
        initEnergy(); 
        transposed = false;
    }
    
    private void transpose() {
        int height = P_energy.length;
        int width = P_energy[0].length;
        
        double[][] temp_energy = new double[width][height];
        int[][] temp_pic = new int[width][height];

        for(int i = 0; i < P_energy.length; i++) {
            for(int j = 0; j < P_energy[0].length; j++) {
                temp_energy[j][i] = P_energy[i][j];              
            }       
        }
        for(int i = 0; i < pic.length; i++) {
            for(int j = 0; j < pic[0].length; j++) {
                temp_pic[j][i] = pic[i][j];              
            }       
        } 
        
        P_energy = temp_energy;
        pic = temp_pic;          
    }
    
    public int[] findVerticalSeam() {
        // by default vertical
        if(transposed) {
            transpose();
            transposed = false;
        }
        return findSeam();
    }
    
    public int[] findHorizontalSeam() {
        if(!transposed) {
            transpose();
            transposed = true;
        }
        return findSeam();
    }
    
    private int[] findSeam() {  
        int height = P_energy.length;
        int width = P_energy[0].length;
        
        double[][] dist = new double[height][width];
        int[][] verticTo = new int[height][width];
        
        for(int i = 1; i < height; i++ ) {
            for(int j = 0; j < width; j++) {
                dist[i][j] = -1;
            }
        }
        
        for(int j = 0; j < width; j++) {
            dist[0][j] = P_energy[0][j];
        }
        
        for(int j = 0; j < width; j++) {
            verticTo[0][j] = 0;
        }
        
        vertSP(dist, verticTo);
        
        ResizingArrayStack<Integer> rev_route = new ResizingArrayStack<Integer>();
        int endPoint = minIndex(dist[height - 1]);
        rev_route.push(endPoint);

        int next = verticTo[height - 1][endPoint];

        for(int i = height - 2; i >= 0; i--) {
            rev_route.push(next);
            next = verticTo[i][next];
        }
        
        int[] route = new int[height];
        for(int i = 0; i < height; i++) 
            route[i] = rev_route.pop();
         
        return route;         
    }
    
    private int minIndex(double[] array) {
        double min = array[0];
        int loc = 0;
        
        for(int i = 1; i < array.length; i++) {
            if(array[i] < min) {
                loc = i;
                min = array[i];            
            }        
        }
        return loc;
    }
    
    private void vertSP(double[][] dist, int[][] verticTo) {
        for(int i = 0; i < P_energy.length - 1; i++) { // for next row
            for(int j = 0; j < P_energy[0].length; j++) {
                int[] curPoint = new int[] {i, j};
                int[] nextPs = adj(j);
                for(int nP : nextPs) {
                    refresh(curPoint, new int[] {i + 1, nP}, dist, verticTo);
                }
            }
        }
        
    }
    
    private int[] adj(int x) {
        // for point at column x, give it adjacency neighbors at next row
        // Constrained by width columns<-> width, 
        if(P_energy[0].length == 1)
            return new int[] {0};
        if(x == 0) {
            return new int[] {0, 1};
        } else if(x == P_energy[0].length - 1) {
            return new int[] {P_energy[0].length - 2, P_energy[0].length - 1};
        } else {
            return new int[] { x - 1, x, x + 1};
        }      
    }
    
    private void refresh(int[] vFrom, int[] vTo, double[][] dist, int[][] verticTo) {
        // vFrom[0] for row, vFrom[1] for column
        if(dist[vFrom[0]][vFrom[1]] + P_energy[vTo[0]][vTo[1]] < dist[vTo[0]][vTo[1]] || dist[vTo[0]][vTo[1]] < 0) {
            verticTo[vTo[0]][vTo[1]] = vFrom[1];  // record the above row column
            dist[vTo[0]][vTo[1]] = dist[vFrom[0]][vFrom[1]] + P_energy[vTo[0]][vTo[1]];
        }
    }
    
    private void removeSeam(int[] seam) {
        if(seam == null)
            throw new NullPointerException();
        if(seam.length != pic.length)
            throw new IllegalArgumentException();
        
        int oldseam = seam[0];
        int afterwidth = pic[0].length - 1;
//        StdOut.println(afterwidth);
        
        for(int i = 0; i < pic.length; i++) {
            if(seam[i] < 0 || seam[i] >= afterwidth + 1) {
                throw new IllegalArgumentException();
            }
            if(Math.abs(seam[i] - oldseam) > 1)
                throw new IllegalArgumentException();
            else
                oldseam = seam[i];

            
            int[] temp = new int[afterwidth];
            for(int j = 0; j < afterwidth + 1; j++) {
                if(j < seam[i])
                    temp[j] = pic[i][j];
                else if(j > seam[i])
                    temp[j - 1] = pic[i][j];
            }
            pic[i] = temp;
        } 
        
        for(int i = 0; i < P_energy.length; i++) {
            double[] temp = new double[afterwidth];
            for(int j = 0; j < afterwidth + 1; j++) {
                if(j < seam[i] - 1)
                    temp[j] = P_energy[i][j];
                else if(j == seam[i] - 1)
                    temp[j] = centerDiff(j, i);
                else if(j == seam[i] + 1)
                    temp[j - 1] = centerDiff(j - 1, i);
                else if(j > seam[i])
                    temp[j - 1] = P_energy[i][j];
            }
            P_energy[i] = temp;
        } 
        

    }
    
    public void removeVerticalSeam(int[] seam) {
        if(transposed) {
            transpose();
            transposed = false;
        }
        
        if(width <= 1)
            throw new IllegalArgumentException();      
        width--;

        removeSeam(seam);
    }
    
    public void removeHorizontalSeam(int[] seam) {
        if(!transposed) {
            transpose();
            transposed = true;
        }
        
        if(height <= 1)
            throw new IllegalArgumentException();    
        height--;
        
        removeSeam(seam);
    }
    
    public double energy(int x, int y) {
        // at column x, row y
        if(x >= width || x < 0 || y >= height || y < 0)
            throw new IndexOutOfBoundsException();
        if(transposed) {
            transpose();
            transposed = false;
        }
        return P_energy[y][x]; // energy per row is picture per row
    }
    
    public int width() {
        return width;
    }
    
    public int height() {
        return height;
    }
    
    public Picture picture() {
        if(transposed) {
            transpose();
            transposed = false;
        }
        
        Picture temp = new Picture(width, height);
        for(int col = 0; col < width; col++) {
            for(int row = 0; row < height; row++) {
                temp.set(col, row, new Color(pic[row][col]));
            }
        }
        
        return temp;
    }
    
    public static void main(String[] args) {
//        Picture picture = new Picture(args[0]);
//        StdOut.printf("image is %d pixels wide by %d pixels high.\n", picture.width(), picture.height());
//        
//        SeamCarver sc = new SeamCarver(picture);
//        
//        for (int j = 0; j < sc.height(); j++) {
//            for (int i = 0; i < sc.width(); i++)
//                StdOut.printf("%9.0f ", sc.energy(i, j));
//            StdOut.println();
//        }
//        sc.picture();
//        
//        StdOut.printf("image is %d pixels wide by %d pixels high.\n", sc.width(), sc.height());
//        sc.picture();
//        sc.removeVerticalSeam(sc.findVerticalSeam());
//        sc.removeHorizontalSeam(sc.findHorizontalSeam());
//        sc.findHorizontalSeam();
//        sc.removeVerticalSeam(sc.findVerticalSeam());
//
//        
//        StdOut.printf("image is %d pixels wide by %d pixels high.\n", sc.width(), sc.height());


//
//        
    }
}
