import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

public class BoggleSolver {

    private int N, M;
    private ArrayList<Bag<Integer>> dir;
    private BoggleBoard boggleboard;

    private TrieSET trieset;

//    private int center(int i, int j) {
//        return i * N + j;
//    }

    private int up(int i, int j) {
        return (i - 1) * N + j;
    }

    private int down(int i, int j) {
        return (i + 1) * N + j;
    }

    private int left(int i, int j) {
        return i * N + j - 1;
    }

    private int right(int i, int j) {
        return i * N + j + 1;
    }

    private int downright(int i, int j) {
        return down(i, j) + 1;
    }

    private int upright(int i, int j) {
        return up(i, j) + 1;
    }

    private int downleft(int i, int j) {
        return down(i, j) - 1;
    }

    private int upleft(int i, int j) {
        return up(i, j) - 1;
    }

    private int[] index2ij(int index) {
        int i = index / N;
        int j = index - i * N;
        return new int[] {i, j};
    }

    private void dir_init() {
        int range = M * N - 1; // to 15
        dir = new ArrayList<>(range + 2); // of size 17
        Bag<Integer> master = new Bag<>();

        for (int index = 0; index < range + 1; index++) { // 16 times
            Bag<Integer> cur_dir = new Bag<>();
            int[] ij = index2ij(index);
            int i = ij[0];
            int j = ij[1];

            if (M > 1) {
                if (i > 0)
                    cur_dir.add(up(i, j));
                if (i < M - 1)
                    cur_dir.add(down(i, j));
            }

            if (N > 1) {
                if (j > 0)
                    cur_dir.add(left(i, j));
                if (j < N - 1)
                    cur_dir.add(right(i, j));
            }

            if (M > 1 && N > 1) {
                if (i < M - 1 && j < N - 1) // have downright
                    cur_dir.add(downright(i, j));
                if (i < M - 1 && j > 0)
                    cur_dir.add(downleft(i, j));
                if (i > 0 && j > 0)
                    cur_dir.add(upleft(i, j));
                if (i > 0 && j < N - 1)
                    cur_dir.add(upright(i, j));
            }

            dir.add(cur_dir);

            master.add(index); // master bag contain route to all bags
        }

        // master bag
        dir.add(master);
    }

    public BoggleSolver(String[] dictionary) {
        trieset = new TrieSET();
        for (String item : dictionary)
            trieset.add(item);
    }

    public Iterable<String> getAllValidWords(BoggleBoard board) {
        boggleboard = board;
        M = board.rows();
        N = board.cols();
        dir_init();

        Set<String> container = new HashSet<>();
        Node root = trieset.getRoot();
        dfs(root, new boolean[M * N], "", container, M * N);

        return container;
    }

    private void dfs(Node cur_node, boolean[] visited, String str, Set<String> container, int index) {
        for (int opts : dir.get(index)) {
            if (!visited[opts]) {
                int[] ij = index2ij(opts);

                boolean[] tempvisited = visited.clone();
                tempvisited[opts] = true;

                String tempstr;
                Node child_node;
                char cur_char = boggleboard.getLetter(ij[0], ij[1]);
                if (cur_char == 'Q') {
                    tempstr = str + "QU";
                    child_node = trieset.getNode(tempstr, str.length(), cur_node);
                }
                else {
                    tempstr = str + cur_char;
                    child_node = trieset.getNode(tempstr, str.length(), cur_node);
                }

                if (child_node != null) {
                    if (TrieSET.isstring(child_node) && tempstr.length() > 2)
                        container.add(tempstr);
                    dfs(child_node, tempvisited, tempstr, container, opts);
                }
            }
        }
    }

    public int scoreOf(String word) {
        if (word == null)
            throw new NullPointerException();
        if(trieset.contains(word)) {
            if (word.length() <= 2)
                return 0;
            if (word.length() <= 4)
                return 1;
            if (word.length() <= 5)
                return 2;
            if (word.length() <= 6)
                return 3;
            if (word.length() <= 7)
                return 5;
            else
                return 11;
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args)
    {
        In in = new In(args[0]);
        String[] dictionary = in.readAllStrings();
        BoggleSolver solver = new BoggleSolver(dictionary);
        BoggleBoard board = new BoggleBoard(args[1]);

        solver.getAllValidWords(board);
        int score = 0;
        for (String word : solver.getAllValidWords(board))
        {
            StdOut.println(word);
            score += solver.scoreOf(word);
        }
        StdOut.println("Score = " + score);
    }
}
