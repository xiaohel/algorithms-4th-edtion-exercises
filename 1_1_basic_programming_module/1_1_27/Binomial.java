import java.util.Arrays;

public class Binomial {
  public static double binomial(int n, int k, double p) {
    if (n == 0 && k == 0) {
      return 1.0;
    }

    if (n < 0 || k < 0) {
      return 0.0;
    }

    return (1.0 - p) * binomial(n - 1, k, p) + p * binomial(n - 1, k - 1, p);
  }

  public static double binomial_saved_worker(int n, int k, double p, double[][] saved) {
    if (n < 0 || k < 0) {
      return 0.0;
    }

    if (n == 0 && k == 0) {
      return 1.0;
    }

    if (saved[n][k] != -1.0) {
      return saved[n][k];
    }

    saved[n][k] = (1.0 - p) * binomial_saved_worker(n - 1, k, p, saved) + p * binomial_saved_worker(n - 1, k - 1, p, saved);

    return saved[n][k];
  }

  public static double binomial_saved(int n, int k, double p) {
    double[][] saved = new double[n + 1][k + 1];
    for (double[] row : saved) {
      Arrays.fill(row, -1.0);
    }

    return binomial_saved_worker(n, k, p, saved);
  }

  public static void main(String[] args) {
    int n = 100;
    int k = 50;
    double p = 0.2;

    System.out.println(binomial(n, k, p));
    System.out.println(binomial_saved(n, k, p));
  }
}

