/**
 * Created by y1275963 on 5/19/16.
 */
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.StdOut;
public class BurrowsWheeler {
    private static char charAt(String text, int i, int index) {
        int N = text.length();
        int num = i + index;
        if (num >= N)
            return text.charAt(num - N);
        else
            return text.charAt(num);
    }

    public static void encode() {
        String s = BinaryStdIn.readString();
        CircularSuffixArray CSA = new CircularSuffixArray(s);
        int first = 0;
        for (int i = 0; i < s.length(); i++) {
            if (CSA.index(i) == 0) {
                first = i;
                break;
            }
        }
        BinaryStdOut.write(first);
        for (int i = 0; i < s.length(); i++) {
//            StdOut.printf("%c ", charAt(s, s.length() - 1, CSA.index(i)));
            BinaryStdOut.write(charAt(s, s.length() - 1, CSA.index(i)));
        }
        BinaryStdOut.close();
    }

    public static void decode() {

    }

    public static void main(String[] args) {
        if (args[0].equals("+"))
            decode();
        else if (args[0].equals("-"))
            encode();
    }
}

