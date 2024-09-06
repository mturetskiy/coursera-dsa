import org.junit.jupiter.api.BeforeEach;

class MajorityElementDcRndQuickSortTest extends BasicSortTest {
    @BeforeEach
    void setUp() {
        sortFunc = MajorityElementDcRndQuickSort::quickSort;
    }
}