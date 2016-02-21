```text
Assessment Summary
Compilation:  PASSED
Style:        FAILED
Findbugs:     No potential bugs found.
API:          PASSED

Correctness:  42/42 tests passed
Memory:       8/8 tests passed
Timing:       17/17 tests passed

Aggregate score: 100.00% [Correctness: 65%, Memory: 10%, Timing: 25%, Style: 0%]
Assessment Details
The following files were submitted:
----------------------------------
total 24K
-rw-r--r-- 1 7.4K Feb 21 12:31 Board.java
-rw-r--r-- 1 4.2K Feb 21 12:31 Solver.java
drwxr-xr-x 2 4.0K Feb 21 12:31 __MACOSX
-rw-r--r-- 1 3.9K Feb 21 12:31 studentSubmission.zip


********************************************************************************
*          COMPILING                                                           *
********************************************************************************


% javac Board.java
*-----------------------------------------------------------

================================================================

% javac Solver.java
*-----------------------------------------------------------

================================================================



% checkstyle *.java
*-----------------------------------------------------------
Board.java:4:1: Unnecessary import statement for 'java.lang.StringBuilder' because it is from the package 'java.lang'.
Board.java:14:12: 'for' is not followed by whitespace.
Board.java:27:17: Method 'element_manhattan' should start with a lowercase letter and use camelCase.
Board.java:39:12: 'for' is not followed by whitespace.
Board.java:40:16: 'for' is not followed by whitespace.
Board.java:41:19: 'if' is not followed by whitespace.
Board.java:52:12: 'for' is not followed by whitespace.
Board.java:53:16: 'for' is not followed by whitespace.
Board.java:54:19: 'if' is not followed by whitespace.
Board.java:55: Line is longer than 128 characters (currently 155).
Board.java:69:12: 'for' is not followed by whitespace.
Board.java:70:16: 'for' is not followed by whitespace.
Board.java:71:19: 'if' is not followed by whitespace.
Board.java:77:12: 'for' is not followed by whitespace.
Board.java:78:15: 'if' is not followed by whitespace.
Board.java:93:12: 'for' is not followed by whitespace.
Board.java:94:16: 'for' is not followed by whitespace.
Board.java:95:19: 'if' is not followed by whitespace.
Board.java:100:19: 'if' is not followed by whitespace.
Board.java:115:11: 'if' is not followed by whitespace.
Board.java:116:11: 'if' is not followed by whitespace.
Board.java:117:11: 'if' is not followed by whitespace.
Board.java:122:11: 'if' is not followed by whitespace.
Board.java:124:12: 'for' is not followed by whitespace.
Board.java:125:16: 'for' is not followed by whitespace.
Board.java:126:19: 'if' is not followed by whitespace.
Board.java:141:12: 'for' is not followed by whitespace.
Board.java:142:16: 'for' is not followed by whitespace.
Board.java:143:19: 'if' is not followed by whitespace.
Board.java:149:11: 'if' is not followed by whitespace.
Board.java:149:34: '{' is not preceded with whitespace.
Board.java:155:11: 'if' is not followed by whitespace.
Board.java:155:18: '{' is not preceded with whitespace.
Board.java:161:11: 'if' is not followed by whitespace.
Board.java:161:34: '{' is not preceded with whitespace.
Board.java:167:11: 'if' is not followed by whitespace.
Board.java:167:18: '{' is not preceded with whitespace.
Board.java:180:12: 'for' is not followed by whitespace.
Board.java:232:12: 'for' is not followed by whitespace.
Solver.java:17:41: Parameter 'Bo' should start with a lowercase letter and use camelCase.
Solver.java:35:11: 'if' is not followed by whitespace.
Solver.java:48:14: 'while' is not followed by whitespace.
Solver.java:49:16: 'for' is not followed by whitespace.
Solver.java:50:19: 'if' is not followed by whitespace.
Solver.java:51:23: 'if' is not followed by whitespace.
Solver.java:61:16: 'for' is not followed by whitespace.
Solver.java:62:19: 'if' is not followed by whitespace.
Solver.java:63:23: 'if' is not followed by whitespace.
Solver.java:73:11: 'if' is not followed by whitespace.
Solver.java:90:11: 'if' is not followed by whitespace.
Solver.java:99:11: 'if' is not followed by whitespace.
Solver.java:102:18: 'while' is not followed by whitespace.
Checkstyle ends with 52 errors.

================================================================


% findbugs *.class
*-----------------------------------------------------------

================================================================


Testing the APIs of your programs.
*-----------------------------------------------------------
Board:

Solver:

================================================================


******************************************************************************
*          CORRECTNESS
******************************************************************************

Testing methods in Board
*-----------------------------------------------------------
Running 22 total tests.

Tests 5, 6, 13, and 14 rely upon toString() returning results in prescribed format.

Test 1a: Test hamming() with file inputs
  *  puzzle04.txt
  *  puzzle00.txt
  *  puzzle07.txt
  *  puzzle17.txt
  *  puzzle27.txt
  *  puzzle2x2-unsolvable1.txt
==> passed

Test 1b: Test hamming() with random N-by-N boards
  *  2-by-2
  *  3-by-3
  *  4-by-4
  *  5-by-5
  *  9-by-9
  *  10-by-10
  *  127-by-127
==> passed

Test 2a: Test manhattan() with file inputs
  *  puzzle04.txt
  *  puzzle00.txt
  *  puzzle07.txt
  *  puzzle17.txt
  *  puzzle27.txt
  *  puzzle2x2-unsolvable1.txt
==> passed

Test 2b: Test manhattan() with random N-by-N boards
  *  2-by-2
  *  3-by-3
  *  4-by-4
  *  5-by-5
  *  9-by-9
  *  10-by-10
  *  127-by-127
==> passed

Test 3: Test dimension() with random N-by-N boards
  *  2-by-2
  *  3-by-3
  *  4-by-4
  *  5-by-5
==> passed

Test 4a: Test toString() with file inputs
  *  puzzle04.txt
  *  puzzle00.txt
  *  puzzle06.txt
  *  puzzle09.txt
  *  puzzle23.txt
  *  puzzle2x2-unsolvable1.txt
==> passed

Test 4b: Test toString() with random N-by-N boards
  *  2-by-2
  *  3-by-3
  *  4-by-4
  *  5-by-5
  *  9-by-9
  *  10-by-10
  *  127-by-127
==> passed

Test 5a: Test neighbors() with file inputs
  *  puzzle04.txt
  *  puzzle00.txt
  *  puzzle06.txt
  *  puzzle09.txt
  *  puzzle23.txt
  *  puzzle2x2-unsolvable1.txt
==> passed

Test 5b: Test neighbors() with random N-by-N boards
  *  2-by-2
  *  3-by-3
  *  4-by-4
  *  5-by-5
  *  9-by-9
  *  10-by-10
  *  127-by-127
==> passed

Test 6a: Test neighbors() of neigbors() with file inputs
  *  puzzle04.txt
  *  puzzle00.txt
  *  puzzle06.txt
  *  puzzle09.txt
  *  puzzle23.txt
  *  puzzle2x2-unsolvable1.txt
==> passed

Test 6b: Test neighbors() of neighbors() with random N-by-N boards
  *  2-by-2
  *  3-by-3
  *  4-by-4
  *  5-by-5
  *  9-by-9
  *  10-by-10
==> passed

Test 7a: Test twin() with file inputs
  *  puzzle04.txt
  *  puzzle00.txt
  *  puzzle06.txt
  *  puzzle09.txt
  *  puzzle23.txt
  *  puzzle2x2-unsolvable1.txt
==> passed

Test 7b: Test twin() with random N-by-N boards
  *  2-by-2
  *  3-by-3
  *  4-by-4
  *  5-by-5
  *  9-by-9
  *  10-by-10
==> passed

Test 8a: Test isGoal() on file inputs
  *  puzzle00.txt
  *  puzzle04.txt
  *  puzzle16.txt
  *  puzzle06.txt
  *  puzzle09.txt
  *  puzzle23.txt
  *  puzzle2x2-unsolvable1.txt
  *  puzzle3x3-unsolvable1.txt
  *  puzzle3x3-00.txt
  *  puzzle4x4-00.txt
==> passed

Test 8b: Test isGoal() on N-by-N goal boards
  *  2-by-2
  *  3-by-3
  *  4-by-4
  *  5-by-5
  *  6-by-6
  *  100-by-100
==> passed

Test 9: Check whether two Board objects can be created at the same time
  *   random 3-by-3 and 3-by-3 boards
  *   random 4-by-4 and 4-by-4 boards
  *   random 2-by-2 and 2-by-2 boards
  *   random 3-by-3 and 4-by-4 boards
  *   random 4-by-4 and 3-by-3 boards
==> passed

Test 10a: Check equals()
  *  reflexive
  *  symmetric
  *  checks that individual entries of array are equal
  *  argument is object of type String
  *  argument is object of type Object
  *  argument is null
  *  argument is Board of different dimension
==> passed

Test 10b: Test equals() on M-by-M vs. N-by-N goal boards
  *  M = 2, N = 2
  *  M = 3, N = 3
  *  M = 4, N = 4
  *  M = 2, N = 5
  *  M = 5, N = 2
==> passed

Test 11: Check that Board is immutable by changing argument array after
         construction and making sure Board does not mutate
==> passed

Test 12: Check that Board is immutable by testing whether methods
         return the same value, regardless of order in which called
  *  puzzle10.txt
  *  puzzle20.txt
  *  puzzle30.txt
  *  2-by-2
  *  3-by-3
  *  4-by-4
==> passed

Test 13: Call hamming() on a board that is kth-neighbor of a board
  * 0th neighbor of puzzle27.txt
  * 1th neighbor of puzzle27.txt
  * 2th neighbor of puzzle27.txt
  * 13th neighbor of puzzle27.txt
  * 13th neighbor of puzzle00.txt
  * 13th neighbor of puzzle2x2-unsolvable1.txt
==> passed

Test 14: Call manhattan() on a board that is a kth-neighbor of a board
  * 0th neighbor of puzzle27.txt
  * 1th neighbor of puzzle27.txt
  * 2th neighbor of puzzle27.txt
  * 13th neighbor of puzzle27.txt
  * 13th neighbor of puzzle00.txt
  * 13th neighbor of puzzle2x2-unsolvable1.txt
==> passed


Total: 22/22 tests passed!


================================================================

******************************************************************************
*          correctness (substituting reference Board.java)
******************************************************************************

Testing methods in Solver
*-----------------------------------------------------------
Running 20 total tests.

Test 1: Call moves() with file inputs
  *  puzzle00.txt
  *  puzzle01.txt
  *  puzzle02.txt
  *  puzzle03.txt
  *  puzzle04.txt
  *  puzzle05.txt
  *  puzzle06.txt
  *  puzzle07.txt
  *  puzzle08.txt
  *  puzzle09.txt
  *  puzzle10.txt
  *  puzzle11.txt
  *  puzzle12.txt
  *  puzzle13.txt
==> passed

Test 2: Call solution() with file inputs
  *  puzzle00.txt
  *  puzzle01.txt
  *  puzzle02.txt
  *  puzzle03.txt
  *  puzzle04.txt
  *  puzzle05.txt
  *  puzzle06.txt
  *  puzzle07.txt
  *  puzzle08.txt
  *  puzzle10.txt
  *  puzzle15.txt
==> passed

Test 3: Create two Solver objects at the same time
  *  puzzle04.txt and puzzle04.txt
  *  puzzle00.txt and puzzle04.txt
  *  puzzle04.txt and puzzle00.txt
==> passed

Test 4a: Call isSolvable() with file inputs
  *  puzzle01.txt
  *  puzzle03.txt
  *  puzzle04.txt
  *  puzzle17.txt
  *  puzzle3x3-unsolvable1.txt
  *  puzzle3x3-unsolvable2.txt
  *  puzzle4x4-unsolvable.txt
==> passed

Test 4b: Call isSolvable() on random N-by-N puzzles
  *  100 random 2-by-2 boards
==> passed

Test 5: Call moves() on unsolvable puzzles
  *  puzzle2x2-unsolvable1.txt
  *  puzzle2x2-unsolvable2.txt
  *  puzzle3x3-unsolvable1.txt
  *  puzzle3x3-unsolvable2.txt
  *  puzzle4x4-unsolvable.txt
==> passed

Test 6: Call solution() on unsolvable puzzles
  *  puzzle2x2-unsolvable1.txt
  *  puzzle2x2-unsolvable2.txt
  *  puzzle3x3-unsolvable1.txt
  *  puzzle3x3-unsolvable2.txt
  *  puzzle4x4-unsolvable.txt
==> passed

Test 7a: Check that Solver is immutable by testing whether methods
         return the same value, regardless of order in which called
  *  puzzle3x3-00.txt
  *  puzzle3x3-01.txt
  *  puzzle3x3-05.txt
  *  puzzle3x3-10.txt
  *  random 2-by-2 solvable boards
==> passed

Test 7b: Check that Solver is immutable by testing whether methods
         return the same value, regardless of order in which called
  *  puzzle3x3-unsolvable1.txt
  *  puzzle3x3-unsolvable2.txt
  *  puzzle4x4-unsolvable.txt
  *  random 2-by-2 unsolvable boards
==> passed

Test 8: Call moves() with more file inputs
  *  puzzle14.txt
  *  puzzle15.txt
  *  puzzle16.txt
  *  puzzle17.txt
  *  puzzle18.txt
  *  puzzle19.txt
  *  puzzle20.txt
  *  puzzle21.txt
  *  puzzle22.txt
  *  puzzle23.txt
  *  puzzle24.txt
  *  puzzle25.txt
  *  puzzle26.txt
  *  puzzle27.txt
  *  puzzle28.txt
  *  puzzle29.txt
  *  puzzle30.txt
  *  puzzle31.txt
==> passed

Test 9: Check whether equals() method in Board is called
        with an argument of the wrong type
  *  puzzle00.txt
  *  puzzle05.txt
  *  puzzle10.txt
  *  puzzle15.txt
==> passed

Test 10: Check that constructor throws exception if board is null
==> passed

Test 11: Check for fragile dependence on toString()
  *  puzzle00.txt
  *  puzzle04.txt
  *  puzzle08.txt
  *  puzzle12.txt
==> passed

Test 12a: Call moves() with 2-by-2 file inputs
  *  puzzle2x2-00.txt
  *  puzzle2x2-01.txt
  *  puzzle2x2-02.txt
  *  puzzle2x2-03.txt
  *  puzzle2x2-04.txt
  *  puzzle2x2-05.txt
  *  puzzle2x2-06.txt
==> passed

Test 12b: Call solution() with 2-by-2 file inputs
  *  puzzle2x2-00.txt
  *  puzzle2x2-01.txt
  *  puzzle2x2-02.txt
  *  puzzle2x2-03.txt
  *  puzzle2x2-04.txt
  *  puzzle2x2-05.txt
  *  puzzle2x2-06.txt
==> passed

Test 13a: Call moves() with 3-by-3 file inputs
  *  puzzle3x3-00.txt
  *  puzzle3x3-01.txt
  *  puzzle3x3-02.txt
  *  puzzle3x3-03.txt
  *  puzzle3x3-04.txt
  *  puzzle3x3-05.txt
  *  puzzle3x3-06.txt
  *  puzzle3x3-07.txt
  *  puzzle3x3-08.txt
  *  puzzle3x3-09.txt
  *  puzzle3x3-10.txt
  *  puzzle3x3-11.txt
  *  puzzle3x3-12.txt
  *  puzzle3x3-13.txt
  *  puzzle3x3-14.txt
  *  puzzle3x3-15.txt
  *  puzzle3x3-16.txt
  *  puzzle3x3-17.txt
  *  puzzle3x3-18.txt
  *  puzzle3x3-19.txt
  *  puzzle3x3-20.txt
  *  puzzle3x3-21.txt
  *  puzzle3x3-22.txt
  *  puzzle3x3-23.txt
  *  puzzle3x3-24.txt
  *  puzzle3x3-25.txt
  *  puzzle3x3-26.txt
  *  puzzle3x3-27.txt
  *  puzzle3x3-28.txt
  *  puzzle3x3-29.txt
  *  puzzle3x3-30.txt
==> passed

Test 13b: Call solution() with 3-by-3 file inputs
  *  puzzle3x3-00.txt
  *  puzzle3x3-01.txt
  *  puzzle3x3-02.txt
  *  puzzle3x3-03.txt
  *  puzzle3x3-04.txt
  *  puzzle3x3-05.txt
  *  puzzle3x3-06.txt
  *  puzzle3x3-07.txt
  *  puzzle3x3-08.txt
  *  puzzle3x3-09.txt
  *  puzzle3x3-10.txt
  *  puzzle3x3-11.txt
  *  puzzle3x3-12.txt
  *  puzzle3x3-13.txt
  *  puzzle3x3-14.txt
  *  puzzle3x3-15.txt
  *  puzzle3x3-16.txt
  *  puzzle3x3-17.txt
  *  puzzle3x3-18.txt
  *  puzzle3x3-19.txt
  *  puzzle3x3-20.txt
  *  puzzle3x3-21.txt
  *  puzzle3x3-22.txt
  *  puzzle3x3-23.txt
  *  puzzle3x3-24.txt
  *  puzzle3x3-25.txt
  *  puzzle3x3-26.txt
  *  puzzle3x3-27.txt
  *  puzzle3x3-28.txt
  *  puzzle3x3-29.txt
  *  puzzle3x3-30.txt
==> passed

Test 14a: Call moves() with 4-by-4 file inputs
  *  puzzle4x4-00.txt
  *  puzzle4x4-01.txt
  *  puzzle4x4-02.txt
  *  puzzle4x4-03.txt
  *  puzzle4x4-04.txt
  *  puzzle4x4-05.txt
  *  puzzle4x4-06.txt
  *  puzzle4x4-07.txt
  *  puzzle4x4-08.txt
  *  puzzle4x4-09.txt
  *  puzzle4x4-10.txt
  *  puzzle4x4-11.txt
  *  puzzle4x4-12.txt
  *  puzzle4x4-13.txt
  *  puzzle4x4-14.txt
  *  puzzle4x4-15.txt
  *  puzzle4x4-16.txt
  *  puzzle4x4-17.txt
  *  puzzle4x4-18.txt
  *  puzzle4x4-19.txt
  *  puzzle4x4-20.txt
  *  puzzle4x4-21.txt
  *  puzzle4x4-22.txt
  *  puzzle4x4-23.txt
  *  puzzle4x4-24.txt
  *  puzzle4x4-25.txt
  *  puzzle4x4-26.txt
  *  puzzle4x4-27.txt
  *  puzzle4x4-28.txt
  *  puzzle4x4-29.txt
  *  puzzle4x4-30.txt
==> passed

Test 14b: Call solution() with 4-by-4 file inputs
  *  puzzle4x4-00.txt
  *  puzzle4x4-01.txt
  *  puzzle4x4-02.txt
  *  puzzle4x4-03.txt
  *  puzzle4x4-04.txt
  *  puzzle4x4-05.txt
  *  puzzle4x4-06.txt
  *  puzzle4x4-07.txt
  *  puzzle4x4-08.txt
  *  puzzle4x4-09.txt
  *  puzzle4x4-10.txt
  *  puzzle4x4-11.txt
  *  puzzle4x4-12.txt
  *  puzzle4x4-13.txt
  *  puzzle4x4-14.txt
  *  puzzle4x4-15.txt
  *  puzzle4x4-16.txt
  *  puzzle4x4-17.txt
  *  puzzle4x4-18.txt
  *  puzzle4x4-19.txt
  *  puzzle4x4-20.txt
  *  puzzle4x4-21.txt
  *  puzzle4x4-22.txt
  *  puzzle4x4-23.txt
  *  puzzle4x4-24.txt
  *  puzzle4x4-25.txt
  *  puzzle4x4-26.txt
  *  puzzle4x4-27.txt
  *  puzzle4x4-28.txt
  *  puzzle4x4-29.txt
  *  puzzle4x4-30.txt
==> passed

Test 15: Call moves() with random solvable N-by-N boards
  *  100 random 2-by-2 boards
  *  200 random 3-by-3 boards that are <= 20 moves from goal
  *  200 random 4-by-4 boards that are <= 20 moves from goal
  *  200 random 5-by-5 boards that are <= 20 moves from goal
==> passed


Total: 20/20 tests passed!


================================================================

******************************************************************************
*          MEMORY
******************************************************************************

Computing memory of Board
*-----------------------------------------------------------
Running 8 total tests.

Memory usage of an N-by-N board

              N       student (bytes)    reference (bytes)
----------------------------------------------------------
=> passed     4           240                  240
=> passed     8           560                  560
=> passed    12          1008                 1008
=> passed    16          1584                 1584
=> passed    20          2288                 2288
=> passed    36          6384                 6384
=> passed    72         23088                23088
=> passed   120         61488                61488
==> 8/8 tests passed

Total: 8/8 tests passed!

Student   memory = 4.00 N^2 + 32.00 N + 48.00   (R^2 = 1.000)
Reference memory = 4.00 N^2 + 32.00 N + 48.00   (R^2 = 1.000)

================================================================



******************************************************************************
*          TIMING
******************************************************************************

Timing Solver
*-----------------------------------------------------------
Running 17 total tests.

Timing tests use your implementation of Board.java and Solver.java.
Maximum time allowed per puzzle is 10 seconds.

               filename   N    seconds    insert()            delMin()         max PQ size
---------------------------------------------------------------------------------------------
=> passed  puzzle20.txt   3     0.03       1968                1184                 785         
=> passed  puzzle21.txt   3     0.03       5033                2984                2050         
=> passed  puzzle22.txt   3     0.02       3978                2376                1603         
=> passed  puzzle23.txt   3     0.04       7492                4430                3063         
=> passed  puzzle24.txt   3     0.03       5606                3386                2221         
=> passed  puzzle25.txt   3     0.05      10315                6122                4194         
=> passed  puzzle26.txt   3     0.06      12780                7630                5151         
=> passed  puzzle27.txt   3     0.03       7749                4704                3046         
=> passed  puzzle28.txt   3     0.10      27618               16532               11087         
=> passed  puzzle29.txt   3     0.08      22284               13496                8789         
=> passed  puzzle30.txt   3     0.14      41042               24886               16157         
=> passed  puzzle31.txt   3     0.13      42607               25786               16822         
=> passed  puzzle34.txt   4     1.09     312507              149514              162994         
=> passed  puzzle37.txt   4     1.06     260577              125578              135000         
=> passed  puzzle39.txt   4     0.81     234631              115324              119308         
=> passed  puzzle41.txt   5     0.48     123332               53092               70241         
=> passed  puzzle44.txt   5     1.25     281539              125974              155566         
==> 17/17 tests passed

Total: 17/17 tests passed!

================================================================


```

