package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class PictureSeedData {

    @Expose
    @Size(min = 2, max = 19)
    private String name;
    @Expose
    @DateTimeFormat
    private String dateAndTime;
    @Expose
    @Positive
    private Long car;

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

    public Long getCarId() {
        return car;
    }

    public void setCarId(Long carId) {
        this.car = carId;
    }
}
