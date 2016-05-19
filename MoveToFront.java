/**
 * Created by y1275963 on 5/19/16.
 */
//import edu.princeton.cs.algs4.StdOut;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.Alphabet;
import java.util.LinkedList;


public class MoveToFront {
    public static void encode() {
        int R = 256; // extended ASCII
        Alphabet alpha = Alphabet.EXTENDED_ASCII;

        int[] num_temp = new int[R];
        for (int i = 0; i < R; i++)
            num_temp[i] = i;

        ListNode dummy = new ListNode(-1);
        dummy.next = ListNode.constructLinkedList(num_temp);

        while (!BinaryStdIn.isEmpty()) {
            char read_char = BinaryStdIn.readChar();
            int char_index = alpha.toIndex(read_char);

            int i = 0;
            ListNode header = dummy.next;
            ListNode before = dummy;

            while (header.val != char_index) {
                before = header;
                header = header.next;
                i++;
            }

            BinaryStdOut.write(i, 8);

            before.next = header.next;
            header.next = dummy.next;
            dummy.next = header;
        }
        BinaryStdOut.close();
    }

    public static void decode() {
        int R = 256; // extended ASCII
        Alphabet alpha = Alphabet.EXTENDED_ASCII;
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < R; i++)
            list.add(i);
        while (!BinaryStdIn.isEmpty()) {
            int loc = BinaryStdIn.readInt(8);
            int list_content = list.get(loc);
            char temp = alpha.toChar(list_content);
            BinaryStdOut.write(temp);
            list.remove(loc);
            list.addFirst(list_content);
        }
        BinaryStdOut.close();
    }

    public static void main(String[] args) {
        if (args[0].equals("+"))
            decode();
        else if (args[0].equals("-"))
            encode();
        else throw new IllegalArgumentException("Illegal command line argument");
    }
}
