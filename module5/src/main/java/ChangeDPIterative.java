import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;


public class ChangeDPIterative {
    private static int[] coins = new int[] {1, 3, 4};
//    private static int[] coins = new int[] {3, 4, 8};

    private static int getChangeFast(int m) {
        long start = System.currentTimeMillis();
        int minCoin = Arrays.stream(coins).min().getAsInt();

        int[] minCosts = new int[m + 1];
        for (int c = 0; c < coins.length; c++) {
            int coin = coins[c];
            minCosts[coin] = 1;
        }


        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(m);

        while (!stack.isEmpty()) {
            int money = stack.pop();
            if (money < minCoin) {
                minCosts[money] = -1;
                continue;
            }

            if (minCosts[money] > 0) { // already known
                continue;
            }

            int minCost = 0;
            boolean pushed = false;

            for (int c = 0; c < coins.length; c++) {
                int coin = coins[c];
                if (money < coin) {
                    minCosts[money] = -1;
                    continue;
                }

                int delta = money - coin;
                int cost = minCosts[delta];

                if (cost < 0) {
                    continue;
                }

                if (delta < minCoin) {
                    minCosts[delta] = -1;
                    continue;
                }

                if (cost == 0) {
                    if (!pushed) {
                        stack.push(money); // we need to visit it again, when all siblings are calculated
                        pushed = true;
                    }
                    stack.push(delta);
                } else {
                    if (minCost == 0 || cost < minCost) {
                        minCost = cost;
                    }
                }
            }

            if (!pushed && minCost > 0) {
                minCosts[money] = minCost + 1;
            }
        }

        System.out.println("Time: " + (System.currentTimeMillis() - start) + " ms");

        return minCosts[m];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChangeFast(m));

    }
}

