import java.util.*;

public class HW3 {

  public static String pantherID() {
    return "002354500";
  }

  public static int[][] callsToMystery() {
    return new int[][] {
      // Fill in your recursive calls as arrays here
      // For example, a call to mystery([4, 5, 3, 9, 7, 1, 3], 3) would start with
      // {4, 5, 3, 9, 7, 1, 3, 3},
      {33, 20, 67, 18, 25, 65, 45, 27, 20, 47, 5}
         /** 
        remove index[0]
        keep index[1], index[2]
        remove index[3], index[4]
        keep index[5], index[6], index[7]
        remove index[8]
        keep index[9], index[10]
      **/
      ////"student answer has more recursive calls than expected"
      //{20,18,25,27,20,5}
    };
  }

  // ==== DO NOT CHANGE ANYTHING BELOW THIS LINE! ====
  public static void main(String[] args) {
    String id = pantherID();
    if (id == null) {
      System.out.println("Please update the pantherID method!");
      return;
    }
    int[] q1Array = ArrayGenerator.generate(id, 10);
    System.out.println(String.format("Your input array for Q1 is %s", Arrays.toString(q1Array)));
    q1Array = Arrays.copyOf(q1Array, 11);
    q1Array[10] = 5;
    System.out.println(String.format("Your first row should be %s", Arrays.toString(q1Array)));
    System.out.println();
  }
}

/**
{33, 20, 67, 18, 25, 65, 45, 27, 20, 47, 5}
  if lst.size() < 2
    return lst.get(0)       index[0] = 33
  pivot = lst.get(0)        use 33 as a pivot point
  left = new list of integers   new List() = leftLst
  middle = new list of integers     new List() = midLst
  right = new list of integers      new List() = rightLst
  for each element el in lst
    if el < pivot          leftLst = [20,18,25,27,20,5]
      left.add(el)
    else if el = pivot      midLst = [33]
      middle.add(el)        
    else                    rightLst = [67,65,47]
      right.add(el)
  if k < left.size()    k = 5 so 5 < 5  does not work
    return mystery(left, k)
  else if k < left.size() + middle.size() k = 5 and 5 < 6 so we return {33}
    return middle.get(0)
  else
    return mystery(right, k-left.size()-middle.size())
**/
