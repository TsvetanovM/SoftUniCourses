package footballBetting.entities;

import Base.BaseNamedEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "rounds")
public class Round extends BaseNamedEntity {

    @OneToMany(mappedBy = "round")
    private Set<Game> games;

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
