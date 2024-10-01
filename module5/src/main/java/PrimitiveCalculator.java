import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        LinkedList<Integer> sequence = new LinkedList<>();

        int startValue = 1;
        int[] minOps = new int[n + 1];
        int[] parents = new int[n + 1];

        for (int i = startValue + 1; i <= n; i++) {
            // +1 case:
            int delta = i - 1;
            int opCount = minOps[delta] + 1;
            int parent = delta;

            // x2 case:
            if (i % 2 == 0) {
                int d = i / 2;
                int opCount2 = minOps[d] + 1;
                if (opCount2 < opCount) {
                    opCount = opCount2;
                    parent = d;
                }
            }

            // x3 case:
            if (i % 3 == 0) {
                int d = i / 3;
                int opCount3 = minOps[d] + 1;
                if (opCount3 < opCount) {
                    opCount = opCount3;
                    parent = d;
                }
            }

            minOps[i] = opCount;
            parents[i] = parent;
        }

        sequence.addFirst(n);
        int p = parents[n];
        while (p > 0) {
            sequence.addFirst(p);
            p = parents[p];
        }

        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

