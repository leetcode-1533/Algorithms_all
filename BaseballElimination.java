import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import edu.princeton.cs.algs4.FlowEdge;
import edu.princeton.cs.algs4.FlowNetwork;
import edu.princeton.cs.algs4.FordFulkerson;
import java.util.ArrayList;

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
        id2t = new SeparateChainingHashST<Integer, String>(numteam); // dual hash table
        
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
//        FlowNetwork flow = constrflow("Detroit");
//        StdOut.println(flow);
//        FordFulkerson maxflow = new FordFulkerson(flow, 0, 1);
//        StdOut.println(flow);
    }
    
    public boolean isEliminated(String team) {
        validTeam(team);
        if(trivialEliminated(team))
            return true;
        else {
            FlowNetwork teamflow = constrflow(team);
            FordFulkerson maxflow = new FordFulkerson(teamflow, 0, 1);
            return nontrivialEliminated(teamflow, maxflow);
        }
    }
    
    private int gameid2flowid(String tar, int gameID) {
        int id = t2id.get(tar).id;
        int teamStart = games.E() - games.degree(id) + 2;
        return gameID + teamStart;     
    }
    
    private boolean nontrivialEliminated(FlowNetwork flownet, FordFulkerson maxflow) {        
        int sumC = 0;
        for(FlowEdge competes : flownet.adj(0)) {
            sumC += competes.capacity(); 
        }
//        StdOut.println();
//        StdOut.println(team + " ->sumc: " + sumC + " maxflow: " + maxflow.value());
        return (sumC != maxflow.value());       
    }
    
    private boolean trivialEliminated(String team) {
        int id = t2id.get(team).id;
        int bestid = wins(team) + remaining(team);
        
        for(int i = 0; i < games.V(); i++) {
            if(i != id) {
//                StdOut.println(bestid + " versus " + t2id.get(id2t.get(i)).wins );
                if(bestid - t2id.get(id2t.get(i)).wins <= 0)
                    return true;               
            }            
        }      
        return false;      
    }
    
    private String trivialEliminatedteam(String team) {
        int id = t2id.get(team).id;
        int bestid = wins(team) + remaining(team);
        
        for(int i = 0; i < games.V(); i++) {
            if(i != id) {
//                StdOut.println(bestid + " versus " + t2id.get(id2t.get(i)).wins );
                if(bestid - t2id.get(id2t.get(i)).wins <= 0)
                    return id2t.get(i);               
            }            
        }      
        return null;       
    }
    
    public Iterable<String> certificateOfElimination(String team) {
        validTeam(team);
        
        ArrayList<String> container = null;
        
        String trivalTeam = trivialEliminatedteam(team);
        if(trivalTeam != null) {
            container = new ArrayList<String>();
            container.add(trivalTeam);   
        }   
        else {
            FlowNetwork teamflow = constrflow(team);
            FordFulkerson maxflow = new FordFulkerson(teamflow, 0, 1);

            if(nontrivialEliminated(teamflow, maxflow)) {
                container = new ArrayList<String>();
                
                for(int i = 0; i < games.V(); i++) {
                    if(i != t2id.get(team).id) {
                        int netid = gameid2flowid(team, i);
                        if(maxflow.inCut(netid))
                            container.add(id2t.get(i));                      
                    }                   
                }             
            } 
        }
        
        return container;
    }
    
    private FlowNetwork constrflow(String team) {
        /*
         * Documentation:
         * Source ID: 0
         * sink ID: 1
         * competitions: from 2 -> game.E() - game.degree(id) + 1: length: game.E() - game.degree(id)
         * team: from game.E() - game.degree(id) + 2 -> numteam + f: length: numteam - 1
         */
        int id = t2id.get(team).id;
        int bestid = wins(team) + remaining(team);
//        StdOut.println("edgrees: " + games.E() + " degree: " + games.degree(id) + " numteam: " + numteam);
        FlowNetwork flow = new FlowNetwork(games.E() - games.degree(id) + numteam + 2); // one additional dummy vertex to make sure easy retrieval of team ID
        int compID = 2;
        int teamStart = games.E() - games.degree(id) + 2; // equal to team 0's id
//        StdOut.println("Team Start: " + teamStart);
        
        for(int i = 0; i < games.V(); i++) { // i shouldn't connected to id
            if(i != id) {
                flow.addEdge(new FlowEdge(teamStart + i, 1, bestid - t2id.get(id2t.get(i)).wins));

                for(Edge compete : games.adj(i)) {
                    int i_against = compete.other(i);
                    if(i_against != id && i_against > i) {
                        // verified, neither i and i_against == id
                        // make it one way only
                        flow.addEdge(new FlowEdge(0, compID, compete.weight()));
                        
                        flow.addEdge(new FlowEdge(compID, teamStart + i, Double.POSITIVE_INFINITY));
                        flow.addEdge(new FlowEdge(compID, teamStart + i_against, Double.POSITIVE_INFINITY));
                        compID++;
                    }
                }
            }
        }
        assert compID == teamStart;
        return flow;    
    }
    
    private void validTeam(String team) {
        if(!t2id.contains(team))
            throw new java.lang.IllegalArgumentException(team + " is invalid");       
    }
    
    public int numberofTeams() {
        return numteam;
    }
    
    public int wins(String team) {
        validTeam(team);
        return t2id.get(team).wins;
    }
    
    public int losses(String team) {
        validTeam(team);
        return t2id.get(team).losses;
    }
    
    public int remaining(String team) {
        validTeam(team);
        return t2id.get(team).rem;
    }
    
    public int against(String team1, String team2) {
        validTeam(team1);
        validTeam(team2);
        
        int id1 = t2id.get(team1).id;
        int id2 = t2id.get(team2).id;
        for(Edge item : games.adj(id1)) {
            if(item.other(id1) == id2)
                return (int) item.weight();   
        }
        
        return 0; // if not found
    }
    
    public Iterable<String> teams() {
        return t2id.keys();
    }
    
    public static void main(String[] args) {        
        BaseballElimination division = new BaseballElimination(args[0]);
        for (String team : division.teams()) {
            if (division.isEliminated(team)) {
                StdOut.print(team + " is eliminated by the subset R = { ");
                for (String t : division.certificateOfElimination(team)) {
                    StdOut.print(t + " ");
                }
                StdOut.println("}");
            }
            else {
                StdOut.println(team + " is not eliminated");
            }
        }
    }
    
}
