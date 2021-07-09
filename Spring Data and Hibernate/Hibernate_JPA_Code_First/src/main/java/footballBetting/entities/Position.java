package footballBetting.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "positions")
public class Position {

    @Id
    @Column(columnDefinition = "CHAR(2)")
    private String id;
    @Column(name = "description", columnDefinition = "TEXT")
    private String positionDescription;

    @OneToMany(mappedBy = "position")
    private Set<Player> players;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
