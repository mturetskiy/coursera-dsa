package my;

public class LCM {
    private GCD gcdCalc = new GCD();

    public long findLeastCommonMultiplier(long a, long b) {

        long gcd = gcdCalc.gcdEuclidean(a, b);
        long lcm = a / gcd * b;
        return lcm;
    }
}