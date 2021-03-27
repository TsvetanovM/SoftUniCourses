import org.junit.Before;
import org.junit.Test;
import rpg_lab.Dummy;

import static org.junit.Assert.assertEquals;

public class DummyTest {
    private static final int EXPERIENCE = 100;
    private static final int ATTACK_POINTS = 10;
    private static final int STARTING_HEALTH_ALIVE = 100;
    private static final int STARTING_HEALTH_DEAD = 0;

    private Dummy aliveDummy;
    private Dummy deadDummy;

    @Before
    public void setUp() {
        this.aliveDummy = new Dummy(STARTING_HEALTH_ALIVE, EXPERIENCE);
        this.deadDummy = new Dummy(STARTING_HEALTH_DEAD, EXPERIENCE);
    }

    @Test
    public void testDummyLosesHealthWhenAttackedAndIsNotAlreadyDead() {
        aliveDummy.takeAttack(ATTACK_POINTS);
        assertEquals(STARTING_HEALTH_ALIVE - ATTACK_POINTS, aliveDummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyFailsWhenAttacked() {
        deadDummy.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void testDeadDummyGivesExperience() {
        int returnedExperience = deadDummy.giveExperience();
        assertEquals(EXPERIENCE, returnedExperience);
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyDoesNotGiveExperience() {
        aliveDummy.giveExperience();
    }
}
