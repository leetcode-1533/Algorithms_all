import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;

public class Dequetest {       
    public Dequetest() {
        StdOut.println("Test Exceptions");
        testexceptions();
        StdOut.println("Test methods");
        testmethods();
    }
    
    private void testmethods() {
        try { //constructor
            Deque<Integer> item = new Deque<Integer>();  
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
        
        try { //addFirst
            StdOut.println("\n");
            Deque<Integer> item = new Deque<Integer>();  
            item.addFirst(5);
            item.addFirst(6);
            StdOut.println("size: " + item.size());
            StdOut.println("isEmpty: " + item.isEmpty());
            for (Integer temp : item)
                StdOut.println(temp);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        finally {
            StdOut.println("addFirst: tested");
        }
        
        try { //removefirst
            StdOut.println("\n");
            Deque<Integer> item = new Deque<Integer>();  
            item.addFirst(5);
            item.addFirst(6);
            item.removeFirst();
            item.removeFirst();
            StdOut.println("size: " + item.size());
            StdOut.println("isEmpty: " + item.isEmpty());
            for (Integer temp : item)
                StdOut.println(temp);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        finally {
            StdOut.println("removefirst: tested");
        }
        
        try { //removefirst
            StdOut.println("\n");
            Deque<Integer> item = new Deque<Integer>();  
            item.addFirst(5);
            item.addFirst(6);
            item.removeFirst();
            item.removeFirst();
            item.removeFirst();
            StdOut.println("size: " + item.size());
            StdOut.println("isEmpty: " + item.isEmpty());
            for (Integer temp : item)
                StdOut.println(temp);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        finally {
            StdOut.println("removefirst: tested");
        }
        
        try { //addLast
            StdOut.println("\n");
            Deque<Integer> item = new Deque<Integer>();  
            item.addLast(5);
            item.addLast(6);
            StdOut.println("size: " + item.size());
            StdOut.println("isEmpty: " + item.isEmpty());
            for (Integer temp : item)
                StdOut.println(temp);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        finally {
            StdOut.println("addLast: tested");
        }
        
        try { //removeLast
            StdOut.println("\n");
            Deque<Integer> item = new Deque<Integer>();  
            item.addFirst(5);
            item.addFirst(6);
            item.removeLast();
            StdOut.println("size: " + item.size());
            StdOut.println("isEmpty: " + item.isEmpty());
            for (Integer temp : item)
                StdOut.println(temp);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        finally {
            StdOut.println("removeLast: tested");
        }
        
        try { //removeLast
            StdOut.println("\n");
            Deque<Integer> item = new Deque<Integer>();  
            item.addFirst(5);
            item.addFirst(6);
            item.removeLast();
            item.removeLast();
            item.removeLast();

            StdOut.println("size: " + item.size());
            StdOut.println("isEmpty: " + item.isEmpty());
            for (Integer temp : item)
                StdOut.println(temp);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        finally {
            StdOut.println("removeLast: tested");
        }
    
    }
    
    private void testexceptions() {          
        try {  // java.util.NoSuchElementException
            Deque<Integer> item = new Deque<Integer>();  
            item.removeLast();
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        finally {
            StdOut.println("NoSuchElementException: tested");
        }
        
        try {
            Deque<Integer> item = new Deque<Integer>();  
            item.addFirst(1);
            item.removeLast();
            item.addFirst(1);
            item.removeLast();
            }catch (Exception ex) {
                ex.printStackTrace();
            }
        finally {
            StdOut.println("NoSuchElementException: fine");
        }
        
        try { // java.lang.NullPointerException
            Deque<Integer> item = new Deque<Integer>();  
            item.addFirst(null);
            }catch (Exception ex) {
                ex.printStackTrace();
            }
        finally {
            StdOut.println("NullPointerException: tested");
        }
        
        try { // java.lang.NullPointerException
            Deque<Integer> item = new Deque<Integer>();  
            item.addFirst(null);
            }catch (Exception ex) {
                ex.printStackTrace();
            }
        finally {
            StdOut.println("NullPointerException: tested");
        }
        
        try { // java.lang.UnsupportedOperationException
            Deque<Integer> item = new Deque<Integer>();  
            Iterator<Integer> iter = item.iterator();
            iter.remove();
            }catch (Exception ex) {
                ex.printStackTrace();
            }
        finally {
            StdOut.println("UnsupportedOperationException: tested");
        }
        
        try { // java.lang.NoSuchElementException
            Deque<Integer> item = new Deque<Integer>();  
            Iterator<Integer> iter = item.iterator();
            iter.next();
            }catch (Exception ex) {
                ex.printStackTrace();
            }
        finally {
            StdOut.println("NoSuchElementException: tested");
        }      
    }
}