package bg.marto.softuni_mobilelele.model.entity;

import javax.persistence.*;
import java.time.Instant;

@MappedSuperclass
public class BaseEntity {

    private Long id;
    private Instant created;
    private Instant modified;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false)
    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    @PrePersist
    public void beforeCreate() {
        this.created = Instant.now();
    }
}
