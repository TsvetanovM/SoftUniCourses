package aquarium.entities.fish;

public class SaltwaterFish extends BaseFish {
    private static final int INITIAL_SIZE = 5;
    // Can only live in saltwater aquarium;

    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
    }
}
