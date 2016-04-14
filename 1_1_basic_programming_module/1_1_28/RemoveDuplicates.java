import java.util.Arrays;

public class RemoveDuplicates {
  public static int removeDuplicates(int[] a) {
    if (a.length < 2) {
      return a.length;
    }

    int cur = 0;
    for (int i = 1; i < a.length; i++) {
      if (a[cur] != a[i]) {
        cur++;
        if (cur != i) {
          a[cur] = a[i];
        }
      }
    }
    return cur + 1;
  }

  public static void main(String[] args) {
    int[] a = {10, 10, -9, 1, 1, 32, 10, 13, 13, 13};
    Arrays.sort(a);
    int length = removeDuplicates(a);
    for (int i = 0; i < length; i++) {
      System.out.println(a[i]);
    }
  }
}

