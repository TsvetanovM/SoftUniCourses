import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

import static org.junit.Assert.*;

public class AxeTest {

    @Test
    public void testAxeConstructorSetsCorrectAttackAndDurability() {

        // First A -> Arrange || AAA
        int attack = 10;
        int durability = 13;

        //Second A -> Act || AAA
        Axe axe = new Axe(attack, durability);

        //Third A -> Assert || AAA
        assertEquals(attack, axe.getAttackPoints());
        assertEquals(durability, axe.getDurabilityPoints());
    }

    @Test(expected =  IllegalStateException.class)
    public void testAxeAttackShouldFailIfAxeHasZeroDurability() {
        int attack = 10;
        int durability = 0;
        Axe axe = new Axe(attack, durability);
        Dummy dummy = new Dummy(100, 20);

        axe.attack(dummy);

    }
}
