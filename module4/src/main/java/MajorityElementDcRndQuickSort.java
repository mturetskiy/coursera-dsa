import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class MajorityElementDcRndQuickSort {
    private static final Random rnd = new Random(System.currentTimeMillis());

    public static int getMajorityElement(int[] a) {
        if (a.length == 0) {
            return -1;
        }

        // Sort:
        quickSort(a);

        // take median:
        int midIdx = a.length / 2;
        int midValStart = getStartPosForElement(a, midIdx);
        int midValEnd = getEndPosForElement(a, midIdx);
        int length = midValEnd - midValStart + 1;

        if (length > a.length / 2) {
            return a[midIdx];
        }

        return -1;
    }

    private static int getStartPosForElement(int[] a, int idx) {
        if (idx == 0) {
            return idx;
        }

        // look for start - where given val changes to some other val:
        int l = 0;
        int r = idx - 1;
        int startPos = l;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (a[m] != a[idx]) { // go right
                startPos = m + 1; // remember
                l = m + 1;
            } else { // still the same val  - go left
                r = m - 1;
            }
        }

        return startPos;
    }

    private static int getEndPosForElement(int[] a, int idx) {
        if (idx == a.length - 1) {
            return idx;
        }

        int val = a[idx];
        int l = idx + 1;
        int r = a.length - 1;
        int endPos = r;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (val == a[mid]) { // still the same val - go right
                l = mid + 1;
            } else { // some other value - remember and go left
                endPos = mid - 1;
                r = mid - 1;
            }
        }

        return endPos;
    }

    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }

        int p = partition(a, l, r);
        quickSort(a, l, p - 1);
        quickSort(a, p + 1, r);
    }

    private static int partition(int[] a, int l, int r) {
        int rndPivot = rnd.nextInt(l, r + 1);
        swap(a,rndPivot,r);

        int q = l; // left pos of high part (greater than pivot)

        for (int i = l; i < r; i++) {
            if (a[i] <= a[r]) {
                swap(a, i, q); // swap current smaller elem with
                q++;
            }
        }

        swap(a, q, r);
        return q;
    }

    private static void swap(int[] a, int idxA, int idxB) {
        if (idxA == idxB) {
            return;
        }

        int tmp = a[idxA];
        a[idxA] = a[idxB];
        a[idxB] = tmp;
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