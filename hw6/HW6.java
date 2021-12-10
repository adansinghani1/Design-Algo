import java.util.*;

class HW6 {

  public static String pantherID() {
    return "002354500";
  }
  /**
  Your adjacency matrix:
[null, null,   11, null,    6, null,   13]
[null, null,    3, null, null,    3,    1]
[  11,    3, null, null, null,   14, null]
[null, null, null, null, null,    8,   14]
[   6, null, null, null, null,    1, null]
[null,    3,   14,    8,    1, null,   14]
[  13,    1, null,   14, null,   14, null]
**/

  public static List<List<Pair>> adjList() {
    return Arrays.asList( 
    Arrays.asList(pair(2, 11), pair(4, 6), pair(6, 13)),
    Arrays.asList(pair(2, 3), pair(5, 3), pair(6, 1)),
    Arrays.asList(pair(0, 11), pair(1, 3), pair(5, 14)),
    Arrays.asList(pair(5, 8), pair(6, 14)),
    Arrays.asList(pair(0, 6), pair(5, 1)),
    Arrays.asList(pair(1, 3), pair(2, 14), pair(3, 8), pair(4, 1), pair(6, 14)),
    Arrays.asList(pair(0, 13), pair(1, 1), pair(3, 14), pair(5, 14))
    );
  }

  public static int[][] dist() {
    int inf = Integer.MAX_VALUE;
    return new int[][] {
    {inf, inf, inf, inf, inf, inf, inf}, // (initial)
    {0, inf, inf, inf, inf, inf, inf},   // (setting dist[s] = 0
    {0, inf, 11, inf, inf, inf, inf},    // (0 <-> 2 edge)
    {0, inf, 11, inf, 6, inf, inf},     // (0 <-> 4 edge)
    {0, inf, 11, inf, 6, inf, 13},     // (0 <-> 6 edge)
    {0, inf, 11, inf, 6, inf, 13},      // (4 <-> 0 edge)
    {0, inf, 11, inf, 6, 7, 13},     // ( 4 <-> 5 edge)
    {0, 10, 11, inf, 6, 7, 13},    // (4 <-> 1 edge)
    {0, 10, 11, inf, 6, 7, 13},        // (1 <-> 0 edge)
    {0, 10, 11, 15, 6, 7, 13},       // (4 <-> 3 edge)
    {0, 10, 11, 15, 6, 7, 13},         // (6 <-> 1 edge)
    {0, 10, 11, 15, 6, 7, 13},         // (6 <-> 3 edge)
    {0, 10, 11, 15, 6, 7, 13},         // (6 <-> 5 edge)
    {0, 10, 11, 15, 6, 7, 13},         // (5 <-> 1 edge)
    {0, 10, 11, 15, 6, 7, 11},         // (5 <-> 2 edge)
    {0, 10, 11, 15, 6, 7, 11},         // (5 <-> 6 edge)
    {0, 10, 11, 15, 6, 7, 11},          // (1 <-> 6 edge)
    {0, 10, 11, 15, 6, 7, 11},          // (1 <-> 6 edge)
    {0, 10, 11, 15, 6, 7, 11},          // (1 <-> 6 edge)
    {0, 10, 11, 15, 6, 7, 11},          // (1 <-> 6 edge)
    {0, 10, 11, 15, 6, 7, 11},          // (1 <-> 6 edge)
    {0, 10, 11, 15, 6, 7, 11},          // (1 <-> 6 edge)
    {0, 10, 11, 15, 6, 7, 11},          // (1 <-> 6 edge)
    {0, 10, 11, 15, 6, 7, 11},          // (1 <-> 6 edge)
    {0, 10, 11, 15, 6, 7, 11},          // (1 <-> 6 edge)
    {0, 10, 11, 15, 6, 7, 11},          // (1 <-> 6 edge)
    {0, 10, 11, 15, 6, 7, 11},          // (1 <-> 6 edge)
    {0, 10, 11, 15, 6, 7, 11},          // (1 <-> 6 edge)
    {0, 10, 11, 15, 6, 7, 11},          // (1 <-> 6 edge)
    {0, 10, 11, 15, 6, 7, 11},          // (1 <-> 6 edge)
    {0, 10, 11, 15, 6, 7, 11},          // (1 <-> 6 edge)
    {0, 10, 11, 15, 6, 7, 11},          // (1 <-> 6 edge)
    
};
  }

