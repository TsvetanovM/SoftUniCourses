package softuni.exam.models.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@XmlRootElement(name = "offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferDataSeed {

    @XmlElement
    @Size(min = 5)
    private String description;
    @XmlElement
    @Positive
    private BigDecimal price;
    @XmlElement(name = "added-on")
    @NotNull
    private String addedOn;
    @XmlElement(name = "has-gold-status")
    private boolean hasGoldStatus;
    @XmlElementWrapper(name = "car")
    @XmlElement(name = "id")
    private List<Long> car;
    @XmlElementWrapper(name = "seller")
    @XmlElement(name = "id")
    private List<Long> seller;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(String addedOn) {
        this.addedOn = addedOn;
    }

    public boolean isHasGoldStatus() {
        return hasGoldStatus;
    }

    public void setHasGoldStatus(boolean hasGoldStatus) {
        this.hasGoldStatus = hasGoldStatus;
    }

    public Long getCar() {
        return car.get(0);
    }

    public void setCar(Long car) {
        this.car.set(0, car);
    }

    public Long getSeller() {
        return seller.get(0);
    }

    public void setSeller(Long seller) {
        this.car.set(0, seller);
    }
}
