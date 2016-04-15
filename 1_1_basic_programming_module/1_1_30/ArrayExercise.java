public class ArrayExercise {
  public static int gcd(int p, int q) {
    if (q == 0) {
      return p;
    }
    return gcd(q, p % q);
  }

  public static boolean[][] getArray(int n) {
    boolean[][] arr = new boolean[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (gcd(i, j) == 1) {
          arr[i][j] = true;
        }
      }
    }

    return arr;
  }

  public static void main(String[] args) {
    boolean[][] arr = getArray(5);
    for (int i = 1; i <= 5; i++) {
      for (int j = 1; j <=5; j++) {
        System.out.println("a[" + i + "][" + j + "] = " + arr[i][j]);
      }
    }
  }
}

