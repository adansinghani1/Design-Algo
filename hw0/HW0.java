import java.util.*;

public class HW0 {

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


    // Q2
    int[] testResult3 = twoSum(new int[] {0, 2, 3, 4, 5}, 6);
    int[] testResult4 = twoSum(new int[] {1, 2, 3, 4, 5}, 10);

    System.out.println(Arrays.toString(testResult3)); // should output [1, 3]
    System.out.println(Arrays.toString(testResult4)); // should output [-1, -1]


    // Q3
    List<Integer> testResult5 = add(Arrays.asList(1, 2, 3), Arrays.asList(2, 4, 2));
    List<Integer> testResult6 = add(Arrays.asList(9, 9, 9), Arrays.asList(1));
    List<Integer> testResult7 = add(Arrays.asList(9, 2, 2, 3, 3, 7, 2, 0, 3, 6, 8, 5, 4, 7, 7, 5, 8, 0, 7), Arrays.asList(1, 2, 3, 4, 5));

    System.out.println(testResult5); // should output [3, 6, 5]
    System.out.println(testResult6); // should output [1, 0, 0, 0]
    System.out.println(testResult7); // should output [9, 2, 2, 3, 3, 7, 2, 0, 3, 6, 8, 5, 4, 7, 8, 8, 1, 5, 2]
  }

  /**
   * Add your key ideas to this comment.
   * How did you approach the problem?
   
   I started with my base case which was: the array cannot be empty, then I created a for loop that initialized a variable "i" that would go through int[] arr.
   Lastly, I checked if each index is greater than the first to find the max and made sure we did not have an empty array. Then the max was given.
   
   * Why does your code work?
   
   It checks if the array is empty and goes through each index of the array to make sure we find the biggest element in the array. Also, it gives the desired output.
   */
  
  // Initialized an empty array called "emptyArr" which has and open and closed brackets which represents an empty array.
  // Then, I created an if statement where we check if the length of the array is zero (which would indicate the array is empty) as well as the array is equal to the emptyArr 
  // that we initialized in the previous line. 
  // If the array has a length of zero (no contents) or it is equal to the empty array, we can throw the IleagleArgumentException "maxofArray is empty!". 
  // In the screenshot, HW0Q1 we can see we get the desired output.
  // Next we have a for loop that initializes a variable "i" which is given the index of 1 and we have said that variable i is greater than the length of the array which i is 
  // incremented using ++ each time we go through the loop.
  // We embedded a if statement which says if index 1 of array is > index 0 and the length of the array is NOT equal to 0 and the length of the array is greater than 0 and 
  // the arr is NOT equal to an empty array.
  // Then we can use index 0 as a temp variable to equal the max and finally, we return the max.
  
  public static int maxOfArray(int[] arr) {
    //throw new UnsupportedOperationException("maxOfArray not yet written");
     int emptyArr[] = {};
     if (arr.length == _0 || arr == emptyArr)
     {
         throw new IllegalArgumentException("maxofArray is empty!");
     }
     for (int i = 1; i < arr.length; i++){
         if (arr[i] > arr[0] && arr.length != _0 && arr.length > _0 && arr != emptyArr){
             arr[0] = arr[i];
          }
      }
      return arr[0];
   } 
  // https://www.geeksforgeeks.org/c-program-find-largest-element-array/

  /**
   * Add your key ideas to this comment.
   * How did you approach the problem?
   
   I approached the problem by figuring out how to compare two values in one array. I was able to do it in my own code see "HW0Q2.java" for my past solution but I got errors 
   because I could not find a way to do it. I found out I could utilize a nested for loop that would check through the array once and once the value is found, we can use the 
   second for loop to find the second value. Once we find the values, I used the variables i and j and made an if statement. if arr[j] + arr[i] == targetSum (result) or with the
   variables switched arround (same answer since addition) return the values that sum up to the targetSum.Lastly, if there are not two sums that result into the targetSum,
   then we are forced to return the array [-1,-1] which acts like a NULL because we can not put return null when working with arrays or integers. 
   
   * Why does your code work?
   
   My code goes through an array with two variables looking for a number that the sum of both of them will equate to the targetSum. 
   It also gives the desired result. I had help from resourses online, because my thought proccess was correct, but my implementation was the issue looking at my "HW0Q2.java".
   */
   //
  public static int[] twoSum(int[] arr, int targetSum) {
    // initialize a nested for loop to scan through an array looking for two numbers
    for (int i = 0; i < arr.length; i++){
        for (int j = i + 1; j < arr.length; j++){
            if (arr[j] + arr[i] == targetSum || arr[i] + arr[j] == targetSum){   // if we can add two values to equal the targetSum then we can return the values that equated to the targetSum
                return new int[] {i, j}; // return the values that equated to the targetSum
            }
        }
    }
    return new int[] {-1,-1};  // if the sum of two values could NOT equal the targetSum, we return [-1,-1] in an array, because adding those will provide us will NULL or 0.
  }

  // https://www.programcreek.com/2012/12/leetcode-solution-of-two-sum-in-java/
  
  /**
   * Add your key ideas to this comment.
   * How did you approach the problem?
   
   I used the pseudocode you provided in the review session and made the code I have. One issue I struggled with was adding the two lists and getting my result to go from [999]
   +[001] = [1000]. I found using the .length of the list or just the .size function works out well too. Then I used while loops to make sure the size of the list is > 0 because
   we can not move through an empty list. I made a function to add the values of both lists that dealt with carrying which is modded by 10 and then the value is carried over by
   using the carry line. Then I had a function that dealt with the carry function for each of the lists if the size of one of the list is < the other list. 
   Then I had a final function that made sure there was a carry value it had to be dealt with.
   
   * Why does your code work?
   Because it is able to add the two lists, observe the sizes of the respective lists while still being able to add both of the lists and carry like we do traditionally when 
   finding the sum and adding it to the next index along with the current value. Also the code outputs the expected result.
   */

  public static List<Integer> add(List<Integer> lst1, List<Integer> lst2) {
    //throw new UnsupportedOperationException("add not yet written")
    LinkedList<Integer> result = new LinkedList<>(); // initialized a LinkedList that stores the final result
    int carry = _0; 
    int carryVal = 10; // variable that deals with carry when the sum is > 9
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
      //using a stack we can push to allow the number to decrement as we move indices
      i--;
    }
    // Checking if lst2 has contents and creating a function to add and carry if needed
    while (j >= _0){ 
      currSum = (lst2.get(j) + carry) % carryVal;
      carry = (lst2.get(j) + carry) / carryVal;
      result.push (currSum);
      //using a stack we can push to allow the number to decrement as we move indices
      j--;
    }
    if (carry > _0) {  //when the lst is reach all the way to the right, if carry is not 0, we add the to the front of the lst
    result.push(carry);
    }
    return result;
    }
  }
