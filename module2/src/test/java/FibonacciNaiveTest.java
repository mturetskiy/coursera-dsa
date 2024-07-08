import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class FibonacciNaiveTest {
    private FibonacciExperiments fibCalc = new FibonacciExperiments();

    @Test
    void testNaiveFibonacci() {
        long start = System.currentTimeMillis();

        int n = 51;
        long res = fibCalc.calcFibonacciRecursive(n);

        System.out.println("Fin res for n=" + n + " => " + res + ", time: " + (System.currentTimeMillis() - start) / 1000.0f + " sec") ;
    }

    @Test
    void testFibonacciWithTable() {
        long start = System.currentTimeMillis();

        int n = 54;
        long res = fibCalc.calcFibonacciWithTable(n);

        System.out.println("Fin res for n=" + n + " => " + res + ", time: " + (System.currentTimeMillis() - start) / 1000.0f + " sec") ;
    }

    @Test
    void testLastFibNum() {
        long start = System.currentTimeMillis();

        int n = 123456;
        long res = fibCalc.calcLastFibNumber(n);

        System.out.println("Last Fib digit for n=" + n + " => " + res + ", time: " + (System.currentTimeMillis() - start) / 1000.0f + " sec") ;
    }

    @Test
    void testFibModNum() {
        long start = System.currentTimeMillis();

        int n = 114;
        int m = 1000;
        long res = fibCalc.calcFibModNum(n, m);

        System.out.println("Fib mod n for n=" + n + ", m: " + m  + " => " + res + ", time: " + (System.currentTimeMillis() - start) / 1000.0f + " sec") ;
    }

    @Test
    void testBigFib() {
        int i = 114;
        BigInteger res = fibCalc.calcFibonacciWithTableLong(i);
        System.out.println(i + " => " + res);
    }

    @Test
    void printAll() {
        for (int i = 0; i < 50; i++) {
            long res = fibCalc.calcFibonacciWithTable(i);
            System.out.println(i + " => " + res);
        }
    }
}