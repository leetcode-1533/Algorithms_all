import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;


public class Board {
    public int[][] board;
    
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
    
    public int hamming() {
        // return the number of blocks out of position
        return 0;
    }
    
    public int manhattan() {
        // the sum of the Manhattan distances between the blocks and their goal positions.
        return 0;
    }
    
    public boolean isGoal() {
        // reached?
        for(int i = 0; i < dimension() - 1; i++) {
            for(int j = 0; j< dimension(); j++) {
                if(board[i][j] != i * dimension() + j + 1)
                    return false;
            }
        }
        
        for(int j = 0; j < dimension() - 1; j++) {
            if(board[dimension() - 1][j] != (dimension() - 1) * dimension() + j + 1)
                return false;
        }
        return true;
    }
    
    public Board twin() {
        // a board that is obtained by exchanging any pair of blocks
        
        int i_loc = 0;
        int[] loc = new int[2];
        int[][] twincopy = new int[dimension()][dimension()];
        for(int i = 0; i < dimension(); i++) {
            for(int j = 0; j < dimension(); j++) {
                if(board[i][j] != 0 && i_loc < 2) {
                    loc[i_loc] = j; // guaranteed in the first row
                    i_loc++;
                }
                twincopy[i][j] = board[i][j];
            }                          
        }
        int temp = twincopy[0][loc[0]];
        twincopy[0][loc[0]] = twincopy[0][loc[1]];
        twincopy[0][loc[1]] = temp;
        return new Board(twincopy);
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
        // string representation
        String print= Integer.toString(dimension());
        
        print += "\n";
        for(int i = 0; i < dimension(); i++) {
            print += " ";
            for(int j = 0; j < dimension(); j++) {
                print += Integer.toString(board[i][j]);
                print += " ";
            }
            print += "\n";
        }
        return print;
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
        
        StdOut.println("Constructed Board:");
        StdOut.println(initial);
        
        StdOut.println("Its twins");
        StdOut.println(initial.twin());
        
        StdOut.println("Its neighbors");
        Iterable<Board> test = initial.neighbors();
        for(Board item : test) {
            StdOut.println(item.toString());
        }
//        StdOut.println(initial.isGoal());
//        StdOut.println(initial.equals(initial));
    }
}
