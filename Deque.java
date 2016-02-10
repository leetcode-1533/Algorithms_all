import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private int N;
    private Node front;
    private Node end;
    
    private class Node {
        private Item content;
        private Node next;
        private Node before;
        
        public Node(Item con, Node ne, Node be) {
            content = con;
            next = ne;
            before = be;
        }
    }
    
    public Deque() {
        N = 0;
        front = null;
        end = null;
    }
    
    public boolean isEmpty() {
        return (N == 0);
    }
    
    public int size() {
        return N;
    }

    public void addFirst(Item item) {     
        if (item == null) {
            throw new NullPointerException();
        }
               
        if (isEmpty()) {
            Node temp = new Node(item, null, null);
            end = temp;
            front = temp;
        }
        else{
            Node temp = new Node(item, null, front); // first doesn't have next
            front.next = temp;
            front = temp;
        }  
        
        N ++;
    }
    
    public void addLast(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
                
        if (isEmpty()) {
            Node temp = new Node(item, null, null);
            end = temp;
            front = temp;
        }
        else{
            Node temp = new Node(item, end, null); // last doesn't have before
            end.before = temp;
            end = temp;
        }     
        
        N ++;
    }
    
    public Item removeFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        
        N --;
        
        if ( front == end ) {
            Node temp = front;
            
            front = null;
            end = null;
            return temp.content;
        }
        else {
            Node temp = front;
            
            front = temp.before;
            front.next = null;
            return temp.content;
        }
    }
    
    public Item removeLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        
        N --;
        
        if (front == end) {
            Node temp = front;
            
            front = null;
            end = null;
            return temp.content;
        }
        else {      
            Node temp = end;
            
            end = temp.next;
            end.before = null;
            return temp.content;
        }
    }
    
    private class dequeueIterator implements Iterator<Item> {
        // hasNext, next, remove
        private Node current = front;
                
        public void remove() {
            throw new UnsupportedOperationException();
        }
        
        public boolean hasNext() {
            return (current != null);
        }
        
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item temp = current.content;
            
            current = current.before;
            return temp;
        }
    }
    
    public Iterator<Item> iterator() {
        return new dequeueIterator();
    }
    
    public static void main(String[] args) {
        Dequetest test = new Dequetest();
//        Deque<Integer> test = new Deque<Integer>();
//        test.addFirst(5);
//        test.addFirst(6);
////        
//        test.removeLast();
////        test.removeLast();
// 
//        Iterator<Integer> iter = test.iterator(); 
//        while(iter.hasNext()){
//            StdOut.println(test.size());
//            StdOut.println(iter.next());
//        }
////        for (Integer temp : test)
////            StdOut.println(temp);
    }
}

