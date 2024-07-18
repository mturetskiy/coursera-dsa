package my;

import java.math.BigInteger;

public class FibonacciExperiments {
    public long calcFibonacciRecursive(int n) {
        if (n <= 1) {
            return 1;
        }

        return calcFibonacciRecursive(n - 2) + calcFibonacciRecursive(n - 1);
    }

    public long calcFibonacciWithTable(int n) {
        if (n <= 1) {
            return 1;
        }

        long[] prev = new long[n + 1];
        prev[0] = 1;
        prev[1] = 1;

        for (int i = 2; i <= n; i++) {
            prev[i] = prev[i - 2] + prev[i - 1];
        }

        return prev[n];
    }

    public BigInteger calcFibonacciWithTableLong(int n) {
        if (n <= 1) {
            return BigInteger.ONE;
        }

        BigInteger[] prev = new BigInteger[n + 1];
        prev[0] = BigInteger.ONE;
        prev[1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            prev[i] = prev[i - 2].add(prev[i - 1]);
        }

        return prev[n];
    }

    public BigInteger calcFibonacciFast(int n) {
        if (n == 0) {
            return BigInteger.ZERO;
        }

        BigInteger prev2 = BigInteger.ZERO;
        BigInteger prev1 = BigInteger.ONE;

        for (int i = 1; i < n; i++) {
            BigInteger val = prev2.add(prev1);
            prev2 = prev1;
            prev1 = val;
        }

        return prev1;
    }

    public int calcLastFibNumber(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] prevLastDigit = new int[n + 1];
        prevLastDigit[0] = 1;
        prevLastDigit[1] = 1;

        for (int i = 2; i <= n; i++) {
            int sum = prevLastDigit[i - 1] + prevLastDigit[i - 2];
            int res = sum % 10;
            prevLastDigit[i] = res;
        }

        return prevLastDigit[n];
    }

    public long calcFibModNum(int n, int m) {
        if (n <= 1) {
            return 1;
        }

        long[] prevModVal = new long[n + 1];
        prevModVal[0] = 1;
        prevModVal[1] = 1;

        for (int i = 2; i <= n; i++) {
            long sum = prevModVal[i - 1] + prevModVal[i - 2];
            long mod = sum % m;
            prevModVal[i] = mod;
        }
        return prevModVal[n];
    }

    public static long fibSumLastDigit(long n) {
        if (n < 2) {
            return (int) n;
        }

        long prev = 0;
        long current = 1;
        long sum = 1;

        for (long i = 2; i <= n; i++) {
            long tmp = prev + current;
            prev = current;
            current = tmp;
            sum += current;
        }

        return sum % 10;
    }
}