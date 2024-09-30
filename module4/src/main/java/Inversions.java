import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class Inversions {

    private static long getNumberOfInversions(int[] a) {
        AtomicLong swapCount = new AtomicLong();
        int[] sorted = mergeSort(a, 0, a.length - 1, swapCount);
        return swapCount.get();
    }

    private static int[] mergeSort(int[] a, int l, int r, AtomicLong swapCount) {
        if (l > r) {
            return new int[0];
        }

        if (l == r) {
            return new int[] {a[l]};
        }

        int mid = l + (r - l) / 2;
        int[] lPart = mergeSort(a, l, mid, swapCount);
        int[] rPart = mergeSort(a, mid + 1, r, swapCount);

        return merge(lPart, rPart, swapCount);
    }

    private static int[] merge(int[] a, int[] b, AtomicLong swapCount) {
        int l = a.length + b.length;
        int[] res = new int[l];

        int aIdx = 0;
        int bIdx = 0;
        for (int i = 0; i < l; i++) {
            if (aIdx < a.length && bIdx < b.length) {

                if (a[aIdx] <= b[bIdx]) {
                    res[i] = a[aIdx];
                    aIdx++;
                } else {
                    int n = a.length - aIdx; // so many elements from aIdx are higher than a[bIdx]
                    swapCount.addAndGet(n);

                    res[i] = b[bIdx];
                    bIdx++;
                }

            } else if (aIdx < a.length) {
                res[i] = a[aIdx];
                aIdx++;
            } else {
                res[i] = b[bIdx];
                bIdx++;
            }
        }

        return res;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        System.out.println(getNumberOfInversions(a));
    }
}