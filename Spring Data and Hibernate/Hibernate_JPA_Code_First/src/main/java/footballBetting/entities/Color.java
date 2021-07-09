package footballBetting.entities;

import Base.BaseNamedEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "colors")
public class Color extends BaseNamedEntity {

    @OneToMany(mappedBy = "primaryKitColor")
    private Set<Team> primaryColorOfTeams;

    @OneToMany(mappedBy = "secondaryKitColor")
    private Set<Team> secondaryColorOfTeams;

    public Set<Team> getPrimaryColorOfTeams() {
        return primaryColorOfTeams;
    }

    public void setPrimaryColorOfTeams(Set<Team> primaryColorOfTeams) {
        this.primaryColorOfTeams = primaryColorOfTeams;
    }

    public Set<Team> getSecondaryColorOfTeams() {
        return secondaryColorOfTeams;
    }

    public void setSecondaryColorOfTeams(Set<Team> secondaryColorOfTeams) {
        this.secondaryColorOfTeams = secondaryColorOfTeams;
    }
}
