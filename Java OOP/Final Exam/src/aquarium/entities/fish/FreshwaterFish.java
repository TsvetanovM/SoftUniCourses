package aquarium.entities.fish;

public class FreshwaterFish extends BaseFish {
    private static final int INITIAL_SIZE = 3;
    // Can only live in freshWater aquarium;

    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
    }
}
