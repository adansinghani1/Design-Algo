import java.util.*;

public class Q4 {
  public static void main(String[] args) {
    return Arrays.asList(13, 10, 16, 15, 21, 18, 25, 23, 30, 27, 35, 33, 39, 37, 45, 41, 50, 47);
  }                    
  public static List<Integer> input() {
    int N;
    if (N<2){
      return List;
    }
    int pivot = List[N - 1]
    ArrayList<Integer> left = new ArrayList<>();
    ArrayList<Integer> right = new ArrayList<>();
    for (int i = 0; i <= N - 2; i++)
            if ( i < pivot) {
                left.add(i);
            }
            else {
                right.add(i);
            }
        }
        //return quicksort(less, min, pivot) + arr.get(pivot) + quicksort(greater, pivot + 1, max);
    }
}
    // REPLACE ME
    return null;
  }
}

/** 
The fastest way to implement quickSort is by placing the pivot point in the middle of the array list and making two sub array lists, left and right and placing those values into
the array list.
The quickest way to sort an array using quickSort is to a greater values to the index to the right. So given the array [1,2,3,4] , we would do something like, if currIndex (being arr[0])
is < nextIndex (being arr[i+1] or arr.length + 1) then swap the two numbers and put them in the right ArrayList. Next we can do the same for the other half and put it into the left ArrayList.
Now we can combine the two and get the array [2,1,4,3]. This is how quickSort works and this example is doing it back wards. We still scan the array, but we swap each set of indices and
do not need to do as much work to sort it.
/** 
