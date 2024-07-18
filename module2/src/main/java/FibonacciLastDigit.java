import java.util.Scanner;

public class FibonacciLastDigit {
    private static int fibLastDigit(int n) {
        if (n < 2) {
            return n;
        }

        int d2 = 0; // last digit of fib num for n-2
        int d1 = 1; // last digit of fib num for n-1

        for (int i = 2; i <= n; i++) {
            int dn = (d2 + d1) % 10;
            d2 = d1;
            d1 = dn;
        }

        return d1;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = fibLastDigit(n);
        System.out.println(result);
    }
}