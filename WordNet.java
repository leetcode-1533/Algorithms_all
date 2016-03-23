import edu.princeton.cs.algs4.SeparateChainingHashST;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Digraph;
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
        
//        StdOut.println(graph);     
    }
    
    private void con_hypernyms(int num_vertices, String hypernyms) {
        graph = new Digraph(num_vertices);
        
        In in = new In(hypernyms);
        while(in.hasNextLine()) {
            String line = in.readLine();
            String[] fields = line.split(",");
            int hyper = Integer.parseInt(fields[0]);
            for(String specified : fields) {
                if(specified == fields[0]) continue;               
                int int_specified = Integer.parseInt(specified);
                graph.addEdge(int_specified, hyper);             
            }         
        }        
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
        Iterable<Integer> subA = st.get(nounA);
        Iterable<Integer> subB = st.get(nounB);
        
        return sap.length(subA, subB);       
    }
    
    public String sap(String nounA, String nounB) {
        Iterable<Integer> subA = st.get(nounA);
        Iterable<Integer> subB = st.get(nounB);
        
        int anc = sap.ancestor(subA, subB);     
        return check_anc.get(anc);
    }
    
    public static void main(String[] args) {
        WordNet net = new WordNet(args[0], args[1]);     
    }
}
