import java.util.Arrays;

public class BinarySearch {
  public static void main(String[] args) {
    int[] a = {19, 10, -3, 1, 99, 8};
    int key = 8;
    Arrays.sort(a);
    int index = rank(a, key);
    System.out.println("Index: " + index);
  }

  public static int rank(int[] a, int key) {
    return rank(a, 0, a.length - 1, key, 0);
  }

  public static int rank(int[] a, int lo, int hi, int key, int depth) {
    for (int i = 0; i < depth; i++) {
      System.out.print(" ");
    }
    System.out.println("lo: " + lo + ", hi: " + hi);
    int mid = lo + (hi - lo) / 2;
    if (lo > hi) {
      return -1;
    }
    if (a[mid] == key) {
      return mid;
    } else if (a[mid] < key) {
      return rank(a, mid + 1, hi, key, depth + 1);
    } else {
      return rank(a, lo, mid - 1, key, depth + 1);
    }
  }
}

