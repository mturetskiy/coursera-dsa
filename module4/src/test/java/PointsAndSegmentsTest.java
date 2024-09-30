import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
class PointsAndSegmentsTest {

    @Test
    void testBasicCase() {
        assertArrayEquals(
                new int[]{1, 0, 0},
                PointsAndSegments.fastCountSegments(new int[]{0, 7}, new int[]{5, 10}, new int[]{1, 6, 11})
        );

        assertArrayEquals(
                new int[]{3, 2, 3, 3, 0, 1, 2, 3},
                PointsAndSegments.fastCountSegments(new int[]{0, 0, 1}, new int[]{2, 4, 5}, new int[]{1, 0, 2, 1, 7, 5, 4, 1})
        );

        assertArrayEquals(
                new int[]{0, 0, 1},
                PointsAndSegments.fastCountSegments(new int[]{-10}, new int[]{10}, new int[]{-100, 100, 0})
        );

        assertArrayEquals(
                new int[]{2, 0},
                PointsAndSegments.fastCountSegments(new int[]{0, -3, 7}, new int[]{5, 2, 10}, new int[]{1, 6})
        );
    }

    @Test
    void perfTest() {
        int segmentsCount = 50_000;
        int pointsCount = 50_000;
        int minPoint = -100;
        int maxPoint = 1_000_000;

        Pair<int[], int[]> segments = generateSegments(segmentsCount, minPoint, maxPoint);
        int[] points = generatePoints(pointsCount, minPoint, maxPoint);

        long start = System.currentTimeMillis();
        int[] counts = PointsAndSegments.fastCountSegments(segments.getLeft(), segments.getRight(), points);
        long end = System.currentTimeMillis();
        assertNotNull(counts);
        log.info("Result: time: {} ms", end - start);
    }

    private Pair<int[], int[]> generateSegments(int count, int minPoint, int maxPoint) {
        Pair<int[], int[]> res = new ImmutablePair<>(new int[count], new int[count]);
        Random rnd = new Random();

        for (int i = 0; i < count; i++) {
            int start = rnd.nextInt(minPoint, maxPoint);
//            int end = rnd.nextInt(start, maxPoint);
            int end = rnd.nextInt(Math.min(maxPoint - 5,start), maxPoint);

            res.getLeft()[i] = start;
            res.getRight()[i] = end;
        }

        return res;
    }

    private int[] generatePoints(int count, int minPoint, int maxPoint) {
        Random rnd = new Random();
        int[] res = new int[count];

        for (int i = 0; i < count; i++) {
            res[i] = rnd.nextInt(minPoint - 100, maxPoint + 100);;
        }

        return res;
    }

    //    @Test
//    void testFindClosestNext() {
//        assertEquals(3, PointsAndSegments.lookupClosestNextIntersectingPoint(new int[] {5, 6, 6, 7, 7, 7, 8, 9, 11}, 7, 10));
//        assertEquals(0, PointsAndSegments.lookupClosestNextIntersectingPoint(new int[] {0, 1, 3, 5, 6, 8}, 0, 5));
//        assertEquals(-1, PointsAndSegments.lookupClosestNextIntersectingPoint(new int[] {0, 1, 3, 5, 6, 8}, 10, 14));
//        assertEquals(2, PointsAndSegments.lookupClosestNextIntersectingPoint(new int[] {0, 1, 3, 5, 6, 8}, 2, 10));
//        assertEquals(0, PointsAndSegments.lookupClosestNextIntersectingPoint(new int[] {0, 1, 3, 5, 6, 8}, -5, 10));
//        assertEquals(0, PointsAndSegments.lookupClosestNextIntersectingPoint(new int[] {3, 5, 6, 8}, 1, 10));
//    }
//
//    @Test
//    void testFindClosestPrev() {
//        assertEquals(7, PointsAndSegments.lookupClosestPrevIntersectingPoint(new int[] {5, 6, 6, 7, 7, 7, 8, 9, 11}, 7, 10));
//        assertEquals(3, PointsAndSegments.lookupClosestPrevIntersectingPoint(new int[] {0, 1, 3, 5, 6, 8}, 0, 5));
//        assertEquals(-1, PointsAndSegments.lookupClosestPrevIntersectingPoint(new int[] {0, 1, 3, 5, 6, 8}, 10, 14));
//        assertEquals(5, PointsAndSegments.lookupClosestPrevIntersectingPoint(new int[] {0, 1, 3, 5, 6, 8}, 2, 10));
//        assertEquals(3, PointsAndSegments.lookupClosestPrevIntersectingPoint(new int[] {3, 5, 6, 8}, 1, 10));
//    }
}