package hospital.entities;

import Base.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;

//@Entity
@Table(name = "visitations")
public class Visitation extends BaseEntity {

    private LocalDate date;
    @Column(columnDefinition = "TEXT")
    private String comments;

    @ManyToOne
    private Patient patient;

    @OneToOne(optional = false)
    private Diagnose diagnose;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
