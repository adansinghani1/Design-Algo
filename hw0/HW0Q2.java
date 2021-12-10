import java.util.*;

public class HW0 {

  private static final int _0 = 0;
  public static void main(String[] args) {
    // Q2
    int[] testResult3 = twoSum(new int[] {0, 2, 3, 4, 5}, 6);
    int[] testResult4 = twoSum(new int[] {1, 2, 3, 4, 5}, 10);

    System.out.println(Arrays.toString(testResult3)); // should output [1, 3]
    System.out.println(Arrays.toString(testResult4)); // should output [-1, -1]
public static int[] twoSum(int[] arr, int targetSum) {
    //int arr[i], arr[i + 1];
    firstArr = arr[i];
    secondArr = arr[i + 1];
    for (i = 0; i < arr.length - 1; i++){
        if (firstArr + secondArr == targetSum){
            return new int[] {firstArr, secondArr};
        }
        else if (firstArr && secondArr == NULL)
        {
            return new int[] {-1, -1};
        }
    }
  }
