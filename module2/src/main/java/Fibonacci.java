import java.util.Scanner;

public class Fibonacci {
    private static int fibCalc(int n) {
        if (n < 2) {
            return n;
        }

        int[] fibValues = new int[n + 1];
        fibValues[0] = 0;
        fibValues[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibValues[i] = fibValues[i - 2] + fibValues[i - 1];
        }

        return fibValues[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = fibCalc(n);
        System.out.println(result);
    }
}