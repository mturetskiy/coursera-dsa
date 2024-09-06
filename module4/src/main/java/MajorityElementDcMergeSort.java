import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MajorityElementDcMergeSort {
    public static int getMajorityElement(int[] a) {
        if (a.length == 0) {
            return -1;
        }
        // Sort:
        int[] sorted = mergeSort(a);

        // take median:
        int midIdx = sorted.length / 2;
        int midValStart = getStartPosForElement(sorted, midIdx);
        int midValEnd = getEndPosForElement(sorted, midIdx);
        int length = midValEnd - midValStart + 1;

        if (length > a.length / 2) {
            return sorted[midIdx];
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

    public static int[] mergeSort(int[] a) {
        return mergeSort(a, 0, a.length - 1);
    }

    private static int[] mergeSort(int[] a, int left, int right) {
        if (left == right) {
            return new int[] {a[left]};
        }

        int mid = left + (right - left) / 2;
        int[] leftPart = mergeSort(a, left, mid);
        int[] rightPart = mergeSort(a, mid + 1, right);
        return merge(leftPart, rightPart);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];

        int lIdx = 0;
        int rIdx = 0;
        int resIdx = 0;
        while (resIdx < res.length) {
            if (lIdx < left.length && rIdx < right.length) {
                if (left[lIdx] < right[rIdx]) {
                    res[resIdx++] = left[lIdx];
                    lIdx++;
                } else {
                    res[resIdx++] = right[rIdx];
                    rIdx++;
                }
            } else if (lIdx < left.length) {
                res[resIdx++] = left[lIdx];
                lIdx++;
            } else {
                res[resIdx++] = right[rIdx];
                rIdx++;
            }


        }

        return res;
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