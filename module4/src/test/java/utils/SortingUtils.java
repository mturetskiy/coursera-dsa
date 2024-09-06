package utils;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class SortingUtils {
    public static final int MAX_ELEMENTS_TO_PRINT = 100;

    public static void assertSorted(int[] elements, Consumer<int[]> sortFunc) {
        assertSorted(elements, sortFunc, false);
    }

    public static void assertSorted(int[] elements, Consumer<int[]> sortFunc, boolean printTime) {
        int len = elements.length;
        int[] expected = Arrays.copyOf(elements, len);

        long sysSortStartTime = System.currentTimeMillis();
        Arrays.sort(expected);
        long sysSortEndTime = System.currentTimeMillis();

        sortFunc.accept(elements);
        long userSortEndTime = System.currentTimeMillis();

        if (printTime) {
            log.info("System sort time: {} ms, user sort time: {}", (sysSortEndTime - sysSortStartTime), (userSortEndTime - sysSortEndTime));
        }

        String message = len <= MAX_ELEMENTS_TO_PRINT ? Arrays.toString(elements) : "Array of " + len + " elements";
        assertTrue(Arrays.equals(expected, elements), message);
    }
}