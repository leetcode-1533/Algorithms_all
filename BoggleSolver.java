import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.TrieSET;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.lang.StringBuilder;


public class BoggleSolver {

    private int size;
    private ArrayList<Bag<Integer>> dir;
    private TrieSET trieset;

    private int center(int i, int j) {
        return i * size + j;
    }

    private int up(int i, int j) {
        return (i - 1) * size + j;
    }

    private int down(int i, int j) {
        return (i + 1) * size + j;
    }

    private int left(int i, int j) {
        return i * size + j - 1;
    }

    private int right(int i, int j) {
        return i * size + j + 1;
    }

    private int[] index2ij(int index) {
        int i = index / size;
        int j = index - i * size;
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

            if (i > 1)
                cur_dir.add(up(i, j));
            if (i < size)
                cur_dir.add(down(i, j));
            if (j > 1)
                cur_dir.add(left(i, j));
            if (j < size)
                cur_dir.add(right(i, j));

            dir.add(cur_dir);
        }
    }

    public BoggleSolver(String[] dictionary) {
        trieset = new TrieSET();
        for (String item : dictionary)
            trieset.add(item);
    }

    public Iterable<String> getAllValidWords(BoggleBoard board) {
        size = board.rows();
//        dir_init();
        Set<String> container = new HashSet<>();

        return container;
    }

    private void dfs(boolean[] visited, StringBuilder str, Set<String> container) {

    }

    public static void main(String[] args)
    {
        In in = new In(args[0]);
        String[] dictionary = in.readAllStrings();
        BoggleSolver solver = new BoggleSolver(dictionary);
        BoggleBoard board = new BoggleBoard(args[1]);
        solver.getAllValidWords(board);
        StdOut.println(solver.index2ij(15)[1]);
//        int score = 0;
//        for (String word : solver.getAllValidWords(board))
//        {
//            StdOut.println(word);
//            score += solver.scoreOf(word);
//        }
//        StdOut.println("Score = " + score);
    }
}