  public static Integer[][] prev() {
    return new Integer[][] {
    {null, null, null, null, null, null, null}, // (initial)
    {null, null, 0, null, null, null, null},    // (0 <-> 2 edge)
    {null, null, 0, null, 0, null, null},       // (0 <-> 3 edge)
    {null, null, 0, null, 0, null, 0},       // (3 <-> 0 edge)
    {null, null, 0, null, 0, null, 0},          // (3 <-> 4 edge)
    {null, null, 0, null, 0, 4, 0},             // (3 <-> 6 edge)
    {null, 5, 0, null, 0, 4, 0},               // (2 <-> 0 edge)
    {null, 5, 0, null, 0, 4, 0},                // (2 <-> 5 edge)
    {null, 5, 0, 5, 0, 4, 0},                // (4 <-> 3 edge)
    {null, 5, 0, 5, 0, 4, 0},                // (4 <-> 3 edge)
    {null, 5, 0, 5, 0, 4, 0},                // (4 <-> 3 edge)
    {null, 5, 0, 5, 0, 4, 0},                // (4 <-> 3 edge)
    {null, 5, 0, 5, 0, 4, 0},                // (4 <-> 3 edge)
    {null, 5, 0, 5, 0, 4, 1},                // (4 <-> 3 edge)
    {null, 5, 0, 5, 0, 4, 1},                // (4 <-> 3 edge)
    {null, 5, 0, 5, 0, 4, 1},                // (4 <-> 3 edge)
    {null, 5, 0, 5, 0, 4, 1},                // (4 <-> 3 edge)
    {null, 5, 0, 5, 0, 4, 1},                // (4 <-> 3 edge)
    {null, 5, 0, 5, 0, 4, 1},                // (4 <-> 3 edge)
    {null, 5, 0, 5, 0, 4, 1},                // (4 <-> 3 edge)
    {null, 5, 0, 5, 0, 4, 1},                // (4 <-> 3 edge)
    {null, 5, 0, 5, 0, 4, 1},                // (4 <-> 3 edge)
    {null, 5, 0, 5, 0, 4, 1},                // (4 <-> 3 edge)
    {null, 5, 0, 5, 0, 4, 1},                // (4 <-> 3 edge)
    {null, 5, 0, 5, 0, 4, 1},                // (4 <-> 3 edge)
    {null, 5, 0, 5, 0, 4, 1},                // (4 <-> 3 edge)
    {null, 5, 0, 5, 0, 4, 1},                // (4 <-> 3 edge)
    {null, 5, 0, 5, 0, 4, 1},                // (4 <-> 3 edge)
    {null, 5, 0, 5, 0, 4, 1},                // (4 <-> 3 edge)
    {null, 5, 0, 5, 0, 4, 1},                // (4 <-> 3 edge)
    };
  }

  // DO NOT MODIFY ANYTHING AFTER THIS LINE
  public static void main(String[] args) {
    Verifier v = new Verifier(pantherID());
    Integer[][] m = v.generate();
    System.out.println("Your adjacency matrix:");
    printMatrix(m);
    System.out.println(
      String.format("\nRun Dijktra's starting at node %d", findFirstNonNullRow(m))
    );
    v.verifyList(adjList());
    v.verifyDist(dist());
    v.verifyPrev(prev());
  }

  public static void printMatrix(Integer[][] m) {
    for (Integer[] arr : m) {
      String[] row = new String[arr.length];
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] != null) {
	  if (arr[i] > 9) {
  	    row[i] = "  " + arr[i];  // Gotta pad the double digits
	  } else {
  	    row[i] = "   " + arr[i]; // Gotta pad the single digits
	  }
	}
      }
      System.out.println(Arrays.toString(row));
    }
  }

  public static int findFirstNonNullRow(Integer[][] m) {
    for (int i = 0; i < m.length; i++) {
      for (Integer edge : m[i]) {
        if (edge != null) {
	  return i;
	}
      }
    }
    return -1;
  }

  public static Pair pair(int label, int weight) {
    return new Pair(label, weight);
  }
}
