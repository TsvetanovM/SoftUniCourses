package p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DatabaseTest {
    private static final int INPUT_ARRAY_SIZE = 10;

    private Database database;
    private Integer testElement;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(generateInputArray(INPUT_ARRAY_SIZE));
        testElement = null;
    }

    @Test
    public void testCtorSetsCorrectValues() {
        assertArrayEquals(database.getElements(), generateInputArray(INPUT_ARRAY_SIZE));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCtorThrowsExceptionWhenArraySizeNotWithinLimits() throws OperationNotSupportedException {
        database = new Database(generateInputArray(22));
    }

    @Test
    public void testAddMethodAddsElementInTheNextAvailableCell() throws OperationNotSupportedException {
        testElement = 42;
        database.add(testElement);
        assertEquals(testElement, database.getElements()[database.getElements().length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddMethodThrowsExceptionWhenElementIsNull() throws OperationNotSupportedException {
        database.add(testElement);
    }

    @Test
    public void testRemoveMethodRemovesTheElementWithHighestIndex() throws OperationNotSupportedException {
        testElement = INPUT_ARRAY_SIZE - 1;
        database.remove();
        assertEquals(testElement, database.getElements()[database.getElements().length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveMethodThrowsAnExceptionWhenArrayIndexIsOutOfBounds() throws OperationNotSupportedException {
        while (true) {
            database.remove();
        }
    }

    private Integer[] generateInputArray(int size) {
        Integer[] array = new Integer[size];
        int currentNumber = 1;
        for (int i = 0; i < size; i++) {
            array[i] = currentNumber++;
        }
        return array;
    }
}