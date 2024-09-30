import java.util.*;

public class PointsAndSegments {

    public static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];

        // build index for points:
        Map<Integer, List<Integer>> pIndex = new HashMap<>(points.length, 1.0f);
        for (int i = 0; i < points.length; i++) {
            List<Integer> indexes = pIndex.computeIfAbsent(points[i], v -> new ArrayList<>());
            indexes.add(i);
        }

        // build map for segments:
        Map<Integer, List<Integer>> sIndex = new HashMap<>(starts.length, 1.0f);
        for (int i = 0; i < starts.length; i++) {
            List<Integer> indexes = sIndex.computeIfAbsent(starts[i], v -> new ArrayList<>());
            indexes.add(i);
        }

        // sort distinct points:
        int[] uniquePoints = Arrays.stream(points).distinct().sorted().toArray();
        int[] uniqCnt = new int[uniquePoints.length];

        // Sort segments by start:
        int[] uniqueStarts = Arrays.stream(starts).distinct().sorted().toArray();

        //iterate over segments and mark
        for (int i = 0; i < uniqueStarts.length; i++) {
            int start = uniqueStarts[i];
            List<Integer> segmentIds = sIndex.get(start);

            for (int j = 0; j < segmentIds.size(); j++) {
                int end = ends[segmentIds.get(j)];

                processIntersectingPointsFast(uniquePoints, start, end, uniqCnt);
            }
        }

        for (int i = 0; i < uniquePoints.length; i++) {
            int count = uniqCnt[i];
            if (count == 0) {
                continue;
            }

            List<Integer> pointIndexes = pIndex.get(uniquePoints[i]);

            for (Integer pointIndex : pointIndexes) {
                cnt[pointIndex] = count;
            }
        }


        return cnt;
    }

    public static void processIntersectingPointsFast(int[] uniqPoints, int startVal, int endVal, int[] uniqCnt) {
        int l = 0;
        int r = uniqPoints.length - 1;

        int matchingIdx = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midVal = uniqPoints[mid];

            if (midVal < startVal) {
                l = mid + 1;
            } else if (midVal > startVal && midVal > endVal) {
                r = mid - 1;
            } else {
                matchingIdx = mid;
                break;
            }
        }

        if (matchingIdx == -1) {
            return;
        }

        for (int i = matchingIdx; i >= 0; i--) {
            int val = uniqPoints[i];
            if (val < startVal) {
                break;
            }

            uniqCnt[i]++;
        }

        for (int i = matchingIdx + 1; i < uniqPoints.length; i++) {
            int val = uniqPoints[i];
            if (val > endVal) {
                break;
            }

            uniqCnt[i]++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}