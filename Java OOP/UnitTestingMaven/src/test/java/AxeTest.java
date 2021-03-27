import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

import static org.junit.Assert.*;

public class AxeTest {

    public static final int ATTACK = 10;
    public static final int DURABILITY = 5;

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
        Dummy dummy = createDummy();

        axe.attack(dummy);

    }

    @Test
    public void testAxeLosesSingleDurabilityWhenSuccessfullyAttackingADummy() {
        Axe axe = createAxe(ATTACK, DURABILITY);
        Dummy dummy = createDummy();

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
