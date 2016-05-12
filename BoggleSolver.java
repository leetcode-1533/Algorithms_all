
import edu.princeton.cs.algs4.StdOut;
import java.util.HashSet;
public class BoggleSolver {

    private int size;

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

    private int[] index2ij(int index) {
        int i = index / size;
        int j = index - i * size;
        return new int[] {i, j};
    }

    public BoggleSolver(String[] dictionary) {
        size = 4;

    }



    public static void main(String[] args) {
        BoggleSolver test = new BoggleSolver(null);
        int num = 10;
        StdOut.println(test.index2ij(num)[0]);
        StdOut.println(test.index2ij(num)[1]);

    }
}
