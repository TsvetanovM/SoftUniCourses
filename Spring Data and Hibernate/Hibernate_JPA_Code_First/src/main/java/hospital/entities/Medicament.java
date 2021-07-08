package hospital.entities;

import Base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

//@Entity
@Table(name = "medicaments")
public class Medicament extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "medicaments")
    private Set<Diagnose> diagnoses;
}
