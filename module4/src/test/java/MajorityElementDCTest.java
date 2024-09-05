import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MajorityElementDCTest {
    private long seed = System.currentTimeMillis();
//    private long seed = 1725534565259L;
    private Random rnd = new Random(seed);

    @Test
    void testQuickSort() {
        int[] ints = generateArray(10_000_000, GenMode.RND);

//        System.out.println("Original: " + Arrays.toString(ints));

        int[] expected = Arrays.copyOf(ints, ints.length);
        Arrays.sort(expected);

        long start = System.currentTimeMillis();
//        MajorityElementDC.selectionSort(ints);
//        int[] sorted = MajorityElementDC.mergeSort(ints, 0, ints.length - 1);
        MajorityElementDcQs.quickSort(ints, 0, ints.length - 1);
        long end = System.currentTimeMillis();

//        System.out.println("Expected: " + Arrays.toString(expected));
//        System.out.println("Sorted: " + Arrays.toString(ints));
        assertTrue(Arrays.equals(expected, ints));
        System.out.println("Sort time: " + (end - start) + " ms");
    }

    private int[] generateArray(int count, GenMode genMode) {
        System.out.println("Generate using seed: " + seed);
        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            switch (genMode) {
                case RND -> res[i] = rnd.nextInt(0, count * 5);
                case SORTED_ASC -> res[i] = i;
                case SORTED_DESC -> res[i] = count - i;
                case HALF_SORTED_ASC -> res[i] = i % 2 == 0 ? i : rnd.nextInt();
                case HALF_SORTED_DESC -> res[i] = i % 2 == 0 ? count - i : rnd.nextInt();
            }
        }

        return res;
    }

    enum GenMode {
        RND,
        SORTED_ASC,
        SORTED_DESC,
        HALF_SORTED_ASC,
        HALF_SORTED_DESC
    }
}