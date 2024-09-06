import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;

@Slf4j
class MajorityElementDc3WayRndQuickSortTest extends BasicSortTest {
    @BeforeEach
    void setUp() {
        sortFunc = MajorityElementDc3WayRndQuickSort::quickSort;
    }
}