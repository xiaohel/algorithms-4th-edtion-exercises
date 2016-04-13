public class GCD {
  public static void main(String[] args) {
    System.out.println(gcd(105, 24));
    System.out.println(gcd(1111111, 1234567));
  }

  public static int gcd(int p, int q) {
    System.out.println("p = " + p + ", q = " + q);
    if (q == 0) {
      return p;
    }
    return gcd(q, p % q);
  }
}
