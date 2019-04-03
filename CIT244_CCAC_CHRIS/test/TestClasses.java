import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import utils.sorting.Sorter;

public class TestClasses {

    @Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {
        Sorter tester = new Sorter(); // MyClass is tested

        // assert statements
        int[] arrayToSort = new int[]{10,6,4,1};
        assertEquals(0, tester.bubbleSort(), "1,4,6,10");
        assertEquals(0, tester.multiply(0, 10), "0 x 10 must be 0");
        assertEquals(0, tester.multiply(0, 0), "0 x 0 must be 0");
    }
}