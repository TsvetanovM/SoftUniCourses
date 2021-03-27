package rpg_lab;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {
    private static final int EXPECTED_EXPERIENCE = 420;

    @Test
    public void testHeroGainsExperienceWhenTargetDies() {

        Weapon weapon = new Weapon() {
            @Override
            public void attack(Target target) {

            }

            @Override
            public int getAttackPoints() {
                return 0;
            }

            @Override
            public int getDurabilityPoints() {
                return 0;
            }
        };

        Target target = new Target() {
            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public void takeAttack(int attackPoints) {

            }

            @Override
            public int giveExperience() {
                return EXPECTED_EXPERIENCE;
            }

            @Override
            public boolean isDead() {
                return true;
            }
        };

        Hero hero = new Hero("Batko", weapon);
        hero.attack(target);
        assertEquals(EXPECTED_EXPERIENCE, hero.getExperience());
    }
}