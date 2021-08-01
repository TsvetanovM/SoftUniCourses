package com.example.football.models.dto;

import com.example.football.models.entity.Position;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerImport {

    @XmlElement(name = "first-name")
    @Size(min = 2)
    @NotNull
    private String firstName;
    @XmlElement(name = "last-name")
    @Size(min = 2)
    @NotNull
    private String lastName;
    @XmlElement
    @Email
    private String email;
    @XmlElement(name = "birth-date")
    @NotNull
    private String birthDate;
    @XmlElement
    @NotNull
    private Position position;
    @XmlElement(name = "town")
    private PlayerTownImport town;
    @XmlElement(name = "team")
    private PlayerTeamImport team;
    @XmlElement(name = "stat")
    private PlayerStatImport stat;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public PlayerTownImport getTown() {
        return town;
    }

    public void setTown(PlayerTownImport town) {
        this.town = town;
    }

    public PlayerTeamImport getTeam() {
        return team;
    }

    public void setTeam(PlayerTeamImport team) {
        this.team = team;
    }

    public PlayerStatImport getStat() {
        return stat;
    }

    public void setStat(PlayerStatImport stat) {
        this.stat = stat;
    }
}
