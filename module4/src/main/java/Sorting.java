import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class Sorting {
    private static Random random = new Random();

    private static int[] partition(int[] a, int l, int r) {
        int k = random.nextInt(r - l + 1) + l;
        swap(a, k, r);

        int p1 = l;
        int p2 = l;

        for (int i = l; i < r; i++) {
            if (a[i] < a[r]) {
                swap(a,p1,i);
                p1++;

                if (a[i] == a[r]) {
                    // swap pivot-equal element back to the next after mid region pos.
                    swap(a, p2, i);
                }
                p2++;
            } else if (a[i] == a[r]) {
                swap(a, p2, i);
                p2++;
            }
        }

        // move pivot to the end of mid section.
        swap(a, p2, r);

        return new int[] {p1, p2};
    }


    public static void randomizedQuickSort(int[] a) {
        randomizedQuickSort(a, 0,a.length - 1);
    }

    public static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }

        int[] p = partition(a, l, r);
        randomizedQuickSort(a, l, p[0] - 1);
        randomizedQuickSort(a, p[1] + 1, r);
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
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
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