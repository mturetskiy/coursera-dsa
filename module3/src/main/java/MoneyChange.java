import java.util.Scanner;

public class MoneyChange {
    private static final int[] denominations = new int[] {10, 5, 1};

    private static int getChange(int m) {
        int count = 0;

        for (int d : denominations) {
            if (m >= d) {
                count += m / d;
                m = m % d;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}