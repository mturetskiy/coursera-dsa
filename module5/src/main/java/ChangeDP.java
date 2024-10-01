import java.util.*;


public class ChangeDP {
    private static int[] coins = new int[] {1, 3, 4};

    private static int getChange(int m) {
        int[] minCost = new int[m + 1];

        for (int i = 1; i <= m; i++) {
            for (int c = 0; c < coins.length; c++) {
                int coin = coins[c];
                if (i >= coin) {
                    int delta = i - coin;
                    int cost = minCost[delta] + 1;
                    if (minCost[i] == 0 || minCost[i] > cost) {
                        minCost[i] = cost;
                    }
                }
            }
        }

        return minCost[m];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}

