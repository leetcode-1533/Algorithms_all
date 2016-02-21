import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stack;


public class Solver {
    
    private SearchNode solution;
    private boolean issolvable;
    
    private static class SearchNode implements Comparable<SearchNode> {
        private Board board;
        private SearchNode previous;
        private int moves;
        
        public SearchNode(int mo, Board Bo, SearchNode pre) {
            moves = mo;
            board = Bo;
            previous = pre;
        }
        
        public int weight() {
            return (moves + board.manhattan());
        }
        
        public int compareTo(SearchNode p) {
            // less than one, smaller 
            return this.weight() - p.weight();
        }
    }
        
    public Solver(Board initial) {
        // find a solution
        if(initial == null) {
            throw new NullPointerException();
        }
        
        MinPQ<SearchNode> heap = new MinPQ<SearchNode>();
        MinPQ<SearchNode> heap_twin = new MinPQ<SearchNode>();

        heap.insert(new SearchNode(0, initial, null));
        heap_twin.insert(new SearchNode(0, initial.twin(), null));
        
        SearchNode deq = heap.delMin();
        SearchNode deq_twin = heap_twin.delMin();
        
        while((!deq.board.isGoal()) && (!deq_twin.board.isGoal())) {
            for(Board item : deq.board.neighbors()) {
                if(deq.previous != null) {
                    if(!item.equals(deq.previous.board)) {
                        heap.insert(new SearchNode(deq.moves + 1, item, deq));
                    }
                } else {
                    heap.insert(new SearchNode(deq.moves + 1, item, deq));
                }
            }
            deq = heap.delMin(); 
//            StdOut.println("deq_moves" + deq.weight());
            
            for(Board item_twin : deq_twin.board.neighbors()) {
                if(deq_twin.previous != null) {
                    if(!item_twin.equals(deq_twin.previous.board)) {
                        heap_twin.insert(new SearchNode(deq_twin.moves + 1, item_twin, deq_twin));
                    }
                } else {
                    heap_twin.insert(new SearchNode(deq_twin.moves + 1, item_twin, deq_twin));
                }
            }
            deq_twin = heap_twin.delMin();            
//            StdOut.println("deq_twin_moves" + deq_twin.weight());
        } 
        if(deq.board.isGoal()) {
            issolvable = true;
            solution = deq;            
        } else {
            issolvable = false;
            solution = null;
        }
        
    }
    
    public boolean isSolvable() {
        // 
        return issolvable;
    }

    public int moves() {
        // minimum movements
        if(isSolvable()) {
            return solution.moves;            
        } else {
            return -1;
        }
    }
    
    public Iterable<Board> solution() {
        // sequence of boards in a shortest solution, null if unsolvable
        if(isSolvable()) {
            Stack<Board> sol = new Stack<Board>();
            SearchNode temp = solution;
            while(temp != null) {
                sol.push(temp.board);
                temp = temp.previous;
            }
            return sol;
        } else {
            return null;
        }   
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
           Solver solver = new Solver(initial);
           
           // print solution to standard output
           if (!solver.isSolvable())
               StdOut.println("No solution possible");
           else {
               StdOut.println("Minimum number of moves = " + solver.moves());
               for (Board board : solver.solution())
                   StdOut.println(board);
           }
    }
}
