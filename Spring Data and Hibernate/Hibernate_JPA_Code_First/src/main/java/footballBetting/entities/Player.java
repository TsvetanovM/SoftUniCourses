package footballBetting.entities;

import Base.BaseNamedEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "players")
public class Player extends BaseNamedEntity {

    @Column(name = "squad_number")
    private int squadNumber;
    @ManyToOne
    private Team team;
    @ManyToOne
    private Position position;
    @Column(name = "is_currently_injured")
    private boolean isCurrentlyInjured;

    @OneToMany(mappedBy = "player")
    private Set<PlayerStatistic> playerStatistics;

    public int getSquadNumber() {
        return squadNumber;
    }

    public void setSquadNumber(int squadNumber) {
        this.squadNumber = squadNumber;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isCurrentlyInjured() {
        return isCurrentlyInjured;
    }

    public void setCurrentlyInjured(boolean currentlyInjured) {
        isCurrentlyInjured = currentlyInjured;
    }

    public Set<PlayerStatistic> getPlayerStatistics() {
        return playerStatistics;
    }

    public void setPlayerStatistics(Set<PlayerStatistic> playerStatistics) {
        this.playerStatistics = playerStatistics;
    }
}
