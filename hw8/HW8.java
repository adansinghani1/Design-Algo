import java.util.*;

public class HW8 {

  public static void main(String[] args) {
    // Q1
    System.out.println(bestValueForFused(4, new int[] {}, new int[] {})); // 0
    System.out.println(bestValueForFused(4, new int[] {4}, new int[] {1})); // 4
    System.out.println(bestValueForFused(4, new int[] {4, 10, 2}, new int[] {3, 1, 5})); // 12
    System.out.println(bestValueForFused(4, new int[] {4, 2, 2}, new int[] {3, 2, 5})); // 14
    System.out.println(bestValueForFused(6, new int[] {4, 2, 1}, new int[] {3, 3, 5})); // 18
    System.out.println(bestValueForFused(6, new int[] {4, 2, 1}, new int[] {3, 2, 9})); // 21 (3*4+9*1)

    // Q2
    System.out.println(bestValueForFusedDP(4, new int[] {}, new int[] {})); // 0
    System.out.println(bestValueForFusedDP(4, new int[] {4}, new int[] {1})); // 4
    System.out.println(bestValueForFusedDP(4, new int[] {4, 10, 2}, new int[] {3, 1, 5})); // 12
    System.out.println(bestValueForFusedDP(4, new int[] {4, 2, 2}, new int[] {3, 2, 5})); // 14
    System.out.println(bestValueForFusedDP(6, new int[] {4, 2, 1}, new int[] {3, 3, 5})); // 18
    System.out.println(bestValueForFusedDP(6, new int[] {4, 2, 1}, new int[] {3, 2, 9})); // 21 (3*4+9*1)
  }

  /*
   * Q1. bestValueForFused
   * Add your key ideas to this comment.
   * How did you approach the problem?
   * Why does your code work?
   */
   
	//helper funtion.
	public static int helperFunction(int B,int[] counts,int values[],int index)
	{
		//intitialize base case
		if(index == counts.length || B == 0)
		{
			return 0;
		}
		if(counts[index] <= B){
			return Math.max(counts[index] * values[index] + helperFunction(B-counts[index], counts, values, index + 1),helperFunction(B, counts, values, index + 1));
		}
        else
        {
		
		return helperFunction(B,counts,values,index + 1);
        }
	}
	//call helperFunction
	public static int bestValueForFused(int B,int[] counts,int values[]){
		return helperFunction(B,counts,values,0);
	}

  /*
   * Q2. bestValueForFusedDP
   * Add your key ideas to this comment.
   * How did you approach the problem?
   * Why does your code work?
   */
   
    public static int bestValueForFusedDP(int B, int[] counts, int values[]) {
      
            int n = values.length;
      // bestValueForFused(6, [4, 10, 2], [3, 1, 5])
      // we increase the size of B for the first dimension of the array and n which is the length of the values array because whenever we check the next index we need to include the previous index so we would need to account for that in the dimesions.
      int matrix[][] = new int[B + 1][n + 1];

      if (counts.length == 1){
          return counts[0];
      }
      //i represents the current bag space
      //j represents the current bar index
      for (int i = 1; i < B + 1; i++){

          for (int j = 1; j < n + 1; j++){

            if (i < counts[j-1]){ 
            // the bar is too big, lets just take the one from before
                int previous = matrix[i][j-1]; 
                matrix[i][j] = previous;
            }
            else
            { 
              //the bar wasnt too big, so lets take either the current bar + the ones from earlier, or the one from earlier
              //step 1: calculate the current bar

              //for example out total capactiy is 10, then take up the current bar which is 5 spots. 
              //we still have 5 other spots. 

                int previous = matrix[i][j-1];
                int total = counts[j-1]*values[i-1] + matrix[j-1][i-counts[j-1]];
                if(total < previous)
                {
                    matrix[i][j] = total + previous;                    
                }
                //take the current bar + the value at j-counts[j-1]
            matrix[i][j] = total;
            }
            
          }
      }
      return matrix[B][n];
    }

    // initialize for loop to keep track of the index in counts
//     for(int i = 0; i < counts.length; i++){
//         int total = counts[i]*values[i];
//         // establish base case(s)
//         if (counts.length < 1){
//             return 0;
//         }
//         else if(counts.length == 1){
//             return counts[i];
//         }
        
//         /**if count of ith bar is less than the current count (i.e. j)
// 		notice first bar ith bar has the position counts[i-1] in the array
// 		and same for values array**/
//         //else if(B > counts[i])
        
//         // if current B is less than or can not fit counts[i+1]*values[i+1] return total
//         /**assigning the maximum of two values
// 		where one value is previous results + current bars taken 
// 		and another value is the previous results
//         **/
//         }
//         //if count of the bar is greater than required
//         else
//         {

//         }
//     }
//     return 0; 
    
}

/** TA comments:
If we have enough space to take in the total of metal X say:
    return max(value of bag if you can take the current metal vs the value of the bag if not taking the current metal)
int takeAll = value of bag taking the current metal = arr[row - 1][col - count of current metal] + (count*value of current metal)
int takeAll = B - total 
int takeNone = value of bag if not take the current metal = arr[row - 1][col]
**/

/**
  public static int bestValueForFusedDP(int B, int[] counts, int values[]) {
    // initialize for loop to keep track of the index in counts
    for(int i = 0; i < counts.length; i++){
        int total = counts[i]*values[i];
        // establish base case(s)
        if (counts.length < 1){
            return 0;
        }
        else if(counts.length == 1){
            return counts[i];
        }
        else if(counts[i -1] <= values.length){
            
        }
    }
    return 0;
  }
}
**/
/** 
Start with base case where we return 0 if there is an empty array and the first index of the counts array if the length is == 1. Coolio
Next we create a function which 
        int max_val = Integer.MIN_VALUE;
  
        // Recursively cut the rod in different pieces and
        // compare different configurations
        //for (i = 0; i < B; i++)
        //max_val = Math.max(max_val, counts[i] + bestValueForFusedDP(B-i-1, counts, values));
  
        //return max_val;
        }
        //return 0;
  }
  **/
