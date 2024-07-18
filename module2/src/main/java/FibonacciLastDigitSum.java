import java.util.Scanner;

public class FibonacciLastDigitSum {
    public static long fibSumLastDigit(long n) {
        long newN = findNewN(n);

        if (newN < 2) {
            return (int) newN;
        }

        long prev = 0;
        long current = 1;
        long sum = 1;

        for (long i = 2; i <= newN; i++) {
            long tmp = prev + current;
            prev = current;
            current = tmp;
            sum += current;
        }

        return sum % 10;
    }

    private static long findNewN(long n) {
        long prev = 0;
        long current = 1;
        int period = 0;

        for (long i = 2; i <= n; i++) {
            long tmp = prev + current;
            prev = current;
            current = tmp % 10;
            period++;
            if (prev == 0 && current == 1) { // for some reason at period last digit of value is the same as last digit of Sum
                return n % period;
            }
        }

        return n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long result = fibSumLastDigit(n);
        System.out.println(result);
    }
}