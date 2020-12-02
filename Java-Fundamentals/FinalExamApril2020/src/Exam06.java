import java.util.*;

public class Exam06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfHeroes = Integer.parseInt(scan.nextLine());
       Map<String, Hero> heroes = new TreeMap<>();

        for (int i = 0; i < numberOfHeroes; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String name = input[0];
            int hp = Integer.parseInt(input[1]);
            int mp = Integer.parseInt(input[2]);
            heroes.put(name, new Hero(name, hp, mp));
        }

        String[] input = scan.nextLine().split(" - ");
        while (!input[0].equals("End")) {
            String action = input[0];
            String heroName = input[1];
            switch (action) {
                case "CastSpell":
                    int manaNeeded = Integer.parseInt(input[2]);
                    if (heroes.get(heroName).getMp()-manaNeeded>=0){
                        heroes.get(heroName).setMp(heroes.get(heroName).getMp()-manaNeeded);
                        System.out.println(heroName + " has successfully cast " + input[3] + " and now has " + heroes.get(heroName).getMp() + " MP!");
                    }
                    else {
                        System.out.println(heroName + " does not have enough MP to cast " + input[3] + "!");
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(input[2]);
                    heroes.get(heroName).setHp(heroes.get(heroName).getHp()-damage);
                    if (heroes.get(heroName).getHp()>0){
                        System.out.println(heroName + " was hit for " + damage + " HP by " + input[3] + " and now has " + heroes.get(heroName).getHp() + " HP left!");
                    }
                    else {
                        System.out.println(heroName + " has been killed by " + input[3] + "!");
                        heroes.remove(heroName);
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(input[2]);
                    int leftover = 0;
                    heroes.get(heroName).setMp(heroes.get(heroName).getMp()+amount);
                    if (heroes.get(heroName).getMp()>200){
                        leftover = heroes.get(heroName).getMp()-200;
                        heroes.get(heroName).setMp(200);
                    }
                    System.out.println(heroName + " recharged for " + (amount-leftover) + " MP!");
                    break;
                case "Heal":
                    amount = Integer.parseInt(input[2]);
                    leftover = 0;
                    heroes.get(heroName).setHp(heroes.get(heroName).getHp()+amount);
                    if (heroes.get(heroName).getHp()>100){
                        leftover = heroes.get(heroName).getHp()-100;
                        heroes.get(heroName).setHp(100);
                    }
                    System.out.println(heroName + " healed for " + (amount-leftover) + " HP!");
                    break;
            }
            input = scan.nextLine().split(" - ");
        }

        heroes.entrySet().stream().sorted((h1, h2) -> Integer.compare(h2.getValue().getHp(), h1.getValue().getHp()))
                .forEach(h -> {
                    System.out.println(h.getValue().getName());
                    System.out.println("  HP: " + h.getValue().getHp());
                    System.out.println("  MP: " + h.getValue().getMp());
                });
    }
}

class Hero {
    String name;
    int hp;
    int mp;

    Hero(String n, int h, int m) {
        this.name = n;
        this.hp = h;
        this.mp = m;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }
}
