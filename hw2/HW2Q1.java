class HW2Q1 {
  public static void main(String[] args) {
      System.out.println("if z is < 10");
      mystery1(1);    // result is 1
      System.out.println("_______________________________________");
      System.out.println("if z is > 10");
      mystery1(10);     // result is 10, 1 , 10
  }
  static void mystery1(int z) {
    System.out.println(z);
    if (z >= 10) {
      mystery1(z/10);
      System.out.println(z);
    }
  }
}
