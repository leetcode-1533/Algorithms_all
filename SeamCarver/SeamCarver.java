//Edward Tseng
//11/09/13

import java.awt.Color;
import edu.princeton.cs.algs4.Picture;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class SeamCarver {
    private int [][] color;
    private int [][] e_matrix, vertexTo, distTo;
    private int width, height;
       
       private static void printHorizontalSeam(SeamCarver sc)
        {        
            double totalSeamEnergy = 0;

            int[] horizontalSeam = sc.findHorizontalSeam();
            for (int j = 0; j < sc.height(); j++)
            {
                for (int i = 0; i < sc.width(); i++)            
                {
                    char lMarker = ' ';
                    char rMarker = ' ';
                    if (j == horizontalSeam[i])
                    {
                        lMarker = '[';
                        rMarker = ']';
                        totalSeamEnergy += sc.energy(i, j);
                    }

                    System.out.printf("%c%6.0f%c ", lMarker, sc.energy(i, j), rMarker);
                }
                System.out.println();
            }                
            
            System.out.printf("\nTotal energy: %.0f\n\n", totalSeamEnergy);
        }


        private static void printVerticalSeam(SeamCarver sc)
        {
            double totalSeamEnergy = 0;

            int[] verticalSeam = sc.findVerticalSeam();
            for (int j = 0; j < sc.height(); j++)
            {
                for (int i = 0; i < sc.width(); i++)            
                {
                    char lMarker = ' ';
                    char rMarker = ' ';
                    if (i == verticalSeam[j])
                    {
                        lMarker = '[';
                        rMarker = ']';
                        totalSeamEnergy += sc.energy(i, j);
                    }

                    System.out.printf("%c%6.0f%c ", lMarker, sc.energy(i, j), rMarker);
                }

                System.out.println();
            }                
            
            System.out.printf("\nTotal energy: %.0f\n\n", totalSeamEnergy);
        }

        public static void main(String[] args)
        {
            Picture inputImg = new Picture("HJocean.png");
            System.out.printf("image is %d columns by %d rows\n", inputImg.width(), inputImg.height());
            //inputImg.show();        
            SeamCarver sc = new SeamCarver(inputImg);
            
            System.out.printf("Displaying horizontal seam calculated.\n");
            //printHorizontalSeam(sc);
            
            System.out.printf("Displaying vertical seam calculated.\n");
            //printVerticalSeam(sc);
            

            //Picture inputImg = new Picture(args[0]);
            int removeColumns = Integer.parseInt("100");
            int removeRows = Integer.parseInt("0"); 

            System.out.printf("image is %d columns by %d rows\n", inputImg.width(), inputImg.height());
            //SeamCarver sc = new SeamCarver(inputImg);

            Stopwatch sw = new Stopwatch();

            for (int i = 0; i < removeRows; i++) {
                int[] horizontalSeam = sc.findHorizontalSeam();
                sc.removeHorizontalSeam(horizontalSeam);
            }

            for (int i = 0; i < removeColumns; i++) {
                int[] verticalSeam = sc.findVerticalSeam();
                sc.removeVerticalSeam(verticalSeam);
            }
            Picture outputImg = sc.picture();

            System.out.printf("new image size is %d columns by %d rows\n", sc.width(), sc.height());

            System.out.println("Resizing time: " + sw.elapsedTime() + " seconds.");
            inputImg.show();
            outputImg.show();
        }
    
   public SeamCarver(Picture picture) {
       this.color = new int[picture.width()][picture.height()];
       this.e_matrix = new int[picture.width()][picture.height()];
       this.vertexTo = new int[picture.width()][picture.height()];
       this.distTo = new int[picture.width()][picture.height()];
       this.width = picture.width();
       this.height = picture.height();
       int[][] red = new int[picture.width()][picture.height()];
       int[][] green = new int[picture.width()][picture.height()];
       int[][] blue = new int[picture.width()][picture.height()];
       
       //fill first and last row of matrix with RGB data
       for (int j = 0; j < picture.width(); j++) {
           readRGB(picture, red, green, blue, j, 0);
           this.e_matrix[j][0] = 195075;
           readRGB(picture, red, green, blue, j, picture.height() - 1);
           this.e_matrix[j][picture.height() - 1] = 195075;
       }
       //fill first and last column of matrix with RGB data
       for (int i = 0; i < picture.height(); i++) {
           readRGB(picture, red, green, blue, 0, i);
           this.e_matrix[0][i] = 195075;
           readRGB(picture, red, green, blue, picture.width() - 1, i);
           this.e_matrix[picture.width() - 1][i] = 195075;
       }
       int r, g, b = 0;
       //fill RGB data and calculate energy of pixel
       for (int i = 0; i < picture.height() - 1; i++)
           for (int j = 0; j < picture.width(); j++) {
               readRGB(picture, red, green, blue, j, i + 1);
               if (i != 0 && j != 0 && i != picture.height() - 1 && j != picture.width() - 1) {
                   //x_gradient 
                   r = red[j - 1][i] - red[j + 1][i];
                   g = green[j - 1][i] - green[j + 1][i];
                   b = blue[j - 1][i] - blue[j + 1][i];
                   e_matrix[j][i] = r * r + g * g + b * b;
                   //y_gradient 
                   r = red[j][i - 1] - red[j][i + 1];
                   g = green[j][i - 1] - green[j][i + 1];
                   b = blue[j][i - 1] - blue[j][i + 1];
                   e_matrix[j][i] += r * r + g * g + b * b;
               }
           }
       
       for (int i = 0; i < picture.height(); i++)
           for (int j = 0; j < picture.width(); j++) {
               this.color[j][i] = Integer.parseInt(("00000000" + Integer.toBinaryString(red[j][i])).substring(Integer.toBinaryString(red[j][i]).length())
                        + ("00000000" + Integer.toBinaryString(green[j][i])).substring(Integer.toBinaryString(green[j][i]).length()) 
                        + ("00000000" + Integer.toBinaryString(blue[j][i])).substring(Integer.toBinaryString(blue[j][i]).length()), 2);
           }
   }
   
   private void readRGB(Picture picture, int[][] red, int[][] green, int[][] blue, int row, int col) {
       red[row][col] = picture.get(row, col).getRed();
       green[row][col] = picture.get(row, col).getGreen();
       blue[row][col] = picture.get(row, col).getBlue();
   }
   
   public Picture picture() {
       // current picture
       Picture p = new Picture(width, height);
       
       for (int i = 0; i < width; i++)
           for (int j = 0; j < height; j++)
               p.set(i, j, new Color(color[i][j]));

       return p;
   }
   
   public     int width() {
       // width of current picture
       return width;
   }
   public     int height() {
       // height of current picture
       return height;
   }
   
   public  double energy(int x, int y) {
       // energy of pixel at column x and row y
       if (x < 0 || y < 0 || x > width() - 1 || y > height() - 1)
           throw new java.lang.IndexOutOfBoundsException("x or y are out of bound");
       if (x == 0 || y == 0 || x == width() - 1 || y == height() - 1)
           return 195075;
       return e_matrix[x][y];
   }
   
   public   int[] findHorizontalSeam() {        
        //set distance for the initial column
       for (int j = 1; j < height() - 1; j++)
           distTo[0][j] = 195075;
       
       // sequence of indices for horizontal seam
       //using relaxing metholodgy
       for (int i = 0; i < width() - 1; i++)
           for (int j = 1; j < height() - 1; j++)
               relax_hor(i, j, vertexTo, distTo);
       
      //find the seam with the smallest sum of energy
       int min_energy = Integer.MAX_VALUE;
       int a[] = new int[width()];
       for (int j = 0; j < height(); j++) {
           //System.out.println("energy " + j + ": " + distTo[width() - 1][j]);
           if (min_energy > distTo[width() - 1][j]) {
               min_energy = distTo[width() - 1][j];
               a[width() - 1] = j;
           }
       }

       //store the path in an array format
       if (height() <= 2) 
           for (int i = width() - 1; i > 0; i--)
               a[i - 1] = 0;
       else
           for (int i = width() - 1; i > 0; i--)
               a[i - 1] = vertexTo[i][a[i]];
                   
       return a;
   }
   
   private void relax_hor(int x, int y, int[][] vertexTo, int[][] distTo) {
       //set value to the advance edge
       distTo[x + 1][y + 1] = distTo[x][y] + e_matrix[x + 1][y + 1];
       vertexTo[x + 1][y + 1] = y;

       //if at the starting point of a new column
       if (y == 1)
           for (int i = -1; i <= 0; i++) {
               distTo[x + 1][y + i] = distTo[x][y] + e_matrix[x + 1][y + i];
               vertexTo[x + 1][y + i] = y;
           }
       else
           //if not at starting point, revisit coordinate to see if there's another optimum path
           for (int i = -1; i <= 0; i++) {
               if (distTo[x + 1][y + i] > distTo[x][y] + e_matrix[x + 1][y + i]) {
                   distTo[x + 1][y + i] = distTo[x][y] + e_matrix[x + 1][y + i];
                   vertexTo[x + 1][y + i] = y;
               }
           }
   }
   
   private void relax_vert(int x, int y, int[][] vertexTo, int[][] distTo) {
       distTo[x + 1][y + 1] = distTo[x][y] + e_matrix[x + 1][y + 1];
       vertexTo[x + 1][y + 1] = x;
       if (x == 1)
           for (int i = -1; i <= 0; i++) {
                   distTo[x + i][y + 1] = distTo[x][y] + e_matrix[x + i][y + 1];
                   vertexTo[x + i][y + 1] = x;
           }
       else
           for (int i = -1; i <= 0; i++) {
               if (distTo[x + i][y + 1] > distTo[x][y] + e_matrix[x + i][y + 1]) {
                   distTo[x + i][y + 1] = distTo[x][y] + e_matrix[x + i][y + 1];
                   vertexTo[x + i][y + 1] = x;
               }
           }
   }
   
   public   int[] findVerticalSeam() {
       for (int j = 1; j < width() - 1; j++)
           distTo[j][0] = 195075;
      
       for (int i = 0; i < height() - 1; i++)
           for (int j = 1; j < width() - 1; j++)
               relax_vert(j, i, vertexTo, distTo);
       
       double min_energy = Integer.MAX_VALUE;         
       int a[] = new int[height()];
       for (int j = 0; j < width(); j++) 
           if (min_energy > distTo[j][height() - 1]) {
               min_energy = distTo[j][height() - 1];
               a[height() - 1] = j;
           }
           
       if (width() <= 2)
           for (int i = height() - 1; i > 0; i--) 
               a[i - 1] = 0;
       else
           for (int i = height() - 1; i > 0; i--)
               a[i - 1] = vertexTo[a[i]][i];
                       
       return a;
   }
   
   public    void removeHorizontalSeam(int[] a) {
       // remove horizontal seam from picture
       if (a.length != width() || width() <= 1)
           throw new java.lang.IndexOutOfBoundsException("array length exceeds the number of horizontal pixels or width <= 1");
       for (int i = 0; i < a.length - 1; i++)
           if (a[i] - a[i + 1] > 1 || a[i] - a[i + 1] < -1)
               throw new java.lang.IndexOutOfBoundsException("invalid seam - pixels do not line up");
       
       //stitch images together
       for (int i = 0; i < width(); i++) {
           System.arraycopy(color[i], a[i] + 1, color[i], a[i], height() - a[i] - 1);
           System.arraycopy(e_matrix[i], a[i] + 1, e_matrix[i], a[i], height() - a[i] - 1);
       }
           
       //re-calculating energy matrix
       int r, g, b;
       String s1, s2;
       for (int j = 1; j < width() - 1; j++) 
           for (int i = -1; i < 1; i++) {
               if (a[j] + i < 1 || a[j] + i >= height() - 2)
                   continue;
               //convert integer that contain rgb into binary, and extracting individual r/g/b from binary data
               s1 = ("000000000000000000000000" 
                       + Integer.toBinaryString(color[j][a[j] + i - 1])).substring(Integer.toBinaryString(color[j][a[j] + i - 1]).length());
               s2 = ("000000000000000000000000" 
                       + Integer.toBinaryString(color[j][a[j] + i + 1])).substring(Integer.toBinaryString(color[j][a[j] + i + 1]).length());
               r = Integer.parseInt(s1.substring(0, 8), 2) - Integer.parseInt(s2.substring(0, 8), 2);
               g = Integer.parseInt(s1.substring(8, 16), 2) - Integer.parseInt(s2.substring(8, 16), 2);
               b = Integer.parseInt(s1.substring(16, 24), 2) - Integer.parseInt(s2.substring(16, 24), 2);
               this.e_matrix[j][a[j] + i] = r * r + g * g + b * b;  
               
               s1 = ("000000000000000000000000" 
                       + Integer.toBinaryString(color[j - 1][a[j] + i])).substring(Integer.toBinaryString(color[j - 1][a[j] + i]).length());
               s2 = ("000000000000000000000000" 
                       + Integer.toBinaryString(color[j + 1][a[j] + i + 1])).substring(Integer.toBinaryString(color[j + 1][a[j] + i + 1]).length());
               r = Integer.parseInt(s1.substring(0, 8), 2) - Integer.parseInt(s2.substring(0, 8), 2);
               g = Integer.parseInt(s1.substring(8, 16), 2) - Integer.parseInt(s2.substring(8, 16), 2);
               b = Integer.parseInt(s1.substring(16, 24), 2) - Integer.parseInt(s2.substring(16, 24), 2);
               this.e_matrix[j][a[j] + i] += r * r + g * g + b * b;  
           }
       this.height -= 1;
   }
   
   public    void removeVerticalSeam(int[] a) {
       // remove vertical seam from picture
       if (a.length != height() || height() <= 1)
           throw new java.lang.IndexOutOfBoundsException("array length exceeds the number of vertical pixels or height <= 1");
       for (int i = 0; i < a.length - 1; i++)
           if (a[i] - a[i + 1] > 1 || a[i] - a[i + 1] < -1)
               throw new java.lang.IndexOutOfBoundsException("invalid seam - pixels do not line up");
       
       for (int j = 0; j < height(); j++)
           for (int i = a[j]; i < width() - 1; i++) {
               color[i][j] = color[i+1][j];
               this.e_matrix[i][j] = this.e_matrix[i+1][j];
           }
       
       String s1, s2;
       int r, g, b;
       for (int j = 1; j < height() - 1; j++) 
           for (int i = -1; i < 1; i++) {
               if (a[j] + i < 1 || a[j] + i >= width() - 2)
                   continue;
               
               s1 = ("000000000000000000000000" 
                       + Integer.toBinaryString(color[a[j] + i - 1][j])).substring(Integer.toBinaryString(color[a[j] + i - 1][j]).length());
               s2 = ("000000000000000000000000" 
                       + Integer.toBinaryString(color[a[j] + i + 1][j])).substring(Integer.toBinaryString(color[a[j] + i + 1][j]).length());
                
               r = Integer.parseInt(s1.substring(0, 8), 2) - Integer.parseInt(s2.substring(0, 8), 2);
               g = Integer.parseInt(s1.substring(8, 16), 2) - Integer.parseInt(s2.substring(8, 16), 2);
               b = Integer.parseInt(s1.substring(16, 24), 2) - Integer.parseInt(s2.substring(16, 24), 2);

               this.e_matrix[a[j] + i][j] = r * r + g * g + b * b;
               
               s1 = ("000000000000000000000000" 
                       + Integer.toBinaryString(color[a[j] + i][j - 1])).substring(Integer.toBinaryString(color[a[j] + i][j - 1]).length());
               s2 = ("000000000000000000000000" 
                       + Integer.toBinaryString(color[a[j] + i][j + 1])).substring(Integer.toBinaryString(color[a[j] + i][j + 1]).length());
                
               r = Integer.parseInt(s1.substring(0, 8), 2) - Integer.parseInt(s2.substring(0, 8), 2);
               g = Integer.parseInt(s1.substring(8, 16), 2) - Integer.parseInt(s2.substring(8, 16), 2);
               b = Integer.parseInt(s1.substring(16, 24), 2) - Integer.parseInt(s2.substring(16, 24), 2);
               this.e_matrix[a[j] + i][j] += r * r + g * g + b * b;  
           }
       this.width -= 1;
   }
   
}
