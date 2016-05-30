import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import java.lang.StringBuilder;


public class Board {
    private int[][] board;
    
    public Board(int[][] blocks) {
        // The constructor
        //  clone is a shallow copy, kind of tricky :)
        board = blocks.clone();        
        for(int i = 0; i < blocks.length; i++) 
            board[i] = blocks[i].clone();
    }
    
    public int dimension() {
        // board Dimension N
        return board.length;
    }
    
    private int ij2index(int i, int j) {
        return (i * dimension() + j + 1);
    }
    
    private int element_manhattan(int i, int j, int index) {
        int ori_i = (index - 1) / dimension();
        int ori_j = index - ori_i * dimension() - 1;
//        StdOut.printf("i %d, j %d\n", ori_i, ori_j);
        int idistance = Math.abs(i - ori_i);
        int jdistance = Math.abs(j - ori_j);
        return idistance + jdistance;
    }
    
    public int hamming() {
        // return the number of blocks out of position
        int miss = 0;
        for(int i = 0; i < dimension(); i++) {
            for(int j = 0; j < dimension(); j++) {
                if(board[i][j] != 0 && board[i][j] != ij2index(i, j))
                    miss++;
            }
        }
        
        return miss;
    }
    
    public int manhattan() {
        // the sum of the Manhattan distances between the blocks and their goal positions.
        int miss = 0;
        for(int i = 0; i < dimension(); i++) {
            for(int j = 0; j < dimension(); j++) {
                if(board[i][j] != 0 && board[i][j] != ij2index(i, j)) {
//                    StdOut.println("Manhattan on i:" + i + " j: " + j + " Value: " + board[i][j] + " distance: " + element_manhattan(i, j, board[i][j]));
                    miss += element_manhattan(i, j, board[i][j]);       
//                    StdOut.printf("element %d, distance: %d \n", board[i][j], element_manhattan(i, j, board[i][j]));
                }
            }
        }
        
        return miss;        
    }
    
    public boolean isGoal() {
        // reached?
        
        // omit the last raw
        for(int i = 0; i < dimension() - 1; i++) {
            for(int j = 0; j < dimension(); j++) {
                if(board[i][j] != ij2index(i, j))
                    return false;
            }
        }
        
        // omit the last element
        for(int j = 0; j < dimension() - 1; j++) {
            if(board[dimension() - 1][j] != ij2index((dimension() - 1), j))
                return false;
        }
        return true;
    }
    
    public Board twin() {
        // a board that is obtained by exchanging any pair of blocks
        
        int rec = 0;
        int[][] locs = new int[2][2];
        
//        int[] loc = new int[2];
//        int[][] twincopy = new int[dimension()][dimension()];
        outer:
        for(int i = 0; i < dimension(); i++) {
            for(int j = 0; j < dimension(); j++) {
                if(board[i][j] != 0 && rec < 2) {
                    locs[rec][0] = i;
                    locs[rec][1] = j;
                    rec++;
                }
                if(rec == 2) {
                    break outer;
                }
            }                          
        }
        return new Board(exchelement(locs[0], locs[1], board));
//        int temp = twincopy[0][loc[0]];
//        twincopy[0][loc[0]] = twincopy[0][loc[1]];
//        twincopy[0][loc[1]] = temp;
//        return new Board(twincopy);
    }
    
    public boolean equals(Object y) {
        // check equality
        // not very elegant
        if(y == this) return true;
        if(y == null) return false;
        if(y.getClass() != this.getClass()) {
            return false;
        }
        
        Board that = (Board) y;
        if(this.dimension() != that.dimension()) return false;
        
        for(int i = 0; i < dimension(); i++) {
            for(int j = 0; j < dimension(); j++) {
                if(this.board[i][j] != that.board[i][j]) 
                    return false;
            }
        }
        return true;     
    }
  
    public Iterable<Board> neighbors() {
        // return iterator: all neighbors boards
        Stack<Board> stboard = new Stack<Board>();
        
        // search for 0
        int i = 0;
        int j = 0;
        outer:
        for(i = 0; i < dimension(); i++) {
            for(j = 0; j < dimension(); j++) {
                if(board[i][j] == 0)
                    break outer;
            }
        }
        
        int [][] tempboard;
        if(i < (dimension() - 1)){
            // have below
            tempboard = exchelement(new int[]{i, j}, new int[]{i + 1, j}, board);
            stboard.push(new Board(tempboard));
        }
        
        if(i > 0){
            // have above 
            tempboard = exchelement(new int[]{i, j}, new int[]{i - 1, j}, board);
            stboard.push(new Board(tempboard));
        }
        
        if(j < (dimension() - 1)){
            // have right
            tempboard = exchelement(new int[]{i, j}, new int[]{i, j + 1}, board);
            stboard.push(new Board(tempboard));
        }
        
        if(j > 0){
            // have left 
            tempboard = exchelement(new int[]{i, j}, new int[]{i, j - 1}, board);
            stboard.push(new Board(tempboard));
        }        
        
        return stboard;
    }
    
    private int[][] exchelement(int[] fir, int[] sec, int[][] copyboard) {
        // exchange element i with j on board, and return a copy of which
        
        int[][] tempboard = copyboard.clone();
        for(int i = 0; i < dimension(); i++) {
            tempboard[i] = copyboard[i].clone();
        }
        int temp = tempboard[fir[0]][fir[1]];
        tempboard[fir[0]][fir[1]] = tempboard[sec[0]][sec[1]];
        tempboard[sec[0]][sec[1]] = temp;
        return tempboard;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(dimension() + "\n");
        for (int i = 0; i < dimension(); i++) {
            for (int j = 0; j < dimension(); j++) {
                s.append(String.format("%2d ", board[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }
    
    public static void main(String[] args) {
     // create initial board from file 
        In in = new In(args[0]);
        int N = in.readInt(); 
        int[][] blocks = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                blocks[i][j] = in.readInt(); 
        Board initial = new Board(blocks);
        Board twin = initial.twin();
        
        StdOut.println("Equals");
        StdOut.println("To twins: "+ initial.equals(twin));
//        StdOut.println("itself" + initial.equals(initial));
        
        StdOut.println("Mantest");
        StdOut.println(initial.manhattan());
        
        StdOut.printf("Hamming: %d\n", initial.hamming());
        
        StdOut.println("Constructed Board: ");
        StdOut.println(initial);
        
        StdOut.println("Is goal?");
        StdOut.println(initial.isGoal());
        
        StdOut.println("Its twins");
        StdOut.println(initial.twin());
        
        StdOut.println("Its neighbors");
        Iterable<Board> test = initial.neighbors();
        for(Board item : test) {
            StdOut.println(item.toString());
        }
    }
}
