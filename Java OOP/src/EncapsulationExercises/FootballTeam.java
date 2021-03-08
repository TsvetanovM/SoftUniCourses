package EncapsulationExercises;

import java.util.ArrayList;
import java.util.List;

public class FootballTeam {
    private String name;
    private List<Player> players;

    public FootballTeam(String name) {
        setName(name);
        players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println(("A name should not be empty."));
        } else this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String playerName) {
        boolean playerExists = players.removeIf(player -> player.getName().equals(playerName));
        if (!playerExists) {
            System.out.printf("Player %s is not in %s team.%n", playerName, this.name);
        }
    }

    public double getRating() {
        double rating = 0;
        for (Player player : players) {
            rating += player.overallSkillLevel();
        }
        return rating / players.size();
    }

    @Override
    public String toString() {
        return this.name + " - " + Math.round(getRating());
    }
}
