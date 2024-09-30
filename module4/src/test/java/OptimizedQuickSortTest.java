import org.junit.jupiter.api.BeforeEach;

class OptimizedQuickSortTest extends BasicSortTest {
    @BeforeEach
    void setUp() {
        sortFunc = Sorting::randomizedQuickSort;
    }
}