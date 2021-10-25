package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.enums.RoleName;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    @Enumerated(value = EnumType.STRING)
    private RoleName name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public RoleName getName() {
        return name;
    }

    public Role setName(RoleName name) {
        this.name = name;
        return this;
    }

    public List<User> getUsers() {
        return users;
    }

    public Role setUsers(List<User> users) {
        this.users = users;
        return this;
    }
}
