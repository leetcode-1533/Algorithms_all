import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    
    private double[] results;	
    	
	public PercolationStats(int N, int T) {     // perform T independent experiments on an N-by-N grid
		if (N <= 0 || T <= 0) {
			throw new java.lang.IllegalArgumentException();
		}
		
		results = new double[T];
		int squ = N * N;
		
		for (int i = 0; i < T; i++) {
			Percolation perc = new Percolation(N);
			
			int opened = 0;
			while (!perc.percolates()) {		
				int[] xy = inverse(StdRandom.uniform(squ), N); 
				if (!perc.isOpen(xy[0], xy[1])) {
					perc.open(xy[0], xy[1]);
					opened++;
				}
			}
			
			results[i] = (float) opened / squ;
		}
	}
	
	private static int[] inverse(int index, int size) {
	    int[] result = {index/size + 1, index % size + 1};
	    return result;
	}
	
	public double mean() {                     // sample mean of percolation threshold
		return StdStats.mean(results);
	}
	
	public double stddev() {
		// sample standard deviation of percolation threshold
		return StdStats.stddev(results);
	}
	
	public double confidenceLo() {
	   // low  endpoint of 95% confidence interval
	   return mean() - 1.96 * stddev() / Math.sqrt(results.length);
	}
   
	public double confidenceHi() {
		// high endpoint of 95% confidence interval
		return mean() + 1.96 * stddev() / Math.sqrt(results.length);
	}

	public static void main(String[] args) {
		// test client (described below)	
		int firstArg = 0;
		int secondArg = 0;
		
		if (args.length > 0) {
		    try {
		        firstArg = Integer.parseInt(args[0]);
		    } catch (NumberFormatException e) {
		        System.err.println("Argument" + args[0] + " must be an integer.");
		        System.exit(1);
		    }
		    try {
		    	secondArg = Integer.parseInt(args[1]);
		    } catch (NumberFormatException e) {
		        System.err.println("Argument" + args[1] + " must be an integer.");
		        System.exit(1);
		    }
		}
		
		PercolationStats test = new PercolationStats(firstArg, secondArg);
		StdOut.printf("mean = %f\n", test.mean());
		StdOut.printf("stddev = %f\n", test.stddev());
		StdOut.printf("95%% confidence interval = %f, %f", test.confidenceLo(), test.confidenceHi());
	}
}
