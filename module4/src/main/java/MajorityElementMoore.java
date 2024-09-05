import java.util.*;
import java.io.*;

public class MajorityElementMoore {
    private static int getMajorityElement(int[] a) {
        int lastMajor = -1;
        int majorCount = 0;

        for (int i = 0; i < a.length; i++) {
            if (majorCount == 0) {
                lastMajor = a[i];
            }

            if (lastMajor == a[i]) {
                majorCount++;
            } else {
                majorCount--;
            }
        }

        // double check if it is a real major:
        majorCount = 0;
        for (int val: a) {
            if (val == lastMajor) {
                majorCount++;
            }

            if (majorCount > a.length / 2) {
                return lastMajor;
            }
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
        if (getMajorityElement(a) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
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