import java.util.*;
// javac HW5.java || run command each time
public class HW5 {

  public static String pantherID() {
    return "002354500";
  }
  /**
  Your graph is G = (V, E), where
    V = {0, 1, 2, 3, 4, 5, 6, 7} and
    E = {[(0,4), (0,6), (1,2), (1,6), (2,4), (2,6), (3,5), (3,6), (4,5), (4,7)]}
  **/
  public static int[][] adjMatrix() {
    return new int [][]{
        {0, 0, 0, 0, 1, 0, 1, 0},
        {0, 0, 1, 0, 0, 0, 1, 0},
        {0, 1, 0, 0, 1, 0, 1, 0},
        {0, 0, 0, 0, 0, 1, 1, 0},
        {1, 0, 1, 0, 0, 1, 0, 1},
        {0, 0, 0, 1, 1, 0, 0, 0}, //
        {1, 1, 1, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 0}
    };
  }

  public static List<List<Integer>> adjList() {
    return Arrays.asList(
        Arrays.asList(4, 6),
        Arrays.asList(2, 6),
        Arrays.asList(1, 4, 6),
        Arrays.asList(5, 6),
        Arrays.asList(0, 2, 5, 7),
        Arrays.asList(3, 4),
        Arrays.asList(0, 1, 2, 3),
        Arrays.asList(4)
        
        /**
        Arrays.asList(0, 4),
        Arrays.asList(0, 6),
        Arrays.asList(1, 2),
        Arrays.asList(1, 6),
        Arrays.asList(2, 4),
        Arrays.asList(2, 6),
        Arrays.asList(3, 5),
        Arrays.asList(3, 6),
        Arrays.asList(4, 5),
        Arrays.asList(4, 7)
        **/
    );
  }

  public static int[] bfsOrder() {
      return new int[] {0,4,6,2,5,7};

  }

  public static int[] dfsOrder() {
    return new int[]{0,4,2,1,6,3,5,7};
  }

  public static void main(String[] args) {
    if (pantherID() == null) {
      System.out.println("Missing Panther ID.");
    } else {
      Verifier v = new Verifier(pantherID());
      v.generateGraph();
      v.verifyMatrix(adjMatrix());
      v.verifyList(adjList());
      v.verifyBFS(bfsOrder());
      v.verifyDFS(dfsOrder());
    }
  }
}
