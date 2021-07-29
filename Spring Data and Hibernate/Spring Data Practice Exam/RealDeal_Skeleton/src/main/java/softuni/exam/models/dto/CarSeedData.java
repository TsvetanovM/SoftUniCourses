package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class CarSeedData {

    @Expose
    @Size(min = 2, max = 19)
    private String make;
    @Expose
    @Size(min = 2, max = 19)
    private String model;
    @Expose
    @Positive
    private int kilometers;
    @Expose
    private String registeredOn;

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

    public String getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(String registeredOn) {
        this.registeredOn = registeredOn;
    }
}
