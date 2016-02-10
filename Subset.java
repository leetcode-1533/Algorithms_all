import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Subset {
    public static void main(String[] args){
        String input;
        RandomizedQueue<String> item = new RandomizedQueue<String>();
        input = StdIn.readAll();
        StdOut.println(input);
//        
//        while(!StdIn.isEmpty()){
//            input = StdIn.readString();
//            StdOut.println(input);
//            item.enqueue(input);
//            StdOut.println(StdIn.hasNextLine());
//        }   
        StdOut.print(item.size());
    }
}
