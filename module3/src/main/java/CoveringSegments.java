import javax.swing.text.Segment;
import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        // Sort by segment end (right) point;

        Arrays.sort(segments, (s1, s2) -> {
            return Integer.compare(s1.end, s2.end);
        });

        List<Integer> points = new ArrayList<>();

        int i = 0;
        while (i < segments.length) {
            Segment segment = segments[i];
            int end = segment.end;
            points.add(end);

            i++;
            while (i < segments.length && segments[i].start <= end) { // skip all segments that start before current point (= intersects)
                i++;
            }
        }

        return points.stream().mapToInt(Integer::intValue).toArray();
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}