import org.junit.Test;
import rpg_lab.Dummy;

import static org.junit.Assert.assertEquals;

public class DummyTest {
    private static final int EXPERIENCE = 100;
    private static final int ATTACK_POINTS = 10;
    private static final int STARTING_HEALTH = 100;

    private Dummy dummy;

    @Test
    public void testDummyLosesHealthIfAttackedAndIsNotAlreadyDead() {
        dummy = createDummy();
        dummy.takeAttack(ATTACK_POINTS);
        assertEquals(STARTING_HEALTH - ATTACK_POINTS, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyThrowsExceptionWhenAttacked() {
        dummy = createDeadDummy();
        dummy.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void testDeadDummyGivesXP() {
        dummy = createDeadDummy();
        int returnedExperience = dummy.giveExperience();
        assertEquals(EXPERIENCE, returnedExperience);
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyCannotGiveXP() {
        dummy = createDummy();
        dummy.giveExperience();
    }

    private Dummy createDummy() {
        return new Dummy(STARTING_HEALTH, EXPERIENCE);
    }

    private Dummy createDeadDummy() {
        return new Dummy(0, EXPERIENCE);
    }
}
