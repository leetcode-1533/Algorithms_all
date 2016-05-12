import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdOut;
import java.util.HashSet;
import java.util.ArrayList;

public class BoggleSolver {

    private int size;
    private ArrayList<Bag<Integer>> dir;

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
        int i = index / size + 1;
        int j = index - (i - 1) * size + 1;
        return new int[] {i, j};
    }

    private void dir_init() {
        int range = center(size, size);
        dir = new ArrayList<>(range);
        for (int index = 0; index < range; index++) {
            Bag<Integer> cur_dir = new Bag<>();
            int[] ij = index2ij(index);
            int i = ij[0];
            int j = ij[1];

            if(i > 1)
                cur_dir.add(up(i, j));
            if(i < size)
                cur_dir.add(down(i, j));
            if(j > 1)
                cur_dir.add(left(i, j));
            if(j < size)
                cur_dir.add(right(i, j));

            dir.add(cur_dir);
        }
    }

    public BoggleSolver(String[] dictionary) {
        size = 4;
        dir_init();
    }

    public Iterable<String> getAllValidWords(BoggleBoard board) {
        HashSet<String> container = new HashSet<>();

        return container;
    }

    public static void main(String[] args) {
        BoggleSolver test = new BoggleSolver(null);
        int num = 10;
        StdOut.println(test.index2ij(num)[0]);
        StdOut.println(test.index2ij(num)[1]);
    }
}
