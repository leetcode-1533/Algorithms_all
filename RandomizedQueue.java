import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] items;
    private int N;
    
    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            temp[i] = items[i];
        }        
        items = temp;
    }
    
    public RandomizedQueue() {
        items = (Item[]) new Object[2];
        N = 0;
    }
    
    public boolean isEmpty() {
        return (N == 0);
    }
    
    public int size() {
        return N;
    }
    
    public void enqueue(Item item){
        if (N == items.length) resize(2*N);
   
        items[N++] = item;
        
        int loc = StdRandom.uniform(N);
        Item temp = items[loc];
        items[loc] = items[N-1];
        items[N-1] = temp; // last one        
    }
    
    public Item dequeue(){
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        
        Item item = items[N-1];
        items[N-1] = null;
        N--;
        
        if (N > 0 && N == items.length/4) resize(items.length/2);
        return item;       
    }
    
    public Item sample(){
        int loc = StdRandom.uniform(N);
        return items[loc];
    }
    
    private class RandomQueueIterator implements Iterator<Item> {
        
        private int[] lookuptable;
        private int current;
        private int creat_size;
        
        public RandomQueueIterator() {
            lookuptable = new int[N];           
            StdRandom.shuffle(lookuptable);
            current = 0;
            creat_size = N;
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
        
        public boolean hasNext() {
            if (N != creat_size) throw new ConcurrentModificationException();

            return (creat_size != current);         
        }
        
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            if (N != creat_size) throw new ConcurrentModificationException();

            return items[lookuptable[current++]];
        }        
    }
    
    public Iterator<Item> iterator(){
        return new RandomQueueIterator();      
    }
    
    public static void main(String[] args){
        
    }
}

class RandomizedQueuetest {
    public RandomizedQueuetest() {
        StdOut.println("Methods tests");
        methodtests();
        
        StdOut.println("Exceptions tests");
        exceptionstests();    
    }
    
    private void methodtests() {
        
    }
    
    private void exceptionstests() {
        
    }
}
