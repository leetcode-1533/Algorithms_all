```text
Compilation:  PASSED
Style:        FAILED
Findbugs:     No potential bugs found.
API:          PASSED

Correctness:  37/37 tests passed
Memory:       51/53 tests passed
Timing:       62/62 tests passed

Aggregate score: 99.62% [Correctness: 65%, Memory: 10%, Timing: 25%, Style: 0%]
Assessment Details
The following files were submitted:
----------------------------------
total 16K
-rw-r--r-- 1 3.3K Feb 10 16:31 Deque.java
-rw-r--r-- 1 2.7K Feb 10 16:31 RandomizedQueue.java
-rw-r--r-- 1  725 Feb 10 16:31 Subset.java
-rw-r--r-- 1 2.3K Feb 10 16:31 studentSubmission.zip


********************************************************************************
*          COMPILING                                                           *
********************************************************************************


% javac Deque.java
*-----------------------------------------------------------

================================================================

% javac RandomizedQueue.java
*-----------------------------------------------------------
RandomizedQueue.java:11: warning: [unchecked] unchecked cast
        items = (Item[]) new Object[2];
                         ^
  required: Item[]
  found:    Object[]
  where Item is a type-variable:
    Item extends Object declared in class RandomizedQueue
RandomizedQueue.java:16: warning: [unchecked] unchecked cast
        Item[] temp = (Item[]) new Object[capacity];
                               ^
  required: Item[]
  found:    Object[]
  where Item is a type-variable:
    Item extends Object declared in class RandomizedQueue
2 warnings

================================================================

% javac Subset.java
*-----------------------------------------------------------

================================================================



% checkstyle *.java
*-----------------------------------------------------------
RandomizedQueue.java:67:21: Instance variable 'Creat_Size' should start with a lowercase letter and use camelCase.
Checkstyle ends with 1 errors.

================================================================


% findbugs *.class
*-----------------------------------------------------------

================================================================


Testing the APIs of your programs.
*-----------------------------------------------------------
Deque:

RandomizedQueue:

Subset:

================================================================


******************************************************************************
*          CORRECTNESS
******************************************************************************

Testing methods in Deque
*-----------------------------------------------------------
Running 16 total tests.

Tests 1-6 make random calls to addFirst(), addLast(), removeFirst(),
removeLast(), isEmpty(), and size(). The probabilities of each
operation are (p1, p2, p3, p4, p5, p6), respectively.

Test 1: Calls to addFirst(), addLast(), and size()
  *    5 random calls (0.4, 0.4, 0.0, 0.0, 0.0, 0.2)
  *   50 random calls (0.4, 0.4, 0.0, 0.0, 0.0, 0.2)
  *  500 random calls (0.4, 0.4, 0.0, 0.0, 0.0, 0.2)
  * 1000 random calls (0.4, 0.4, 0.0, 0.0, 0.0, 0.2)
==> passed

Test 2: Calls to addFirst(), removeFirst(), and isEmpty()
  *    5 random calls (0.8, 0.0, 0.1, 0.0, 0.1, 0.0)
  *   50 random calls (0.8, 0.0, 0.1, 0.0, 0.1, 0.0)
  *  500 random calls (0.8, 0.0, 0.1, 0.0, 0.1, 0.0)
  * 1000 random calls (0.8, 0.0, 0.1, 0.0, 0.1, 0.0)
  *    5 random calls (0.1, 0.0, 0.8, 0.0, 0.1, 0.0)
  *   50 random calls (0.1, 0.0, 0.8, 0.0, 0.1, 0.0)
  *  500 random calls (0.1, 0.0, 0.8, 0.0, 0.1, 0.0)
  * 1000 random calls (0.1, 0.0, 0.8, 0.0, 0.1, 0.0)
==> passed

Test 3: Calls to addFirst(), removeLast(), and isEmpty()
  *    5 random calls (0.8, 0.0, 0.0, 0.1, 0.1, 0.0)
  *   50 random calls (0.8, 0.0, 0.0, 0.1, 0.1, 0.0)
  *  500 random calls (0.8, 0.0, 0.0, 0.1, 0.1, 0.0)
  * 1000 random calls (0.8, 0.0, 0.0, 0.1, 0.1, 0.0)
  *    5 random calls (0.1, 0.0, 0.0, 0.8, 0.1, 0.0)
  *   50 random calls (0.1, 0.0, 0.0, 0.8, 0.1, 0.0)
  *  500 random calls (0.1, 0.0, 0.0, 0.8, 0.1, 0.0)
  * 1000 random calls (0.1, 0.0, 0.0, 0.8, 0.1, 0.0)
==> passed

Test 4: Calls to addLast(), removeLast(), and isEmpty()
  *    5 random calls (0.0, 0.8, 0.0, 0.1, 0.1, 0.0)
  *   50 random calls (0.0, 0.8, 0.0, 0.1, 0.1, 0.0)
  *  500 random calls (0.0, 0.8, 0.0, 0.1, 0.1, 0.0)
  * 1000 random calls (0.0, 0.8, 0.0, 0.1, 0.1, 0.0)
  *    5 random calls (0.0, 0.1, 0.0, 0.8, 0.1, 0.0)
  *   50 random calls (0.0, 0.1, 0.0, 0.8, 0.1, 0.0)
  *  500 random calls (0.0, 0.1, 0.0, 0.8, 0.1, 0.0)
  * 1000 random calls (0.0, 0.1, 0.0, 0.8, 0.1, 0.0)
==> passed

Test 5: Calls to addLast(), removeFirst(), and isEmpty()
  *    5 random calls (0.0, 0.8, 0.1, 0.0, 0.1, 0.0)
  *   50 random calls (0.0, 0.8, 0.1, 0.0, 0.1, 0.0)
  *  500 random calls (0.0, 0.8, 0.1, 0.0, 0.1, 0.0)
  * 1000 random calls (0.0, 0.8, 0.1, 0.0, 0.1, 0.0)
  *    5 random calls (0.0, 0.1, 0.8, 0.0, 0.1, 0.0)
  *   50 random calls (0.0, 0.1, 0.8, 0.0, 0.1, 0.0)
  *  500 random calls (0.0, 0.1, 0.8, 0.0, 0.1, 0.0)
  * 1000 random calls (0.0, 0.1, 0.8, 0.0, 0.1, 0.0)
==> passed

Test 6: Calls to addFirst(), addLast(), removeFirst(),
        removeLast(), isEmpty(), and size().
  *    5 random calls (0.3, 0.3, 0.1, 0.1, 0.1, 0.1)
  *   50 random calls (0.3, 0.3, 0.1, 0.1, 0.1, 0.1)
  *  500 random calls (0.3, 0.3, 0.1, 0.1, 0.1, 0.1)
  * 1000 random calls (0.3, 0.3, 0.1, 0.1, 0.1, 0.1)
  *    5 random calls (0.1, 0.1, 0.3, 0.3, 0.1, 0.1)
  *   50 random calls (0.1, 0.1, 0.3, 0.3, 0.1, 0.1)
  *  500 random calls (0.1, 0.1, 0.3, 0.3, 0.1, 0.1)
  * 1000 random calls (0.1, 0.1, 0.3, 0.3, 0.1, 0.1)
==> passed

Test 7: Removing from an empty deque
  *  removeFirst()
  *  removeLast()
==> passed

Test 8: Create multiple deque objects at the same time
==> passed

Test 9: Check iterator() after calls only to addFirst()
==> passed

Test 10: Check iterator() after intermixed calls to addFirst(), addLast(),
         removeFirst(), and removeLast()
==> passed

Test 11: Create two nested iterators to same deque
  *  N = 10
  *  N = 1000
==> passed

Test 12: Create two parallel iterators to same deque
  *  N = 10
  *  N = 1000
==> passed

Test 13: Create Deque objects of different parameterized types
==> passed

Test 14: Check that addFirst() and addLast() each throw a NullPointerException
         when inserting null items
==> passed

Test 15: Check that remove() and next() throw the specified exceptions in iterator()
==> passed

Test 16: Check iterator() when Deque is empty
==> passed


Total: 16/16 tests passed!


================================================================

Testing methods in RandomizedQueue
*-----------------------------------------------------------
Running 18 total tests.

Tests 1-4 make random calls to enqueue(), dequeue(), sample(),
isEmpty(), and size(). The probabilities of each operation are
(p1, p2, p3, p4, p5), respectively.

Test 1: Calls to enqueue() and size().
  *     5 random calls (0.8, 0.0, 0.0, 0.0, 0.2)
  *    50 random calls (0.8, 0.0, 0.0, 0.0, 0.2)
  *   500 random calls (0.8, 0.0, 0.0, 0.0, 0.2)
  *  1000 random calls (0.8, 0.0, 0.0, 0.0, 0.2)
==> passed

Test 2: Calls to enqueue() and dequeue().
  *     5 random calls (0.7, 0.1, 0.0, 0.1, 0.1)
  *    50 random calls (0.7, 0.1, 0.0, 0.1, 0.1)
  *   500 random calls (0.7, 0.1, 0.0, 0.1, 0.1)
  *  1000 random calls (0.7, 0.1, 0.0, 0.1, 0.1)
  *     5 random calls (0.1, 0.7, 0.0, 0.1, 0.1)
  *    50 random calls (0.1, 0.7, 0.0, 0.1, 0.1)
  *   500 random calls (0.1, 0.7, 0.0, 0.1, 0.1)
  *  1000 random calls (0.1, 0.7, 0.0, 0.1, 0.1)
==> passed

Test 3: Calls to enqueue(), sample(), and size().
  *     5 random calls (0.8, 0.0, 0.1, 0.0, 0.1)
  *    50 random calls (0.8, 0.0, 0.1, 0.0, 0.1)
  *   500 random calls (0.8, 0.0, 0.1, 0.0, 0.1)
  *  1000 random calls (0.8, 0.0, 0.1, 0.0, 0.1)
  *     5 random calls (0.1, 0.0, 0.8, 0.0, 0.1)
  *    50 random calls (0.1, 0.0, 0.8, 0.0, 0.1)
  *   500 random calls (0.1, 0.0, 0.8, 0.0, 0.1)
  *  1000 random calls (0.1, 0.0, 0.8, 0.0, 0.1)
==> passed

Test 4: Calls to enqueue(), dequeue(), sample(), isEmpty(), and size().
  *     5 random calls (0.6, 0.1, 0.1, 0.1, 0.1)
  *    50 random calls (0.6, 0.1, 0.1, 0.1, 0.1)
  *   500 random calls (0.6, 0.1, 0.1, 0.1, 0.1)
  *  1000 random calls (0.6, 0.1, 0.1, 0.1, 0.1)
  *     5 random calls (0.1, 0.1, 0.6, 0.1, 0.1)
  *    50 random calls (0.1, 0.1, 0.6, 0.1, 0.1)
  *   500 random calls (0.1, 0.1, 0.6, 0.1, 0.1)
  *  1000 random calls (0.1, 0.1, 0.6, 0.1, 0.1)
==> passed

Test 5: dequeue() and sample() from an empty randomized queue
  *  dequeue()
  *  sample()
==> passed

Test 6: Create multiple randomized queue objects at the same time
==> passed

Test 7: Check that iterator() returns correct items after a sequence of
        enqueue() operations
==> passed

Test 8: Check that iterator() returns correct items after sequence of enqueue()
        and dequeue() operations
==> passed

Test 9: Create two nested iterators over same randomized queue
  *  N = 10
  *  N = 1000
==> passed

Test 10: Create two parallel iterators over same randomized queue
  *  N = 10
  *  N = 1000
==> passed

Test 11: Create two iterators over different randomized queues
==> passed

Test 12: Create RandomizedQueue objects of different parameterized types
==> passed

Test 13: Check randomness of sample() by enqueueing strings, repeatedly calling
         sample(), and counting the frequency of each value.
  *  Enqueue strings A to C and sampling 3000 times
  *  Enqueue strings A to E and sampling 5000 times
  *  Enqueue strings A to H and sampling 8000 times
  *  Enqueue strings A to J and sampling 10000 times
==> passed

Test 14: Check randomness of dequeue() by enqueueing items, repeatedly calling
         dequeue() until a specific enqueued string appears.
  *  Enqueue strings A to C and call dequeue() until C is dequeued; repeat 3000 times
  *  Enqueue strings A to E and call dequeue() until C is dequeued; repeat 5000 times
  *  Enqueue strings A to H and call dequeue() until G is dequeued; repeat 8000 times
  *  Enqueue strings A to J and call dequeue() until G is dequeued; repeat 10000 times
==> passed

Test 15: Check randomness of iterator() by enqueueing strings, getting an iterator()
         and repeatedly calling next() until a specific enqueued string appears.
  *  Enqueue strings A to C, create iterator(), and call next() until B is returned;
     Repeat 3000 times
  *  Enqueue strings A to E, create iterator(), and call next() until C is returned;
     Repeat 5000 times
  *  Enqueue strings A to H, create iterator(), and call next() until C is returned;
     Repeat 8000 times
  *  Enqueue strings A to J, create iterator(), and call next() until D is returned;
     Repeat 10000 times
==> passed

Test 16: Check that NullPointerException is thrown when inserting null items
==> passed

Test 17: Check that remove() and next() throw the specified exceptions in iterator()
==> passed

Test 18: Check iterator() when RandomizedQueue is empty
==> passed


Total: 18/18 tests passed!


================================================================

******************************************************************************
*          correctness (substituting reference RandomizedQueue.java and Deque.java)
******************************************************************************

Testing methods in Subset
*-----------------------------------------------------------
Tests 1-3 call the main() function directly, resetting standard input
before each call.

Running 3 total tests.

Test 1: assignment inputs

% echo "A B C D E F G H I" | java Subset 3
[student solution]
F
D
G

% echo "A B C D E F G H I" | java Subset 3
[student solution]
D
H
I

% echo "AA BB BB BB BB BB CC CC " | java Subset 8
[student solution]
BB
CC
BB
BB
CC
AA
BB
BB

==> passed

Test 2: various inputs

% echo "A B C D E F G H I" | java Subset 1
[student solution]
D

% echo "A B C D E F G H I" | java Subset 5
[student solution]
C
B
A
F
D

% echo "A B C D E F G H I" | java Subset 5
[student solution]
D
H
I
G
A

% echo "A B C D E F G H I" | java Subset 9
[student solution]
D
G
I
E
B
A
F
H
C

% echo "A B C D E F G H I" | java Subset 0
[student solution]

% echo "it was the best of times it was the worst of times" | java Subset 10
[student solution]
times
best
worst
it
was
of
times
of
the
it

% echo "It was the best of times, it was the worst of times, it was ..." | java Subset 10
[student solution]
of
times,
times,
it
best
was
It
the
the
worst

% echo "AA BB BB BB BB BB CC CC " | java Subset 7
[student solution]
BB
CC
AA
BB
BB
CC
BB

==> passed

Test 3: check that subsets are uniformly random
  * 1000 subsets of size 1 from subset10.txt
  * 250 subsets of size 4 from subset10.txt
  * 600 subsets of size 1 from subset6.txt
  * 300 subsets of size 2 from subset6.txt
  * 800 subsets of size 1 from subset8.txt
  * 160 subsets of size 5 from subset8.txt
==> passed

Total: 3/3 tests passed!


================================================================

******************************************************************************
*          MEMORY
******************************************************************************

Computing memory of Subset
*-----------------------------------------------------------
Running 2 total tests.

Test 1: Check that only one Deque or RandomizedQueue object is created
  * filename = subset9.txt, N = 9, k = 1
  * filename = subset9.txt, N = 9, k = 2
  * filename = subset9.txt, N = 9, k = 4
  * filename = tinyTale.txt, N = 12, k = 10
  * filename = tale.txt, N = 138653, k = 50
     java.util.NoSuchElementException: Randomized queue underflow

     RandomizedQueue.dequeue(RandomizedQueue.java:91)
     Subset.main(Subset.java:22)
     MemoryOfSubset.numberOfObjects(MemoryOfSubset.java:27)
     MemoryOfSubset.test1(MemoryOfSubset.java:151)
     MemoryOfSubset.main(MemoryOfSubset.java:189)

==> FAILED

Test 2: Check that the maximum size of any Deque or RandomizedQueue object
        created is <= N
  * filename = subset9.txt, N = 9, k = 1
  * filename = subset9.txt, N = 9, k = 2
  * filename = subset9.txt, N = 9, k = 4
  * filename = tinyTale.txt, N = 12, k = 10
  * filename = tale.txt, N = 138653, k = 5
  * filename = tale.txt, N = 138653, k = 50
     java.util.NoSuchElementException: Randomized queue underflow

     RandomizedQueue.dequeue(RandomizedQueue.java:91)
     Subset.main(Subset.java:22)
     MemoryOfSubset.maxSize(MemoryOfSubset.java:63)
     MemoryOfSubset.test2(MemoryOfSubset.java:163)
     MemoryOfSubset.main(MemoryOfSubset.java:190)

  * filename = tale.txt, N = 138653, k = 500
     java.util.NoSuchElementException: Randomized queue underflow

     RandomizedQueue.dequeue(RandomizedQueue.java:91)
     Subset.main(Subset.java:22)
     MemoryOfSubset.maxSize(MemoryOfSubset.java:63)
     MemoryOfSubset.test2(MemoryOfSubset.java:164)
     MemoryOfSubset.main(MemoryOfSubset.java:190)

  * filename = tale.txt, N = 138653, k = 5000
     java.util.NoSuchElementException: Randomized queue underflow

     RandomizedQueue.dequeue(RandomizedQueue.java:91)
     Subset.main(Subset.java:22)
     MemoryOfSubset.maxSize(MemoryOfSubset.java:63)
     MemoryOfSubset.test2(MemoryOfSubset.java:165)
     MemoryOfSubset.main(MemoryOfSubset.java:190)

  * filename = tale.txt, N = 138653, k = 50000
     java.util.NoSuchElementException: Randomized queue underflow

     RandomizedQueue.dequeue(RandomizedQueue.java:91)
     Subset.main(Subset.java:22)
     MemoryOfSubset.maxSize(MemoryOfSubset.java:63)
     MemoryOfSubset.test2(MemoryOfSubset.java:166)
     MemoryOfSubset.main(MemoryOfSubset.java:190)

==> FAILED

Test 3 (bonus): Check that maximum size of any or Deque or RandomizedQueue object
                created is <= k
  * filename = tale.txt, N = 138653, k = 5
    - max size of RandomizedQueue object = 12
  * filename = tale.txt, N = 138653, k = 50
     java.util.NoSuchElementException: Randomized queue underflow

     RandomizedQueue.dequeue(RandomizedQueue.java:91)
     Subset.main(Subset.java:22)
     MemoryOfSubset.maxSizeBonus(MemoryOfSubset.java:111)
     MemoryOfSubset.test3(MemoryOfSubset.java:175)
     MemoryOfSubset.main(MemoryOfSubset.java:191)

  * filename = tale.txt, N = 138653, k = 500
     java.util.NoSuchElementException: Randomized queue underflow

     RandomizedQueue.dequeue(RandomizedQueue.java:91)
     Subset.main(Subset.java:22)
     MemoryOfSubset.maxSizeBonus(MemoryOfSubset.java:111)
     MemoryOfSubset.test3(MemoryOfSubset.java:176)
     MemoryOfSubset.main(MemoryOfSubset.java:191)

  * filename = tale.txt, N = 138653, k = 5000
     java.util.NoSuchElementException: Randomized queue underflow

     RandomizedQueue.dequeue(RandomizedQueue.java:91)
     Subset.main(Subset.java:22)
     MemoryOfSubset.maxSizeBonus(MemoryOfSubset.java:111)
     MemoryOfSubset.test3(MemoryOfSubset.java:177)
     MemoryOfSubset.main(MemoryOfSubset.java:191)

  * filename = tale.txt, N = 138653, k = 50000
     java.util.NoSuchElementException: Randomized queue underflow

     RandomizedQueue.dequeue(RandomizedQueue.java:91)
     Subset.main(Subset.java:22)
     MemoryOfSubset.maxSizeBonus(MemoryOfSubset.java:111)
     MemoryOfSubset.test3(MemoryOfSubset.java:178)
     MemoryOfSubset.main(MemoryOfSubset.java:191)

==> FAILED

Total: 0/2 tests passed!

================================================================



******************************************************************************
*          MEMORY
******************************************************************************

Computing memory of Deque
*-----------------------------------------------------------
For tests 1-4, the maximum amount of memory allowed for a deque
containing N items is 48N + 192.

Running 28 total tests.

Test 1a-1e: Total memory usage after inserting N items,
            where N is a power of 2.

                 N        bytes
----------------------------------------------------------
=> passed        8          424         
=> passed       64         3112         
=> passed      256        12328         
=> passed     1024        49192         
=> passed     4096       196648         
==> 5/5 tests passed

Memory: 48.00 N + 40.00   (R^2 = 1.000)



Test 2a-2e: Total memory usage after inserting N+1 items,
            where N is a power of 2.

                 N        bytes
----------------------------------------------------------
=> passed        8          472         
=> passed       64         3160         
=> passed      256        12376         
=> passed     1024        49240         
=> passed     4096       196696         
==> 5/5 tests passed

Memory after adding N = 2^i + 1 items: 48.00 N + 40.00   (R^2 = 1.000)



Test 3a-3e: Total memory usage after inserting 2N+1 items
            and deleting N items, where N is a power of 2.

                 N        bytes
----------------------------------------------------------
=> passed        8          472         
=> passed       64         3160         
=> passed      256        12376         
=> passed     1024        49240         
=> passed     4096       196696         
==> 5/5 tests passed

Memory: 48.00 N + 40.00   (R^2 = 1.000)



Test 4a-4e: Total memory usage after inserting N items and then
            deleting all but one item, where N is a power of 2.
            (should not grow with N or be too large of a constant)

                 N        bytes
----------------------------------------------------------
=> passed        8           88         
=> passed       64           88         
=> passed      256           88         
=> passed     1024           88         
=> passed     4096           88         
==> 5/5 tests passed

Memory after adding N = 2^i items: 88.00   (R^2 = 1.000)



Test 5a-5e: Total memory usage of iterator after inserting N items.
            (should not grow with N or be too large of a constant)

                 N        bytes
----------------------------------------------------------
=> passed        8           32         
=> passed       64           32         
=> passed      256           32         
=> passed     1024           32         
=> passed     4096           32         
==> 5/5 tests passed

Memory of iterator after adding N = 2^i items: 32.00   (R^2 = 1.000)



Test 6a: Insert N strings; delete them one at a time, checking for
         loitering after each deletion. The probabilities of addFirst()
         and addLast() are (p1, p2), respectively. The probabilities of
         removeFirst() and removeLast() are (q1, q2), respectively
  * 100 random insertions (1.0, 0.0) and 100 random deletions (1.0, 0.0)
  * 100 random insertions (1.0, 0.0) and 100 random deletions (0.0, 1.0)
  * 100 random insertions (0.0, 1.0) and 100 random deletions (1.0, 0.0)
  * 100 random insertions (0.0, 1.0) and 100 random deletions (0.0, 1.0)
  * 100 random insertions (0.5, 0.5) and 100 random deletions (0.5, 0.5)
==> passed

Test 6b: Perform random operations, checking for loitering after
         each operation. The probabilities of addFirst(), addLast(),
         removeFirst(), and removeLast() are (p1, p2, p3, p4),
         respectively.
  * 100 random operations (0.8, 0.0, 0.2, 0.0)
  * 100 random operations (0.8, 0.0, 0.0, 0.2)
  * 100 random operations (0.0, 0.8, 0.2, 0.0)
  * 100 random operations (0.0, 0.8, 0.0, 0.2)
  * 100 random operations (0.4, 0.4, 0.1, 0.1)
  * 100 random operations (0.2, 0.2, 0.3, 0.3)
==> passed

Test 7: Worst-case constant memory allocated or deallocated
        per deque operation?
  * 128 random operations
  * 256 random operations
  * 512 random operations
==> passed

Total: 28/28 tests passed!

================================================================



Computing memory of RandomizedQueue
*-----------------------------------------------------------
For tests 1-4, the maximum amount of memory allowed for a
randomized queue containing N items is 48N + 192.

Running 23 total tests.

Test 1a-1d: Total memory usage after inserting N integers.

                 N        bytes
----------------------------------------------------------
=> passed       64          568         
=> passed      256         2104         
=> passed     1024         8248         
=> passed     4096        32824         
==> 4/4 tests passed


Memory: 8.00 N + 56.00   (R^2 = 1.000)



Test 2a-2d: Total memory usage after inserting N+1 items.

                 N        bytes
----------------------------------------------------------
=> passed       64         1080         
=> passed      256         4152         
=> passed     1024        16440         
=> passed     4096        65592         
==> 4/4 tests passed


Memory: 16.00 N + 40.00   (R^2 = 1.000)



Test 3a-3d: Total memory usage after inserting 2N+1 items, and
            then deleting N items.

                 N        bytes
----------------------------------------------------------
=> passed       64         2104         
=> passed      256         8248         
=> passed     1024        32824         
=> passed     4096       131128         
==> 4/4 tests passed


Memory: 32.00 N + 24.00   (R^2 = 1.000)



Test 4a-4d: Total memory usage after inserting N items, and
            then deleting all but one item.

                 N        bytes
----------------------------------------------------------
=> passed       64           72         
=> passed      256           72         
=> passed     1024           72         
=> passed     4096           72         
==> 4/4 tests passed


Memory: 72.00   (R^2 = 1.000)



Test 5a-5d: Total memory usage of iterator after inserting N items.

                 N        bytes
----------------------------------------------------------
=> passed       64          320         
=> passed      256         1088         
=> passed     1024         4160         
=> passed     4096        16448         
==> 4/4 tests passed


Memory: 4.00 N + 64.00   (R^2 = 1.000)



Test 6a: Insert 100 strings; delete them one at a time, checking
         for loitering after each deletion.
==> passed

Test 6b: Perform random operations, checking for loitering after
         each operation. The probabilities of enqueue(), dequeue(),
         and sample() are (p1, p2, p3), respectively.
  * 200 random operations (0.8, 0.2, 0.0)
  * 200 random operations (0.2, 0.8, 0.0)
  * 200 random operations (0.6, 0.2, 0.2)
  * 200 random operations (0.2, 0.4, 0.4)
==> passed

Test 7: Insert T items into queue; then iterate over queue and check
        that worst-case constant memory is allocated or deallocated
        per iterator operation.
  * T = 64
  * T = 128
  * T = 256
==> passed

Total: 23/23 tests passed!

================================================================



******************************************************************************
*          TIMING
******************************************************************************

Timing Deque
*-----------------------------------------------------------
Running 31 total tests.

Test 1a-1g:  N random calls to addFirst(), addLast(), removeFirst(),
             and removeLast().

                    N  seconds
------------------------------
=> passed        1024     0.00
=> passed        2048     0.00
=> passed        4096     0.00
=> passed        8192     0.00
=> passed       16384     0.00
=> passed       32768     0.01
=> passed       65536     0.01
=> passed      128000     0.01
=> passed      256000     0.01
=> passed      512000     0.04
=> passed     1024000     0.09
=> passed     2048000     0.11
==> 12/12 tests passed


Test 2a-2g:  Create deque of N objects, then iterate over the N objects
             by calling next() and hasNext().

                    N  seconds
------------------------------
=> passed        1024     0.00
=> passed        2048     0.00
=> passed        4096     0.00
=> passed        8192     0.00
=> passed       16384     0.00
=> passed       32768     0.00
=> passed       65536     0.00
=> passed      128000     0.00
=> passed      256000     0.00
=> passed      512000     0.01
=> passed     1024000     0.02
=> passed     2048000     0.09
==> 12/12 tests passed


Test 3a-3g:  Create deque of N objects, then interleave N calls each to
             removeFirst()/removeLast() and addFirst()/addLast().

                    N  seconds
----------------------------------
=> passed        1025     0.00
=> passed        2049     0.00
=> passed        4097     0.00
=> passed       16385     0.00
=> passed       32767     0.01
=> passed       32768     0.01
=> passed       32769     0.00
==> 7/7 tests passed

Total: 31/31 tests passed!
================================================================



Timing RandomizedQueue
*-----------------------------------------------------------
Running 31 total tests.

Test 1a-1g:  N random calls to enqueue(), sample(), dequeue(),
             isEmpty(), and size().

                    N  seconds
----------------------------------
=> passed        1024     0.00
=> passed        2048     0.00
=> passed        4096     0.00
=> passed        8192     0.00
=> passed       16384     0.00
=> passed       32768     0.01
=> passed       65536     0.01
=> passed      128000     0.02
=> passed      256000     0.03
=> passed      512000     0.06
=> passed     1024000     0.17
=> passed     2048000     0.32
==> 12/12 tests passed


Test 2a-2g:  Create randomized queue of N objects, then iterate
             over the N objects by calling next() and hasNext().

                    N  seconds
----------------------------------
=> passed        1024     0.00
=> passed        2048     0.00
=> passed        4096     0.00
=> passed        8192     0.00
=> passed       16384     0.00
=> passed       32768     0.00
=> passed       65536     0.01
=> passed      128000     0.01
=> passed      256000     0.02
=> passed      512000     0.04
=> passed     1024000     0.07
=> passed     2048000     0.16
==> 12/12 tests passed


Test 3a-3g:  Create randomized queue of N objects, then interleave
             N calls each to dequeue() and enqueue().

                    N  seconds
----------------------------------
=> passed        1025     0.00
=> passed        2049     0.00
=> passed        4097     0.00
=> passed       16385     0.00
=> passed       32767     0.00
=> passed       32768     0.00
=> passed       32769     0.00
==> 7/7 tests passed

Total: 31/31 tests passed!
================================================================
```
