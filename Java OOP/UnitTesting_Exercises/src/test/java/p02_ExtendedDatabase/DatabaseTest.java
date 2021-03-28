package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DatabaseTest {

    private static final int INPUT_ARRAY_SIZE = 10;
    private Database database;
    private String username;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(generateInputArray(INPUT_ARRAY_SIZE));
        username = "1";
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameMethodFailsWhenUsernameEqualsNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameMethodFailsWhenManyPeopleHaveTheSameUsername() throws OperationNotSupportedException {
        database.add(createMockPersonWithUsername(username));
        database.findByUsername(username);
    }

    @Test
    public void testFindByUsernameMethodReturnsPersonWhenUsernameMatchesOneElement() throws OperationNotSupportedException {
        assertEquals(username, database.findByUsername(username).getUsername());
    }

    private Person[] generateInputArray(int size) {
        Person[] array = new Person[size];
        int usernameCounter = 1;
        for (int i = 0; i < size; i++) {
            array[i] = createMockPersonWithUsername(String.valueOf(usernameCounter));
            usernameCounter++;
        }
        return array;
    }

    private Person createMockPersonWithUsername(String username) {
        Person person = mock(Person.class);
        when(person.getUsername()).thenReturn(String.valueOf(username));
        return person;
    }
}