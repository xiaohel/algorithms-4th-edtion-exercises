import edu.princeton.cs.algs4.StdRandom;

public class DiceSimulation {
  private static final int SIDES = 6;

  public static double[] exact() {
    double[] dist = new double[2 * SIDES + 1];
    for (int i = 1; i <= SIDES; i++) {
      for (int j = 1; j <= SIDES; j++) {
        dist[i + j] += 1.0;
      }
    }

    for (int i = 2; i <= 2 * SIDES; i++) {
      dist[i] /= 36.0;
    }

    return dist;
  }

  public static double[] experiment(int n) {
    double[] dist = new double[2 * SIDES + 1];
    for (int i = 0; i < n; i++) {
      dist[throwDices()] += 1.0;
    }

    for (int i = 0; i <= 2 * SIDES; i++) {
      dist[i] /= n;
    }

    return dist;
  }

  private static int throwDices() {
    return StdRandom.uniform(1, SIDES + 1) + StdRandom.uniform(1, SIDES + 1);
  }

  public static void main(String[] args) {
    int n = 10000000; //20000000
    double[] exact = exact();
    double[] experiment = experiment(n);
    System.out.printf("Exact\tExperiment\n");
    for (int i = 2; i <= 2 * SIDES; i++) {
      System.out.printf("%6.3f\t%6.3f\n", exact[i], experiment[i]);
    }
  }
}

