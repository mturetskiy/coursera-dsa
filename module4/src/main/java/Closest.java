import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Closest {

    static class Point implements Comparable<Point> {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (x < o.x) {
                return -1;
            } else if (x == o.x) {
                return Long.compare(y,o.y);
            } else {
                return 1;
            }
        }
    }

    static double minimalDistance(int[] x, int y[]) {
        Point[] points = new Point[x.length];
        for (int i = 0; i < x.length; i++) {
            points[i] = new Point(x[i], y[i]);
        }

        Arrays.sort(points);

        return minDistance(points, 0, points.length - 1);
    }

    static double minDistance(Point[] p, int l, int r) {
        if (p.length < 2) {
            return Double.POSITIVE_INFINITY;
        }

        return 0;
    }

    static double distance(Point p1, Point p2) {
        long a = p1.x - p2.x;
        long b = p1.y = p2.y;
        return Math.sqrt(a*a + b*b);
    }

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
        }
        System.out.println(minimalDistance(x, y));
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}