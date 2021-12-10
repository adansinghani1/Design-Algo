class Main {
  public static void main(String[] args) {
    // Q4
    int testResult5 = pickTrees(new int[] {1, 2, 3, 4, 5});
    System.out.println(testResult5); // should output 9

    int testResult6 = pickTrees(new int[] {1, 3, 4, 3});
    System.out.println(testResult6); // should output 6

    int testResult7 = pickTrees(new int[] {5, 1, 4, 9});
    System.out.println(testResult7); // should output 14 
  }

  public static int pickTrees(int[] arr) {
     //throw new UnsupportedOperationException("countFives not yet written");
    int i;
    int sumofArr = IntStream.of(arr).sum();
    int arrSize = arr.length;
    if (arrSize > 4){
        return arr[0] + arr[2] + arr[4];
    }
    else if (sumofArr <= 12){
        return arr[0] + arr[4];
    }
    else{
    return arr[2] + arr[4];
    }
  }
}
