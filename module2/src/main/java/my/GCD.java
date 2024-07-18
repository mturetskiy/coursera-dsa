package my;

public class GCD {

    public int gcdNaive(int a, int b) {
        int d = 1;

        int maxRange = Math.min(a, b);
        for (int i = 2; i <= maxRange; i++) {
            if (a % i == 0 && b % i == 0) {
                d = i;
            }
        }

        return d;
    }

    public long gcdEuclideanRecursive(long a, long b) {
        if (b == 0) {
            return a;
        }

        long newA = b;
        long newB = a % b;
        return gcdEuclideanRecursive(newA, newB);
    }

    public long gcdEuclidean(long a, long b) {
        long currA = a;
        long currB = b;

        while (currB != 0) {
            long tmp = currB;
            currB = currA % currB;
            currA = tmp;
        }

        return currA;
    }
}