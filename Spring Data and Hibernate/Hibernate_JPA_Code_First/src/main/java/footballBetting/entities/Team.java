package footballBetting.entities;

import Base.BaseNamedEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team extends BaseNamedEntity {

    private String logo;
    private String initials;
    @ManyToOne
    @JoinColumn(name = "primary_kit_color_id", referencedColumnName = "id")
    private Color primaryKitColor;
    @ManyToOne
    @JoinColumn(name = "secondary_kit_color_id", referencedColumnName = "id")
    private Color secondaryKitColor;
    @ManyToOne
    private Town town;
    private BigDecimal budget;

    @OneToMany(mappedBy = "team")
    private Set<Player> players;

    @OneToMany(mappedBy = "homeTeam")
    private Set<Game> homeTeamGames;
    @OneToMany(mappedBy = "awayTeam")
    private Set<Game> awayTeamGames;


    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public Color getPrimaryKitColor() {
        return primaryKitColor;
    }

    public void setPrimaryKitColor(Color primaryKitColor) {
        this.primaryKitColor = primaryKitColor;
    }

    public Color getSecondaryKitColor() {
        return secondaryKitColor;
    }

    public void setSecondaryKitColor(Color secondaryKitColor) {
        this.secondaryKitColor = secondaryKitColor;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public Set<Game> getHomeTeamGames() {
        return homeTeamGames;
    }

    public void setHomeTeamGames(Set<Game> homeTeamGames) {
        this.homeTeamGames = homeTeamGames;
    }

    public Set<Game> getAwayTeamGames() {
        return awayTeamGames;
    }

    public void setAwayTeamGames(Set<Game> awayTeamGames) {
        this.awayTeamGames = awayTeamGames;
    }
}
