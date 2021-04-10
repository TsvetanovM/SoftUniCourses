package aquarium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AquariumTests {
    private Aquarium aquarium;
    private Fish fish;

    @Before
    public void setUp() {
        aquarium = new Aquarium("PacificOcean", 3);
        fish = new Fish("Yanka");
        aquarium.add(fish);
    }

    @Test
    public void testConstructorSetsTheRightName() {
        assertEquals("PacificOcean", aquarium.getName());
    }

    @Test
    public void testConstructorSetsTheRightCapacity() {
        assertEquals(3, aquarium.getCapacity());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameFailsWhenNameIsNull() {
        Aquarium nullAquarium = new Aquarium(null, 600);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameFailsWhenNameIsEmpty() {
        Aquarium aquarium = new Aquarium("  ", 600);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityFailsWhenValueIsNegative() {
        Aquarium aquarium = new Aquarium("PacificOcean", -22);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFishFailsWhenAquariumIsFull() {
        aquarium.add(fish);
        aquarium.add(fish);
        aquarium.add(fish);
    }

//    @Test
//    public void testAddFishAddsTheFishToTheAquarium() {
//        aquarium.add(fish);
//    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFishFailsWhenThereIsNoFishWithSuchName() {
        aquarium.remove("Genadi");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellFishFailsWhenThereIsNoFishWithSuchName() {
        aquarium.sellFish("Genadi");
    }

    @Test
    public void testSellFishMakesFishUnavailableAfterItGetsSold() {
        aquarium.sellFish("Yanka");
        assertFalse(fish.isAvailable());
    }

    @Test
    public void testSellFishReturnsTheRightFish() {
       assertEquals(fish, aquarium.sellFish("Yanka"));
    }

    @Test
    public void testReportReturnsFullInformation() {
        Fish fish2 = new Fish("Zdenka");
        aquarium.add(fish2);
        Fish fish3 = new Fish("Mario");
        aquarium.add(fish3);

        String expected = "Fish available at PacificOcean: Yanka, Zdenka, Mario";
        String result = aquarium.report();
        assertEquals(expected, result);
    }
}

