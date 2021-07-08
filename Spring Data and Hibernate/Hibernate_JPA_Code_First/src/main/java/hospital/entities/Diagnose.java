package hospital.entities;

import Base.BaseEntity;

import javax.persistence.*;
import java.util.Set;

//@Entity
@Table(name = "diagnoses")
public class Diagnose extends BaseEntity {

    private String name;
    @Column(columnDefinition = "TEXT")
    private String comments;

    @OneToOne(mappedBy = "diagnose")
    private Visitation visitation;

    @ManyToMany
    @JoinTable(name = "diagnoses_medicaments",
    joinColumns = @JoinColumn(name = "medicament_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "diagnose_id", referencedColumnName = "id"))
    private Set<Medicament> medicaments;

}
