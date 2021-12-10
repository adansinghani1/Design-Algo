import java.util.*;

//import com.sun.org.apache.bcel.internal.classfile.Node;

public class HW7 {

  public static void main(String[] args) {
    // Q1
    System.out.println(bestValue(7, new int[] {}, new int[] {})); // 0
    System.out.println(bestValue(7, new int[] {4}, new int[] {1})); // 4
    System.out.println(bestValue(7, new int[] {4, 10, 2, 4}, new int[] {3, 1, 5, 2})); // 24
    System.out.println(bestValue(7, new int[] {4, 10, 2, 4}, new int[] {3, 3, 5, 2})); // 25
    System.out.println(bestValue(7, new int[] {4, 10, 2, 4}, new int[] {3, 5, 5, 2})); // 35
  }

  public static int bestValue(int W, int[] counts, int values[]) {
    /**
    [4, 10, 2, 4] // 4 bars of gold, 10 silver, 2 platinum, 4 steel
    and these values
    [3, 1, 5, 2]  // gold worth 3 per bar, silver worth 1, platinum 5, steel 2

    Then you would want to take this much of each metal

    [4, 0, 2, 1]  // all the gold, no silver, all the platinum, 1 steel bar
                  // for a total value of 24 (4*3 + 2*5 + 1*2)
    **/
    //Node bar[n];
    
    int total = 0;
    int extraBar = 0;
    if (counts.length <= 0){
      return 0;
    }
    MetalBar[] bars = new MetalBar[counts.length];

    for (int i = 0; i < bars.length; i++){
      bars[i] = new MetalBar(values[i], counts[i]);
    }
    // Using count [] {4, 10, 2, 4}, value [] {3, 1, 5, 2}; // 24
    Arrays.sort(bars);

    // After sorting: count [] {2, 4, 4, 10}, value [] {5, 3, 2, 1}; // 24
    //we can continue multiplying correct index of value and count
        while(W > 0)
        {
            for (int i = 0; i < bars.length; i++)
            {
                //establish base case
                if (bars.length <= 1){
                    return bars[i].getCount();
                }
                // Quantity of count is less than W, we can take all the bars
                else if (bars[i].getCount() < W)
                {
                    int totalBars = bars[i].getValue() * bars[i].getCount();
                    total = total + totalBars; 
                    W = W - bars[i].getCount();
                }
                else
                {
                // if count is > W, we take only the bars that are required to suffice the condition i.e. if we have 6 bars and we need one but the amount of bars are for the metal are 10, we only take one bar to maintain the condition 
                extraBar = bars[i].getValue() * W;
                total = total + extraBar;
                W = W - W;
                }
            }
            return total;
        }
        return 0;
    }
}



  /**



  W = 10 
  counts = [1,2,3,4,5]
  values = [3,5,1,9,2]

  after sorting :
  counts = [4,2,1,5,3]
  values = [9,5,3,2,1]
  W = 3 

  result = 36 + 10 + 3 + 6 = 55
  /
}

/**
The parameters: 
count array that keeps track of the contents
vals array that keeps track of the values that are inputed maybe
int W for wumbo or capacity of the bag
n = arr.length to keep track of contents to see if we got the bag full full

bars[i] - counts val

Intuition:
multiply array of Count and array of Value to get the total:
Bars[i].getCount()
totalBars = value.getValue() * counts.getValue()
if  counts is > W then multiply w by value


**/
