package footballBetting.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "player_statistics")
public class PlayerStatistic implements Serializable {

    @Id
    @ManyToOne
    private Game game;
    @Id
    @ManyToOne
    private Player player;
    @Column(name = "scored_goals")
    private int scoredGoals;
    @Column(name = "player_assists")
    private int playerAssists;
    @Column(name = "played_minutes")
    private double playedMinutes;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getScoredGoals() {
        return scoredGoals;
    }

    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    public int getPlayerAssists() {
        return playerAssists;
    }

    public void setPlayerAssists(int playerAssists) {
        this.playerAssists = playerAssists;
    }

    public double getMinutesPlayed() {
        return playedMinutes;
    }

    public void setMinutesPlayed(double minutesPlayed) {
        this.playedMinutes = minutesPlayed;
    }
}
