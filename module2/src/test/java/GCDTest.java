import lombok.extern.slf4j.Slf4j;
import my.GCD;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class GCDTest {
    private GCD gcd = new GCD();
    @Test
    void testNaiveCorrectness() {
        assertEquals(4, gcd.gcdNaive(4, 8));
        assertEquals(4, gcd.gcdNaive(12, 16));
        assertEquals(3, gcd.gcdNaive(357, 234));
    }

    @Test
    void testEuclideanRecursiveCorrectness() {
        assertEquals(4, gcd.gcdEuclideanRecursive(4, 8));
        assertEquals(4, gcd.gcdEuclideanRecursive(12, 16));
        assertEquals(3, gcd.gcdEuclideanRecursive(357, 234));
    }

    @Test
    void testEuclideanCorrectness() {
        assertEquals(4, gcd.gcdEuclidean(4, 8));
        assertEquals(4, gcd.gcdEuclidean(12, 16));
        assertEquals(3, gcd.gcdEuclidean(357, 234));
    }

    @Test
    void testNaiveTime() {
        long start = System.currentTimeMillis();
        int res = gcd.gcdNaive(1024 * 1024, 2048 * 4096 * 255);

        log.info("Naive time: {} ms", System.currentTimeMillis() - start);
        assertEquals(1024 * 1024, res);
    }

    @Test
    void testEuclideanRecursiveTime() {
        long start = System.currentTimeMillis();
        long res = gcd.gcdEuclideanRecursive(1024L * 1024 * 1024 * 2048, 2048L * 4096 * 255* 256 * 4096);

        log.info("Euclidean recursive time: {} ms", System.currentTimeMillis() - start);
        assertEquals(2199023255552L, res);
    }

    @Test
    void testEuclidean() {
        long start = System.currentTimeMillis();
        long res = gcd.gcdEuclidean(1024L * 1024 * 1024 * 2048, 2048L * 4096 * 255* 256 * 4096);

        log.info("Euclidean time: {} ms", System.currentTimeMillis() - start);
        assertEquals(2199023255552L, res);
    }
}