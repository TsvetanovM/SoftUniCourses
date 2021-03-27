import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

import static org.junit.Assert.*;

public class AxeTest {

    public static final int ATTACK = 10;
    public static final int DURABILITY = 5;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp() {
        axe = createAxe(ATTACK, DURABILITY);
        dummy = createDummy();
    }

    @Test
    public void testAxeConstructorSetsCorrectAttackAndDurability() {

        // First A -> Arrange || AAA
        int attack = 10;
        int durability = 13;

        //Second A -> Act || AAA
        Axe axe = createAxe(attack, durability);

        //Third A -> Assert || AAA
        assertEquals(attack, axe.getAttackPoints());
        assertEquals(durability, axe.getDurabilityPoints());
    }

    @Test(expected =  IllegalStateException.class)
    public void testAxeAttackShouldFailIfAxeHasZeroDurability() {
        int durability = 0;
        Axe axe = createAxe(ATTACK, durability);
        axe.attack(dummy);
    }

    @Test
    public void testAxeLosesSingleDurabilityWhenSuccessfullyAttackingADummy() {
        axe.attack(dummy);
        assertEquals(DURABILITY - 1, axe.getDurabilityPoints());
    }

    private Axe createAxe(int attack, int durability) {
        return new Axe(attack, durability);
    }

    private Dummy createDummy() {
        return new Dummy(100, 50);
    }
}
