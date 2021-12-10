public class Pair implements Comparable<Pair> {

    public static void main(String[] args) {
      Pair a = new Pair(3, 4);
      Pair b = new Pair(3, 4);
      System.out.println(a.equals(b));
      b.x = 5;
      System.out.println(a.equals(b));
    }

  
    public int x, y; // bad practice but I'm lazy

    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int compareTo(Pair p) {
      if (this.y == p.y) {
        return Integer.compare(this.x, p.x);
      }
      return Integer.compare(this.y, p.y);
    }

    public String toString() {
      return String.format("(%d,%d)", x, y);
    }

    public boolean equals(Pair p) {
      return this.x == p.x && this.y == p.y;
    }

  }


