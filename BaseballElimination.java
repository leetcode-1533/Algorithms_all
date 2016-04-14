import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SeparateChainingHashST;

public class BaseballElimination {
    private class Team {
        int id;
        int wins;
        int losses;
        int rem;
        
        Team(int num_id, int num_wins, int num_losses, int num_rem) {
            id = num_id;
            wins = num_wins;
            losses = num_losses;
            rem = num_rem;
        }
    }
    
    private SeparateChainingHashST<String, Team> t2id;
    private SeparateChainingHashST<Integer, String> id2t;
    private EdgeWeightedGraph games;
    private int numteam;
    
    public BaseballElimination(String filename) {
        In in = new In(filename);
        assert in.exists();
        
        numteam = in.readInt();
        games = new EdgeWeightedGraph(numteam);
        t2id = new SeparateChainingHashST<String, Team>(numteam);
        for(int i = 0; i < numteam; i++) { // read each line
            String teamname = in.readString();
            
            t2id.put(teamname, new Team(i, in.readInt(), in.readInt(), in.readInt()));
            id2t.put(i, teamname);
            for(int sk = 0; sk < numteam; sk++) { // read diagonally
                if(sk <= i) {
                    in.readInt(); // skip
                } else {
                    int rem = in.readInt();
                    if(rem != 0) {
                        games.addEdge(new Edge(i, sk, rem));
                    }
                }
            }          
        }
        in.close();
        
    }
    
    public int numberofTeams() {
        return numteam;
    }
    
    public int wins(String team) {
        return t2id.get(team).wins;
    }
    
    public int losses(String team) {
        return t2id.get(team).losses;
    }
    
    public int remaining(String team) {
        return t2id.get(team).rem;
    }
    
    public int against(String team1, String team2) {
        int id1 = t2id.get(team1).id;
        int id2 = t2id.get(team2).id;
        for(Edge item : games.adj(id1)) {
            if(item.other(id1) == id2)
                return (int) item.weight();   
        }
        
        return 0; // if not found
    }
    
    public static void main(String[] args) {
        BaseballElimination test = new BaseballElimination(args[0]);   
        StdOut.println(args[0]);

    }
    
}
