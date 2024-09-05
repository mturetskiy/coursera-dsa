import java.io.*;
import java.util.*;

public class BinarySearchDup {

    static int binarySearch(int[] a, int x) {
        int l = 0;
        int r = a.length - 1;

        if (a[l] == x) {
            return l;
        }

        l++;
        while (l <= r) {
            if (l == r && a[l - 1] != x && a[l] == x) {
                return l;
            }

            int mid = l + (r - l) / 2;
            int curr = a[mid];
            int prev = a[mid - 1];

            if (curr == x) {
                if (prev == x) { // go left
                    r = mid - 1;
                } else {
                    return mid;
                }
            } else if (curr > x) {
                r = mid  - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.print(binarySearch(a, b[i]) + " ");
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}