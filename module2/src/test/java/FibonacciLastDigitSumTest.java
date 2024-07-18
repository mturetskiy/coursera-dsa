import my.FibonacciExperiments;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciLastDigitSumTest {
    @Test
    void testSumLastDigitCorrectness() {
        for (int i = 0; i < 90; i++) {
            long expected = FibonacciExperiments.fibSumLastDigit(i);
            long actual = FibonacciLastDigitSum.fibSumLastDigit(i);
            assertEquals(expected, actual);
        }
    }
}