import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdOut;

public class Percolation {
	private WeightedQuickUnionUF container; // the container
	private int size; // the global size
	
	// No checking, use with cares
	private int center(int i, int j) {
		return (i - 1) * size + j;
	}
	
	private int up(int i, int j) {
		return (i - 2) * size + j;
	}
	
	private int down(int i, int j) {
		return i * size + j;
	}
	
	private int left(int i, int j) {
		return (i - 1) * size + j - 1;
	}
	
	private int right(int i, int j) {
		return (i - 1) * size + j + 1;
	}
	
	public Percolation(int N) {
		// The constructor
		size = N;
		
		if(N <= 0){
			throw new java.lang.IllegalArgumentException();
		}
		
		container = new WeightedQuickUnionUF(N*N);		
	}
	
	public void open(int i, int j) {
		if(i <= 0 || i > size || j <= 0 || j > size) {
			throw new java.lang.IndexOutOfBoundsException();
		}
		
		if( i > 1) { // Have above
			container.union(up(i, j), center(i, j));
		}
		
		if( i < size) { // Have below
			container.union(down(i, j), center(i, j));
		}
		
		if( j > 1) { // Have left
			container.union(left(i, j), center(i, j));
		}
		
		if( j < size) { // Have right
			container.union(right(i, j), center(i, j));
		}
	}
	
	public boolean isOpen(int i, int j) {
		if(i <= 0 || i > size || j <= 0 || j > size) {
			throw new java.lang.IndexOutOfBoundsException();
		}
		
		if( i > 1) { // Have above, checked if connected with its above
			return container.connected(up(i, j), center(i, j));
		}
		else if( j > 1) { // i==1, j>1 have left
			return container.connected(left(i, j), center(i, j));
		}
		else { // i,j = (1, 1)
			return container.connected(right(i, j),	center(i ,j));
		}
	}
	
	public boolean isFull(int i, int j) {
		if(i <= 0 || i > size || j <= 0 || j > size) {
			throw new java.lang.IndexOutOfBoundsException();
		}
		
		int curid = container.find(center(i, j));
		
		for( int ind = 1; ind <= size; ind ++){ 
			int targetid = container.find(center(1, ind));
			
			if( curid == targetid){ // Return true if connected, else continue
				return true;
			}
		}
		return false; // Not connected
	}
	
	public boolean percolates() {
		return true;		
	}
	
	public static void main(String[] args) {
		StdOut.println("Hello Algorithm");
		new Percolation(5);	
	}
}
