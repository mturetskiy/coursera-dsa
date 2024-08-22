import java.util.*;

public class DotProduct {
    private static long maxDotProduct(int[] a, int[] b) {
        int len = a.length;
        Arrays.sort(a);
        Arrays.sort(b);

        long dotProduct = 0;

        for (int i = 0; i < len; i++) {
            dotProduct += (long)a[i] * (long)b[i];
        }

        return dotProduct;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}