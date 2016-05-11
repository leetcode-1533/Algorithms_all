
import edu.princeton.cs.algs4.StdOut;
import java.util.HashSet;
public class Main {


    public static void main(String[] args) {
        HashSet<String> test = new HashSet<>();
        String st1 = new String(new char[] {'a', 'b', 'c'});
        String st2 = new String(new char[] {'a', 'b', 'c'});
        StdOut.println(st1 == st2);
        StdOut.println(st1.equals(st2));

        test.add(st1);
        StdOut.println(test.contains(st2));
	// write your code here
    }
}
