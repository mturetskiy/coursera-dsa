package utils;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class DataGenUtils {
    public static long SEED = System.currentTimeMillis();
    public static AtomicLong ID_GEN = new AtomicLong(SEED);
    public static Random RANDOM = new Random(SEED);

    public static int[] generateArray(int count, GenMode genMode) {
        Random rnd = new Random(ID_GEN.incrementAndGet());
        int identicalVal = rnd.nextInt();

        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            switch (genMode) {
                case RND -> res[i] = rnd.nextInt(0, count);
                case SORTED_ASC -> res[i] = i;
                case SORTED_DESC -> res[i] = count - i;
                case HALF_SORTED_ASC -> res[i] = i % 2 == 0 ? i : rnd.nextInt();
                case HALF_SORTED_DESC -> res[i] = i % 2 == 0 ? count - i : rnd.nextInt();
                case IDENTICAL -> res[i] = identicalVal;
            }
        }

        return res;
    }

    public enum GenMode {
        RND,
        SORTED_ASC,
        SORTED_DESC,
        HALF_SORTED_ASC,
        HALF_SORTED_DESC,
        IDENTICAL
    }
}