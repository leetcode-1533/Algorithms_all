import edu.princeton.cs.algs4.StdOut;


// v1 is implemented using LSD
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

    private void lsdSort() {
        int R = 256; // extend ASCII
        int[] aux = new int[N];
        for (int d = N - 1; d >= 0; d--) {
            int [] count = new int[R+1];

            for (int i = 0; i < N; i++)
                count[charAt(d, suffixes[i]) + 1]++;
            for (int r = 0; r < R; r++)
                count[r+1] += count[r];
            for (int i = 0; i < N; i++)
                aux[count[charAt(d, suffixes[i])]++] = suffixes[i];
            for (int i = 0; i < N; i++)
                suffixes[i] = aux[i];
        }
    }

    public CircularSuffixArray(String s) {
        // circular suffix array of s
        text = s;
        N = text.length();
        suffixes = new int[N];
        for (int i = 0; i < N; i++) {
            suffixes[i] = i;
        }
        lsdSort();
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
//        for (int index = 0; index < test.length(); index++) {
//            for (int i = test.length() - 1; i > 0; i--) {
//                StdOut.print(test.charAt(i, index));
//            }
//            StdOut.print('\n');
//        }
        for (int i = 0; i < test.length(); i++) {
            StdOut.printf("%d ",test.suffixes[i]);
        }
    }
}
