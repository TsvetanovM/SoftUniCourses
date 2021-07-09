package footballBetting.entities;

import Base.BaseNamedEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town extends BaseNamedEntity {

    @ManyToOne
    private Country country;

    @OneToMany(mappedBy = "town")
    private Set<Team> teams;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }
}
