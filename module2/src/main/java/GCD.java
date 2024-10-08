import java.util.Scanner;

public class GCD {
    private static int calcGcd(int a, int b) {
        int newA = a;
        int newB = b;

        while (newB != 0) {
            int tmp = newA % newB;
            newA = newB;
            newB = tmp;
        }

        return newA;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int gcd = calcGcd(a, b);
        System.out.println(gcd);
    }
}