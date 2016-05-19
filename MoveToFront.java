/**
 * Created by y1275963 on 5/19/16.
 */
import edu.princeton.cs.algs4.StdOut;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.Alphabet;
import java.util.LinkedList;


public class MoveToFront {
    public static void encode() {
        int R = 256; // extended ASCII
        Alphabet alpha = Alphabet.EXTENDED_ASCII;
//        String str_alpha = alpha.toString();
        LinkedList<Integer> list = new LinkedList<>();

//        StdOut.println(alpha.R());

        for (int i = 0; i < R; i++)
            list.add(i);
        while(!BinaryStdIn.isEmpty()) {
            char temp = BinaryStdIn.readChar();
            int i;
            for (i = 0; i < R; i++) {
                if (alpha.toChar(list.get(i)) == (temp))
                    break;
            }
            BinaryStdOut.write(i, 8);
            list.remove(i);
            list.addFirst(alpha.toIndex(temp));
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
        else throw new IllegalArgumentException("Illegal command line argument");
    }
}
