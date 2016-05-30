import edu.princeton.cs.algs4.MaxPQ;

public class Outcast {
    private WordNet wordn;
    
    public Outcast(WordNet wordnet) {
        wordn = wordnet;       
    }
    
    public String outcast(String[] nouns) {
        MaxPQ<ksbind> heap = new MaxPQ<ksbind>();
        for(String item : nouns) {
            int dis = 0;
            for(String target : nouns)
                dis = dis + wordn.distance(item, target);
            ksbind ks = new ksbind(dis, item);
            heap.insert(ks);            
        }
        ksbind largest = heap.max();
        return largest.getnoun();       
    }
    
    public static void main(String[] args) {
        
    }
}



class ksbind implements Comparable<ksbind> {
    private int distance;
    private String noun;
    
    public ksbind(int initdis, String initnoun) {
        distance = initdis;
        noun = initnoun;
    }
    
    public String getnoun() {
        return noun;
    }
    
    public int compareTo(ksbind tar) {
        return this.distance - tar.distance;           
    }
}