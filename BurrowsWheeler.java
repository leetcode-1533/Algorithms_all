/**
 * Created by y1275963 on 5/19/16.
 */
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.StdOut;
public class BurrowsWheeler {
    private char charAt(String text, int i, int index) {
        int N = text.length();
        int num = i + index;
        if (num >= N)
            return text.charAt(num - N);
        else
            return text.charAt(num);
    }

    public static void encode() {

    }

    public static void decode() {

    }

    public static void main(String[] args) {
        if (args[0].equals("+"))
            StdOut.println('+');
        else
            StdOut.println(args[0]);

        while (!BinaryStdIn.isEmpty()) {
            char c = BinaryStdIn.readChar();
            StdOut.println(c);
        }
    }
}

