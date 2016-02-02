import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdOut;

public class Percolation {
    private WeightedQuickUnionUF container; // the container
    private int size; // the global size
    private boolean[] isopen; // 0 ~ ( N - 1)

    // No checking, use with cares
    private int center(int i, int j) {
        return (i - 1) * size + j - 1;
    }

    private int up(int i, int j) {
        return (i - 2) * size + j - 1;
    }

    private int down(int i, int j) {
        return i * size + j - 1;
    }

    private int left(int i, int j) {
        return (i - 1) * size + j - 2;
    }

    private int right(int i, int j) {
        return (i - 1) * size + j;
    }

    public Percolation(int N) {
        // The constructor
        if(N <= 0){
            throw new java.lang.IllegalArgumentException();
        }

        size = N;
        isopen = new boolean[size*size];

        container = new WeightedQuickUnionUF(N*N);		
    }

    public void open(int i, int j) {
        if (i <= 0 || i > size || j <= 0 || j > size) {
            throw new java.lang.IndexOutOfBoundsException();
        }

        isopen[center(i, j)] = true;

        if (i > 1 && isOpen(i - 1, j)) { // Have above
            container.union( up(i, j), center(i, j));
        }

        if(i < size && isOpen(i + 1, j)) { // Have below
            container.union(down( i, j), center(i, j));
        }

        if(j > 1 && isOpen(i, j - 1)) { // Have left
            container.union( left(i, j), center(i, j));
        }

        if(j < size && isOpen(i, j + 1)) { // Have right
            container.union( right(i, j), center(i, j));
        }
    }

    public boolean isOpen(int i, int j) {
        if(i <= 0 || i > size || j <= 0 || j > size) {
            throw new java.lang.IndexOutOfBoundsException();
        }

        return isopen[center(i, j)];
    }

    public boolean isFull(int i, int j) {
        if(i <= 0 || i > size || j <= 0 || j > size) {
            throw new java.lang.IndexOutOfBoundsException();
        }

        if(isOpen(i, j) == false){
            return false;
        }

        int curid = container.find(center(i, j));

        for(int ind = 1; ind <= size; ind ++){ 	
            if(isOpen( 1, ind) == true){
                int targetid = container.find(center(1, ind));

                if(curid == targetid){ // Return true if connected, else continue
                    return true;
                }
            }
        }
        return false; // Not connected
    }

    public boolean percolates() {		
        for (int ind = 1; ind <= size; ind++) {
            if (isOpen(1, ind) == true){
                int eid = container.find(center( 1, ind));

                for (int inn = 1; inn <= size; inn++) {
                    if (isOpen(size, inn) == true) {
                        if (eid == container.find(center(size, inn))) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        StdOut.println("Hello Algorithm");
        Percolation test = new Percolation(4);	

        test.open(1, 1);
        test.open(2, 1);
        test.open(2, 2);

        StdOut.println(test.isFull(2, 2));
    }
}
