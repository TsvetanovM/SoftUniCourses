package Inheritance;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList<Integer> {
    public Integer getRandomElement() {
        Random random = new Random();
        int randomIndex = random.nextInt(this.size() - 1);
        Integer randomElement = this.get(randomIndex);
        this.remove(randomIndex);
        return randomElement;
    }
}
