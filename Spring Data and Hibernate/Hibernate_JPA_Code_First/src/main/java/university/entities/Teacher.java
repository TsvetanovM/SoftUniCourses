package university.entities;

import Base.Person;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

//@Entity
@Table(name = "teachers")
public class Teacher extends Person {

    private String email;
    @Column(name = "salary_per_hour", columnDefinition = "DECIMAL(10,4)")
    private double salaryPerHour;
    @OneToMany(mappedBy = "teacher")
    private Set<Course> courses;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }
}
