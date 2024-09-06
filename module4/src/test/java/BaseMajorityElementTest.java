import org.junit.jupiter.api.Test;
import utils.DataGenUtils.GenMode;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.DataGenUtils.GenMode.RND;
import static utils.DataGenUtils.generateArray;
import static utils.SortingUtils.MAX_ELEMENTS_TO_PRINT;

class BaseMajorityElementTest {
    protected Function<int[], Integer> expectedMajorityFunc = MajorityElementMoore::getMajorityElement;
    protected Function<int[], Integer> userMajorityFunc = MajorityElementMoore::getMajorityElement;

    @Test
    void testMajorityOnShort() {
        assertMajorityMultipleIters(1_000_000, () -> 5);
    }

    @Test
    void testMajorityOnLong() {
        assertMajorityMultipleIters(1_000, () -> 100_000);
    }

    private void assertMajorityMultipleIters(int iterations, Supplier<Integer> elementsPerIter) {
        int majorityFoundCount = 0;

        for (int i = 0; i < iterations; i++) {
            int[] ints = generateArray(elementsPerIter.get(), GenMode.RND);

            int majorityElement = assertMajority(ints);
            if (majorityElement != -1) {
                majorityFoundCount++;
            }
        }

        String message = "Too few majority found cases: " + majorityFoundCount + " of " + iterations + ". Bad arrays.";
        assertTrue(majorityFoundCount > iterations / 5, message);
    }

    @Test
    void testMajorityCorrectnessOnSpecific() {
        assertMajority(new int [] {});
        assertMajority(new int [] {1});
        assertMajority(new int [] {1, 1});
        assertMajority(new int [] {1, 2});
        assertMajority(new int [] {1, 2, 3});
        assertMajority(new int [] {1, 2, 1});
        assertMajority(new int [] {3, 2, 1, 2, 1});
        assertMajority(new int [] {3, 2, 1, 2, 2});
        assertMajority(new int [] {3, 2, 1, 2, 2, 3});
        assertMajority(new int [] {3, 2, 1, 2, 2, 2});
        assertMajority(new int [] {2, 2, 2, 2, 2, 2});
        assertMajority(new int [] {2, 2, 2, 1, 2, 2});
        assertMajority(new int [] {2, 2, 1, 1, 2, 2});
        assertMajority(new int [] {2, 3, 9, 2, 2});
        assertMajority(new int [] {2, 3, 9, 2, 2, 9, 9, 9, 3, 2});
        assertMajority(new int [] {2, 3, 3, 2, 2, 2});
        assertMajority(new int [] {1, 1, 1, 2, 3, 4, 5});
        assertMajority(new int [] {7, 1, 3, 2, 4 , 2});
        assertMajority(new int [] {0});
        assertMajority(new int [] {0, 0, 0});
        assertMajority(new int [] {0, 1, 0, 1});
        assertMajority(new int [] {0, 1, 0, 1, -1});
        assertMajority(new int [] {0, 1, 2, 3, 4, 5});

    }

    @Test
    void testMajorityCorrectness2() {
        assertMajority(generateArray(100_000, RND));
    }

    private int assertMajority(int[] data) {
        return assertMajority(data, userMajorityFunc);
    }

    private int assertMajority(int[] data, Function<int[], Integer> majorityFunc) {
        int len = data.length;
        int[] ints1 = Arrays.copyOf(data, len);
        int expectedMajority = expectedMajorityFunc.apply(data);

        String message = len <= MAX_ELEMENTS_TO_PRINT ? Arrays.toString(data) : "Array of " + len + " elements";
        assertEquals(expectedMajority, majorityFunc.apply(ints1), "data: " + message);
        return expectedMajority;
    }

}