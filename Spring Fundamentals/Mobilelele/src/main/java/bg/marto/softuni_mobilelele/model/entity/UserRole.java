package bg.marto.softuni_mobilelele.model.entity;

import bg.marto.softuni_mobilelele.model.enums.Role;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserRole {

    private long Id;
    private Role role;
    private List<User> users;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return Id;
    }

    public UserRole setId(long id) {
        Id = id;
        return this;
    }

    @Enumerated
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @OneToMany(mappedBy = "role")
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
