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
            BinaryStdOut.write(charAt(s, s.length() - 1, CSA.index(i)));
        }
        BinaryStdOut.close();
    }

    public static void decode() {
//        int first = BinaryStdIn.readInt();
//        String text = BinaryStdIn.readString();
        String text = "ARD!RCAAAABB";
        int N = text.length();
        int R = 256; // extended ASCII

        // construct Next[]
        int[] count = new int[R+1];
        int[] next = new int[N];
        for (int i = 0; i < N; i++)
            count[text.charAt(i) + 1]++;
        for (int r = 0; r < R; r++)
            count[r+1] += count[r];
        for (int i = 0; i < N; i++)
            next[count[text.charAt(i)]++] = i;

        for (int i = 0; i < N; i++)
            StdOut.println(next[i]);
    }

    public static void main(String[] args) {
        if (args[0].equals("+"))
            decode();
        else if (args[0].equals("-"))
            encode();
        else throw new IllegalArgumentException("Illegal command line argument");
    }
}

