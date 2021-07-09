package footballBetting.entities;

import Base.BaseNamedEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "competition_types")
public class CompetitionType extends BaseNamedEntity {

    @OneToMany(mappedBy = "type")
    private Set<Competition> competitions;

    public Set<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(Set<Competition> competitions) {
        this.competitions = competitions;
    }
}
