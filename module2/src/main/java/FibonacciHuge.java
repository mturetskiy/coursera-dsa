import java.util.Scanner;

public class FibonacciHuge {
    private static int calcHugeFinModM(long n, int m) {
        if (n < 2) {
            return (int) n;
        }

        long newN = calcReducedFib(n, m);
        return calcFibModM(newN, m);
    }

    private static int calcFibModM(long n, int m) {
        if (n < 2) {
            return (int) n;
        }

        int prev = 0;
        int current = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = prev + current;
            prev = current;
            current = tmp % m;
        }

        return current;
    }

    private static long calcReducedFib(long n, int m) {
        // find period:
        long prev = 0;
        long curr = 1;
        int period = 0;

        for (int i = 2; i <= n; i++) {
            long tmp = prev + curr;
            prev = curr;
            curr = tmp % m;
            period++;

            if (prev == 0 && curr == 1) { // check for Pisano period
                return n % period;
            }
        }

        return n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int m = scanner.nextInt();
        int result = calcHugeFinModM(n, m);
        System.out.println(result);
    }
}