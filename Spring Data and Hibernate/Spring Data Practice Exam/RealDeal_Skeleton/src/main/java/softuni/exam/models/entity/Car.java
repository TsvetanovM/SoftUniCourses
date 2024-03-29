package softuni.exam.models.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car  extends BaseEntity {

    private String make;
    private String model;
    private int kilometers;
    private LocalDate registeredOn;
    private Set<Picture> pictures;
    private Set<Offer> offers;


    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }


    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDate registeredOn) {
        this.registeredOn = registeredOn;
    }

    @OneToMany(mappedBy = "car", fetch = FetchType.EAGER)
    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }

    @OneToMany(mappedBy = "car")
    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }
}
