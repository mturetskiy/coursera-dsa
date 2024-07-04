import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxProductOfTwo {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            FastScanner scanner = new FastScanner(br);
            int count = scanner.nextInt();

            int[] elements = new int[count];
            for (int i = 0; i < count; i++) {
                elements[i] = scanner.nextInt();
            }

            long maxProduct = calcMaxProduct(elements);
            System.out.println(maxProduct);
        } catch (Exception e) {
            System.out.println("Error during input data reading: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static long calcMaxProduct(int[] elements) {
        if (elements.length <= 1) {
            return 0;
        }

        int maxIdx1 = -1;
        int maxIdx2 = -1;

        for (int i = 0; i < elements.length; i++) {
            if (maxIdx1 < 0 || elements[i] > elements[maxIdx1]) {
                maxIdx2 = maxIdx1;
                maxIdx1 = i;
            } else if (maxIdx2 < 0 || elements[i] > elements[maxIdx2]) {
                maxIdx2 = i;
            }
        }

        return (long) elements[maxIdx1] * elements[maxIdx2];
    }

    static class FastScanner {
        private StringTokenizer st;
        private BufferedReader br;

        public FastScanner(BufferedReader br) {
            this.br = br;
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }

            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}