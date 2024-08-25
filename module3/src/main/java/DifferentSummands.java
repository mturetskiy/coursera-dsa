import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<>();

        int prevSmd = 0;
        int smd = 1;
        int sum = 0;

        while (sum < n) {
            if (sum + smd > n) {
                sum -= prevSmd; // revert prev smd
                smd = n - sum;
                summands.add(smd);
                break;
            }

            if (prevSmd != 0) {
                summands.add(prevSmd);
            }

            if (sum + smd == n) {
                summands.add(smd);
                break;
            }

            sum += smd;
            prevSmd = smd;
            smd++;
        }

        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}