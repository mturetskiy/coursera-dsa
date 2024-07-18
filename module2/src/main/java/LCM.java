import java.util.Scanner;

public class LCM {
    private static long calcLcm(int a, int b) {
        // first calc gcd:
        int newA = a;
        int newB = b;
        while (newB != 0) {
            int tmp = newA % newB;
            newA = newB;
            newB = tmp;
        }

        int gcd = newA;

        return (long) a / gcd * b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        long lcm = calcLcm(a, b);
        System.out.println(lcm);
    }
}