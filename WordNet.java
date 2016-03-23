import edu.princeton.cs.algs4.SeparateChainingHashST;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedCycle;
import edu.princeton.cs.algs4.StdOut;

public class WordNet {
    private SeparateChainingHashST<String, Bag<Integer>> st;
    private SeparateChainingHashST<Integer, String> check_anc;
    private Digraph graph;
    private SAP sap;
    
    public WordNet(String synsets, String hypernyms) {
        int num_vertices = con_synsets(synsets);
        con_hypernyms(num_vertices, hypernyms);
        
        sap = new SAP(graph);
        
    }
    
    private void con_hypernyms(int num_vertices, String hypernyms) {
        graph = new Digraph(num_vertices);
        
        In in = new In(hypernyms);
        while(in.hasNextLine()) {
            String line = in.readLine();
            String[] fields = line.split(",");
            int specified = Integer.parseInt(fields[0]);
            for(String hyper : fields) {
                if(hyper == fields[0]) continue;        
                
                int int_hyper = Integer.parseInt(hyper);
                graph.addEdge(specified, int_hyper);             
            }         
        }
        DirectedCycle det_cycle = new DirectedCycle(graph);
        if(det_cycle.hasCycle())
            throw new java.lang.IllegalArgumentException();
    }
    
    private int con_synsets(String synsets) {
        st = new SeparateChainingHashST<String, Bag<Integer>>();
        check_anc = new SeparateChainingHashST<Integer, String>();
        In in = new In(synsets);
        int graphsize = 0;
        
        while(in.hasNextLine()) {
            graphsize++;
            
            String line = in.readLine();
            String[] fields = line.split(",");
            
            int id = Integer.parseInt(fields[0]);  
            
            check_anc.put(id, fields[1]);
            String[] nouns = fields[1].split(" ");
            
            for(String item : nouns) {
                if(st.contains(item)) {
                    Bag<Integer> temp = st.get(item);
                    temp.add(id);                  
                } else {
                    Bag<Integer> temp = new Bag<Integer>();
                    temp.add(id);
                    st.put(item, temp);
                }
            }
        }
        return graphsize;
    }

    public Iterable<String> nouns() {
        return st.keys();      
    }
    
    public boolean isNoun(String word) {
        return st.contains(word);       
    }
    
    public int distance(String nounA, String nounB) {
        check(nounA);
        check(nounB);
        
        Iterable<Integer> subA = st.get(nounA);
        Iterable<Integer> subB = st.get(nounB);
        
        return sap.length(subA, subB);       
    }
    
    public String sap(String nounA, String nounB) {
        check(nounA);
        check(nounB);
        
        Iterable<Integer> subA = st.get(nounA);
        Iterable<Integer> subB = st.get(nounB);
        
        int anc = sap.ancestor(subA, subB);   
        return check_anc.get(anc);
    }
    
    private void check(String noun) {
        if(noun == null)
            throw new java.lang.NullPointerException();
        if(!isNoun(noun))
            throw new java.lang.IllegalArgumentException();
    }
    
    public static void main(String[] args) {
        WordNet net = new WordNet(args[0], args[1]);     
        StdOut.println(net.sap("worm", "bird"));
    }
}
