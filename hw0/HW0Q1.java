import java.util.*;

public class Main {
    private static final int _0 = 0;

  public static void main(String[] args) {
    // Q1
    int testResult1 = maxOfArray(new int[] {1, 3, 4, 5, 2});
    int testResult2 = maxOfArray(new int[] {-1, -3, -4, -5, -2});

    System.out.println(testResult1); // should output 5
    System.out.println(testResult2); // should output -1
    boolean emptyCaseCorrect = false;
    try {
      maxOfArray(new int[] {});
    } catch (IllegalArgumentException e) {
      emptyCaseCorrect = true;
    }
    if (emptyCaseCorrect) {
      System.out.println("maxOfArray appears to work for the empty array case");
    } else {
      System.out.println("maxOfArray appears to be incorrect for the empty array case");
    }
  }
        public static int maxOfArray(int[] arr) {
    //throw new UnsupportedOperationException("maxOfArray not yet written");
      boolean emptyCaseCorrect = false;
      for (int i = 1; i < arr.length; i++){
          if (arr[i] > arr[0] && arr.length != _0 && arr.length > _0 && emptyCaseCorrect == false)
          arr[0] = arr[i+2];
          return arr[0];
      }
      return _0;
    }
  } 