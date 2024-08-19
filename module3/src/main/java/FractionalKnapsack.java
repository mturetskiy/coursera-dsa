import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        int freeWeight = capacity;

        int len = values.length;
        double[] factors = new double[len]; // value per weight.
        for (int i = 0; i < len; i++) {
            int val = values[i];
            int weight = weights[i];
            factors[i] = val / (double) weight;
        }

        int nextId = getMostValuableIdx(factors);
        while (freeWeight > 0 && nextId != -1) {
            int weight = weights[nextId];
            int val = values[nextId];

            if (freeWeight >= weight) {
                value += val;
                freeWeight -= weight;
                nextId = getMostValuableIdx(factors);
            } else {
                value += (val * freeWeight / (double) weight);
                break;
            }
        }

        return BigDecimal.valueOf(value).setScale(4, RoundingMode.HALF_UP).doubleValue();
    }

    private static int getMostValuableIdx(double[] factors) {
        int maxFactorIdx = -1;
        double maxFactor = 0;
        for (int i = 0; i < factors.length; i++) {
            if (factors[i] <= 0) {
                continue;
            }

            if (factors[i] > maxFactor) {
                maxFactor = factors[i];
                maxFactorIdx = i;
            }
        }

        if (maxFactorIdx >= 0) {
            factors[maxFactorIdx] = -1.0;
        }

        return maxFactorIdx;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 