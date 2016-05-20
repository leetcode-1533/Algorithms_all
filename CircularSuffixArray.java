import edu.princeton.cs.algs4.StdOut;


// v1 is implemented using LSD
public class CircularSuffixArray {
    private String text;
    private int N;
    private int[] suffixes;

    private char charAt(int i, int index) {
        int num = i + index;
        return text.charAt(num % N);
//        if (num >= N)
//            return text.charAt(num - N);
//        else
//            return text.charAt(num);
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
        if (s == null)
            throw new java.lang.NullPointerException();

        text = s;
        N = text.length();
        suffixes = new int[N];
        for (int i = 0; i < N; i++) {
            suffixes[i] = i;
        }
//        lsdSort();
//        insertion(0, N-1, N-1);
    }

    public int length() {
        // length of s
        return N;
    }

    public int index(int i) {
        // returns index of ith sorted suffix
        if (i >= N || i < 0)
            throw new java.lang.IndexOutOfBoundsException();
        return suffixes[i];
    }

    private static final int CUTOFF = 5;

//    private void quickSort() {
//        qsort(0, N-1, 0);
//    }
//
//    private void qsort(int lo, int hi, int d) {
//        if (hi <= lo + CUTOFF) {
//            insertion(lo, hi, d);
//            return;
//        }
//    }

    private void insertion(int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(suffixes[j], suffixes[j-1], d); j--) {
                int temp = suffixes[j];
                suffixes[j] = suffixes[j-1];
                suffixes[j-1] = temp;
            }
        }
    }

    private boolean less(int v, int w, int d) {
        for (int i = d; i < N; i++) {
            if (charAt(i, v) < charAt(i, w)) return true;
            if (charAt(i, v) > charAt(i, w)) return false;
        }
        return false;
    }




    public static void main(String[] args) {
        String str = "ABRACADABRA!";

        CircularSuffixArray test = new CircularSuffixArray(str);
        for (Integer item : test.suffixes) {
            for (int i = test.length() - 1; i > 0; i--) {
                StdOut.print(test.charAt(i, item));
            }
            StdOut.print('\n');
        }
        StdOut.print('\n');


        test.lsdSort();
        for (Integer item : test.suffixes) {
            for (int i = test.length() - 1; i > 0; i--) {
                StdOut.print(test.charAt(i, item));
            }
            StdOut.print('\n');
        }
        StdOut.print('\n');


        test.insertion(0, test.length()-1, 0);
        for (Integer item : test.suffixes) {
            for (int i = test.length() - 1; i > 0; i--) {
                StdOut.print(test.charAt(i, item));
            }
            StdOut.print('\n');
        }
        StdOut.print('\n');


//        for (int i = 0; i < test.length(); i++) {
//            StdOut.printf("%c ",test.charAt(test.length() - 1, test.suffixes[i]));
//        }
    }
}
