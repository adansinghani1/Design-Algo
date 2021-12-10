import java.util.*;

public class Main {
    private static final int _0 = 0;

  public static void main(String[] args) {
    // Q3
    List<Integer> testResult5 = add(Arrays.asList(1, 2, 3), Arrays.asList(2, 4, 2));
    List<Integer> testResult6 = add(Arrays.asList(9, 9, 9), Arrays.asList(1));
    List<Integer> testResult7 = add(Arrays.asList(9, 2, 2, 3, 3, 7, 2, 0, 3, 6, 8, 5, 4, 7, 7, 5, 8, 0, 7), Arrays.asList(1, 2, 3, 4, 5));

    System.out.println(testResult5); // should output [3, 6, 5]
    System.out.println(testResult6); // should output [1, 0, 0, 0]
    System.out.println(testResult7); // should output [9, 2, 2, 3, 3, 7, 2, 0, 3, 6, 8, 5, 4, 7, 8, 8, 1, 5, 2]
  }
    
  public static List<Integer> add(List<Integer> lst1, List<Integer> lst2) {
    //throw new UnsupportedOperationException("add not yet written")
    LinkedList<Integer> result = new LinkedList<>(); // initialized a LinkedList that stores the final result
    int carry = _0; 
    int carryVal = 10; // variable that deals with carry when the sum is >= 9
    int i = lst1.size() - 1; // create a variable that keeps track of the size of lst1 and decrements through the list
    int j = lst2.size() - 1; // create a variable that keeps track of the size of lst2 and decrements through the list
    int currSum = _0;
    
    // If the either lists are not empty or do not have integer, we continue with the while loop
    while(i >= _0 && j >= _0) { 
      currSum = (lst1.get(i) + lst2.get(j) + carry) % carryVal;
      carry = (lst1.get(i) + lst2.get(j) + carry) / carryVal;
      result.push(currSum); 
      //using a stack we can push to allow the number to decrement as we move indices
      i--;
      j--;
    }
    // Checking if lst1 has contents and creating a function to add and carry if needed
    while (i >= _0){ 
      currSum = (lst1.get(i) + carry) % carryVal;
      carry = (lst1.get(i) + carry) / carryVal;
      result.push (currSum);
      i--;
    }
    // Checking if lst2 has contents and creating a function to add and carry if needed
    while (j >= _0){ 
      currSum = (lst2.get(j) + carry) % carryVal;
      carry = (lst2.get(j) + carry) / carryVal;
      result.push (currSum);
      j--;
    }
    if (carry > _0) {  //when the lst is reach all the way to the right, if carry is not 0, we add the to the front of the lst
    result.push(carry);
    }
    return result;
    }
  }
