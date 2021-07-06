package university.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

//@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    private double credits;
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;
    @ManyToOne
    private Teacher teacher;
}
