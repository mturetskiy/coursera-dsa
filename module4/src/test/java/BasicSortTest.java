import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Consumer;

import static utils.DataGenUtils.GenMode.*;
import static utils.DataGenUtils.RANDOM;
import static utils.DataGenUtils.generateArray;
import static utils.SortingUtils.assertSorted;

class BasicSortTest {
    protected Consumer<int[]> sortFunc;

    @Test
    void testQuickSortWithIdentical() {
        assertSorted(generateArray(100, IDENTICAL), sortFunc, true);
        assertSorted(generateArray(100_000, IDENTICAL), sortFunc, true);
    }

    @Test
    void testQsCorrectnessOnRndShort() {
        int iterations = 1_000_000;
        int maxElements = 100;

        for (int i = 0; i < iterations; i++) {
            int elements = RANDOM.nextInt(Math.min(i + 1, maxElements));
            assertSorted(generateArray(elements, RND), sortFunc);
        }
    }

    @Test
    void testQsCorrectnessOnRndLong() {
        int iterations = 10_000;
        int maxElements = 1_000_000;

        for (int i = 0; i < iterations; i++) {
            int elements = RANDOM.nextInt(Math.min(i + 1, maxElements));
            assertSorted(generateArray(elements, RND), sortFunc);
        }
    }

    @Test
    void testQsCorrectnessWithSorted() {
        int maxElements = 1_000_000;
        assertSorted(generateArray(maxElements, RND), ints -> {
            Arrays.sort(ints);
            sortFunc.accept(ints);
        });

        assertSorted(generateArray(maxElements, SORTED_ASC), sortFunc);
        assertSorted(generateArray(maxElements, SORTED_DESC), sortFunc);
    }

    @Test
    void testCorrectnessWithPartiallySorted() {
        int maxElements = 1_000_000;
        assertSorted(generateArray(maxElements, HALF_SORTED_ASC), sortFunc);
        assertSorted(generateArray(maxElements, HALF_SORTED_DESC), sortFunc);
    }

    @Test
    void testQsCorrectnessWithSpecific() {
        assertSorted(new int[] {2, 3, 2, 0, 2}, sortFunc);
        assertSorted(new int[] {4, 4, 1, 4, 0}, sortFunc);
        assertSorted(new int[] {8, 8, 1, 1, 6, 2, 5, 8, 13, 3, 4, 5, 2, 2}, sortFunc);
    }
}