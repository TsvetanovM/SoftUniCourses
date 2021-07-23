package softuni.jsonprocessing.productsShop.models.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserSeed {

    @Expose
    private String firstName;
    @Expose
    @Size(min = 3, message = "Last name has to contain at least 3 letters!")
    @NotNull
    private String lastName;
    @Expose
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
