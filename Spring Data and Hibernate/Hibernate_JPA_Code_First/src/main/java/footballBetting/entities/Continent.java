package footballBetting.entities;

import Base.BaseNamedEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "continents")
public class Continent extends BaseNamedEntity {

    @ManyToMany(mappedBy = "continents")
    private Set<Country> countries;

    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }
}
