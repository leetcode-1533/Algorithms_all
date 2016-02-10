import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Subset {
    public static void main(String[] args){
        String input;
        RandomizedQueue<String> item = new RandomizedQueue<String>();
        
        Integer firstArg = 0;
        try {
            firstArg = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Argument" + args[0] + " must be an integer.");
            System.exit(1);
        }
        
        input = StdIn.readLine();
        String[] inputs = input.split(" ");
        for (String s: inputs)
            item.enqueue(s);
               
        for (int i = 0; i < firstArg; i ++)
            StdOut.println(item.dequeue());
    }
}