```text
[~/Dropbox/python_works/ass4/src y1275963$]java -Xmx1600m PuzzleChecker ../8puzzle/puzzle*.txt
../8puzzle/puzzle00.txt: 0
../8puzzle/puzzle01.txt: 1
../8puzzle/puzzle02.txt: 2
../8puzzle/puzzle03.txt: 3
../8puzzle/puzzle04.txt: 4
../8puzzle/puzzle05.txt: 5
../8puzzle/puzzle06.txt: 6
../8puzzle/puzzle07.txt: 7
../8puzzle/puzzle08.txt: 8
../8puzzle/puzzle09.txt: 9
../8puzzle/puzzle10.txt: 10
../8puzzle/puzzle11.txt: 11
../8puzzle/puzzle12.txt: 12
../8puzzle/puzzle13.txt: 13
../8puzzle/puzzle14.txt: 14
../8puzzle/puzzle15.txt: 15
../8puzzle/puzzle16.txt: 16
../8puzzle/puzzle17.txt: 17
../8puzzle/puzzle18.txt: 18
../8puzzle/puzzle19.txt: 19
../8puzzle/puzzle20.txt: 20
../8puzzle/puzzle21.txt: 21
../8puzzle/puzzle22.txt: 22
../8puzzle/puzzle23.txt: 23
../8puzzle/puzzle24.txt: 24
../8puzzle/puzzle25.txt: 25
../8puzzle/puzzle26.txt: 26
../8puzzle/puzzle27.txt: 27
../8puzzle/puzzle28.txt: 28
../8puzzle/puzzle29.txt: 29
../8puzzle/puzzle2x2-00.txt: 0
../8puzzle/puzzle2x2-01.txt: 1
../8puzzle/puzzle2x2-02.txt: 2
../8puzzle/puzzle2x2-03.txt: 3
../8puzzle/puzzle2x2-04.txt: 4
../8puzzle/puzzle2x2-05.txt: 5
../8puzzle/puzzle2x2-06.txt: 6
../8puzzle/puzzle2x2-unsolvable1.txt: -1
../8puzzle/puzzle2x2-unsolvable2.txt: -1
../8puzzle/puzzle2x2-unsolvable3.txt: -1
../8puzzle/puzzle30.txt: 30
../8puzzle/puzzle31.txt: 31
../8puzzle/puzzle32.txt: 32
../8puzzle/puzzle33.txt: 33
../8puzzle/puzzle34.txt: 34
../8puzzle/puzzle35.txt: 35
../8puzzle/puzzle36.txt: 36
../8puzzle/puzzle37.txt: 37
../8puzzle/puzzle38.txt: 38
../8puzzle/puzzle39.txt: 39
../8puzzle/puzzle3x3-00.txt: 0
../8puzzle/puzzle3x3-01.txt: 1
../8puzzle/puzzle3x3-02.txt: 2
../8puzzle/puzzle3x3-03.txt: 3
../8puzzle/puzzle3x3-04.txt: 4
../8puzzle/puzzle3x3-05.txt: 5
../8puzzle/puzzle3x3-06.txt: 6
../8puzzle/puzzle3x3-07.txt: 7
../8puzzle/puzzle3x3-08.txt: 8
../8puzzle/puzzle3x3-09.txt: 9
../8puzzle/puzzle3x3-10.txt: 10
../8puzzle/puzzle3x3-11.txt: 11
../8puzzle/puzzle3x3-12.txt: 12
../8puzzle/puzzle3x3-13.txt: 13
../8puzzle/puzzle3x3-14.txt: 14
../8puzzle/puzzle3x3-15.txt: 15
../8puzzle/puzzle3x3-16.txt: 16
../8puzzle/puzzle3x3-17.txt: 17
../8puzzle/puzzle3x3-18.txt: 18
../8puzzle/puzzle3x3-19.txt: 19
../8puzzle/puzzle3x3-20.txt: 20
../8puzzle/puzzle3x3-21.txt: 21
../8puzzle/puzzle3x3-22.txt: 22
../8puzzle/puzzle3x3-23.txt: 23
../8puzzle/puzzle3x3-24.txt: 24
../8puzzle/puzzle3x3-25.txt: 25
../8puzzle/puzzle3x3-26.txt: 26
../8puzzle/puzzle3x3-27.txt: 27
../8puzzle/puzzle3x3-28.txt: 28
../8puzzle/puzzle3x3-29.txt: 29
../8puzzle/puzzle3x3-30.txt: 30
../8puzzle/puzzle3x3-31.txt: 31
../8puzzle/puzzle3x3-unsolvable.txt: -1
../8puzzle/puzzle3x3-unsolvable1.txt: -1
../8puzzle/puzzle3x3-unsolvable2.txt: -1
../8puzzle/puzzle40.txt: 40
../8puzzle/puzzle41.txt: 41
../8puzzle/puzzle42.txt: 42
../8puzzle/puzzle43.txt: 43
../8puzzle/puzzle44.txt: 44
../8puzzle/puzzle45.txt: 45
../8puzzle/puzzle46.txt: 46
Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
	at Board.exchelement(Board.java:179)
	at Board.neighbors(Board.java:157)
	at Solver.<init>(Solver.java:61)
	at PuzzleChecker.main(PuzzleChecker.java:50)
```
