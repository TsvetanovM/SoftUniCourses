package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class PictureSeedData {

    @Expose
    @Size(min = 2, max = 19, message = "Picture name should be between 2 and 19 symbols!")
    private String name;
    @Expose
    @DateTimeFormat
    private String dateAndTime;
    @Expose
    @Positive(message = "Please enter a valid car id!")
    private int carId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }
}
