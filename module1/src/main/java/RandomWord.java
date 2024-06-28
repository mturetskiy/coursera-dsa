import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        String wordToPrint = null;

        for (int i = 1; !StdIn.isEmpty(); i++) {
            String word = StdIn.readString();
            double probability = 1.0 / i;
            boolean shouldBePrinted = StdRandom.bernoulli(probability);

            if (shouldBePrinted) {
                wordToPrint = word;
            }
        }

        System.out.println(wordToPrint);
    }
}