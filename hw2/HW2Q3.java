class HW2Q3 {
  public static void main(String[] args) {
      System.out.println(pow(3, 2));    // 9.0
      System.out.println(pow(2, 7));    // 128.0
      System.out.println(pow(3, 9));    // 19683
  }
  static double pow(double b, int p) {
    double temp = 0;
    if (p == 0){
        return 1;
    }
    else if (p == 1){
        return b;
    }
    else if (p % 2 == 0 || p % 2 != 1){
        temp = pow(b, p / 2);    // the one line that could change the worst case
        return temp * temp;
    }
    else if (p % 3 == 0){
        temp = pow(b, p / 3);    
        return temp * temp * temp;
    }
    else if(p % 3 != 0 && p % 2 != 0){
        temp = pow(b, p - 1);
        return temp * b;
    }
    else
    {
    pow(b,p);
    }
    return 0;
  }
}
