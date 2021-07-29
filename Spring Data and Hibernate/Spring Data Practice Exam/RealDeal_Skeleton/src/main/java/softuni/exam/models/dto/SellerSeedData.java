package softuni.exam.models.dto;

import softuni.exam.models.enums.Rating;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "seller")
@XmlAccessorType(XmlAccessType.FIELD)
public class SellerSeedData {

    @XmlElement(name = "first-name")
    @Size(min = 2, max = 19, message = "First name must be between 2 and 19 letters!")
    private String firstName;
    @XmlElement(name = "last-name")
    @Size(min = 2, max = 19, message = "Last name must be between 2 and 19 letters!")
    private String lastName;
    @XmlElement
    @Email(message = "Please enter a valid e-mail address!")
    private String email;
    @XmlElement
    @NotNull(message = "You must enter a rating!")
    private Rating rating;
    @XmlElement
    @NotNull(message = "Please enter a town name!")
    private String town;

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

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
