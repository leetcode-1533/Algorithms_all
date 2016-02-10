import edu.princeton.cs.algs4.StdOut;

public class RandomizedQueuetest {
    public RandomizedQueuetest() {
        StdOut.println("Methods tests");
        methodtests();
        
        StdOut.println("Exceptions tests");
        exceptionstests();    
    }
    
    public static void main(String[] args) {
        new RandomizedQueuetest();
    }
    
    private void methodtests() {
        try { //constructor
            RandomizedQueue<Integer> item = new RandomizedQueue<Integer>();  
            StdOut.println("size: " + item.size());
            StdOut.println("isEmpty: " + item.isEmpty());
            for (Integer temp : item)
                StdOut.println(temp);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        finally {
            StdOut.println("constructor: tested");
        }   
        
        try { //enqueue
            RandomizedQueue<Integer> item = new RandomizedQueue<Integer>();  

            
            for (int i = 0; i < 5; i++)
                item.enqueue(i);
            
            StdOut.println("size: " + item.size());
            StdOut.println("isEmpty: " + item.isEmpty());
            
            StdOut.println("Iterator 1:");
            for (Integer temp : item){
                StdOut.print(temp);
                StdOut.print(',');
                StdOut.println(' '); 
            }   
            
            StdOut.println("Iterator 2:");
            for (Integer temp : item){
                StdOut.print(temp);
                StdOut.print(',');
                StdOut.println(' '); 
            }  

        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        finally {
            StdOut.println("enqueue, iteratable tested");
        }
        
        try { //dequeue
            RandomizedQueue<Integer> item = new RandomizedQueue<Integer>();  
            item.enqueue(1);            
            StdOut.println("size: " + item.size());
            StdOut.println("isEmpty: " + item.isEmpty());
            
            StdOut.println(item.sample());
            StdOut.println("size: " + item.size());
            StdOut.println("isEmpty: " + item.isEmpty());
            
            for (Integer temp : item)
                StdOut.println(temp);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        finally {
            StdOut.println("dequeue: tested");
        } 
        
        try { //sample
            RandomizedQueue<Integer> item = new RandomizedQueue<Integer>();  
            for (int i = 0; i < 5; i++)
                item.enqueue(i);           
            StdOut.println("size: " + item.size());
            StdOut.println("isEmpty: " + item.isEmpty());
            
            StdOut.println("Sampling: " + item.sample());
            StdOut.println("size: " + item.size());
            StdOut.println("isEmpty: " + item.isEmpty());
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        finally {
            StdOut.println("sample: tested");
        }  
    }
    
    private void exceptionstests() {
        
    }
}