import my.LCM;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LCMTest {
    private LCM lcm = new LCM();
    @Test
    void testLcmCorrectness() {
        assertEquals(30, lcm.findLeastCommonMultiplier(6, 15));
        assertEquals(120, lcm.findLeastCommonMultiplier(8, 15));
        assertEquals(24, lcm.findLeastCommonMultiplier(8, 6));
        assertEquals(120, lcm.findLeastCommonMultiplier(24, 30));
        assertEquals(120, lcm.findLeastCommonMultiplier(120, 30));
    }
}