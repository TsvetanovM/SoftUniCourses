package bankSafe;


import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

import static org.junit.Assert.*;

public class BankVaultTest {
    private BankVault bankVault;
    private Item item;
    private Item secondItem;

    @Before
    public void setUp() throws OperationNotSupportedException {
        bankVault = new BankVault();
        item = new Item("Marto", "11");
        secondItem = new Item("Ive", "21");

    }

    @Test
    public void testConstructorFillsAllCellsWithNullValues() {
        boolean allMatch = bankVault.getVaultCells().values().stream().allMatch(Objects::isNull);
        assertTrue(allMatch);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemFailsWhenCelDoesNotExist() throws OperationNotSupportedException {
        bankVault.addItem("Z7", item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemFailsWhenCellIsAlreadyTaken() throws OperationNotSupportedException {
        bankVault.addItem("A1", item);
        bankVault.addItem("A1", item);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddItemFailsWhenItemAlreadyExists() throws OperationNotSupportedException {
        bankVault.addItem("A1", item);
        bankVault.addItem("B3", item);
    }

    @Test
    public void testAddItemPutsItemInTheCorrectSell() throws OperationNotSupportedException {
        bankVault.addItem("C2", secondItem);
        assertEquals(secondItem, bankVault.getVaultCells().get("C2"));
    }

    @Test
    public void testAddItemsReturnTheCorrectStringWhenItPutsANewItemIn() throws OperationNotSupportedException {
        String result = bankVault.addItem("C2", secondItem);
        assertEquals("Item:21 saved successfully!", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemFailsWhenCellDoesNotExist() {
        bankVault.removeItem("C33", item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemFailsWhenItemDoesNotExistInCell() throws OperationNotSupportedException {
        bankVault.addItem("A1", item);
        bankVault.removeItem("A1", secondItem);
    }

    @Test
    public void testRemoveItemSetsCellValueToNullWhenItemIsRemoved() throws OperationNotSupportedException {
        String cell = "A1";
        bankVault.addItem(cell, item);
        bankVault.removeItem(cell, item);
        assertNull(bankVault.getVaultCells().get(cell));
    }

    @Test
    public void testRemoveItemReturnsTheCorrectStringAfterItemIsRemoved() throws OperationNotSupportedException {
        bankVault.addItem("A1", item);
        String result = bankVault.removeItem("A1", item);
        assertEquals("Remove item:11 successfully!", result);
    }
}