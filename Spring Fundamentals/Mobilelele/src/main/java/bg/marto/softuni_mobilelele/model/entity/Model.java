package bg.marto.softuni_mobilelele.model.entity;

import bg.marto.softuni_mobilelele.model.enums.Category;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.EnumType.STRING;

@Entity
public class Model extends BaseEntity {

    private String name;
    private Category category;
    private String ImageUrl;
    private Integer startYear;
    private Integer endYear;
    private Brand brand;
    private List<Offer> offers;

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public Model setName(String name) {
        this.name = name;
        return this;
    }

    @Enumerated(STRING)
    @Column(nullable = false)
    public Category getCategory() {
        return category;
    }

    public Model setCategory(Category category) {
        this.category = category;
        return this;
    }

    @Column(length = 512)
    public String getImageUrl() {
        return ImageUrl;
    }

    public Model setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
        return this;
    }

    @Column(nullable = false)
    public Integer getStartYear() {
        return startYear;
    }

    public Model setStartYear(Integer startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public Model setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

    @OneToMany(mappedBy = "model")
    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    @ManyToOne
    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
