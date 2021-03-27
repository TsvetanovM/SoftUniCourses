package rpg_lab;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class HeroTest {
    private static final int EXPECTED_EXPERIENCE = 420;

    @Test
    public void testHeroGainsExperienceWhenTargetDies() {

        Weapon weapon = mock(Weapon.class);
        Hero hero = new Hero("Batko", weapon);

        Target target = mock(Target.class);
        when(target.isDead()).thenReturn(true);
        when(target.giveExperience()).thenReturn(EXPECTED_EXPERIENCE);
        hero.attack(target);
        assertEquals(EXPECTED_EXPERIENCE, hero.getExperience());
    }
}