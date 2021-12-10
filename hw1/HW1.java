import java.util.stream.*;
import java.util.Arrays;
public class HW1 {

  public static void main(String[] args) {
    // Q1
    int testResult1 = findMissing(new int[] {0, 1, 2, 4, 5});
    System.out.println(testResult1); // should output 3

    int testResult2 = findMissing(new int[] {5, 0, 4, 3, 1});
    System.out.println(testResult2); // should output 2

    int testResult3 = findMissing(new int[] {});
    System.out.println(testResult3); // should output 0

    int testResult4 = findMissing(new int[] {9, 3, 5, 1, 4, 8, 2, 10, 0, 6});
    System.out.println(testResult4); // should output 7


    // Q3
    System.out.println(countFives(123467890)); // should output 0
    System.out.println(countFives(555555));    // should output 6
    System.out.println(countFives(15354));     // should output 2


    // Q4
    int testResult5 = pickTrees(new int[] {1, 2, 3, 4, 5});
    System.out.println(testResult5); // should output 9

    int testResult6 = pickTrees(new int[] {1, 3, 4, 3});
    System.out.println(testResult6); // should output 6

    int testResult7 = pickTrees(new int[] {5, 1, 4, 9});
    System.out.println(testResult7); // should output 14 
  }
  
  /**
   * Add your key ideas to this comment.
   * How did you approach the problem?
    I figured I would need a variable called index that could could track a value > the current index which is i in the for loop. Then I wrote a function :
    "if (arr.isEmpty or arr == to an empty array)
    	return 0;
     else if (i is - 1 the value of the current index of the arr) 	// i.e. ( 3 - 1 or 2 == 3 )
     	go to next index (because we found the number that is greater than the current index
     else
     return i (return number that is one greater than the current but is not found in the array)
     
   * Why does your code work?
     My code simply has a variable called index that can compare values similar to if we had a nested for loop and we find a value that is one more than the value of the index.
   */
  public static int findMissing(int[] arr) {
    //throw new UnsupportedOperationException("findMissing not yet written");
    int sum = 0, n = arr.length;	// intialize variable sum and variable n as arr.length so we can calculate the missing value
    for(int i = 0; i < n; i++) {
        sum += arr[i];
    }
    int missingVal = ((n*(n + 1))/2) - sum;	// using the formula from the Overview of HW1 to get the missing value
    	return missingVal;
  }

  /**
   * Add your key ideas to this comment.
   * How did you approach the problem?
   I was trying to figure out a way to find the integer "5" without using a string buffer. So, I started with a base case which was:
   	if (num.isEmpty && the value is > or < 5)
		return 0;
	next we modulo each place by using
	(num % 10 == 5) and if the place that we are looking at == 5
		return each time you find a five
	Finally, we return the times 5 occurs in the array
   * Why does your code work?
   My code checks if the array is empty and each place if there is a five in the array.
   */
  public static int countFives(int num) {
    //throw new UnsupportedOperationException("countFives not yet written");
    if(num == 0 && num < 5){	// Handles the case when num = 0 and < 5 
    	return 0;
    }	
    else if(num % 10 == 5)
    {
	return 1 + countFives(num / 10);
    }
    return countFives(num / 10);
    }

  /**
   * Add your key ideas to this comment.
   * How did you approach the problem?
   I got this idea from the TA to use a helper function instead of having if else if statements to add indicies since the last problem add index arr[0] and arr[3].
   So I started with the base case which is if the index is > than the size of the array (Giving an OutOfBounds error), return 0. Next I had two options I could choose where: 
   option one: if we use the index, we can add an index that is not neighboring the current index i.e. a + 2
   option two: else we do not keep the value and we move on to the next index and see if we can use that value to cut down
   Finally I made an if statement that says if optionOne is > optionTwo where we want to sum of two numbers to be > then the next alternating indicies.
   * Why does your code work?
   We have a recursive function that traverses through the whole array checking for the sum of all alternating indicies and finds the sequence that yield the max possibilies of the array.
   Also we do not have to worry about the differences of the length because the function adds all the alternating values in the array and finds the sum of that yields the greatest value.
   */
  public static int pickTrees(int[] arr) {
    // throw new UnsupportedOperationException("pickTrees not yet written");
	 // return the reults from the helper function
	return helperFunction(arr,0);
  }
  public static int helperFunction (int[] arr, int index){
	int arrSize = arr.length;
	if (index >= arrSize && arrSize >= 3){	// if the index is > than the size of the array (Giving an OutOfBounds error), return 0;
		return 0;
  	}
	int optionOne = arr[index] + helperFunction(arr, index + 2);	// if we use the index, we can add an index that is not neighboring the current index i.e. a + 2
	int optionTwo = helperFunction(arr, index + 1); 		// else we do not keep the value and we move on to the next index and see if we can use that value to cut down
	
	// use an if statement to see if the value of optionOne (the one we use to keep the value and add the value that is two indicies away) is greater than optionTwo  
	if (optionOne > optionTwo && optionOne != optionTwo && optionTwo <= optionOne) {
		return optionOne;
	}
	return optionTwo;
   }
  }
