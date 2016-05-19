import edu.princeton.cs.algs4.StdOut;

public class CircularSuffixArray {
    private String text;
    private int N;
    private int[] suffixes;

    private char charAt(int i, int index) {
        int num = i + index;
        if (num >= N)
            return text.charAt(num - N);
        else
            return text.charAt(num);
    }

    public CircularSuffixArray(String s) {
        // circular suffix array of s
        text = s;
        N = text.length();
        suffixes = new int[N];
        for (int i = 0; i < N; i++) {
            suffixes[i] = i;
        }
    }

    public int length() {
        // length of s
        return N;
    }

    public int index(int i) {
        // returns index of ith sorted suffix
        return 0;
    }

    public static void main(String[] args) {
        CircularSuffixArray test = new CircularSuffixArray("ABRACADABRA!");
        for (int index = 0; index < test.length(); index++) {
            for (int i = 0; i < test.length(); i++) {
                StdOut.print(test.charAt(i, index));
            }
            StdOut.print('\n');
        }
    }
}
